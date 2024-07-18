pipeline {
    agent {
        docker {
            image 'maven:3.9.2-amazoncorretto-20'
            args '-v $HOME/.m2:/home/jenkins/.m2'
        }
    }
    stages {
        stage("Create Maven Repository") {
            steps {
                sh 'mkdir -p /home/jenkins/.m2/repository'
                sh 'chmod -R 777 /home/jenkins/.m2/repository'
            }
        }
        stage("build & SonarQube analysis") {
            steps {
                dir('assurance') {
                    withSonarQubeEnv('sonarserver') {
                        sh 'mvn sonar:sonar'
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