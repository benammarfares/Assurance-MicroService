pipeline {
    environment {
        JAVA_TOOL_OPTIONS = "-Duser.home=/var/maven"
    }
    agent {
        docker {
            image 'maven'
            args "-v /tmp/maven:/var/maven/.m2 -e MAVEN_CONFIG=/var/maven/.m2"
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