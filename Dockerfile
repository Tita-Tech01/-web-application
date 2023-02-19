FROM tomcat:9.0.71-jre11
COPY target/*.war /usr/local/tomcat/webapps/cohort7.war
