pipeline {
    agent {
        docker {
            image 'maven:3.9.2-amazoncorretto-20'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
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
