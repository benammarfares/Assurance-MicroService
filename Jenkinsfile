pipeline {
    agent {
        docker {
            image 'maven:3.9.2-amazoncorretto-20'
            args '-v $HOME/.m2:/root/.m2'
        }
    }
    stages {
        stage("Build & SonarQube Analysis") {
            steps {
                dir('assurance') {
                    withSonarQubeEnv('sonarserver') {
                        sh 'mvn clean package sonar:sonar'
                    }
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