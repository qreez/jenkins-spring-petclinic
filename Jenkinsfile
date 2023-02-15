#!/usr/bin/env groovy

pipeline {
    agent any
    triggers { pollSCM('* * * * *') }
    stages {

        stage('Build') {
            steps {
                sh '.mvnw clean package'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/TEST-*.xml'
            archiveArtifacts 'target/*.jar'
        }
    }
}