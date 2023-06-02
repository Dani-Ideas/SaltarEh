# Saltar Eh 
### indice
- Descripción general del proyecto (no técnica)
- Descripción general del flujo del ciclo principal del juego
- Descripción de los objetos

### Descripción general del proyecto
Este proyecto nació como un proyecto de mi clase de programación orientada a objetos.
 
El videojuego consta de un personaje que tiene que saltar de forma infinita en una serie de plataformas que van cayendo y aparecen nuevas en la parte superior de la pantalla. El videojuego se pone más difícil conforme aumenta el puntaje del jugador. Existen distintas plataformas con las que tiene que interactuar el jugador para hacerlo más divertido. El jugador tiene la capacidad de dispararle a los múltiples enemigos que aparecen.
###Descripción general del flujo
El videojuego se sustenta en la librería edu.epromero escrita por Ernesto Peñalosa Romero. El programa se divide en distintas fases:

- Fase de creación de objetos:
En esta fase se utiliza un algoritmo que genera los distintos tipos de plataformas y enemigos, garantizando que no se superpongan entre sí. Además, posiciona a los enemigos encima de las plataformas para garantizar que estén apoyados y no caigan al vacío.

- Fase de mover objetos:
Monitorea los movimientos del jugador (flechas del teclado y barra espaciadora) para mostrarlos en pantalla. Mueve verticalmente todas las plataformas y enemigos hacia abajo para acercarlos a la lava.

- Fase de comprobación de colisión:
Después de mover los múltiples objetos, se realiza una comprobación de las colisiones del jugador y los enemigos con los distintos objetos de interés, como las balas y las plataformas, para que interactúen.

- Fase de impresión de objetos:
Muestra los distintos objetos en sus nuevas posiciones.
- borra todos los objetos en pantalla
###Plataformas
                    
Plataforma  | Tipo| característica
------------- | -------------
Basica  | Plataform_Basic| es estatica 
Plataforma movil  | Platform_Move| se mueve de izquierda a derecha 
