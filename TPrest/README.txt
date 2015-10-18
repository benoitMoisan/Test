Benoit Moisan.

TPrest.

Dans le repertoire TPrest :

*Compile the clients and the servers : 
mkdir bin
javac -cp "jars/*" -sourcepath src -d bin src/tprest/*.java

* Launch the Publisher :
java -cp "jars/*:bin"  tprest.Publisher

* From a different terminal launch the client :
java -cp "jars/*:bin"  tprest.JavaClient