def projectName = "bcr-fe-cicd"

pipeline {
    agent any
    
    tools {
        nodejs 'Node20'  // Name must match your NodeJS installation in Jenkins
    }
    
    environment {
        VERCEL_TOKEN = credentials('vercel-token')
        GITHUB_REPO = "git@github.com:agung-madani/bcr-fe-cicd.git"
        BRANCH = "main"
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo "Checking out code from GitHub using SSH..."
                sshagent(['github-ssh-key']) {
                    // The first time you connect to a new host, you might need to approve the host key
                    sh '''
                        mkdir -p ~/.ssh
                        ssh-keyscan -H github.com >> ~/.ssh/known_hosts
                        git clone --branch ${BRANCH} ${GITHUB_REPO} .
                    '''
                }
            }
        }
        
    //     stage('Install Dependencies') {
    //         steps {
    //             echo "Installing dependencies..."
    //             sh 'npm install'
    //         }
    //     }
        
    //     stage('Lint') {
    //         steps {
    //             echo "Running linter..."
    //             sh 'npm run lint || true'  // Continue even if linting fails
    //         }
    //     }
        
    //     stage('Test') {
    //         steps {
    //             echo "Running tests..."
    //             sh 'npm test || echo "No tests found, continuing..."'
    //         }
    //     }
        
    //     stage('Build') {
    //         steps {
    //             echo "Building the project..."
    //             sh 'npm run build'
    //         }
    //     }
        
    //     stage('Deploy to Vercel') {
    //         steps {
    //             echo "Deploying to Vercel..."
                
    //             // Install Vercel CLI globally
    //             sh 'npm install -g vercel'
                
    //             // Deploy to Vercel using the CLI
    //             script {
    //                 def deployCommand = """
    //                 vercel --token ${VERCEL_TOKEN} --prod --confirm
    //                 """
                    
    //                 sh deployCommand
    //             }
    //         }
    //     }
    // }
    
    // post {
    //     success {
    //         echo "Pipeline executed successfully!"
    //     }
    //     failure {
    //         echo "Pipeline failed. Please check the logs."
    //     }
    //     always {
    //         echo "Cleaning up workspace..."
    //         cleanWs()
    //     }
    // }
}