pipeline {
    environment {
    registry = "sshukla30/capstone"
    registryCredential = 'docker-hub'
    }

    agent any
    stages {
	    stage ('Cloning Git Repository') {
            steps {
                git 'https://github.com/sameershukla/cloud_devops_microservice'
            }
        }
	    
	 
	   stage('Gradle Build'){
	        steps{
		 	  sh './gradlew build'
	        }
	   }

	
        stage('Building Docker image') {
            steps {
                script {
	              sh 'docker build --tag sshukla30/capstone .'
                }
            }
        }

        stage('Deploy Docker Image') {
            steps {
                script {
                   withDockerRegistry([ credentialsId: "Docker", url: "https://registry.hub.docker.com/sshukla30/capstone:latest" ]) {
					 sh "docker login -u username -p password"
                     sh 'docker push docker.io/sshukla30/capstone:latest'
                    }
                }
            }
        }
		
		stage('Run Docker Image') {
            steps {
                script {
	              sh 'docker run -d sshukla30/capstone'
                }
            }
        }
     }
}
