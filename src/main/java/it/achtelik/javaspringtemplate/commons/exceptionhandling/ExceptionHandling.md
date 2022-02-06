# Exception Handling

From business context it's import to know if the origin of an error is on the client side, or the server side. So it's
for the most use cases enough, if you make this separation:

* __Application400Exception__: A failure which has his origin at the client side. For example wrong data.
* __Application500Exception__: Am error at the server side. For example a network error, NullPointer or other Runtime
  errors.

Also important from technical point of view are the following topics:

* __No technical details__: Your exception shouldn't expose any technical information. Technical details could show
  secrity issues.
* __Rough for the frontend, dateiled at the backend__: Give your client only as less information as possible. Write all
  necessary details in your backend log and link both information with a unique error id.
* __Catch and handle all exceptions__: Catch all exceptions inside your application and handle them. In this way your
  applications has a clear defined behaviour for all exceptions. 
