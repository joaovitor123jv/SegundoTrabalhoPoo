#Fontes
COMPILADOR=javac
CODIGO=src/trabalho/*.java
INICIO=trabalho.Inicio

JAVA=jar
CONCATENAR=cfm
JAR_NAME=Trabalho.jar
MANIFEST=Manifest.txt
CLASSES=trabalho/*.class




all:
	$(COMPILADOR) $(CODIGO) -d ./

debug:
	$(COMPILADOR) -g $(CODIGO) -d ./
	
build:
	$(COMPILADOR) $(CODIGO) -d ./
	echo "Main-Class: $(INICIO)">Manifest.txt
	$(JAVA) $(CONCATENAR) $(JAR_NAME) $(MANIFEST) $(CLASSES)
	chmod +x $(JAR_NAME)
#	rm $(CLASSES)
