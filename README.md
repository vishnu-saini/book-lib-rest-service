# BookLibrary-Rest-Webservice

..* To set up project, follow below step 
  1. Import library_database.sql in mysql database.
  2. Change database configuration in "src/main/resources/db.properties" file.

..* Database Diagram 

![alt text](https://raw.githubusercontent.com/vishnu-saini/BookLibrary-Rest-Webservice/master/Database_EER.png"ER Diagram")
  
..* Resourse URL's to use this web service 
1.	add student : POST – http://localhost:8080/booklib/api/student
	{
		"firstName" : "Anuj",
		"lastName" : "Gupta",
		"phoneNubmer" : "1234567890",
		"email" : "anuj@gmail.com",
		"password" :  "password"
	}
	
2.	Student authentication : POST - http://localhost:8080/booklib/api/student/authenticate
	{	
		"email" : "anuj@gmail.com",
		"password" :  "password"
	}
	
3.	Get all book publishers: GET -  http://localhost:8080/booklib/api/bookPublisher


4.	Add publisher : POST -  http://localhost:8080/booklib/api/bookPublisher
	{
		"name": "Demo publisher"
	}
	
5.	Update publisher: PUT - http://localhost:8080/booklib/api/bookPublisher/{publisherid}
	{
		"name": "Demo publisher updated1"
	}
	
6.	Get all book categories: GET -  http://localhost:8080/booklib/api/bookCategory 

7.	Add Category : POST -  http://localhost:8080/booklib/api/bookCategory 
	{
		"name": "biography"
	}
	
8.	Update Category: PUT - http://localhost:8080/booklib/api/bookCategory/{categoryid}
	{
		"name": "updated category name"
	}
	
9.	Get books by page: http://localhost:8080/booklib/api/book?page=1&limit=5&authorid=1
	Here page, limit and author id are parameters.
	
10.	Add book : POST - http://localhost:8080/booklib/api/book
	{
		"name": "Game of throns",
		"edision": "3",
		"numberOfBookAvailable": "10",
		"category": {
			"id" : "10"
		},
		"author" : {
			"id" : "2"
		},
		
		"publisher" : {
			"id" : "2"
		}
	}
11.	Issue a book to a student : - POST - http://localhost:8080/booklib/api/loan
	{
		"bookId" : 13,
		"studentId" : 3
	}
	
12.	Get the assigned book (loan detail) detail in a report : - http://localhost:8080/booklib/api/loan/report

13.	Deposit a book for student : PUT - Issue a book to a student : - POST - http://localhost:8080/booklib/api/loan
	{
		"bookId" : 13,
		"studentId" : 3
	}
	
14.	Get book assigned to student : GET - http://localhost:8080/booklib/api/loan?studentId=2



