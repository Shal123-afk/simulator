# simulator
the machine simulator project overview

IDE used: eclipse 
server used to deploy:tomacat 9
API design: RESTfull API
language used:JAVA 11


step1: Download and install apache tomcat on the system
step2: Download and install eclipse enterprise version on the system
step3: Download and install java JDK 11 OR above 
step4: Setup Tomcat Runtime Environment in Eclipse 
step5: Create a dynamic web project with tomacat runtime environment configurations.
step6: Create Tomcat9Library  user library in eclipse preferences.
step7: Define Tomcat9Library path in the project properties in eclipse.
spet8: Download JAX-RS-2.0 RI bundle.
step9: Create JAX-RS-Jersey Api user library in eclipse preferences.
step10:Define JAX-RS-Jersey path in the project properties in eclipse.
step11: Download jackson api bundle to support the running of JSON/XML files.
step12: Create  Jackson-Parser-API user library in eclipse preferences.
step13:Define  Jackson-Parser-API path in the project properties in eclipse.
step14: Define com.pegaexchange.java.web.rest package inside src/java/main folder.
strp15: create .java file inside the package com.pegaexchange.java.web.rest.
step16:Deploy JAVA Rest service on tomacat9.
step17:Create project war file in eclipse .
step18:Enable Tomacat Manager Application by adding manager-gui role  in the tomcat-users.xml file.
step19:Stop tomcat by running Stop.bat file .
step20:Start tomcat by running Startup.bat file.
step21:Access the Manager application by running the default URL:http://localhost:8080/manager on web browser.
step22:When promped enter the user name and password as set in the tomcat-users.xml file.
step23:Scroll down to the WAR file to deploy section and use the Choose File button to select a WAR file from the local disk, then click on the Deploy button.
step24:The deployed web application will be started automatically and is then listed in the Applications section of the Manager Application.
step25:Finally, the deployed web application can be accessed with a web browser by using the application’s context path and the Servlet URL.

Project insights-

use java jframe and jpanel classes to define the grid structure in the code 
create planepanel object of class jpanel inside simulator subclass of the Jframe class.
declaire a static final integer type private variable zoom and initialize it to value 4.
create a public function simulator and pass a boolean type two dimensinal array called plane as it's parameter.
create a public void type paint function overriding  jpannel class object  and pass a graphics class variable g as its parameter.
create annotations @override before the function definition .
also create annotation @PUT before function deffinition and import its supporting class import javax.ws.rs.PUT; 
again create anotation @path to expose it as a rest resource.
again create anotations @Consumes and @produce these annotations can be used to specify request and response formats such as XML and JSON.
create 2 integer variables x and y to definne two axis of the 2d panel diffened earlier .
create two nested for loops each for controlling the itteration of code staments to fill the colors in the square block to the limit of the plane's length which is uninitialised.
hence ,can range from 0 to infinite.
after this,it is necessary to close this operarion otherwise it can lead to a neverending execution of code.
To be able to view the patterns generated on the screen we must set the visibility TRUE.
create an object of the simulator class and pass the runmachine  2D bolean type function  as its parameter inside the main function of the program .
define the runmachine function accepting two integer type parameters height  and width.
create a 2d boolean type array object called plane inside the runmachine function where height and width being its sizes.
create 2 interger type variables machineX and machineY and initialize them with hallf of width and height of the object plane.this keeps the starting point for the machine diffened in the centre of the plane.
declare 2 integer type variables xchange and ychange to define the direction of motion of the machine from the starting point in the middle.
initialize ychange to -1 so that the machine starts to move upwards. 
create a while loop for keep the machine moving untill it lies within the plane.
implement if else loop for creating conditions of the machine's motion over the plane the conditions for moving up or down and left or right will be interchanged per loop 
as once we need to move clockwise for a white square and the other time we need to move counter-clockwise for the black square.
then if the machine comes out of the plane i.e; plane[machineY][machineX] = !plane[machineY][machineX];
then the trajectory of the machine's movements withing the plane gets returned.
also write the web.xml file to support this application to run on the server by sending a http put request to the tomacat server using the jersey and jax-rs user libraries already added to the project.
tomcat library is also  needed for running the api .

improvements possible-

CSS style sheets can be added to beautify the output .
