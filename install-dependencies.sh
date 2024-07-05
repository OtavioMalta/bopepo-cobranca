#!/bin/bash

# Instalação das dependências locais no repositório local do Maven
mvn install:install-file -Dfile=lib/jrimum-domkee-0.2.3-DEV-SNAPSHOT.jar -DgroupId=org.jrimum -DartifactId=jrimum-domkee -Dversion=0.2.3-DEV-SNAPSHOT -Dpackaging=jar
mvn install:install-file -Dfile=lib/jrimum-texgit-0.2.3-DEV-SNAPSHOT.jar -DgroupId=org.jrimum -DartifactId=jrimum-texgit -Dversion=0.2.3-DEV-SNAPSHOT -Dpackaging=jar
mvn install:install-file -Dfile=lib/jrimum-utilix-0.2.3-DEV-SNAPSHOT.jar -DgroupId=org.jrimum -DartifactId=jrimum-utilix -Dversion=0.2.3-DEV-SNAPSHOT -Dpackaging=jar
mvn install:install-file -Dfile=lib/itext-2.0.8.jar -DgroupId=com.lowagie -DartifactId=itext -Dversion=2.0.8 -Dpackaging=jar
mvn install:install-file -Dfile=lib/commons-lang3-3.7.jar -DgroupId=org.apache.commons -DartifactId=commons-lang3 -Dversion=3.7 -Dpackaging=jar
mvn install:install-file -Dfile=lib/log4j-1.2.17.jar -DgroupId=log4j -DartifactId=log4j -Dversion=1.2.17 -Dpackaging=jar
mvn install:install-file -Dfile=lib/jrimum-vallia-0.2.3-DEV-SNAPSHOT.jar -DgroupId=org.jrimum -DartifactId=jrimum-vallia -Dversion=0.2.3-DEV-SNAPSHOT -Dpackaging=jar
mvn install:install-file -Dfile=lib/commons-io-2.4.jar -DgroupId=commons-io -DartifactId=commons-io -Dversion=2.4 -Dpackaging=jar
mvn install:install-file -Dfile=lib/guava-jdk5-14.0.1.jar -DgroupId=com.google.guava -DartifactId=guava-jdk5 -Dversion=14.0.1-jre -Dpackaging=jar
mvn install:install-file -Dfile=lib/hamcrest-all-1.3.jar -DgroupId=org.hamcrest -DartifactId=hamcrest-all -Dversion=1.3 -Dpackaging=jar
mvn install:install-file -Dfile=lib/itextpdf-5.4.5.jar -DgroupId=com.itextpdf -DartifactId=itextpdf -Dversion=5.4.5 -Dpackaging=jar
mvn install:install-file -Dfile=lib/junit-4.11.jar -DgroupId=junit -DartifactId=junit -Dversion=4.11 -Dpackaging=jar
mvn install:install-file -Dfile=lib/mockito-all-1.9.5.jar -DgroupId=org.mockito -DartifactId=mockito-all -Dversion=1.9.5 -Dpackaging=jar
mvn install:install-file -Dfile=lib/commons-lang-2.6.jar -DgroupId=org.apache.commons -DartifactId=commons-lang -Dversion=2.6 -Dpackaging=jar
