pipeline {
    agent any

    environment {
        // Define the SonarQube server name and the SonarQube scanner version
        SONARQUBE_SERVER = 'sonarserver'
        SONARQUBE_SCANNER = 'SonarQube Scanner'
    }

    tools {
        // Specify the JDK version and SonarQube Scanner version
        jdk 'JDK 20'
        sonarQubeScanner "${SONARQUBE_SCANNER}"
    }

    stages {
        stage('Checkout') {
            steps {
                // Clone the Git repository
                git 'https://github.com/benammarfares/Assurance-MicroService.git'
            }
        }

        stage('Build and Analyze') {
            steps {
                script {
                    // Run the SonarQube analysis
                    withSonarQubeEnv("${SONARQUBE_SERVER}") {
                        sh 'mvn clean verify sonar:sonar'
                    }
                }
            }
        }

        stage('Quality Gate') {
            steps {
                // Wait for the SonarQube analysis report and check the quality gate status
                waitForQualityGate abortPipeline: true
            }
        }
    }

    post {
        always {
            // Archive the SonarQube report
            recordIssues(tools: [sonarQube(issuePattern: '**/*.xml')])
        }
    }
}
