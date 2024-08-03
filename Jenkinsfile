pipeline {
    agent any

    tools {
        maven 'Maven 3.6.3'
        jdk 'JDK 17'
    }

    stages {
        stage('Clean') {
            steps {
                script {
                    def mvnHome = tool 'Maven 3.6.3'
                    bat "'${mvnHome}/bin/mvn' clean"
                }
            }
        }
        stage('Build and Test') {
            steps {
                script {
                    def mvnHome = tool 'Maven 3.6.3'
                    bat "'${mvnHome}/bin/mvn' test"
                }
            }
        }
        stage('Allure Report') {
            steps {
                script {
                    def allureHome = tool 'Allure 2.13.8' // vagy a megfelelő Allure verzió
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