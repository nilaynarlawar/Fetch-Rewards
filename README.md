
## User's points manager REST API's

This is the coding challenge of Fetch Rewards.

Author: Nilay Narlawar

Email: nilaynarlawar9211@gmail.com

Link to [My Resume](https://www.dropbox.com/s/lica27y0r4k4qyq/Nilay_Narlawar_Resume.pdf?dl=0)

Connect with me [here](https://www.linkedin.com/in/nnarlawar/)!

## Description
This is implemented in SpringBoot and has postman collection also added in Github. I have also integrated with swagger so when you start the local server you should be able to see swagger document at link:

http://localhost:8080/swagger-ui.html#/transaction-controller

Also you can use postman to make a call for swagger document:

http://localhost:8080/v2/api-docs (Postman collection has this API too.) 

## Implementation
There is a REST controller named "TransactionController" which contains three API's:

 * /transaction
 * /balance
 * /spend

I have followed MVC coding standards, so there are service files, model files and repositories. 

## Setup, Usage and Testing

Prerequsite tools and software:
IDEs: Intellj or VS Code

1. Java 8, JDK,JRE. 

> Link to download:

   * https://www.oracle.com/java/technologies/javase-jre8-downloads.html
   * https://www.oracle.com/java/technologies/javase-jdk15-downloads.html
   * java version "15.0.2" 2021-01-19
   * Java(TM) SE Runtime Environment (build 15.0.2+7-27)
   * Java HotSpot(TM) 64-Bit Server VM (build 15.0.2+7-27, mixed mode, sharing)

2. Maven should be installed.

> Link to download:
 
   * https://maven.apache.org/download.cgi
   *  % mvn -version
   * Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
   * Maven home: /Users/nilaynarlawar/Documents/Softwares/apache-maven-3.6.3
   * Java version: 15.0.2, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/jdk-15.0.2.jdk/Contents/Home
   * Default locale: en_US, platform encoding: UTF-8
   * OS name: "mac os x", version: "10.16", arch: "x86_64", family: "mac"

3.Add java path and maven:

>  sudo vi /etc/paths file.

4.Clone the repository:

> `git clone https://github.com/nilaynarlawar/Fetch-Rewards.git`

5.Install the dependencies:

> mvn clean install

6.Run the code:

> mvn spring-boot:run

7.Open a web browser and test:

> `http://localhost:8080/<api>`


## Postman Colletion

I have created the postman collection for APIs, you can find it [here](https://github.com/nilaynarlawar/Fetch-Rewards/blob/main/FetchRewards.postman_collection.json). 

Note: Also for ease I have created API for addtransaction 5 times just so that you don't have to keep on changing the body for the API.
