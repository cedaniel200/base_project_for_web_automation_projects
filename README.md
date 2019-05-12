# base_project_for_web_automation_projects

# [Español]
Proyecto base con ejemplo para proyectos de automatización web con serenidad BDD, screenplay y cucumber.

## Detalles generales de la implementación

Los tests usan tareas (tasks), interacciones (interactions), preguntas (questions), elementos de páginas (userinterface).
La estructura completa del proyecto es la siguiente:

````
+ exceptions
    Clases que controlan las posibles excepciones técnicas y de negocios que se presentan durante la ejecución de pruebas
+ model
    Clases relacionadas con el modelo de dominio y sus respectivos builder cuando es necesario
+ tasks
    Clases que representan tareas que realiza el actor a nivel de proceso de negocio
+ interactions
    Clases que representan las interacciones directas con la interfaz de usuario
+ userinterface
    Page Objects y Page Elements. Mapean los objetos de la interfaz de usuario
+ questions
    Objetos usados para consultar acerca del estado de la aplicación
+ util
    Clases de utilidad
+ runners
    Clases que permiten correr los tests
+ step definitions
    Clases que mapean las líneas Gherkin a código java
+ features
    La representación de las historias en archivos cucumber
````

## Requerimientos

Para correr el proyecto se necesita Java JDK 1.8 y Gradle preferiblemente con la versión 4.3.

## Para correr el proyecto

En caso de querer ejecutar el proyecto en un solo navegador se debe en el archivo serenity.properties descomentar la línea 
    
    #webdriver.driver= chrome

eliminando el caracter #, en el ejemplo se tiene por defecto chrome. seguidamente se puede ejecutar el comando:

    gradle clean test -Dgithub-user=tuUsuarioGitHub -Dpassword=TuContraseña aggregate

Para ejecutar este proyecto en diferentes navegadores se debe seguir el siguiente orden de ejecución:

    gradle clean 
    gradle test -Dgithub-user=tuUsuarioGitHub -Dpassword=TuContraseña -Dcontext=navegador -Dwebdriver.driver=driverAUtilizar // Se repite dependiendo a la cantidad de driver quieras utilziar
    gradle aggregate
    
Independiente de si es en un solo navegador o varios, se generará el reporte en la carpeta /target/site/serenity/

Ejemplo:
    
    gradle clean 
    gradle test -Dgithub-user=cedaniel200 -Dpassword=123456 -Dcontext=chrome -Dwebdriver.driver=chrome
    gradle test -Dgithub-user=cedaniel200 -Dpassword=123456 -Dcontext=firefox -Dwebdriver.driver=firefox
    gradle test -Dgithub-user=cedaniel200 -Dpassword=123456 -Dbinary="C:\Users\miusuario\AppData\Local\Programs\Opera\60.0.3255.83\opera.exe" -Dcontext=opera -Dwebdriver.driver=opera
    gradle aggregate
    
En el caso del navegador Opera, se debe añadir un nuevo parámetro que especifica la ruta dónde está el ejecutable del navegador.

 ## Jenkins file
 
 Para utilizar el jenkinsfile necesitas crear una credencial con id password-github, ejecutar con parametro, donde se solicita el 
 usuario de github. Ésta configuracion solo ejecuta la prueba en el navegador firefox.
 
 ## Pipeline Azure DevOps
 
 ir a http://bit.ly/2Pxeuqy luego ingresar en Pipelines -> Releases -> DevFest -> Release-4
 
 # Advertencia 
 El ejemplo utiliza usuarios de GitHub, si el usuario que usa es nuevo, puede fallar, ya que GitHub lo envía a una página diferente a la que se usó en el ejercicio.
 
 ### Si tiene alguna pregunta, puede escribirme a cdanielmg200@gmail.com


# [English]

base project with example for web automation projects with serenity BDD, screenplay and cucumber

## General details of the implementation

The tests use tasks, interactions, questions, elements of pages (userinterface).
The complete structure of the project is the following:

````
+ exceptions
     Classes that control the possible technical and business exceptions that arise during the execution of tests
+ model
     Classes related to the domain model and their respective builders when necessary
+ tasks
     Classes that represent tasks performed by the actor at the business process level
+ interactions
     Classes that represent direct interactions with the user interface
+ userinterface
     Page Objects and Page Elements. Map the objects of the user interface
+ questions
     Objects used to check the status of the application
+ util
     Utility classes
+ runners
     Classes that allow to run the tests
+ step definitions
     Classes that map the Gherkin lines to java code
+ features
     The representation of the stories in cucumber archives
````
## Requirements

To run the project you need Java JDK 1.8 and Gradle preferably with version 4.3.

## To run the project

In case you want to run the project in a single browser, you must in the file serenity.properties uncomment the line
    
    #webdriver.driver= chrome

eliminating the character #, in the example you have default chrome. Then the command can be executed:

    gradle clean test -Dgithub-user=tuUsuarioGitHub -Dpassword=TuContraseña aggregate

To execute this project in different browsers the following order of execution must be followed:

    gradle clean 
    gradle test -Dgithub-user=tuUsuarioGitHub -Dpassword=TuContraseña -Dcontext=navegador -Dwebdriver.driver=driverAUtilizar // Repeats depending on the amount of driver you want to use
    gradle aggregate
    
Regardless of whether it is in a single browser or several, the report will be generated in the folder /target/site/serenity/

Example:
    
    gradle clean 
    gradle test -Dgithub-user=cedaniel200 -Dpassword=123456 -Dcontext=chrome -Dwebdriver.driver=chrome
    gradle test -Dgithub-user=cedaniel200 -Dpassword=123456 -Dcontext=firefox -Dwebdriver.driver=firefox
    gradle test -Dgithub-user=cedaniel200 -Dpassword=123456 -Dbinary="C:\Users\miusuario\AppData\Local\Programs\Opera\60.0.3255.83\opera.exe" -Dcontext=opera -Dwebdriver.driver=opera
    gradle aggregate
    
In the case of the Opera browser, a new parameter must be added specifying the path where the browser executable is.

## Jenkins file
 
To use the jenkinsfile you need to create a credential with id password-github, Run with parameter, where the github user is requested. This configuration only runs the test in the firefox browser.

 ## Pipeline Azure DevOps
 
go to http://bit.ly/2Pxeuqy after that, click in Pipelines -> Releases -> DevFest -> Release-4
 
# Warning
The example uses GitHub users, if the user used is new it may fail, since GitHub sends it to a different page than the one used in the exercise.

## If you have any questions you can write me at cdanielmg200@gmail.com
