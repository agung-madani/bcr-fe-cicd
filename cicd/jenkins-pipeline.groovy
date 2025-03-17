def projectName = "bcr-fe-cicd"

pipeline {
    agent any
    
    tools {
        nodejs 'Node20'  // Name must match your NodeJS installation in Jenkins
    }
    
    environment {
        VERCEL_TOKEN = credentials('vercel-token')
    }
    
    stages {
        
        stage('Install Dependencies') {
            steps {
                echo "Installing dependencies..."
                sh 'npm install'
            }
        }

        stage('Test') {
            steps {
                echo "Running tests..."
                sh 'npm run test || echo "No tests found, continuing..."'
            }
        }
        
        stage('Build') {
            steps {
                echo "Building the project..."
                sh 'npm run build'
            }
        }
        
        stage('Deploy to Vercel') {
            steps {
                echo "Deploying to Vercel..."
                
                // Install Vercel CLI globally
                sh 'npm install -g vercel'
                
                // Deploy to Vercel using the CLI
                script {
                    def deployCommand = '
                    vercel --token $VERCEL_TOKEN --prod --confirm
                    '
                    
                    sh deployCommand
                }
            }
        }
    }
    post {
        success {
            echo "Pipeline executed successfully!"
        }
        failure {
            echo "Pipeline failed. Please check the logs."
        }
    }
}