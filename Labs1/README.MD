
# Requirements

-   ✔️(2p) Create a servlet that:
    -   ✔️receives the following parameters  _key:String_,  _value:int_,  _mock:boolean_  and  _sync:boolean_.
    -   ✔️if  _mock_  is true than the servlet simply returns a confirmation message.
    -   ✔️if  _mock_  is false, the servlet writes in a text file called  _repository_  a line containing the key, repeated  _value_  times, along with the timestamp of the request, and returns the content of the repository, as an HTML page containing all the lines that were created, ordered by key.
    -   ✔️if  _sync_  is false, then the servlet will not use any synchronized method when writing in the file.
    
    The servlet invocation will be done using a simple HTML form.  
    Write in the server log the following information about each request: the HTTP  _method_  used, the IP-address of the client, the  _user-agent_, the client  _language(s)_  and the  _parameters_  of the request. (Take a look at  [HttpServletRequest API](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/http/HttpServletRequest.html)).
    
-   ✔️(0.5p) Invoke the service from a desktop application (Java, Python, .NET, etc.).  
    In this case, the servlet must respond with a simple text, instead of an HTML page.  
    
-   ✔️(1p)  Analyze the performance and concurrency issues, invoking the servlet repeatedly, in an asynchronous manner (use different values for the  _mock_  and  _sync_  parameters).

# Explanations

For the first part of the requirement I have create a servlet called `WebServlet`, mapped to the /web endpoint. As stated in the requirement we are interested in delivering `text/html` content to our clients. `Request` class is used to extract from the incoming request the mock, sync, value and key request parameters and delivering them when necessary. `RequestService` service class is used to read and write from and to the repository file but also to convert the content of the repository file into a valid HTML table which can be rendered by the client. As mentioned in the requirements when sync argument value is true we need to ensure that the write operation to the repository is thread safe, I did this by using a lock object and subsequently a syncronized block of instructions connected to the lock. A simple HTML form from which the servlet can be invoked was also provided and can be found in the project tree in the folder `app`.


For the second and the third part of the assignment I wrote a JavaScript script to either invoke the service or benchmarked it by making a batch of `n` asyncronous requests. Although there is already an `WebServlet` defined and mapped to the /web endpoint, I created another servlet called `Servlet` and mapped to the /servlet endpoint which is similiar to the previous mentioned one but with the only difference that this one is using `Request` and `RequestService` to deliver content as text and not `text/html`. The script from which we either invoke or benchmark the servlet should be ran with the following configuration `node app.js [mode: invoke, benchmark] [mock: boolean] [sync: boolean] [key: string] [value: integer] [benchmark-with-req-count: integer]`.
