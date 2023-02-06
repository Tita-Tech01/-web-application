node{
	def mavenHome = tool name: 'Maven 3.8.7'
	stage('1cloneCode')
	{
		git "https://github.com/Tita-Tech01/-web-application.git"
	}
	stage('2Test&Build')
	{
	sh "${mavenHome}/bin/mvn clean package"
	//bat "mvn clean package"
	}
	stage('3codeQuality')
	{
	sh "${mavenHome}/bin/mvn clean sonar:sonar"
	}
	stage('4uploadArtifactory')
	{
	sh "${mavenHome}/bin/mvn deploy"
	}
	stage('5deploy2UAT')
	{
	sh "echo 'deploy to UAT' "
	deploy adapters: [tomcat9(credentialsId: 'bob_tomcat_credential', path: '', url: 'http://100.24.20.142:8080/')], contextPath: null, war: 'target/*war'
	}
	stage('6approvalGate')
	{
	sh "echo 'Ready For Review' "
	timeout(time:9, unit:'HOURS')
	   {
	input message: 'Application ready for deployment, Please review and approve.'
	   }
	}
	stage('7deploy2prod')
	{
        sh "sleep 30"
	deploy adapters: [tomcat9(credentialsId: 'bob_tomcat_credential', path: '', url: 'http://100.24.20.142:8080/')], contextPath: null, war: 'target/*war'    
	}
	stage('8emailNotification')
	 {
	emailext body: '''Hi,
You got notified to check build project.

Regards,
 Bob''', recipientProviders: [buildUser()], subject: 'Build status', to: 'titauc@aol.com'
	 }
	}
