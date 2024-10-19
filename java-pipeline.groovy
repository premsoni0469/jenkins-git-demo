pipeline {
    agent any

    stages {
        stage('Compile Java Program') {
            steps {
                // Compile the Java program from the JenkinsPipeline folder
                bat 'javac C:\\JenkinsPipeline\\Test2.java'
            }
        }
        stage('Run Java Program') {
            steps {
                // Run the Java program from the JenkinsPipeline folder
                bat 'java -cp C:\\JenkinsPipeline Test2'
            }
        }
    }
}
