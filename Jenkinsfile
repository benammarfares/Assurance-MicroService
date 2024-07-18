pipeline {
    agent any

    environment {
        MAVEN_HOME = '/usr/share/maven'
        MAVEN_REPO_LOCAL = '/usr/share/maven-repo'
        MAVEN_OPTS = '-Xmx4096m'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn -s $MAVEN_HOME/conf/settings.xml -Dmaven.repo.local=$MAVEN_REPO_LOCAL clean install'
            }
        }

        stage('SonarQube analysis') {
            steps {
                dir('assurance') {
                    withSonarQubeEnv('sonarserver') {
                        sh 'mvn -s $MAVEN_HOME/conf/settings.xml -Dmaven.repo.local=$MAVEN_REPO_LOCAL sonar:sonar'
                    }
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}