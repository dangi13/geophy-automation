pipeline {
    agent any
    tools {
        maven 'Maven 3.8.6'
        jdk 'openjdk-11'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Install drivers') {
            steps {
                sh './scripts/InstallChrome.sh' 
            }
        }
        
        stage ('Build') {
            steps {
                sh 'mvn clean install' 
            }
        }
    }
}