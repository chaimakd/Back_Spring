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
   stage('Test Unitaire') {
     steps {
       sh './gradlew test'
     }
   }
    stage("SonarQube Test"){
     agent any
        steps{
           withSonarQubeEnv('sonar-server') {
              sh 'mvn clean package sonar:sonar'
             }
           }
        }
     }
   }
