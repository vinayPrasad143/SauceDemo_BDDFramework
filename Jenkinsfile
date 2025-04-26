pipeline {
    agent any

    tools {
        maven 'Maven'  // Make sure Maven is configured in Jenkins Global Tools
        jdk 'JDK17'    // Configure JDK 17 or whichever you use
    }

    environment {
        REPORT_PATH = "**/target/cucumber-reports/*.json"
        EMAIL_RECIPIENTS = "yourteam@example.com"
    }

    stages {
        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Build and Execute Tests') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Publish Cucumber Reports') {
            steps {
                cucumber buildStatus: 'UNSTABLE',
                         fileIncludePattern: "${REPORT_PATH}",
                         sortingMethod: 'ALPHABETICAL'
            }
        }
        stage('Archive Extent Report') {
            steps {
                archiveArtifacts artifacts: 'target/extent-report/**', allowEmptyArchive: true
            }
        }
    }

    post {
        success {
            echo '✅ Build Successful. Sending Email...'
            emailext (
                subject: "SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """<p>✅ The build succeeded!</p>
                         <p> See the <a href="${env.BUILD_URL}cucumber-html-reports/overview-features.html">Cucumber Report</a></p>
                          <p>📝 <b>Extent Report:</b> <a href="${env.BUILD_URL}artifact/target/extent-report/index.html">View Extent Report</a></p>
                          <p>📝 <b>Cucumber Report:</b> <a href="${env.BUILD_URL}cucumber-html-reports/overview-features.html">View Cucumber Report</a></p>""",
                to: "${EMAIL_RECIPIENTS}",
                mimeType: 'text/html'
            )
        }
        failure {
            echo '❌ Build Failed. Sending Email...'
            emailext (
                subject: "FAILURE: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """<p>❌ The build failed!</p>
                         <p>See <a href="${env.BUILD_URL}console">Console Output</a> for more details.</p>""",
                to: "${EMAIL_RECIPIENTS}",
                mimeType: 'text/html'
            )
        }
        always {
            cleanWs()
        }
        failure {
            retry(2) {
                sh 'mvn clean test'
            }
        }
    }
}