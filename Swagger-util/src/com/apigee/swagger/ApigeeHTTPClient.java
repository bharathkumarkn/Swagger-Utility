package com.apigee.swagger;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
public class ApigeeHTTPClient {

    public String doGET(String url, Map<String, String> headers, String username, String password) throws IOException {

        DefaultHttpClient httpclient = new DefaultHttpClient();
        try {
            int port;
            String host;
            if (url.startsWith("https://")) {
                String strippedURL = url.substring("https://".length());
                if (strippedURL.contains("/"))
                    strippedURL = strippedURL.substring(0, strippedURL.indexOf("/"));
                if (strippedURL.contains(":")) {
                    host = strippedURL.substring(0, strippedURL.indexOf(":"));
                    port = Integer.parseInt(strippedURL.substring(strippedURL.indexOf(":") + 1));

                } else {
                    host = strippedURL;
                    port = 443;

                }
            } else {
                String strippedURL = url.substring("http://".length());
                if (strippedURL.contains("/"))
                    strippedURL = strippedURL.substring(0, strippedURL.indexOf("/"));
                if (strippedURL.contains(":")) {
                    host = strippedURL.substring(0, strippedURL.indexOf(":"));
                    port = Integer.parseInt(strippedURL.substring(strippedURL.indexOf(":") + 1));

                } else {
                    host = strippedURL;
                    port = 80;
                }

            }

            httpclient.getCredentialsProvider().setCredentials(
                    new AuthScope(host, port),
                    new UsernamePasswordCredentials(username, password));
            System.out.println("doGEt Call for Developer App--->"+url);
            HttpGet httpget = new HttpGet(url);

            if (headers != null) {
                for (String header : headers.keySet()) {
                    httpget.addHeader(new BasicHeader(header, headers.get(header)));
                }

            }

            System.out.println("Executing: " + httpget.getRequestLine());
            System.out.println(Arrays.toString(httpget.getAllHeaders()));

            HttpResponse response = httpclient.execute(httpget);
            System.out.println("Executed: " + httpget.getRequestLine());
            HttpEntity entity = response.getEntity();


            if (entity != null) {
                System.out.println("Response content length: " + entity.getContentLength());
                return EntityUtils.toString(entity);
            }
            EntityUtils.consume(entity);
        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }
        return null;

    }

