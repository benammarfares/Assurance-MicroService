pipeline {
    agent {
        docker {
            image 'maven'
            args '-u root'
        }
    }

    stages {
        stage('Build configServer') {
            steps {
                dir('configServer') {
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

        stage('Build discoveryServer') {
            steps {
                dir('discoveryServer') {
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

        stage('Build gateway') {
            steps {
                dir('gateway') {
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

        stage('Build assurance') {
            steps {
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

        stage('Build assurancePolicy') {
            steps {
                dir('assurancePolicy') {
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