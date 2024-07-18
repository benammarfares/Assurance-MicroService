pipeline {
    agent any
    stages {
        stage('Build') {
            when {
                branch 'main'
            }
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'githubtoken', url: 'https://github.com/benammarfares/Assurance-MicroService.git']])
                sh 'mvn clean install'
            }
        }
        stage('Sonar Analysis on jenkins-sonar') {
            when {
                branch 'jenkins-sonar'
            }
            steps {
                checkout scmGit(branches: [[name: '*/jenkins-sonar']], extensions: [], userRemoteConfigs: [[credentialsId: 'githubtoken', url: 'https://github.com/benammarfares/Assurance-MicroService.git']])
                withSonarQubeEnv('sonar') {
                    sh 'mvn sonar:sonar'
                }
            }
        }
    }
    post {
        success {
            script {
                def branchToCheckout = 'jenkins-sonar'
                echo "Checking out ${branchToCheckout} branch"
                checkout scmGit(branches: [[name: "*/${branchToCheckout}"]], extensions: [], userRemoteConfigs: [[credentialsId: 'githubtoken', url: 'https://github.com/benammarfares/Assurance-MicroService.git']])
                echo "Executing Jenkinsfile on ${branchToCheckout} branch"
                sh 'jenkins-jobs/run.sh'
            }
        }
    }
}
