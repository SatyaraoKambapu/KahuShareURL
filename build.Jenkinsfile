def label = "java11"

podTemplate {
  node(label) {
    def skipTheBuild = false
    
    stage('Git Setup') {
      container('java11builder') {
        try {
            env.CI_RUN = true

            checkout([$class: 'GitSCM',
              branches: scm.branches,
              doGenerateSubmoduleConfigurations: scm.doGenerateSubmoduleConfigurations,
              extensions: scm.extensions + [[$class: 'LocalBranch', localBranch: '**']],
              userRemoteConfigs: scm.userRemoteConfigs
            ])

            sh '''
              PROJECT_NAME=$(/bin/bash -c "cut -d/ -f2 <<<${JOB_NAME}")
              git config --global user.email "devops@spireon.com"
              git config --global user.name "ci-spireon"
              git remote remove origin
              git remote add origin https://$ORG_GRADLE_PROJECT_GITHUBOAUTH:x-oauth-basic@github.com/ProconGPS/${PROJECT_NAME}
              '''

            try {
              sh '''
                git pull origin ${BRANCH_NAME}
              '''
            } catch(exc) {
              println exc
            }
        } catch (exc) {
          println "Failed to checkout - ${currentBuild.fullDisplayName}"
          throw(exc)
        }
      }
    }

    stage('Build/Test') {
      container('java11builder') {
        try {
            sh './gradlew jib -Djib.httpTimeout=0'
        } catch (e) {
          println "Failed to build - ${currentBuild.fullDisplayName}"
          throw(e)
        }
      }
    }
  }
}