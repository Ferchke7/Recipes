# Recipe API

This project is a RESTful API built with Spring Boot that allows users to manage recipes. It includes endpoints for creating, retrieving, updating, and deleting recipes. Users can also register and authenticate to access protected endpoints.

## Prerequisites

To run this project, make sure you have the following prerequisites:

- Java Development Kit (JDK)
- Spring Boot
- Project Lombok
- H2 Database

## Installation

1. Clone the repository to your local machine:

   ```shell
   git clone https://github.com/Ferchke7/recipe-api.git

    Open the project in your favorite IDE.

    Build the project to resolve dependencies.

Configuration

No additional configuration is required.
Usage



    Use the following endpoints to interact with the API:
        POST /api/register - Register a new user by sending a JSON object with the user's email and password.
        POST /api/recipe/new - Create a new recipe by sending a JSON object containing the recipe details.
        GET /api/recipe/{id} - Retrieve a recipe with a specified ID as a JSON object.
        PUT /api/recipe/{id} - Update a recipe with a specified ID by sending a JSON object containing the updated recipe details.
        DELETE /api/recipe/{id} - Delete a recipe with a specified ID.
        GET /api/recipe/search - Search for recipes by category or name by providing the corresponding query parameters.

    Make requests to the endpoints using your preferred API testing tool, such as cURL or Postman.

Examples
Register a New User

Send a POST request to /api/register with the following JSON body:
```
json

{
   "email": "example@example.com",
   "password": "password123"
}
```
The API will respond with a status code of 200 (OK) if the user is successfully registered. If a user with the specified email already exists, the API will respond with a status code of 400 (Bad Request).
Create a Recipe

Send a POST request to /api/recipe/new with a JSON object containing the recipe details. Include basic authentication by providing the user's email and password as credentials.

json
```
{
   "name": "Fresh Mint Tea",
   "category": "beverage",
   "description": "Light, aromatic and refreshing beverage...",
   "ingredients": ["boiled water", "honey", "fresh mint leaves"],
   "directions": ["Boil water", "Pour boiling hot water into a mug", "Add fresh mint leaves", "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again"]
}
```
The API will respond with a JSON object containing the ID of the created recipe.
Retrieve a Recipe

Send a GET request to ```/api/recipe/{id}``` to retrieve a recipe with the specified ID. Include basic authentication by providing the user's email and password as credentials.

The API will respond with a JSON object containing the recipe details.
Update a Recipe

Send a PUT request to /api/recipe/{id} with a JSON object containing the updated recipe details. Include basic authentication by providing the user's email and password as credentials.

The API will respond with a status code of 204 (No Content) if the recipe is successfully updated. If a recipe with the specified ID does not exist, the API will respond with a status code of 404 (Not Found). If the provided recipe does not meet the required restrictions, such as blank fields or invalid values, the API will respond with a status code of 400 (Bad Request).
Delete a Recipe

Send a DELETE request to /api/recipe/{id} to delete a recipe with the specified ID. Include basic authentication by providing the user's email and password as credentials.

The API will respond with a status code of 204 (No Content) if the recipe is successfully deleted. If a recipe with the specified ID does not exist or the user is not the author of the recipe, the API will respond with a status code of 403 (Forbidden).
Search for Recipes

Send a GET request to /api/recipe/search with the corresponding query parameters to search for recipes. Include basic authentication by providing the user's email and password as credentials.

    To search by category, include the category parameter with the desired category value. The API will respond with a JSON array of recipes matching the specified category, sorted by date (newer first).
    To search by name, include the name parameter with the desired name value. The API will respond with a JSON array of recipes containing the specified name, sorted by date (newer first).

If no recipes are found or the provided query parameters are not valid, the API will respond with an empty JSON array. If more than one parameter is passed or no parameters are passed, the API will respond with a status code of 400 (Bad Request).
Contributing
