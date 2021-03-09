# SAD MIDTERM

Employee management web application.
This web app implements similar features to Lab2 with some extras.

## How to use
* Start by creating a user, e.g admin
* Log in
* Then below endpoints are available

## Endpoints

`/login`: Page to log in

`/home`: Dashboard for user. 
* List users in the system
* List the user role
* Show user address (TODO)
* Show user details

`/register`: Page to create a user. For test purposes, user can register as an admin or normal user

`/create`: Similar to register but it is supposed to be the page where the admin creates an employee and assigns a user id. Later on I would create a new table joining the ids of users and employees but couldn't find how to do

Things I didn't implement
- Monetary
- Editing details for users
- Calculate salary
- Create employee