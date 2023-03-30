pipeline {
    agent any
    tools {
        maven 'M2_HOME'
    }
    stages {
        stage('Checkout Git') {
            steps {
                git branch: 'main', url: 'https://github.com/chaimakd/Back_Spring.git'
            }
        }
        stage("Build") {
            steps{
                sh "mvn clean install -DskipTests"
            }
        }

   /* stage("Unit Test"){

       steps {
           sh 'mvn test'
       }
    }*/
    stage("SonarQube Test code"){
     agent any
        steps{
           withSonarQubeEnv(credentialsId: 'jenkins-api') {
              sh 'mvn clean package sonar:sonar'
             }
           }
        }
     }
   }
