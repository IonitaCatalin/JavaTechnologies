
-   (2p) Create a servlet that:
    -   receives the following parameters  _key:String_,  _value:int_,  _mock:boolean_  and  _sync:boolean_.
    -   if  _mock_  is true than the servlet simply returns a confirmation message.
    -   if  _mock_  is false, the servlet writes in a text file called  _repository_  a line containing the key, repeated  _value_  times, along with the timestamp of the request, and returns the content of the repository, as an HTML page containing all the lines that were created, ordered by key.
    -   if  _sync_  is false, then the servlet will not use any synchronized method when writing in the file.
    
    The servlet invocation will be done using a simple HTML form.  
    Write in the server log the following information about each request: the HTTP  _method_  used, the IP-address of the client, the  _user-agent_, the client  _language(s)_  and the  _parameters_  of the request. (Take a look at  [HttpServletRequest API](https://javaee.github.io/javaee-spec/javadocs/javax/servlet/http/HttpServletRequest.html)).
    
-   (0.5p) Invoke the service from a desktop application (Java, Python, .NET, etc.).  
    In this case, the servlet must respond with a simple text, instead of an HTML page.  
    
-   (1p)  Analyze the performance and concurrency issues, invoking the servlet repeatedly, in an asynchronous manner (use different values for the  _mock_  and  _sync_  parameters).