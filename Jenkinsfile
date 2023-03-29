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
                sh "mvn clean install"
            }
        }

   /* stage("Unit Test"){
       steps {
           sh 'mvn test'
       }
    }*/
    stage("Sonar"){
        steps{
         script{
           def scannerHome = tool 'SonarQube Server'
           withSonarQubeEnv('sonar-server') {
              sh "${scannerHome}/bin/sonar-scanner"
             }
           }
        }
    }
}

}