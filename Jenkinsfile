pipeline {
    agent {
        docker {
            image 'maven'
            args "-v /tmp:/tmp"
        }
    }

    stages {
        stage('Build configServer') {
            steps {
                script {
                    dir('configServer') {
                        withSonarQubeEnv('sonarserver') {
                            sh 'mvn clean package sonar:sonar'
                        }
                        sh "mvn clean install"
                    }
                    sh 'cd'
                }
            }
        }

        stage('Build discoveryServer') {
            steps {
                script {
                    dir('assurance') {

                        withSonarQubeEnv('sonarserver') {
                            sh 'mvn clean package sonar:sonar'
                        }
                        sh "mvn clean install"
                    }
                    sh 'cd'
                }
            }
        }

        stage('Build gateway') {
            steps {
                script {
                    dir('assurancePolicy') {

                        withSonarQubeEnv('sonarserver') {
                            sh 'mvn clean package sonar:sonar'
                        }
                        sh "mvn clean install"
                    }
                }
            }
        }

        stage('Build assurance') {
            steps {
                script {
                    dir('gateway') {

                        withSonarQubeEnv('sonarserver') {
                            sh 'mvn clean package sonar:sonar'
                        }
                        sh "mvn clean install"
                    }
                }
            }
        }

        stage('Build assurancePolicy') {
            steps {
                script {
                    dir('discorveryServer') {

                        withSonarQubeEnv('sonarserver') {
                            sh 'mvn clean package sonar:sonar'
                        }
                        sh "mvn clean install"
                    }
                }
            }
        }
    }
}