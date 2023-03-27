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
        stage("Compilation") {
            steps{
                sh "mvn clean install -DskipTests"
            }
        }
    }
}