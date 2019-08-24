node {
    stage("Say Hello"){
        properties([parameters([string(defaultValue: 'Caglar', description: 'Paste your name', name: 'NAME', trim: false)]), pipelineTriggers([cron('* * * * *')])])
        sh "echo Hello ${NAME}"
    }
}