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
	
