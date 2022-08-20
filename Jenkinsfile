pipeline {
	agent any
	environment{
		dockerHome = tool 'myDocker'
		mavenHome = tool 'myMaven'
		PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
	}
	stages{
		stage('Checkout'){
			steps{
				sh 'mvn --version'
				sh 'docker --version'
				echo "Build"
				echo "path - $PATH"
				echo "buildowner - $env.BUILD_NUMER"
				echo "branch name -  $env.BRANCH_NAME"
				echo "Docker Image - $docker.Image.id"
				echo "Branch Name - $env.BRANCH_NAME"

			}
		}
	stage('Compile'){
			steps{
				sh "mvn clean compile"
			}
		}
		stage('Test'){
			steps{
				sh "mvn test"
				
			}
		}
		

		stage('Package'){
			steps{
				sh "mvn package -DskipTests"
			
			}
		}
		stage('scenario Checking Custom Ven'){
		steps{
			sh "java --version"
			sh  "echo 'Venkat Checking'"
		
		}
	}


		stage('Build Docker Image'){
			steps{
				//"docker build -t venkatkrish/jenkcurrency-exchange:$env.BUILD_TAG"
				script{
					dockerImag = docker.build("venkatkrish/sceninjenk:${env.BUILD_TAG}")
				}
			}
		}
		stage('Build Docker push'){
			steps{
				//"docker build -t venkatkrish/jenkcurrency-exchange:$env.BUILD_TAG"
				script{
						docker.withRegistry('','dockerhub'){
							dockerImag.push()
							dockerImag.push('latest') 
					}
				}
			}
		}
	}
}