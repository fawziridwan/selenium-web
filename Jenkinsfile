pipeline {
    agent {
        docker {
            image 'maven:3.8.1-openjdk-11'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }

    tools {
        maven 'maven-3.8.1'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/fawziridwan/selenium-web.git '
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                script {
                    // Jalankan Selenium Grid dengan Docker
                    sh '''
                    docker run -d --name selenium-chrome \
                      -p 4444:4444 \
                      -p 5900:5900 \
                      selenium/standalone-chrome:latest

                    # Tunggu Selenium ready
                    sleep 30
                    '''

                    // Jalankan tests
                    sh 'mvn test -Dtest=WebTests'
                }
            }
            post {
                always {
                    // Cleanup Selenium container
                    sh 'docker stop selenium-chrome || true'
                    sh 'docker rm selenium-chrome || true'
                }
            }
        }

        stage('Reports') {
            steps {
                junit 'target/surefire-reports/*.xml'
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'target/surefire-reports',
                    reportFiles: '*.html',
                    reportName: 'HTML Report'
                ])
            }
        }
    }

    post {
        always {
            // Cleanup
            sh 'docker system prune -f'
        }
    }
}