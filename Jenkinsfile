pipeline {
    agent {
        docker {
            image 'maven'
            args '-u root -v $HOME/.m2:/root/.m2'
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
                        sh "mvn clean compile"
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
                        sh "mvn clean compile"
                    }
                    sh 'cd ..'
                }
            }
        }

        stage('Build assurance') {
            steps {
                script {
                    dir('assurance') {
                        withSonarQubeEnv('sonarserver') {
                            sh 'mvn sonar:sonar'
                        }
                        sh "mvn clean compile"
                    }
                    sh 'cd ..'
                }
            }
        }

        stage('Build assurancePolicy') {
            steps {
                script {
                    dir('assurancePolicy') {
                        sh "mvn clean compile"
                        withSonarQubeEnv('sonarserver') {
                            sh 'mvn sonar:sonar'
                        }
                        sh "mvn clean compile"
                    }
                    sh 'cd ..'
                }
            }
        }

        stage('Build gateway') {
            steps {
                script {
                    dir('gateway') {

                        withSonarQubeEnv('sonarserver') {
                            sh 'mvn sonar:sonar'
                        }
                        sh "mvn clean compile"
                    }
                    sh 'cd ..'
                }
            }
        }
    }
}