Java IO (INPUT/OUTPUT).

Os termos Input e Output podem ser um pouco confuso. O input de uma parte da aplicação pode ser o output de outra parte e vice-versa.
Os tipos mais comuns são
Arquivos, Pipes, Coneções de rede, buffers de memória, system in/out,etc.


Fonte -> Programa -> Destino


IO Streams -> é o conceito principal no Java IO. A stream é conceitualmente um fluxo de data infinito.
Você pode tanto ler quanto escrever na stream. A stream é conectada no data source ou na data destination.
Streams podem ser tanto baseadas em byte ou caracteres.

Um programa que lê data de algum recurso é um InputStream ou Reader.
Um programa que escreve data para algum recurso é um OutputStream ou Writer.

Java IO possui um monte  de subclasses de entrada e saída, destinadas para tais necessidades.
-Acesso de Arquivo
-Acesso de Rede
-Acesso interno à memoria buffer.
-Comunicação inter-thread(pipes)
-Buffering
-Filtering
-Parsing
-Ler e Escrever textos(Reader/Writers)
-Ler e Escrever dados primitivos (long,int)
-Ler e Escrever objetos.

Tabelona : http://tutorials.jenkov.com/java-io/overview.html

Ler/Enviar dados

InputStream - Classe Abstrada - é utilizada para ler bytes baseados em dados, um byte de cada vez.

FileInputStream/BufferedInputStream/ObjectInputStream / existem outros.

FileInputStream

		InputStream inputstream = new FileInputStream("c:\\lol\\renan.txt");
	    int data = inputstream.read();
	    while(data != -1){
	        System.out.print((char) data);
	        data = inputstream.read();
	    }
	    inputstream.close();


BufferedInputStream - provêm buffer para os seus inputstreams.Ajuda na velocidade pq ele lê varios bytes de uma vez só em vez de um de cada vez.

		InputStream inputstream = new BufferedInputStream(new FileInputStream("c:\\lol\\renan.txt"));
	    int data = inputstream.read();
	    while(data != -1){
	        System.out.print((char) data);
	        data = inputstream.read();
	    }
	    inputstream.close();

	    Dá pra setar o tamanho do buffer no contrustor também, 8 * 1024 = 8KB , sempre use múltiplos de 1024 pq eles trabalham melhor com a maioria dos buffers dos hard disks.

ObjectInputStream -  Lê um objeto, deve ser um objeto gravado serializado.

        ObjectInputStream objectInputStream =
            new ObjectInputStream(new FileInputStream("data/person.bin"));

        Person personRead = (Person) objectInputStream.readObject();

        objectInputStream.close();

        System.out.println(personRead.name);
        System.out.println(personRead.age);


OutputStream - classe abstrata
FileOutputStream, BufferedOutputStream, ObjectOutputStream / existem outros.


FileOutputStream
OutputStream output = null;

try{
  output = new FileOutputStream("c:\\data\\output-text.txt");

  while(hasMoreData()) {
    int data = getMoreData();
    output.write(data);
  }
} finally {
    if(output != null) {
        output.close();
    }
}

BufferedOutputStream

OutputStream output = new BufferedOutputStream(
                      new FileOutputStream("c:\\data\\output-file.txt"));


ObjectOutputStream

        ObjectOutputStream objectOutputStream =
            new ObjectOutputStream(new FileOutputStream("data/person.bin"));

        Person person = new Person();
        person.name = "Jakob Jenkov";
        person.age  = 40;

        objectOutputStream.writeObject(person);
        objectOutputStream.close();



Baseados em caracteres :
Existem vários, mas os principais são : FileReader/BufferedReader e FileWriter/BufferedWriter / printwriter ?



FileReader

Reader fileReader = new FileReader("c:\\data\\input-text.txt");
int data = fileReader.read();
while(data != -1) {
  //do something with data...
  doSomethingWithData(data);

  data = fileReader.read();
}
fileReader.close();


BufferedReader - consegue ler linha inteira.

BufferedReader bufferedReader = new BufferedReader(
                      new FileReader("c:\\data\\input-file.txt"));

    String line = bufferedReader.readLine();
    while(line != null) {
        //do something with line
        line = bufferedReader.readLine();
    }
fileReader.close();


FileWriter

Writer fileWriter = new FileWriter("data\\filewriter.txt");

fileWriter.write("data 1");
fileWriter.write("data 2");
fileWriter.write("data 3");

fileWriter.close();

BufferedWriter

BufferedWriter bufferedWriter = 
    new BufferedWriter(new FileWriter("c:\\data\\output-file.txt"));
    bufferedWriter.write("data 1");
    
