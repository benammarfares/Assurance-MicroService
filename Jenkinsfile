pipeline {
    agent none

    stages {
        stage("Build & SonarQube Analysis") {
            agent any
            steps {
                withSonarQubeEnv('sonarserver') {
                    sh 'mvn clean package sonar:sonar'
                }
            }
        }

        stage("Quality Gate") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}
