pipeline{
    agent any
    options{
    buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
    }
    tools{maven 'maven_3.8.8'}

    stages{
        stage('Code Compilation'){
            steps{
                sh 'mvn clean compile'
            }
        }

        stage('Code Test'){
            steps{
                sh 'mvn clean test'
            }
        }

        stage('Code Package'){
            steps{
                sh 'mvn clean package'
            }
        }
        stage('SonarQube'){
            environment{
                scannerHome = tool 'SonarQubeScanner'
            }
            steps{
             withSonarQubeEnv('sonar-server'){
                    sh '${scannerHome}/bin/sonar-scanner'
                    sh 'mvn sonar:sonar -X'
                } // withSonarQubeEnv end
                timeout(time:10, unit: 'MINUTES'){waitForQualityGate abortPipeline: True}
            }
        }

    } // stages end
} // pipeline end
