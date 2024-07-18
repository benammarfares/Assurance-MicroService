pipeline {
    agent {
        docker {
            image 'maven:3.9.2-amazoncorretto-20'
            args '-v $HOME/.m2:/root/.m2'
        }
    }

    stages {
        stage('Quality Gate Status Check') {
            steps {
                script {
                    dir('assurance') {
                        withSonarQubeEnv('sonarserver') {
                            echo 'Running SonarQube Scan'
                        }
                        timeout(time: 1, unit: 'HOURS') {
                            def qg = waitForQualityGate()
                            if (qg.status != 'OK') {
                                error "Pipeline aborted due to quality gate failure: ${qg.status}"
                            }
                        }
                        sh "mvn clean install"
                    }
                }
            }
        }
    }
}