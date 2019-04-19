pipeline {
    agent none
    stages {
        stage('Package') {
            agent {
                    docker {
                        image 'maven:3-alpine'
                        args '-v /root/.m2:/root/.m2 '
                    }
            }
            steps {
                echo 'Package..'
                sh 'mvn clean package'
            }
        }
        stage('Build') {
            steps {
                echo 'Build..'
                sh 'mv  target/demo-0.0.1-SNAPSHOT.jar  docker/demo.jar'
                sh "docker build -t demo:${GIT_BRANCH} docker/"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Stopping ....'
                docker stop demo
                echo 'Deploying....'
                sh 'docker run --rm -d -p8081:8080  --name demo demo:master '
            }
        }
    }
}