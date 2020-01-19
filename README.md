# cloud_devops_microservice

1. This project demonstrates the deployment of Reactive SpringBoot REST service to AWS + EKS
2. All the steps are mentioned in Jenkinsfile 
     - Checkout
     - Linting (Done through gradle)
     - Test cases execution 
     - Docker Image build and Deploy to Docker Hub 
     - Then the execution of Blue/Green deployment 
     
3. The infra folder contains the cloudformation.yml files. 
