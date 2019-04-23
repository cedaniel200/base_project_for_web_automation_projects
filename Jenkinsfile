pipeline {
    agent any
    triggers { cron('H */4 * * 1-5') }
    stages {
        stage('build') {
            steps {
                bat 'gradle clean build -x test'
            }
        }
        stage('test-chrome') {
            steps {
                bat 'gradle test -Dcontext=chrome -Dwebdriver.driver=chrome'
            }
        }
        stage('test-firefox') {
            steps {
                bat 'gradle test -Dcontext=firefox -Dwebdriver.driver=firefox'
            }
        }
        stage('aggregate') {
            steps {
                bat 'gradle aggregate'
            }
            post {
                always {
                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: false,
                        reportDir: 'target/site/serenity',
                        reportFiles: 'index.html',
                        reportName: 'Resultado de los Tests',
                        reportTitles: ''])
                }
            }
        }
    }
}