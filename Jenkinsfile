  
pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "mvn 3"
    }
	
    triggers {
        githubPush()
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/jglick/simple-maven-project-with-tests.git'
            }
        }

        stage('Build') {
            steps {

                // Run Maven on a Unix agent.
                // sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                bat "C:\\Users\\Administrator\\Desktop\\apache-maven-3.6.3\\bin\\mvn.cmd -Dmaven.test.failure.ignore=true clean install"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
		
		stage('Test') {
            steps {
                echo "hello ! C:\\Users\\Administrator\\Desktop\\apache-maven-3.6.3\\bin\\mvn.cmd -Dmaven.test.failure.ignore=true clean test"
            }
        }
    }
}
