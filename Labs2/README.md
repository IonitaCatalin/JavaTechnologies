
# Requirements


-   (2p) Create a Web application containing the following components:
    
    -   input.jsp:  **a page**  containing a form for introducing a  _record_, i.e. a triple containing a  _category_, a  _key_  and a  _value_. (The  _key_  may be a word and the  _value_  may be its definition). The categories  **are not static**, being read from a server-side component (an object);
    -   result.jsp  **a page**  describing the response that will be delivered to the client, for example an HTML table containing the records stored on the server.
    -   an object-oriented domain model;
    -   a server-side component responsible with the business-logic of the application: writing the record to a server-side data structure, reading data from it, etc.
    -   a server-side component responsible with controlling the web-flow.
    
    The purpose of the application is to integrate various components, each having a specialized role.
    
-   (1p) Create the following web filters:
    
    -   A  **web filter**  that will log all requests received by  _input.jsp_.
        
    -   A web filter that will decorate the response by adding a specific  _prelude_  (at the beginning) and a specific  _coda_  (at the end) to the generated HTML page.  
        Important: we assume that the pages are already created and the functionalities described above cannot be implemented by modifying them directly.
    
-   (0.5p) Create a  **web listener**  that reads a default category specified as a  [context init parameter](https://javatutorial.net/java-init-parameters)  at the application start-up. This default value should be stored in an attribute having application scope and it will be used whenever the request does not contain a category.
    
-   (0.5p) Use a "hand-made"  [cookie](http://docs.oracle.com/javaee/7/api/javax/servlet/http/Cookie.html)  to store the category selected by the client. When the user returns to the site (after the current session was invalidated) and presents this cookie, the category will be set automatically.  
    (In case you want to store sensitive data in a cookie, you may read  [Improved Persistent Login Cookie Best Practice](http://jaspan.com/improved_persistent_login_cookie_best_practice).)
    
-   (1p) Add an original, math-inspired,  [CAPTCHA](http://www.captcha.net/)  facility to the input form

# Explanations
	

 

1.	For the first part of the assignment,  the JSP pages [`input.jsp`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs2/src/main/webapp/jsp/input.jsp) and [`result.jsp`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs2/src/main/webapp/jsp/result.jsp) were created.   [`input.jsp`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs2/src/main/webapp/jsp/input.jsp)  is responsible for delivering an HTML form with tuples of inputs (category, value, key) on HTTP GET  but also to store the request in a memory loaded data structure on an HTTP POST to the JSP. Since the categories available for the user to choose from are to be not static, the most viable approach at hand would be to make a separate ENUM class called [`Category`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs2/src/main/java/com/javatechnologies/labs2/enums/Category.java) to store the possible values. As we intend to use this ENUM class as an iterable to fill in the fields in the option element for our form, string representations were defined for the possible values of [`Category`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs2/src/main/java/com/javatechnologies/labs2/enums/Category.java). To store all the requests that were made by the client using the given form a [`Repository`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs2/src/main/java/com/javatechnologies/labs2/util/Repository.java) class was tailored, also [`Request`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs2/src/main/java/com/javatechnologies/labs2/util/Request.java) class was created to simply store the values of category, key, value. [`Repository`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs2/src/main/java/com/javatechnologies/labs2/util/Repository.java) is a Singleton class used to share a single instance per execution, an instance which we use to either store or retrieve requests made by the clients, these requests are stored in a generic ArrayList of  [`Request`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs2/src/main/java/com/javatechnologies/labs2/util/Request.java) instances. [`result.jsp`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs2/src/main/webapp/jsp/result.jsp) makes it possible to retrieve data about the requests made by the client and store in memory. To retrieve the request we simply get an instance of the Singleton class and then render the data in a table accordingly.
2.	For the second part of the assignment, the filters [`ContentFilter`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs2/src/main/java/com/javatechnologies/labs2/filters/ContentFilter.java) and [`LoggerFilter`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs2/src/main/java/com/javatechnologies/labs2/filters/LoggerFilter.java) were created.  [`ContentFilter`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs2/src/main/java/com/javatechnologies/labs2/filters/ContentFilter.java) has the purpose of adding comments in the HTML file delivered to the client, acting as a middleware in between the request being received but also the response is delivered. [`LoggerFilter`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs2/src/main/java/com/javatechnologies/labs2/filters/LoggerFilter.java) enables us to log data about the request before the request is processed and response is sent to the client.
3.	For the third part of the assignment, a default state of the `category` value was declared in the [`web.xml`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs2/src/main/webapp/WEB-INF/web.xml) document to be used in the input.jsp file. Since we have an `UNAVAILABLE` option for the client to choose as a category we will want to read from the servlet InitParameters the value start_category as declared to replace the `UNAVAILABLE` category with `SUBARU`.
4.	For the fourth part of the assignment, a mechanism for cookies was implemented. After we submit the form and the request is stored as a result the default value for `category`  would be the last we choose to make a request. This behavior was possible by making use of them for creating a cookie and getting the value of a cookie offered by the servlet
