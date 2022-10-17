# geophy-automation

 :seedling: :seedling: This is just a basic framework under development for automating of Web applications.  `Java` `Selenium` `JUnit` `AllureReports`

 Designed specifically for `geophy` project. 🌍⛰️🌋
 
 #
 
**How to run test locally** :desktop_computer:    

1. Go to the project folder `geophy-automation` where `pom.xml` file is present.
2. Open terminal/CMD in this folder.   
3. Run command **mvn clean install**   

the test suite execution will start and you can see the execution report under **allure-results** folder (it will be generated automatically).
#

**How to run test in parallel locally** :desktop_computer:    

1. Go to the project folder `geophy-automation` where `pom.xml` file is present.
2. Uncomment below lines from surefire plugin in pom.xml.  


`<!-- <configuration>
        <parallel>methods</parallel> 
        <threadCount>3</threadCount> 
        <perCoreThreadCount>true</perCoreThreadCount>
        </configuration> -->
`.  


2. Open terminal/CMD in this folder.   
3. Run command **mvn clean install**   

the parallel test suite execution will start and you can see the execution report under **allure-results** folder (it will be generated automatically).
#

**How to run test on BrowserStack**   :cloud_with_lightning_and_rain:   :rocket:  

I have created a github workflow for this project that will execute the script on BrowserStack  

On this repository   

1. Go to Actions tab in this repository
2. Click on workflow `UI Automation test pipeline`
3. Click on `Run workflow` dropdown 
4. Select browser as `CHROME_BROWSERSTACK`
4. Click on green `Run workflow` button   

Login to browserstack to see results, follow below steps   
Sign in: [BrowserStack](https://www.browserstack.com/users/sign_in )  
[Username]: gawolo8548@satedly.com   
[Password]: Fork@123   
Now go to [dashboard](https://automate.browserstack.com/dashboard/v2/builds)  to check your run. You can see here video of your execution and all the logs.

You can also download the `allure-results` folder present inside `Artifact` block in last github workflow run and see the extent HTML report.  
#

Cheers :shipit: :tada:



