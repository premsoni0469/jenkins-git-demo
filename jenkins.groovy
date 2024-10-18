pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deployment will be done on my Birthday!!'
            }
        }
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('SonarHome')
                {
                    bat script: """
                    sonar-scanner -D"sonar.projectKey=python1" \
                    -D"sonar.sources=." \
                    -D"sonar.host.url=http://localhost:9000" \
                    -D"sonar.login="sqp_93e1e1a90dc4343d66fdb59ec17ccc2620196227"
                    """
                }
            }
        }
    }
}
