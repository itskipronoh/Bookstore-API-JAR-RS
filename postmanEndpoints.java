{
        "info": {
        "_postman_id": "bd1666ba-8075-42b8-9df4-b9877549334b",
        "name": "BookStore API : CRUD, test & variable",
        "description": "# 🚀 Get started here\n\nThis template guides you through CRUD operations (GET, POST, PUT, DELETE), variables, and tests.\n\n## 🔖 **How to use this template**\n\n#### **Step 1: Send requests**\n\nRESTful APIs allow you to perform CRUD operations using the POST, GET, PUT, and DELETE HTTP methods.\n\nThis collection contains each of these [request](https://learning.postman.com/docs/sending-requests/requests/) types. Open each request and click \"Send\" to see what happens.\n\n#### **Step 2: View responses**\n\nObserve the response tab for status code (200 OK), response time, and size.\n\n#### **Step 3: Send new Body data**\n\nUpdate or add new data in \"Body\" in the POST request. Typically, Body data is also used in PUT request.\n\n```\n{\n    \"name\": \"Add your name in the body\"\n}\n\n ```\n\n#### **Step 4: Update the variable**\n\nVariables enable you to store and reuse values in Postman. We have created a [variable](https://learning.postman.com/docs/sending-requests/variables/) called `base_url` with the sample request [https://postman-api-learner.glitch.me](https://postman-api-learner.glitch.me). Replace it with your API endpoint to customize this collection.\n\n#### **Step 5: Add tests in the \"Scripts\" tab**\n\nAdding tests to your requests can help you confirm that your API is working as expected. You can write test scripts in JavaScript and view the output in the \"Test Results\" tab.\n\n<img src=\"https://content.pstmn.io/fa30ea0a-373d-4545-a668-e7b283cca343/aW1hZ2UucG5n\" alt=\"\" height=\"1530\" width=\"2162\">\n\n## 💪 Pro tips\n\n- Use folders to group related requests and organize the collection.\n    \n- Add more [scripts](https://learning.postman.com/docs/writing-scripts/intro-to-scripts/) to verify if the API works as expected and execute workflows.\n    \n\n## 💡Related templates\n\n[API testing basics](https://go.postman.co/redirect/workspace?type=personal&collectionTemplateId=e9a37a28-055b-49cd-8c7e-97494a21eb54&sourceTemplateId=ddb19591-3097-41cf-82af-c84273e56719)  \n[API documentation](https://go.postman.co/redirect/workspace?type=personal&collectionTemplateId=e9c28f47-1253-44af-a2f3-20dce4da1f18&sourceTemplateId=ddb19591-3097-41cf-82af-c84273e56719)  \n[Authorization methods](https://go.postman.co/redirect/workspace?type=personal&collectionTemplateId=31a9a6ed-4cdf-4ced-984c-d12c9aec1c27&sourceTemplateId=ddb19591-3097-41cf-82af-c84273e56719)",
        "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
        "_exporter_id": "32786132"
        },
        "item": [
        {
        "name": "BookResource",
        "item": [
        {
        "name": "get all books",
        "request": {
        "method": "GET",
        "header": [],
        "url": {
        "raw": "http://localhost:8080/books",
        "protocol": "http",
        "host": [
        "localhost"
        ],
        "port": "8080",
        "path": [
        "books"
        ]
        }
        },
        "response": []
        },
        {
        "name": "get a book by id",
        "request": {
        "method": "GET",
        "header": [],
        "url": {
        "raw": "http://localhost:8080/books/5",
        "protocol": "http",
        "host": [
        "localhost"
        ],
        "port": "8080",
        "path": [
        "books",
        "5"
        ]
        }
        },
        "response": []
        },
        {
        "name": "Create book",
        "request": {
        "method": "POST",
        "header": [],
        "body": {
        "mode": "raw",
        "raw": "{\r\n    \"id\": \"1\",\r\n    \"title\": \"Clean Code\",\r\n    \"authorId\": \"101\",\r\n    \"isbn\": \"9780132350884\",\r\n    \"publicationYear\": 2008,\r\n    \"price\": 37.99,\r\n    \"stockQuantity\": 15\r\n  }",
        "options": {
        "raw": {
        "language": "json"
        }
        }
        },
        "url": {
        "raw": "http://localhost:8080/books",
        "protocol": "http",
        "host": [
        "localhost"
        ],
        "port": "8080",
        "path": [
        "books"
        ]
        }
        },
        "response": []
        },
        {
        "name": "Update book",
        "request": {
        "method": "PUT",
        "header": [],
        "body": {
        "mode": "raw",
        "raw": "{\r\n    \"id\": \"1\",\r\n    \"title\": \"Clean Code\",\r\n    \"authorId\": \"102\",\r\n    \"isbn\": \"9780132350884\",\r\n    \"publicationYear\": 2008,\r\n    \"price\": 37.99,\r\n    \"stockQuantity\": 15\r\n  }",
        "options": {
        "raw": {
        "language": "json"
        }
        }
        },
        "url": {
        "raw": "http://localhost:8080/books/1",
        "protocol": "http",
        "host": [
        "localhost"
        ],
        "port": "8080",
        "path": [
        "books",
        "1"
        ]
        }
        },
        "response": []
        },
        {
        "name": "Delete book",
        "request": {
        "method": "DELETE",
        "header": [],
        "body": {
        "mode": "raw",
        "raw": "{\r\n    \"id\": \"1\",\r\n    \"title\": \"Clean Code\",\r\n    \"authorId\": \"102\",\r\n    \"isbn\": \"9780132350884\",\r\n    \"publicationYear\": 2008,\r\n    \"price\": 37.99,\r\n    \"stockQuantity\": 15\r\n  }",
        "options": {
        "raw": {
        "language": "json"
        }
        }
        },
        "url": {
        "raw": "http://localhost:8080/books/6",
        "protocol": "http",
        "host": [
        "localhost"
        ],
        "port": "8080",
        "path": [
        "books",
        "6"
        ]
        }
        },
        "response": []
        }
        ]
        },
        {
        "name": "Author Resource",
        "item": [
        {
        "name": "Retrieve all authors",
        "request": {
        "method": "GET",
        "header": [],
        "url": {
        "raw": "http://localhost:8080/authors",
        "protocol": "http",
        "host": [
        "localhost"
        ],
        "port": "8080",
        "path": [
        "authors"
        ]
        }
        },
        "response": []
        },
        {
        "name": "Retrieve a specific author",
        "request": {
        "method": "GET",
        "header": [],
        "url": {
        "raw": "http://localhost:8080/authors",
        "protocol": "http",
        "host": [
        "localhost"
        ],
        "port": "8080",
        "path": [
        "authors"
        ]
        }
        },
        "response": []
        },
        {
        "name": "Create a new author",
        "request": {
        "method": "POST",
        "header": [],
        "url": {
        "raw": "http://localhost:8080/authors",
        "protocol": "http",
        "host": [
        "localhost"
        ],
        "port": "8080",
        "path": [
        "authors"
        ]
        }
        },
        "response": []
        },
        {
        "name": "Update an author",
        "request": {
        "method": "PUT",
        "header": [],
        "body": {
        "mode": "raw",
        "raw": "",
        "options": {
        "raw": {
        "language": "json"
        }
        }
        },
        "url": {
        "raw": "http://localhost:8080/authors/4",
        "protocol": "http",
        "host": [
        "localhost"
        ],
        "port": "8080",
        "path": [
        "authors",
        "4"
        ]
        }
        },
        "response": []
        },
        {
        "name": "Delete an author",
        "request": {
        "method": "DELETE",
        "header": [],
        "body": {
        "mode": "raw",
        "raw": "",
        "options": {
        "raw": {
        "language": "json"
        }
        }
        },
        "url": {
        "raw": "http://localhost:8080/authors/4",
        "protocol": "http",
        "host": [
        "localhost"
        ],
        "port": "8080",
        "path": [
        "authors",
        "4"
        ]
        }
        },
        "response": []
        },
        {
        "name": "Get books written by a specific author",
        "protocolProfileBehavior": {
        "disableBodyPruning": true
        },
        "request": {
        "method": "GET",
        "header": [],
        "body": {
        "mode": "raw",
        "raw": "",
        "options": {
        "raw": {
        "language": "json"
        }
        }
        },
        "url": {
        "raw": "http://localhost:8080/authors/4",
        "protocol": "http",
        "host": [
        "localhost"
        ],
        "port": "8080",
        "path": [
        "authors",
        "4"
        ]
        }
        },
        "response": []
        }
        ]
        },
        {
        "name": "Customer Resource",
        "item": [
        {
        "name": "Get All Customers",
        "request": {
        "method": "GET",
        "header": [],
        "url": {
        "raw": "http://localhost:8080/customers",
        "protocol": "http",
        "host": [
        "localhost"
        ],
        "port": "8080",
        "path": [
        "customers"
        ]
        }
        },
        "response": []
        },
        {
        "name": "Get a Single Customer",
        "request": {
        "method": "GET",
        "header": [],
        "url": {
        "raw": "http://localhost:8080/customers/1",
        "protocol": "http",
        "host": [
        "localhost"
        ],
        "port": "8080",
        "path": [
        "customers",
        "1"
        ]
        }
        },
        "response": []
        },
        {
        "name": "Create a Customer",
        "request": {
        "method": "POST",
        "header": [],
        "body": {
        "mode": "raw",
        "raw": "{\r\n  \"id\": \"1\",\r\n  \"name\": \"John Doe\",\r\n  \"email\": \"johndoe@example.com\",\r\n  \"password\": \"securepass123\"\r\n}\r\n",
        "options": {
        "raw": {
        "language": "json"
        }
        }
        },
        "url": {
        "raw": "http://localhost:8080/customers",
        "protocol": "http",
        "host": [
        "localhost"
        ],
        "port": "8080",
        "path": [
        "customers"
        ]
        }
        },
        "response": []
        },
        {
        "name": "Update a Customer",
        "request": {
        "method": "PUT",
        "header": [],
        "body": {
        "mode": "raw",
        "raw": "{\r\n  \"id\": \"1\",\r\n  \"name\": \"John Doe\",\r\n  \"email\": \"johndoe@example.com\",\r\n  \"password\": \"securepass123\"\r\n}\r\n",
        "options": {
        "raw": {
        "language": "json"
        }
        }
        },
        "url": {
        "raw": "http://localhost:8080/customers/4",
        "protocol": "http",
        "host": [
        "localhost"
        ],
        "port": "8080",
        "path": [
        "customers",
        "4"
        ]
        }
        },
        "response": []
        },
        {
        "name": "Delete a Customer",
        "request": {
        "method": "DELETE",
        "header": [],
        "body": {
        "mode": "raw",
        "raw": "{\r\n  \"id\": \"1\",\r\n  \"name\": \"John Doe\",\r\n  \"email\": \"johndoe@example.com\",\r\n  \"password\": \"securepass123\"\r\n}\r\n",
        "options": {
        "raw": {
        "language": "json"
        }
        }
        },
        "url": {
        "raw": "http://localhost:8080/customers/4",
        "protocol": "http",
        "host": [
        "localhost"
        ],
        "port": "8080",
        "path": [
        "customers",
        "4"
        ]
        }
        },
        "response": []
        }
        ]
        },
        {
        "name": "Cart Resource",
        "item": [
        {
        "name": "Update Book Quantity in Cart Copy",
        "request": {
        "method": "PUT",
        "header": []
        },
        "response": []
        },
        {
        "name": "Get Customer Cart",
        "request": {
        "method": "GET",
        "header": []
        },
        "response": []
        },
        {
        "name": "Add a Book to Cart",
        "request": {
        "method": "POST",
        "header": []
        },
        "response": []
        },
        {
        "name": "Remove a Book from Cart",
        "request": {
        "method": "DELETE",
        "header": [],
        "url": {
        "raw": "http://localhost:8080/customers/1/cart/items/101",
        "protocol": "http",
        "host": [
        "localhost"
        ],
        "port": "8080",
        "path": [
        "customers",
        "1",
        "cart",
        "items",
        "101"
        ]
        }
        },
        "response": []
        }
        ]
        },
        {
        "name": "Order Resource",
        "item": [
        {
        "name": "Create Order for Customers",
        "request": {
        "method": "POST",
        "header": [],
        "url": {
        "raw": "http://localhost:8080/customers/2/orders",
        "protocol": "http",
        "host": [
        "localhost"
        ],
        "port": "8080",
        "path": [
        "customers",
        "2",
        "orders"
        ]
        }
        },
        "response": []
        },
        {
        "name": "Retrieve all orders for a specific customer",
        "request": {
        "method": "GET",
        "header": [],
        "url": {
        "raw": "http://localhost:8080/customers/2/orders",
        "protocol": "http",
        "host": [
        "localhost"
        ],
        "port": "8080",
        "path": [
        "customers",
        "2",
        "orders"
        ]
        }
        },
        "response": []
        },
        {
        "name": "Retrieve a specific order by order ID",
        "request": {
        "method": "GET",
        "header": [],
        "url": {
        "raw": "http://localhost:8080/customers/3/orders/5002",
        "protocol": "http",
        "host": [
        "localhost"
        ],
        "port": "8080",
        "path": [
        "customers",
        "3",
        "orders",
        "5002"
        ]
        }
        },
        "response": []
        }
        ]
        }
        ],
        "event": [
        {
        "listen": "prerequest",
        "script": {
        "type": "text/javascript",
        "exec": [
        ""
        ]
        }
        },
        {
        "listen": "test",
        "script": {
        "type": "text/javascript",
        "exec": [
        ""
        ]
        }
        }
        ],
        "variable": [
        {
        "key": "id",
        "value": "1"
        },
        {
        "key": "base_url",
        "value": "https://postman-rest-api-learner.glitch.me/"
        }
        ]
        }