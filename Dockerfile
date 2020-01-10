FROM tomcat
MAINTAINER ardy.dedase@gmail.com

COPY ROOT.war /usr/local/tomcat/webapps/

CMD ["catalina.sh", "run"]