pipeline {
    environment {
      registry = "ykreddys/vedikaser:3${BUILD_NUMBER}"
      dockerImage = ''
    }
    agent any
	
	tools {
        gradle "gradle-6.2"
    }
	
    stages {
      /**  stage('SCM') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/ykishanreddy/Vedika-Service.git'
				}
			}  **/
		stage('Build') {
            steps {
                sh "gradle clean build"
				}
			}
			stage('Build Docker image') {
      steps {
            script{
             dockerImage= docker.build registry 
            }
        }
    }
	  
	  stage('Push Image'){
        steps{
            script{
        withDockerRegistry(credentialsId: 'dockerhubcredentials') {
            dockerImage.push()
             }
          }
       }
    }
	    stage('changed image tag name with build numebr') {
            steps {
            sh ("sed -i 's/ImageTag/${BUILD_NUMBER}/g' vedikaser-deployment.yml" )
			}
		}
		stage('Deploy to Kubernetes') {
            steps {
           sshagent(['kops-mechine']) {
           sh "scp -o StrictHostKeyChecking=no vedikaser-deployment.yml vedikaser-service.yml ubuntu@3.16.165.140:/home/ubuntu"
           sh "ssh ubuntu@3.16.165.140 kubectl apply -f vedikaser-deployment.yml"
          }
        }
     }  
    
    }

}
