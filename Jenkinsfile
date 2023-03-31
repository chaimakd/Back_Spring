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
     when {
       changeset "src/**"
     }
     steps {
       sh 'mvn test'
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
 stage('Nexus deploy'){
   steps{
    script{
     nexusArtifactUploader artifacts:
	 [
	  [
	    artifactId: 'tpAchatProject',
		classifier: '', file: 'target/Achat.jar',
		type: 'jar'
		]
	],
	credentialsId: 'nexus-auth',
	groupId: 'com.esprit.examen',
	nexusUrl: 'localhost:8081',
	nexusVersion: 'nexus3',
	protocol: 'http',
	repository: 'TpAchatSpring3',
	version: '1.0'
	}
  }
 }
  }
}
