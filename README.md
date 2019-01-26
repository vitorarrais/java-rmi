# Remote Method Invocation (RMI) in Java

The RMI (Remote Method Invocation) is an API that provides a mechanism to create distributed application in java. The RMI allows an object to invoke methods on an object running in another JVM.

## Description
A simple app that provide students a way to list offered disciplines and information about them. Also enables professors to update lecture notes for next classes.

The application consists of a server that allows a client to invoke methods remotely. Users can interact with the client via terminal but the actual execution occurs remotely in the server JVM. 

## Usage
### Compile and Start Server
./start-server.sh <ABSOLUTE_PROJECT_PATH>

### Compile Start Client
./start-client.sh <ABSOLUTE_PROJECT_PATH>

## Key Considerations
   * Database is a .dat file. Its not a real database. 


### Reference
   * https://docs.oracle.com/javase/tutorial/rmi/overview.html
