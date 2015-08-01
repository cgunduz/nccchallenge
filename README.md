    Hey there !

    The information here can also be reached via the readme file.

    -- Installation --

    I have tested the application on Tomcat 7, but am not expecting any problems on other mainstream web/app servers.
    Need to have MySql up and running for the application to start. There is also a file called mysql.properties,
    which should be filled with respect to the local settings.
    On top of that, the 3rd party ip registry services should also be started and serving on localhost:9000, if not
    the endpoint should be specified by hand.

    Without the sanity check, tests would fail and the application would not be built. (surefire plugin)

    In order to test the app, here are the endpoints for RESTful communication :

    curl localhost:8080/isp/all
    Makes a list of all registered isps

    curl localhost:8080/isp/companyName/{companyName}
    Gives information regarding a specific company

    curl -H "Content-Type: application/json" -X POST -d '{"companyName":"xyz","website":"xyz.com"}' http://localhost:8080/isp/register
    Registers a company with the given company name and website

    Cheers !
