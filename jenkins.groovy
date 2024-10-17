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
                    sonar-scanner -D"sonar.projectKey=python" \
                    -D"sonar.sources=." \
                    -D"sonar.host.url=http://localhost:9000" \
                    -D"sonar.login="sqp_a3341758da24ce578a453cc882da961cf095e41f"
                    """
                }
            }
        }
    }
}
