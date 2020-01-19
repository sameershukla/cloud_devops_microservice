pipeline {
    environment {
    registry = "sshukla30/capstone"
    registryCredential = 'docker-hub'
    }

    agent any
    stages {
	    stage ('Git Clone') {
            steps {
                git 'https://github.com/sameershukla/cloud_devops_microservice'
            }
        }
	    
	 
	   stage('Linting Step - Gradle'){
	        steps{
		 	  sh './gradlew build'
	        }
	   }
	   
	   stage('Test Execution'){
	   		steps{
	   		  sh './gradlew test'
	   		}
	   }

	
        stage('Building Docker image') {
            steps {
                script {
	              sh 'docker build --tag sshukla30/capstone .'
                }
            }
        }
		
	 
        stage('Deploy to Docker Hub') {
            steps {
                script {
                   withDockerRegistry([ credentialsId: "Docker", url: "https://registry.hub.docker.com/sshukla30/capstone:latest" ]) {
		              sh 'docker login -u username -p password'
					  sh 'docker push docker.io/sshukla30/capstone:latest'
                    }
                }
            }
        }
		
		stage('Blue Deployment') {
            steps {
                script {
				   withAWS(credentials: 'EKSADMIN', region: 'us-west-2') {
				     sh "aws eks --region us-west-2 update-kubeconfig --name sameer-eks-1"
                     sh 'kubectl apply -f deploy-blue.yml'
				  }
                }
            }
		}	
		
		stage('Remove Blue Deployment') {
            steps {
                script {
				   withAWS(credentials: 'EKSADMIN', region: 'us-west-2') {
				     sh "aws eks --region us-west-2 update-kubeconfig --name sameer-eks-1"
                     sh 'kubectl delete deploy/blue'
				  }
                }
            }
		}
		
		stage('Green Deployment') {
            steps {
                script {
				   withAWS(credentials: 'EKSADMIN', region: 'us-west-2') {
				     sh "aws eks --region us-west-2 update-kubeconfig --name sameer-eks-1"
                     sh 'kubectl apply -f deploy-green.yml'
				  }
                }
             } 
          }
		  
		stage('Remove Green Deployment') {
            steps {
                script {
				   withAWS(credentials: 'EKSADMIN', region: 'us-west-2') {
				     sh "aws eks --region us-west-2 update-kubeconfig --name sameer-eks-1"
                     sh 'kubectl delete deploy/green'
				  }
                }
             } 
          }  
		}
     }
