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
            // Add a dependency on the configServer build
            dependsOn('Build configServer')
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
                    sh 'cd ..'
                }
            }
            // Add a dependency on the discoveryServer build
            dependsOn('Build discoveryServer')
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
                    sh 'cd ..'
                }
            }
            // Add a dependency on the gateway build
            dependsOn('Build gateway')
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
                    sh 'cd ..'
                }
            }
            // Add a dependency on the assurance build
            dependsOn('Build assurance')
        }
    }
}