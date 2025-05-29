pipeline {
  agent any
  tools {
    jdk 'jdk'
    maven 'maven'
  }

  environment {
    COVERAGE_THRESHOLD = '70'
    PUBLISH_DIR        = 'C:\\ProgramData\\Jenkins\\.jenkins\\target'
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Install') {
      steps {
        bat 'mvn clean install -DskipTests'
      }
    }

    stage('Analyze') {
      when { branch 'develop' }
      steps {
        bat 'mvn site -DskipTests'
      }
    }

    stage('Report') {
      when { branch 'develop' }
      steps {
        
        archiveArtifacts artifacts: '**/target/site/pmd.html', fingerprint: true, allowEmptyArchive: true
        
        publishHTML([
          reportName:           'Common PMD',
          reportDir:            'common/target/site',
          reportFiles:          'pmd.html',
          allowMissing:         true,
          alwaysLinkToLastBuild:true,
          keepAll:              true
        ])
        publishHTML([
          reportName:           'Utils PMD',
          reportDir:            'utils/target/site',
          reportFiles:          'pmd.html',
          allowMissing:         true,
          alwaysLinkToLastBuild:true,
          keepAll:              true
        ])
      }
    }

    stage('Test') {
      when {
        branch pattern: '^feature/.+', comparator: 'REGEXP'
      }
      steps {
        bat 'mvn test'
      }
    }

    stage('Coverage') {
      steps {
        
        bat "mvn test"

        
        dir('coverage') {
          bat "mvn verify -Dcoverage.threshold=${env.COVERAGE_THRESHOLD}"
        }

        
        publishHTML([
          reportName:           'Jacoco Coverage',
          reportDir:            'coverage/target/site/jacoco-aggregate',
          reportFiles:          'index.html',
          allowMissing:         true,
          alwaysLinkToLastBuild:true,
          keepAll:              true
        ])
      }
    }

    stage('Publish') {
      steps {
        bat 'mvn package -DskipTests'
        bat 'mvn install -DskipTests'
        bat "copy aggregator\\target\\*-jar-with-dependencies.jar %PUBLISH_DIR%\\"
        echo "Artifact published: ${env.PUBLISH_DIR}"
      }
    }
  }

  post {
    success {
      recordCoverage(
        tools: [[
          parser: 'JACOCO',
          pattern: 'coverage/target/site/jacoco-aggregate/jacoco.xml'
        ]],
        sourceCodeRetention: 'LAST_BUILD',
        failOnError: false,
        qualityGates: [[
          metric: 'LINE',
          threshold: env.COVERAGE_THRESHOLD.toInteger(),
          criticality: 'UNSTABLE'
        ]],
        checksAnnotationScope: 'SKIP'
      )
      echo 'Build successfully completed'
    }
    failure {
      echo 'Build failed'
    }
  }
}