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
                script {
                    dir('configServer') {
                        // Clean the Maven local repository cache
                        sh 'rm -rf ~/.m2/repository'

                        withSonarQubeEnv('sonarserver') {
                            sh 'mvn clean package sonar:sonar'
                        }
                        sh "mvn clean install"
                    }
                }
            }
        }

        stage('Build discoveryServer') {
            steps {
                script {
                    dir('discoveryServer') {

                        withSonarQubeEnv('sonarserver') {
                            sh 'mvn clean package sonar:sonar'
                        }
                        sh "mvn clean install"
                    }
                }
            }
        }

        stage('Build gateway') {
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

        stage('Build assurance') {
            steps {
                script {
                    dir('assurance') {

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
                    dir('assurancePolicy') {

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