# drone

Para la resolución de este ejercicio he decidido usar la estructura de datos Grafo.

Se ha asumido que no se puede usar ninguna librería externa que lo implemente, por lo que se ha optado por implementar un Grafo.siguendo la filosofía TDD, es decir, se implementan las operaciones indispensables para poder resolver los 3 requisitos del enunciado.

Objetivos para la resolución del ejercicio:
- Implementar las mínimas operaciones necesarias para resolver el ejercicio
- Reducir la complejidad computacional
- Ofrecer una interfaz (API) con las operaciones que puede realizar un dron.

Asumpciones
- A cada pareja **CoordenadaX , Coordenada Y** le corresponde un **único** identificador de **urbanización** (1-1).  Esta relación se ha modelado con un a estructura de datos Map <String,String> cuya clave es un String compuesto por "CoordenadaX,CoordenadaY" y el valor es un identificador de urbanizacion . De este modo el acceso a una urbanización a partir de sus coordenadas tiene una complejidad computacional O(1)

- Cada urbanización ( identificador de urbanizacion) puede tener como máximo 4 urbanizaciones adyacentes 1 izquierda, 1 derecha, 1 arriba y 1 abajo .  Esta relación se ha modelado con un Grafo dirigido :
    - Vertices;  Son los identificadores de urbanizacion.
    - Aristas(edge) dirigidas y ponderadas (Edges) modelan la relación de adyacencia. 
    - Una arista tiene una urbanización destino, un peso y una dirección 
    - A través del identificador de urbanizacion se accede a las aristas con una complejidad computacional O(1) y a las aristas se accede en función de la dirección O(n) siendo N el número de aristas de una urbanización

- Para implementar el recorrido de las urbanizaciones adjacentes , se ha usado una pila.
