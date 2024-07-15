pipeline {
    agent any
    stages {
        stage('Build') {
            when {
                branch 'main'
            }
            steps {
                echo 'Building on the main branch...'
            }
        }
    }
}
