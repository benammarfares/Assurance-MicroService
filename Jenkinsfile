pipeline {
    agent {
        docker {
            image 'maven'
            args '-v /tmp:/tmp'
        }
    }

    stages {
        stage('Build configServer') {
            steps {
                script {
                    dir('configServer') {
                        // Clean the Maven local repository cache
                        sh 'rm -rf ~/.m2/repository'

                        withSonarQubeEnv('sonarserver') {
                            sh 'mvn clean package sonar:sonar'
                        }
                        sh "mvn clean install"
                    }
                    sh 'cd ..'
                }
            }
        }

        stage('Build discoveryServer') {
            when {
                // Only run this stage if the configServer build was successful
                expression { return env.STAGE_RESULT_Build_configServer == 'SUCCESS' }
            }
            steps {
                script {
                    dir('discoveryServer') {
                        withSonarQubeEnv('sonarserver') {
                            sh 'mvn clean package sonar:sonar'
                        }
                        sh "mvn clean install"
                    }
                    sh 'cd ..'
                }
            }
        }

        stage('Build gateway') {
            when {
                // Only run this stage if the discoveryServer build was successful
                expression { return env.STAGE_RESULT_Build_discoveryServer == 'SUCCESS' }
            }
            steps {
                script {
                    dir('gateway') {
                        withSonarQubeEnv('sonarserver') {
                            sh 'mvn clean package sonar:sonar'
                        }
                        sh "mvn clean install"
                    }
                    sh 'cd ..'
                }
            }
        }

        stage('Build assurance') {
            when {
                // Only run this stage if the gateway build was successful
                expression { return env.STAGE_RESULT_Build_gateway == 'SUCCESS' }
            }
            steps {
                script {
                    dir('assurance') {
                        withSonarQubeEnv('sonarserver') {
                            sh 'mvn clean package sonar:sonar'
                        }
                        sh "mvn clean install"
                    }
                    sh 'cd ..'
                }
            }
        }

        stage('Build assurancePolicy') {
            when {
                // Only run this stage if the assurance build was successful
                expression { return env.STAGE_RESULT_Build_assurance == 'SUCCESS' }
            }
            steps {
                script {
                    dir('assurancePolicy') {
                        withSonarQubeEnv('sonarserver') {
                            sh 'mvn clean package sonar:sonar'
                        }
                        sh "mvn clean install"
                    }
                    sh 'cd ..'
                }
            }
        }
    }
}