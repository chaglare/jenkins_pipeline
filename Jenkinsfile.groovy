node {
    stage("Say Hello"){
        properties([parameters([string(defaultValue: '3.18.214.214', description: '''Dev:3.18.214.214 QA:3.19.61.100 Prod:18.219.49.241''', name: 'Remote_instance', trim: true)])])
        git 'https://github.com/chaglare/jenkins.git'
    }
}