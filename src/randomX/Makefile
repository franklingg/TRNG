
#   Makefile for randomX package

VERSION = 1.1

SRC = randomX.java randomJava.java randomHotBits.java randomLCG.java \
      randomMCG.java randomLEcuyer.java randomXdemo.java

CLASS = $(SRC:.java=.class)

all:	
	javac -classpath ..  *java ; cp -p *class randomX

test:
	java randomXdemo

clean:
	rm -f *.bak *.class
	rm -rf doc
	mkdir doc
	rm -rf randomX
	mkdir randomX

RELEASE = $(SRC) Makefile

release:
	tar cfvz randomX.tar.gz $(RELEASE)

html:
	javadoc -classpath .. -d doc *.java

images:
	( cd $(JAVA)/images ; tar cfv /tmp/ZZimages.tar . )
	rm -rf doc
	mkdir doc
	mkdir doc/images
	(cd doc/images ; tar xfv /tmp/ZZimages.tar )
	rm -f /tmp/ZZimages.tar
	touch randomX.java

.SUFFIXES:  .java .class
