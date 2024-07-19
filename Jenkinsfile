pipeline {
    agent {
        docker {
            image 'maven'
            args '-u root'
        }
    }

        stage('Build configServer') {
            steps {
                dir('configServer') {
                    sh './mvnw clean install'
                }
            }
        }

        stage('Build discorveryServer') {
            steps {
                dir('discorveryServer') {
                    sh './mvnw clean install'
                }
            }
        }

        stage('Build gateway') {
            steps {
                dir('gateway') {
                    sh './mvnw clean install'
                }
            }
        }

        stage('Build assurance') {
            steps {
                dir('assurance') {
                    sh './mvnw clean install'
                }
            }
        }

        stage('Build assurancePolicy') {
            steps {
                dir('assurancePolicy') {
                    sh './mvnw clean install'
                }
            }
        }

        stage('Quality Gate Status Check') {
            steps {
                script {
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
                }
            }
        }
    }
}