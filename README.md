# RBVapes_Project
This project is a simple vape shop api consisting of 5 tables which are (Customers, Brands, Flavours, Orders & Order_Info) within the main database, the basic outline of the project is to be able to create customers; add various brands as well as the flavours of the brands; create orders consisting of the brand, flavour and quantity alongside with the order info containing the customer id, order id, date placed and delievery date. Which will show relationships between tables, transferring various bits of data across as well as implementing different functionalities to execute different type of Http request which include the basic CRUD fundamentals alongside several custom queries to retrieve or update certain data. The overall concept for the API is to be able to Create,Read,Update&Delete in all the tables as well implementing relations between the tables to show different types of data where it is needed, examples of this will be shown within the screenshots further down of the Http requests within Postman.
I did expect the project to go extremely well as it allowed me to expand my mindset as well as skills involving Spring Boot API's, but throughout the process of the project there was a few different challenges that appeared, which some of them were quite simple to figure out and resolve there were others that did oppose more of a challenge and did take some extra time and research in order to overcome the challenge.
All the way through the duration of the project majority of everything went well and as planned as i followed the exact way that i set up and laid out the jira board for the project, it planned a big part in keeping the project on track with the order that everything needed to be accomplished. On the other hand though there were a couple of things that didn't go as planned but the situations and issues where quickly resolved and turned around, all that the issues were was that a few of the unit tests kept returning a null result but was resolved after some research into the situation.
There are some improvements that could be created and implemented within the future, all these improvements could be is a login system for the customers so that they could view the current stock of brands and flavours. Another improvement is to develop a front-end to the API and implement the API into it.

POSTMAN-REQUESTS:

Customers:

Creating a customer
![image](https://user-images.githubusercontent.com/97595011/158198926-1a02366a-b063-4693-8573-58fe1bee2f24.png)
Updating a customer
![image](https://user-images.githubusercontent.com/97595011/158198982-7d17a0b0-c4d4-4cfd-856f-c3502a1fd579.png)
Reading a Customer by their ID
![image](https://user-images.githubusercontent.com/97595011/158199335-ce873c51-d548-4db0-bddf-8775866da20f.png)
Reading All Customers
![image](https://user-images.githubusercontent.com/97595011/158199436-5264134a-b7ef-442c-be2f-c2371fe83ee0.png)
Deleting a Customer
![image](https://user-images.githubusercontent.com/97595011/158199524-b3ab7514-9eb5-4d58-a9c2-4b52be0b3341.png)

Brands:

Read a brand based on the brand name instead of its ID
![image](https://user-images.githubusercontent.com/97595011/158200000-3a5e5a02-2b78-4e37-9da1-cbf753ffb5fc.png)


Flavours:

Updating just the quantity of a flavour
![image](https://user-images.githubusercontent.com/97595011/158200410-6d98d2c4-1643-47f8-8fe1-cb3afda65b3f.png)


Orders:

Creating an order which only requires the body input of the BrandID, FlavourID and the item amount as the order will be created based on the CustomerID
![image](https://user-images.githubusercontent.com/97595011/158201954-fc2fd688-8e8f-4b42-aa8a-87d1c7cf91a2.png)
Updating an order only takes the parameters of the BrandID, FlavourID and item amount
![image](https://user-images.githubusercontent.com/97595011/158202191-81d9687c-d41b-46a2-9c4a-a3486138c402.png)


OrderInfo:

Reading Order information based on either the date placed or the delivery date
![image](https://user-images.githubusercontent.com/97595011/158203116-39d2009a-4d6e-438d-a79f-8be9df21a4b8.png)
![image](https://user-images.githubusercontent.com/97595011/158203173-e909eafa-e82d-4b5a-9bb8-b15a42a7a828.png)

DATABASE:
![image](https://user-images.githubusercontent.com/97595011/158203475-2bf28ff9-4907-4b4c-89f3-b603426b0422.png)


TEST-RESULTS&COVERAGE
![image](https://user-images.githubusercontent.com/97595011/158204097-8b578c21-d139-4957-ac92-e546e53b6b2b.png)


JIRA-BOARD:
https://abqa.atlassian.net/jira/software/projects/RB/boards/2/roadmap

Additonal-Info:
The Date placed & Delievery date have to be changed with the data-test.sql file and within the intergration test to the Date placed: current date and Delivery date: 3 days from current date.
