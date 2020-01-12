pipeline {
    environment {
    registry = "sshukla30/capstone"
    registryCredential = 'docker-hub'
    }

    agent any
    stages {
	
        stage ('Cloning Git Repository') {
            steps {
                git 'https://github.com/sameershukla/cloud_devops_microservice.git'
            }
        }

	stage ('Build Repo') {
            steps {
		tool name: 'gradle-4.4.1', type: 'gradle'
                sh 'gradle clean build -x test'
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
