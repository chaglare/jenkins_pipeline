node {
    stage("Say Hello"){
        git "https://github.com/chaglare/jenkins.git"
        sh "echo Hello ${NAME}"
    }
}