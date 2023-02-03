pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/qreez/jenkins-spring-petclinic'
                
               
            }
        }
        stage('Build') {
            steps {
              sh './mvnw clean package'   
            }
        
            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
