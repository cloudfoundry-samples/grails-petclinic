Grails Pet Clinic application
=============================

This is a Grails port of the standard Spring Pet Clinic web application. It's very simple, consisting of a few domain classes for persistence and three controllers to support the user interface.

### The domain model

This is the basic domain model for the Pet Clinic application:

               Person               Clinic
              /      \
          Owner      Vet
            |         |
           Pet    Speciality
          /   \
    PetType  Visit

An `Owner` has many `Pet`s, which in turn has many `Visit`s and a `PetType`. A `Vet` has many `Speciality`s. `Clinic` is on its own, but has a controller dedicated to it.

## Building and running locally

To run this application, make sure you have the appropriate version of Grails installed (at least 2.2.1). Then build and run the application using the following command:

    $ grails run-app

This will start the application in development mode and use an in-memory HSQLDB database.

## Deploying to Cloud Foundry

To run the application on Cloud Foundry, first build the project into a .war file:

    $ grails prod war

After installing the 'cf' [command-line interface for Cloud Foundry](http://docs.cloudfoundry.com/docs/using/managing-apps/cf/),
targeting a Cloud Foundry instance, and logging in, the application can be pushed using these commands:

    $ cf push

You may need to provide a different URL for the application if the name `petclinic` has already been taking in your Cloud Foundry domain. 

When using the provided `manifest.yml` file, a MySQL service will be created and bound to the app when it is pushed. You can choose a different MySQL service or a PostgreSQL service to bind to the application. 
