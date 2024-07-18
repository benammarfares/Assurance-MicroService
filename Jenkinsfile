pipeline {
    agent {
        docker {
            image 'maven'
            args '-u root'
        }
    }

    stages {
        stage('Quality Gate Status Check') {
            steps {
                script {
                    dir('assurance') {
                        // Clean the Maven local repository cache
                        sh 'rm -rf ~/.m2/repository'

                        withSonarQubeEnv('sonarserver') {
                            sh 'mvn clean package sonar:sonar'
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
