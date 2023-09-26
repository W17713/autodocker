# autodocker

## Introduction

This Java program serves as an automation tool designed to simplify the deployment and management of Docker containers for Java applications. It streamlines the process of creating four distinct Docker containers, each with a specific role: sender, secure sender (secure messaging Docker container), secure receiver (secure messaging Docker container), and the receiver.

## Features

- **Simplified Automation**: Easily automate the creation and management of Docker containers for your Java applications.

- **Role-Based Containers**: This tool generates four Docker containers, each serving a specific role in your application's ecosystem.

- **Secure Messaging**: The tool includes secure sender and receiver containers for enhanced data privacy.

## Prerequisites

Before using this automation tool, ensure you have the following prerequisites installed:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)

## Usage

1. **Clone Repository**: Clone this repository to your local machine.

   ```shell
   git clone https://github.com/your-username/docker-automation-tool.git

2. **Compile Java File:** Place your Java application file (e.g., YourApp.java) inside the src directory.

   Run the Tool: Execute the following command to generate the Docker containers:

         java -jar DockerAutomationTool.jar  

   This will create four Docker containers in separate directories: sender, secure-sender, secure-receiver, and receiver.

4. **Customize Configuration:** Adjust the Docker configurations and environment variables in the generated Dockerfiles to meet your application's requirements.

5. **Build and Run Containers:** Navigate to each container directory and use Docker Compose to build and run the containers.
   ```shell
     cd sender
     docker-compose up -d


Repeat this step for the other containers.

5. **Test and Monitor:** Test your Java application within the Docker containers and monitor their behavior.

## Directory Structure
        docker-automation-tool/
        ├── src/
        │   ├── YourApp.java
        │   └── ...
        ├── DockerAutomationTool.jar
        ├── sender/
        │   ├── Dockerfile
        │   ├── docker-compose.yml
        │   └── ...
        ├── secure-sender/
        │   ├── Dockerfile
        │   ├── docker-compose.yml
        │   └── ...
        ├── secure-receiver/
        │   ├── Dockerfile
        │   ├── docker-compose.yml
        │   └── ...
        ├── receiver/
        │   ├── Dockerfile
        │   ├── docker-compose.yml
        │   └── ...
        └── README.md


Feel free to explore and customize the directory structure to suit your project needs.


## Contribution
Contributions and improvements to this Docker automation tool are welcome. Feel free to fork the repository, make changes, and submit a pull request.

## License
This project is licensed under the MIT License. You are free to modify and distribute the tool as per the terms of the license.
