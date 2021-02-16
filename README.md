# J-Dx Server Application
![logo](jdx.png)
## Overview
This application represents a Java server that uses TCP and Sockets to 
instantiate the server on a configurable port.
After it is started, the server waits for a client socket to connect to
the given port.

The server expects to connect to a client that's going to be sending 
byte packets according to a serial protocol (like CAN, RS232, ETHERNET, I2C).
After the client starts sending those packets to the J-Dx app, 
the server decodes them according to the protocol interface 
and stores the decoded data for further processing.

## External Dependencies  
- [Junit 4.12](https://mvnrepository.com/artifact/junit/junit/4.12)
- SnakeYaml 1.8