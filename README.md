# drone

Para la resoluci�n de este ejercicio he decidido usar la estructura de datos Grafo.

Se ha asumido que no se puede usar ninguna librer�a externa que lo implemente, por lo que se ha optado por implementar un Grafo.siguendo la filosof�a TDD, es decir, se implementan las operaciones indispensables para poder resolver los 3 requisitos del enunciado.

Objetivos para la resoluci�n del ejercicio:
- Implementar las m�nimas operaciones necesarias para resolver el ejercicio
- Reducir la complejidad computacional
- Ofrecer una interfaz (API) con las operaciones que puede realizar un dron.

Asumpciones
- A cada pareja **CoordenadaX , Coordenada Y** le corresponde un **�nico** identificador de **urbanizaci�n** (1-1).  Esta relaci�n se ha modelado con un a estructura de datos Map <String,String> cuya clave es un String compuesto por "CoordenadaX,CoordenadaY" y el valor es un identificador de urbanizacion . De este modo el acceso a una urbanizaci�n a partir de sus coordenadas tiene una complejidad computacional O(1)

- Cada urbanizaci�n ( identificador de urbanizacion) puede tener como m�ximo 4 urbanizaciones adyacentes 1 izquierda, 1 derecha, 1 arriba y 1 abajo .  Esta relaci�n se ha modelado con un Grafo dirigido :
    - Vertices;  Son los identificadores de urbanizacion.
    - Aristas(edge) dirigidas y ponderadas (Edges) modelan la relaci�n de adyacencia. 
    - Una arista tiene una urbanizaci�n destino, un peso y una direcci�n 
    - A trav�s del identificador de urbanizacion se accede a las aristas con una complejidad computacional O(1) y a las aristas se accede en funci�n de la direcci�n O(n) siendo N el n�mero de aristas de una urbanizaci�n

- Para implementar el recorrido de las urbanizaciones adjacentes , se ha usado una pila.
