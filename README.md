# medi-app-server
 - libraries 추가
mvn install:install-file -Dfile="ojdbc8.jar" -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=12.1 -Dpackaging=jar
mvn install:install-file -Dfile="ICERTSecu_JDK18.jar" -DgroupId=com.medi -DartifactId=ICERTSecu_JDK18 -Dversion=1.8 -Dpackaging=jar

 - 개발 DB 세팅(https://hub.docker.com/r/wnameless/oracle-xe-11g/)
 - docker run -d -p 49161:1521 -e ORACLE_ENABLE_XDB=true wnameless/oracle-xe-11g