    public String doPOST(String url, Map<String, String> headers, String payload, String username, String password) throws IOException {

        DefaultHttpClient httpclient = new DefaultHttpClient();
        try {
            int port;
            String host;
            if (url.startsWith("https://")) {
                String strippedURL = url.substring("https://".length());
                if (strippedURL.contains("/"))
                    strippedURL = strippedURL.substring(0, strippedURL.indexOf("/"));
                if (strippedURL.contains(":")) {
                    host = strippedURL.substring(0, strippedURL.indexOf(":"));
                    port = Integer.parseInt(strippedURL.substring(strippedURL.indexOf(":") + 1));

                } else {
                    host = strippedURL;
                    port = 443;

                }
            } else {
                String strippedURL = url.substring("http://".length());
                if (strippedURL.contains("/"))
                    strippedURL = strippedURL.substring(0, strippedURL.indexOf("/"));
                if (strippedURL.contains(":")) {
                    host = strippedURL.substring(0, strippedURL.indexOf(":"));
                    port = Integer.parseInt(strippedURL.substring(strippedURL.indexOf(":") + 1));

                } else {
                    host = strippedURL;
                    port = 80;
                }

            }

            httpclient.getCredentialsProvider().setCredentials(
                    new AuthScope(host, port),
                    new UsernamePasswordCredentials(username, password));

            HttpPost httpPost = new HttpPost(url);

            if (headers != null) {
                for (String header : headers.keySet()) {
                    httpPost.addHeader(new BasicHeader(header, headers.get(header)));
                }

            }
            if(payload != null) {
                StringEntity rentity = new StringEntity(payload);
                rentity.setContentType(new BasicHeader(DeploymentUtilityConstants.CONTENT_TYPE_HEADER, DeploymentUtilityConstants.CONTENT_TYPE_APPLICATION_OCTET_STREAM));
                httpPost.setEntity(rentity);
            }


            System.out.println("Executing: " + httpPost.getRequestLine());
            System.out.println(Arrays.toString(httpPost.getAllHeaders()));

            HttpResponse response = httpclient.execute(httpPost);

            System.out.println("Executed: " + httpPost.getRequestLine());

            HttpEntity entity = response.getEntity();

            System.out.println(response.getStatusLine());


            if (entity != null) {
                System.out.println("Response content length: " + entity.getContentLength());



                return EntityUtils.toString(entity);

            }
            EntityUtils.consume(entity);
        }catch (Exception ex){
            ex.printStackTrace();

        }
        finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }
        return null;

    }

    public String doPOST(String url, Map<String, String> headers, File attachment, String username, String password) throws IOException {

        DefaultHttpClient httpclient = new DefaultHttpClient();
        try {
            int port;
            String host;
            if (url.startsWith("https://")) {
                String strippedURL = url.substring("https://".length());
                if (strippedURL.contains("/"))
                    strippedURL = strippedURL.substring(0, strippedURL.indexOf("/"));
                if (strippedURL.contains(":")) {
                    host = strippedURL.substring(0, strippedURL.indexOf(":"));
                    port = Integer.parseInt(strippedURL.substring(strippedURL.indexOf(":") + 1));

                } else {
                    host = strippedURL;
                    port = 443;

                }
            } else {
                String strippedURL = url.substring("http://".length());
                if (strippedURL.contains("/"))
                    strippedURL = strippedURL.substring(0, strippedURL.indexOf("/"));
                if (strippedURL.contains(":")) {
                    host = strippedURL.substring(0, strippedURL.indexOf(":"));
                    port = Integer.parseInt(strippedURL.substring(strippedURL.indexOf(":") + 1));

                } else {
                    host = strippedURL;
                    port = 80;
                }

            }

            httpclient.getCredentialsProvider().setCredentials(
                    new AuthScope(host, port),
                    new UsernamePasswordCredentials(username, password));

            HttpPost httpPost = new HttpPost(url);

            if (headers != null) {
                for (String header : headers.keySet()) {
                    httpPost.addHeader(new BasicHeader(header, headers.get(header)));
                }

            }

            httpPost.setEntity(new FileEntity(attachment));
            System.out.println("Executing: " + httpPost.getRequestLine());
            System.out.println(Arrays.toString(httpPost.getAllHeaders()));

            HttpResponse response = httpclient.execute(httpPost);
            System.out.println("Executed: " + httpPost.getRequestLine());
            HttpEntity entity = response.getEntity();

            System.out.println(response.getStatusLine());


            if (entity != null) {
                System.out.println("Response content length: " + entity.getContentLength());
                return EntityUtils.toString(entity);
            }
            EntityUtils.consume(entity);
        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }
        return null;

    }

    public File importBundle(String url, Map<String, String> headers, File fileToWrite, String username, String password) throws IOException {

        DefaultHttpClient httpclient = new DefaultHttpClient();
        try {
            int port;
            String host;
            if (url.startsWith("https://")) {
                String strippedURL = url.substring("https://".length());
                if (strippedURL.contains("/"))
                    strippedURL = strippedURL.substring(0, strippedURL.indexOf("/"));
                if (strippedURL.contains(":")) {
                    host = strippedURL.substring(0, strippedURL.indexOf(":"));
                    port = Integer.parseInt(strippedURL.substring(strippedURL.indexOf(":") + 1));

                } else {
                    host = strippedURL;
                    port = 443;

                }
            } else {
                String strippedURL = url.substring("http://".length());
                if (strippedURL.contains("/"))
                    strippedURL = strippedURL.substring(0, strippedURL.indexOf("/"));
                if (strippedURL.contains(":")) {
                    host = strippedURL.substring(0, strippedURL.indexOf(":"));
                    port = Integer.parseInt(strippedURL.substring(strippedURL.indexOf(":") + 1));

                } else {
                    host = strippedURL;
                    port = 80;
                }

            }

            httpclient.getCredentialsProvider().setCredentials(
                    new AuthScope(host, port),
                    new UsernamePasswordCredentials(username, password));

            HttpGet httpPost = new HttpGet(url);

            if (headers != null) {
                for (String header : headers.keySet()) {
                    httpPost.addHeader(new BasicHeader(header, headers.get(header)));
                }

            }

            System.out.println("Executing: " + httpPost.getRequestLine());
            System.out.println(Arrays.toString(httpPost.getAllHeaders()));

            HttpResponse response = httpclient.execute(httpPost);
            System.out.println("Executed: " + httpPost.getRequestLine());
            HttpEntity entity = response.getEntity();


            System.out.println(response.getStatusLine());


            if (entity != null) {
                System.out.println("Response content length: " + entity.getContentLength());

                byte[] bytes = EntityUtils.toByteArray(entity);
                FileOutputStream fos = new FileOutputStream(fileToWrite);
                fos.write(bytes);

                return fileToWrite.getAbsoluteFile();


            }
            EntityUtils.consume(entity);
        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }
        return null;

    }

    public String doDelete(String url, Map<String, String> headers, String username, String password) throws IOException {

        DefaultHttpClient httpclient = new DefaultHttpClient();
        try {
            int port;
            String host;
            if (url.startsWith("https://")) {
                String strippedURL = url.substring("https://".length());
                if (strippedURL.contains("/"))
                    strippedURL = strippedURL.substring(0, strippedURL.indexOf("/"));
                if (strippedURL.contains(":")) {
                    host = strippedURL.substring(0, strippedURL.indexOf(":"));
                    port = Integer.parseInt(strippedURL.substring(strippedURL.indexOf(":") + 1));

                } else {
                    host = strippedURL;
                    port = 443;

                }
            } else {
                String strippedURL = url.substring("http://".length());
                if (strippedURL.contains("/"))
                    strippedURL = strippedURL.substring(0, strippedURL.indexOf("/"));
                if (strippedURL.contains(":")) {
                    host = strippedURL.substring(0, strippedURL.indexOf(":"));
                    port = Integer.parseInt(strippedURL.substring(strippedURL.indexOf(":") + 1));

                } else {
                    host = strippedURL;
                    port = 80;
                }

            }

            httpclient.getCredentialsProvider().setCredentials(
                    new AuthScope(host, port),
                    new UsernamePasswordCredentials(username, password));

            HttpDelete httpget = new HttpDelete(url);

            if (headers != null) {
                for (String header : headers.keySet()) {
                    httpget.addHeader(new BasicHeader(header, headers.get(header)));
                }

            }

            System.out.println("Executing: " + httpget.getRequestLine());
            System.out.println(Arrays.toString(httpget.getAllHeaders()));

            HttpResponse response = httpclient.execute(httpget);
            System.out.println("Executed: " + httpget.getRequestLine());
            System.out.println(response.getStatusLine());

            HttpEntity entity = response.getEntity();


            if (entity != null) {
                System.out.println("Response content length: " + entity.getContentLength());

                return EntityUtils.toString(entity);
            }
            EntityUtils.consume(entity);
        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }
        return null;

    }

    public String doPUT(String url, Map<String, String> headers, String payload, String username, String password) throws IOException {

        DefaultHttpClient httpclient = new DefaultHttpClient();
        try {
            int port;
            String host;
            if (url.startsWith("https://")) {
                String strippedURL = url.substring("https://".length());
                if (strippedURL.contains("/"))
                    strippedURL = strippedURL.substring(0, strippedURL.indexOf("/"));
                if (strippedURL.contains(":")) {
                    host = strippedURL.substring(0, strippedURL.indexOf(":"));
                    port = Integer.parseInt(strippedURL.substring(strippedURL.indexOf(":") + 1));

                } else {
                    host = strippedURL;
                    port = 443;

                }
            } else {
                String strippedURL = url.substring("http://".length());
                if (strippedURL.contains("/"))
                    strippedURL = strippedURL.substring(0, strippedURL.indexOf("/"));
                if (strippedURL.contains(":")) {
                    host = strippedURL.substring(0, strippedURL.indexOf(":"));
                    port = Integer.parseInt(strippedURL.substring(strippedURL.indexOf(":") + 1));

                } else {
                    host = strippedURL;
                    port = 80;
                }

            }

            httpclient.getCredentialsProvider().setCredentials(
                    new AuthScope(host, port),
                    new UsernamePasswordCredentials(username, password));

            HttpPut httpPut = new HttpPut(url);

            if (headers != null) {
                for (String header : headers.keySet()) {
                    httpPut.addHeader(new BasicHeader(header, headers.get(header)));
                }

            }
            if(payload != null) {
                StringEntity rentity = new StringEntity(payload);
                rentity.setContentType(new BasicHeader(DeploymentUtilityConstants.CONTENT_TYPE_HEADER, DeploymentUtilityConstants.CONTENT_TYPE_APPLICATION_OCTET_STREAM));
                httpPut.setEntity(rentity);
            }


            System.out.println("Executing: " + httpPut.getRequestLine());
            System.out.println(Arrays.toString(httpPut.getAllHeaders()));

            HttpResponse response = httpclient.execute(httpPut);
            System.out.println("Executed: " + httpPut.getRequestLine());
            HttpEntity entity = response.getEntity();

            System.out.println(response.getStatusLine());


            if (entity != null) {
                System.out.println("Response content length: " + entity.getContentLength());



                return EntityUtils.toString(entity);

            }
            EntityUtils.consume(entity);
        }catch (Exception ex){
            ex.printStackTrace();

        }
        finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }
        return null;

    }
}
