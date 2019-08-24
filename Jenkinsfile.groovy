node {
    stage("Pull Repo"){
        properties([parameters([string(defaultValue: '3.18.214.214', description: '''Dev:3.18.214.214 QA:3.19.61.100 Prod:18.219.49.241''', name: 'Remote_instance', trim: true)])])
        git 'https://github.com/chaglare/jenkins.git'
    }
    stage("Install Apache"){
        sh "ssh   ec2-user@${Remote_instance}   sudo yum install httpd -y "
    }
    stage("Create Index.html"){
        sh "scp  index.html  ec2-user@${Remote_instance}:/tmp "
    }
    stage("Move File"){
        sh "ssh   ec2-user@${Remote_instance}    sudo mv /tmp/index.html  /var/www/html/index.html"
    }
    stage(){
        sh "ssh   ec2-user@${Remote_instance}    sudo systemctl start httpd "
    }
}