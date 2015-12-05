#Swagger Utility
![](http://www.mikestowe.com/wp-content/uploads/2014/05/swagger.png)
## Swagger Utility
Swagger utility is a Java utility for generating Apigee API proxies from Swagger API Model. 
This utility generates Flows for all of the Resources defined under /Paths and complete Apigee Proxy for any generic Swagger generated for API modelling. 
This utility will also accept the Swagger yaml files which is generated from Apigee-127, which has policies defined in it using volos elements tags, So it looks in each of the resources, and adds policy for flows in Apiproxy wherever the policies are applied under /Paths in swagger.

###
Once the API Bundles is created tool has an option to deploy to Enterprise  org.
Currently the following policies are applied to API proxies.
###
> 1. OAuthV2- Validate Access Token

> 2. Quota.

> 3. SpikeArrest

In the next version/release of this utility we'll add Cahcing and other features of API Management.

##Using Swagger-Utility

Clone the Git Repo on your machine, git@github.com:bharathkumarkn/Swagger-Utility.git, and There will be an executable jar.
Go to the location of the clone on your machine and locate the Swagger-Util.jar.
it is a Java util, So make sure you have Java6 JRE or higher version installed and configured in your machine.

###Go to terminal/console and use below command to run the jar.

> java -jar Swagger-Utility.jar

###
Once you have executed, follow the below option to give the inputs for the Uitity to generate and deploy to and Enterprise Org.


> Enter the location of the Yaml file :/Users/bharathkumar/Documents/4G/Utils-Ws/yaml-files/WeatherAdvanced.yaml

> Is this Swagger developed from Apigee-127 Specific (y/n) :y

> Enter the API Proxy Name :WeatherAPI

> Enter the Location for the API Bundle :/Users/bharathkumar/Desktop

> API Proxy Successfully Generated.Do you want to deploy this API to enterprise(y/n) :y

> Enter the Enterprise URL (Default= https://api.enterprise.apigee.com) :

> Enterprise URL: https://api.enterprise.apigee.com

> Enter the Org Name :apigee-edu

> Enter the Environment Name :test

> Enter the Username :bharathkumar@apigee.com

> Enter Password for Org :

###
Here is the below Successful Api Proxy Generated and Deployed to an Enterprise org.

> Executing: POST https://api.enterprise.apigee.com/v1/organizations/apigee-edu/apis?action=import&name=WeatherAPI HTTP/1.1
[Content-Type: application/octet-stream]

> Executed: POST https://api.enterprise.apigee.com/v1/organizations/apigee-edu/apis?action=import&name=WeatherAPI HTTP/1.1
HTTP/1.1 201 Created
Response content length: 680

> Executing: POST https://api.enterprise.apigee.com/v1/organizations/apigee-edu/apis/WeatherAPI/revisions/1/deployments?action=deploy&env=test HTTP/1.1
[Content-Type: application/octet-stream]

> Executed: POST https://api.enterprise.apigee.com/v1/organizations/apigee-edu/apis/WeatherAPI/revisions/1/deployments?action=deploy&env=test HTTP/1.1
HTTP/1.1 200 OK
Response content length: 1047

> API Proxy WeatherAPI Successfully Generated and Deployed to Enterprise


Now you have an API Proxy created with all the resouces and policies attached to it, and you can start adding more features and enhance you APIs by adding more feaures to it.

##Contribute

You can find the Source Code of the Utility as well. Please feel free to contribute by adding more features and let us know u any feedbacks/bugs in this Utility.

  [1]: https://github.com/bharathkumarkn/Swagger-Utility
