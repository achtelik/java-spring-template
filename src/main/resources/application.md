# Environment variables

It should be normal, that all your configuration could be set and/or overwritten by environment variables.

In this example you have to set the following environment variables to execute the application correctly. You should
never store username or passwords inside your code. Also references to external systems could be critical.

An exception could be username and passwords which are used for docker-compose. They are already part of the source
code.

|Environment variable name|Comment|
|---|---|
|SPRING_PROFILES_ACTIVE|_local_ or _cloud_|
|SPRING_DATA_MONGODB_USERNAME||
|SPRING_DATA_MONGODB_PASSWORD||
