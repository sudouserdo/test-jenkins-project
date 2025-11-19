pipeline {
  agent any
//   agent {
//     docker {
//       image 'vegardit/graalvm-maven:22.3.3-java11'
//     }
//   }

  environment {
    IMAGE_NAME = "eurodyn-project"
    IMAGE_TAG  = "latest"
  }

  stages {
    stage('Build') {
      steps {
        sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
      }
    }

    stage('Save & Archive') {
      steps {
        sh "docker save ${IMAGE_NAME}:${IMAGE_TAG} -o ${IMAGE_NAME}_${IMAGE_TAG}.tar"
        archiveArtifacts artifacts: "${IMAGE_NAME}_${IMAGE_TAG}.tar", fingerprint: true
      }
    }
  }
}
