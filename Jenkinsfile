pipeline {
    environment {
    registry = "sshukla30/capstone"
    registryCredential = 'docker-hub'
    }

    agent any
    stages {
	    stage ('Cloning Git Repository') {
            steps {
                git 'ssh://git@github.com:sameershukla/cloud_devops_microservice.git'
            }
        }
	    
	 
	   stage('Gradle Build'){
	        steps{
	     	  sudo 'chmod +x ./gradlew'
		      sh './gradlew clean build'
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
                    withDockerRegistry([ credentialsId: "docker-hub", url: "" ]) {
                    sh 'docker push sshukla30/capstone'
                    }
                }
            }
        }
     }
}
