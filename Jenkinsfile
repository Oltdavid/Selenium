pipeline {
    agent any

    tools {
        maven '3.8.1'
        jdk 'Java 17'
    }

    stages {
        stage('Clean') {
            steps {
                script {
                    def mvnHome = tool 'Maven 3.8.1'
                    bat "'${mvnHome}/bin/mvn' clean"
                }
            }
        }
        stage('Build and Test') {
            steps {
                script {
                    def mvnHome = tool 'Maven 3.8.1'
                    bat "'${mvnHome}/bin/mvn' test"
                }
            }
        }
        stage('Allure Report') {
            steps {
                script {
                    def allureHome = tool 'Allure 2.29.0'
                    bat "'${allureHome}/bin/allure' generate 'target/allure-results' -o 'target/allure-report' --clean"
                }
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts 'target/allure-results/**/*'
            allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
        }
    }
}