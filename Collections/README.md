##Collections

![Arquitetura Collection](https://www3.ntu.edu.sg/home/ehchua/programming/java/images/Collection_interfaces.png)


ENTENDER OS TIPOS DE FILA, LIFO,FIFO ETC
#####Iterable
É a Interface raíz da API Collection, quem implementa essa classe consegue fazer o loop for each (String minhaString : listaStrings)'.

#####Collection
É uma das Interfaces raíz

####List
Interface que representa uma lista de objetos ordenados por índice, ou seja, você por acessar um objeto diretamente pelo índice,
e pode possuir objetos duplicados.
######List Tipos de implementações

* ArrayList
* LinkedList
* Stack
* Vector

Maneiras de percorrer uma lista
foreach
```java
List<String> listaNomes = new ArrayList<String>();
for(String nome : listaNomes){
   System.out.println(nome);
}
```
for each com contador
```java
List<String> listaNomes = new ArrayList<String>();
for(int contador = 0; contador < listaNomes.size(); contador++){
   System.out.println(listaNomes.get(contador));
}
```

iterator
```java
List<String> listaNomes = new ArrayList<String>();
Iterator<String> iterador = listaNomes.iterator();
    while(iterador.hasNext()){
       System.out.println(iterador.next());
    }
```

####Set
Interface que representa um conjunto de objetos que não podem ser repetidos, o cálculo é executado pelo hashcode e equals.
######Set Tipos de implementações

* HashSet - Não garante a ordem que os objetos foram inseridos nele.
* EnumSet - **estudar**
* LinkedHashSet - Garante a ordem que os objetos foram inseridos nele.
* TreeSet - Garante a ordem que os objetos, porém não pela inserção, e sim pelo calculo de ordenação ( compareTo())
é a única implementação que implementa NavigableSet -> SortedSet

TreeSet implementa o NavigableSet , existem métodos interessantes sobre:
TreeSet<String> minhaArvore = new TreeSet<String>(;

* descendingSet() - retorna um NavigableSet da minhaArvore com todos os registros na ordem ao contrário.
* descendingIterator() - retorna um Iterator com todos os objetos na ordem ao contrário.
 *headSet(3) - retorna um NavigableSet onde todos os registros são menores que 3, ou seja, limite < 3,só retorna 3 se o segundo argumeento for true.
 *tailSet(3) - retorna um NavigableSet onde todos os registros são maiores que 3, ou seja limite > 3, só retorna 3 se o segundo argumeento for true.
 *subSet - retorna de acordo com o range.
 *ceiling - retorna o menor objeto que seja igual ou maior que o valor passado, ou seja, se eu tenho um set de 1 até 7, e passar o valor 2, ele vai retornar 2, se não existir o 2 no set, ele irá retornar o 3.
 *floor - oposto do ceiling
 *higher - traz o próximo resto que seja maior que o do argumento, mas não pega registro igual.
 *lower - oposto do higher.
 pollFirst - REMOVE e retorna o primeiro registro do set , ou seja, o menor registro.
 pollLast - REMOVE e retorna o último registro do set, ou seja, o maior registro.


##Map
A interface Map representa um conjunto de chaves e valores, ela não é um subtipo de Collection.

#####Implementações do Map
* HashMap
* Hashtable
* EnumMap
* IdentityHashMap
* LinkedHashMap
* Properties
* TreeMap
* WeakHashMap
* 
###Iterando mapas.



##Queue
A interface Queue representa uma lista ordenada igual à List, mas ela age um pouquinho diferente. A Queue é designada para
adicionar elementos no final da fila( acho que lista mesmo ja faz isso ), e elementos removidos no começo da lista.Igual a uma fila de supermercado.
 
