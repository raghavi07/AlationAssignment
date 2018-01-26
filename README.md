A Web Driver based Automation Framework using selenium.

Local setup steps:
Make sure you have Java version 7 (JDK) or above installed in your machine.
Download eclipse [https://eclipse.org/downloads/].
Setup TestNG in eclipse [http://goo.gl/GleaWs].
Extract the ZIP file AutomationV1.zip 
Open the eclipse in either new workspace or existing one.
Import the file project by navigating File->import and select Existing Maven Projects
Once the project is imported, verify the java compiler path is set to jdk (not to JRE) by following steps below. 
i) Project -> properties 
ii) Click on Java compiler 
iii) Click on Installed JRE's link 
iv) Verify that the path set is for jdk 1.7 or above, otherwise change the path and save.
To download the dependencies 
i) Right click on the project module and select Run As -> Maven Install 
ii) Verify that build status is success (Ignore if found the following error -> Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:2.12.4:test (default-test) on project AutomationV1). If not, restart eclipse and import the projects again. 
iii) Once it completed, right click on the project module and select Maven -> Update Project

Note:
Have setup the Script to run BookSearchResult.xml when built the project as Run As -> Maven Install
or To run the test, Right Click the BookSearchResult.xml file and select Run As -> TestNG Suite
src.main.java contains page objects
src.test.java contains test scripts
Result are written in \test-output\Automation_Test_Result.txt
Test Status is written in \test-output\BookSearch\Test.html

Assertions are explained in the booksSearchtest.java 
For configuring Browser and URL, Use config.properties in src/main/java