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

                        withSonarQubeEnv('sonarserver') {
                            sh 'mvn sonar:sonar'
                        }
                        sh "mvn clean verify"
                    }
                    sh 'cd ..'
                }
            }
        }

        stage('Build discoveryServer') {
            steps {
                script {
                    dir('discorveryServer') {
                        withSonarQubeEnv('sonarserver') {
                            sh 'mvn sonar:sonar'
                        }
                        sh "mvn clean verify"
                    }
                    sh 'cd ..'
                }
            }
        }

        stage('Build gateway') {
            steps {
                script {
                    dir('assurance') {

                        withSonarQubeEnv('sonarserver') {
                            sh 'mvn sonar:sonar'
                        }
                        sh "mvn clean verify"
                    }
                }
            }
        }

        stage('Build assurance') {
            steps {
                script {
                    dir('assurancePolicy') {

                        withSonarQubeEnv('sonarserver') {
                            sh 'mvn sonar:sonar'
                        }
                        sh "mvn clean verify"
                    }
                }
            }
        }

        stage('Build assurancePolicy') {
            steps {
                script {
                    dir('gateway') {

                        withSonarQubeEnv('sonarserver') {
                            sh 'mvn sonar:sonar'
                        }
                        sh "mvn clean verify"
                    }
                }
            }
        }
    }
}