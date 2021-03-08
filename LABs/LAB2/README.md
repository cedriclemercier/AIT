# Spring Security Application

This application is a demonstration of basic features spring security offers to us

## Endpoints

The application starts by default on `http:localhost:8080/`, from there you can access those URLs

- `/home`: Homepage with a list of your roles, redirects to `/login` if the user is not logged in
- `/login`: Page to log into the website
- `/register`: Register yourself as a new user and select your role
- `/logout`: Logging out confirmation page

## Features

* Upon registration, an email will be sent to the mailtrap app
