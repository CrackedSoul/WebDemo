pipeline {
    agent {
            docker {
                image 'maven:3-alpine'
                args '-v /root/.m2:/root/.m2'
            }
    }
    stages {
        stage('Package') {
            steps {
                echo 'Package..'
                sh 'mvn clean package'
            }
        }
        stage('Build') {
            steps {
                echo 'Build..'
                sh 'mv -u target/demo-0.0.1-SNAPSHOT.jar  docker/demo.jar'
                sh "docker build -t demo:${GIT_BRANCH} docker/"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh 'docker run -d -p8081:8080  --name demo demo:master '
            }
        }
    }
}