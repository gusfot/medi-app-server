# medi-app-server
 - libraries 추가
mvn install:install-file -Dfile="ojdbc8.jar" -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=12.1 -Dpackaging=jar
mvn install:install-file -Dfile="ICERTSecu_JDK18.jar" -DgroupId=com.medi -DartifactId=ICERTSecu_JDK18 -Dversion=1.8 -Dpackaging=ja