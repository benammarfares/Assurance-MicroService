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
                        sh "mvn clean compile test"
                    }
                    sh 'cd'
                }
            }
        }

        stage('Build discoveryServer') {
            steps {
                script {
                    dir('discoveryServer') {
                        withSonarQubeEnv('sonarserver') {
                            sh 'mvn sonar:sonar'
                        }
                        sh "mvn clean compile test"
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
                        sh "mvn clean compile test"
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
                        sh "mvn clean compile test"
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
                        sh "mvn clean compile test"
                    }
                }
            }
        }
    }
}