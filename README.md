#Swagger Utility
![](http://www.mikestowe.com/wp-content/uploads/2014/05/swagger.png)
## Swagger Utility
Swagger utility is a Java utility for generating API proxies from Swagger. The utility generates Flows for all of the Resources defined in under /Paths and complete proxy bundle for any generic Swager generated for API modelling. 
This utility will also accept the Swagger Docs which is generated APigee-127, which has policies defined in it, So it looks in each of the resources, and adds policy in APIproxy wherever the policies are applied in swagger.
Once the API Bundles is created, it has the option to deploy to Enterprise  org.
Currently The following policies are applied to API proxies.
1. OAuthV2- Validate Access Token
2. Quota.
3. SpikeArrest

In the next version/release of this utility we'll add Cahcing and other features of API Management.

##Using Swagger-Utility
Clone the Git Repo on your machine, git@github.com:bharathkumarkn/Swagger-Utility.git, and There will be an executable jar.
Go to the location of the clone on your local machine and locate the Swagger-Util.jar.
it is a Java util, So make sure you have Java6 JRE installed and configured.

Go to terminal/console. and use this command to run the jar.

java -jar Swagger-Util.jar
Once you have executed, follow the below option to give the inputs for the Uitity to generate and deploy to and Enterprise Org.

Enter the location of the Yaml file :/Users/bharathkumar/Documents/4G/Utils-Ws/yaml-files/WeatherAdvanced.yaml
Is this Swagger developed from Apigee-127 Specific (y/n) :y
Enter the API Proxy Name :WeatherAPI
Enter the Location for the API Bundle :/Users/bharathkumar/Desktop
18:24:14.146 [main] DEBUG org.zeroturnaround.zip.ZipUtil - Compressing '/Users/bharathkumar/Desktop/WeatherAPI' into '/Users/bharathkumar/Desktop/WeatherAPI/apiproxy.zip'.
API Proxy Successfully Generated.Do you want to deploy this API to enterprise(y/n) :y
Enter the Enterprise URL (Default= https://api.enterprise.apigee.com) :
Enterprise URL: https://api.enterprise.apigee.com
Enter the Org Name :apigee-edu
Enter the Environment Name :test
Enter the Username :bharathkumar@apigee.com
Enter Password for Org :

Here is the below Succesfful Api Proxy Generated and Deployed to Enterprise org as well.

Executing: POST https://api.enterprise.apigee.com/v1/organizations/apigee-edu/apis?action=import&name=WeatherAPI HTTP/1.1
[Content-Type: application/octet-stream]
Executed: POST https://api.enterprise.apigee.com/v1/organizations/apigee-edu/apis?action=import&name=WeatherAPI HTTP/1.1
HTTP/1.1 201 Created
Response content length: 680
Executing: POST https://api.enterprise.apigee.com/v1/organizations/apigee-edu/apis/WeatherAPI/revisions/1/deployments?action=deploy&env=test HTTP/1.1
[Content-Type: application/octet-stream]
Executed: POST https://api.enterprise.apigee.com/v1/organizations/apigee-edu/apis/WeatherAPI/revisions/1/deployments?action=deploy&env=test HTTP/1.1
HTTP/1.1 200 OK
Response content length: 1047
API Proxy WeatherAPI Successfully Generated and Deployed to Enterprise


Now you have an API Proxy created with all the resouces and policies attached to it, and you can start adding more features and enhance you APIs by adding more feaures to it.

##Contribute

You can find the Source Code of the Utility as well. Please feel free to contribute to the Unitlity.


##Licence

All of SweetLime is licensed under the Apache License, Version 2

Copyright (c) 2014 Girish Rangaswamy @ Apigee Corp 

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


  [1]: https://github.com/bharathkumarkn/Swagger-Utility
