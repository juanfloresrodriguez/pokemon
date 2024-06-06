# Proyecto Pokémon

## Introducción

Akira Toriyama creó justo antes de morir en 2024 una máquina para entrenar Pokémon, de forma que los entrenadores pueden poner en práctica las habilidades de sus Pokémon y mejorar. La máquina simula un Pokémon de gran poder al que tendremos que derrotar. Es este:

### TUX

| NIVEL | PS-HP | AT  | DEF | S_AT | S_DEF | VEL |
|-------|-------|-----|-----|------|-------|-----|
| 100   | 444   | 372 | 372 | 372  | 372   | 372 |
| 75    | 350   | 220 | 220 | 220  | 220   | 220 |
| 50    | 227   | 189 | 189 | 189  | 189   | 189 |
| 25    | 180   | 112 | 112 | 112  | 112   | 112 |

PS: puntos de salud / AT: ataque / DEF: defensa / S_AT: ataque especial / S_DEF: defensa especial / VEL: velocidad

Nuestro trabajo es montar un simulador escrito en JAVA. La interfaz de la aplicación será algo parecido a lo que se incluye en los anexos.

La base de datos sobre la que trabajaremos está en la siguiente URL: [https://www.mycompiler.io/view/9MdCC3C](https://www.mycompiler.io/view/9MdCC3C)

Analizando esta base de datos, tenemos las siguientes características:
- Hay un total de 151 Pokémon disponibles, con sus características básicas y un tipo asociado.
- Las estadísticas recogidas en la BD corresponden a Pokémon de nivel básico (nivel 1).
- Cada uno de los 12 entrenadores que hay en la BD tiene como máximo 6 Pokémon a su disposición.

## Metodología

El proyecto se llevará a cabo en varias fases, comenzando con una introducción al mundo de Pokémon y la programación básica, seguido de actividades prácticas donde los estudiantes desarrollarán sus propios proyectos relacionados con Pokémon.

## Recursos

Para llevar a cabo el proyecto, los estudiantes utilizarán computadoras, software de programación, y recursos educativos relacionados con Pokémon.

## Conclusiones

Al finalizar el proyecto, los estudiantes habrán adquirido una comprensión básica de la programación y el pensamiento computacional, así como habilidades para trabajar en equipo y resolver problemas.

## Bibliografía

1. "Introducción a la programación con Python", Autor, Año.
2. "Pensamiento computacional y resolución de problemas", Autor, Año.

## El juego se desarrolla de la siguiente manera:

- Al abrir la aplicación, se muestra la configuración de BD (puede estar en localhost o en un servidor remoto). Habrá un botón de ‘Test’, otro de ‘Aceptar’ y otro de ‘Salir’.
- El jugador elige uno de los 12 entrenadores disponibles.
- Se decide la dificultad de entre 4 niveles posibles y se inicia el combate (con un botón, por ejemplo).
- En la interfaz se cargan los Pokémon asociados al entrenador elegido, dotándoles de un nivel aleatorio que estará entre 1 y 100, según la dificultad que se haya elegido. Este nivel es necesario para calcular el daño que hace un Pokémon en un ataque.

### Dificultad y niveles

| DIFICULTAD | NIVEL TUX | NIVEL POKÉMON JUGADOR | % MEJORA HABILIDADES POKÉMON |
|------------|-----------------------|-----------|------------------------------|
| Pesadilla  |   100   | Aleatorio [1, 25) |  Aleatorio [1, 25]                         |
| Veterano   |  75   | Aleatorio [25, 50) |  Aleatorio [25, 50]                          |
| Marine     |  50   | Aleatorio [50, 75)  | Aleatorio [50, 75]                         |
| Recluta    |  25  | Aleatorio [75, 100]  | Aleatorio [75, 100]                          |

- Comienza la partida el Pokémon con más velocidad. En caso de empate entre varios Pokémon del jugador, el jugador decidirá cuál empieza pasando uno de los posibles a la zona de ‘Activo’. En caso de empate con TUX, se lanza una moneda al aire y se decide quién comienza la batalla. Sea quien sea (la máquina o el jugador), uno de los Pokémon del jugador debe estar en la zona de ‘Activo’.
- En cada turno se calcula el daño que hará el Pokémon a su rival siguiendo esta fórmula:

Daño = 0.01 x B x E x V x ( (((0.2 x N + 1) x A x P )/ 25 x D) +2 )


Donde:
- N = Nivel del Pokémon que ataca.
- A = Cantidad de ataque o ataque especial del Pokémon.
- P = Poder del ataque, normal o especial dependiendo de lo que se decida / pueda.
- D = Cantidad de defensa del Pokémon rival, normal o especial dependiendo del ataque que se esté usando.
- B = Bonificación. Dependiendo del tipo del Pokémon que ataca y el que es atacado, se aplica una bonificación (buena o mala), según la tabla que podéis encontrar en los anexos de este enunciado.
- E = Efectividad. Puede tomar los valores de 0, 0.25, 0.5, 1, 2 y 4, pero para nuestro caso será siempre igual a 1.
- V = Valor aleatorio entero en el rango [85 , 100]

- Cada Pokémon tiene un único ataque a su disposición, que podrá ser normal o especial, usándose para el cálculo del daño los correspondientes valores de sus habilidades.
- El jugador puede usar un ataque especial en cualquier momento, pero dejará a nuestro Pokémon fuera de combate por un turno. Si fuera el único Pokémon a nuestra disposición, lo dejaría a merced de TUX y podría recibir daño dos veces seguidas: la respuesta de TUX y el siguiente turno.
- TUX tiene una probabilidad de un 20% de realizar un ataque especial, de forma que así puede poner a prueba la defensa especial de su oponente. TUX responde igual a los ataques normales o especiales de sus oponentes (mirar tabla de estadísticas).
- TUX no tiene un tipo asociado de Pokémon. Al iniciarse la partida tomará uno de los valores posibles existentes en la BD de forma aleatoria. Esto afectará según los componentes del equipo del jugador.
- Todo lo que ocurra durante el juego debe quedar recogido en la zona ‘LOG’ que hay en la parte inferior de la interfaz como diferentes entradas de texto.
- Si logramos derrotar TUX, aparecerá otro del mismo nivel y nuestros Pokémon deberán continuar la batalla con las pocas energías que les queden.

## Mínimos exigidos en este proyecto

- Interfaz principal FXML siguiendo la idea de la propuesta de este enunciado.
- Ventana de configuración de la BD.
- Ventana de ayuda con las reglas del juego.
- Jugabilidad según las especificaciones.
- Imágenes de los Pokémon de al menos un entrenador.
- Gestionar la partida completa, permitiendo abandonar en cualquier momento. No se pueden cambiar las configuraciones (dificultad, BD, entrenador elegido) si una partida está en marcha.
- Los Pokémon del jugador son elegibles desde un array creado en tiempo de ejecución.
- Los Pokémon del jugador se pueden arrastrar y soltar a la zona de ‘Activo’ y al banquillo de reservas.
- Crear una versión .JAR del proyecto que se podrá ejecutar en cualquier plataforma (Windows10, Linux o MACv11)

## Se valorará

- Imágenes disponibles de todos los Pokémon.
- Poder crear un equipo personalizado de Pokémon, aleatorio o a mano. ¡Sé tu propio/a entrenador/a!
- Implementar una Pokédex en una ventana que muestre la información de la BD.
- Escritura en disco del LOG de una partida y de la configuración de acceso a la BD.
- TUX puede ser inteligente y escoger la víctima más propicia para ir eliminando enemigos o maximizar sus ataques.

## Se prohíbe

- Alterar los valores de la BD. Así podremos comparar los juegos de unos y otros.

## Anexo I: Interfaz Cutre Propuesta (¡Imaginación al poder!)

## Anexo II: Bonificación de los Ataques

| FILAS = Pokémon que ataca | COLUMNAS = Pokémon que se defiende |
|---------------------------|------------------------------------|
| Círculo verde             | Supereficaz (bonificación 1,75)    |
| Triángulo rojo            | No muy eficaz (bonificación 1,25)  |
| Espacio blanco            | Eficacia normal (bonificación 1)   |
| X                         | Inmunidad (bonificación 0)         |

|       | Normal | Fuego | Agua | Planta | Eléctrico | Lucha | Veneno | Tierra | Volador | Psíquico | Bicho | Roca | Fantasma | Hielo | Dragón | Siniestro | Acero |
|-------|--------|-------|------|--------|-----------|-------|--------|--------|---------|----------|-------|------|----------|-------|--------|-----------|-------|
| Normal|        |       |      |        |           |       |        |        |         |          |       |      |          |       |        |           |       |
| Fuego |        |       |      |        |           |       |        |        |         |          |       |      |          |       |        |           |       |
| Agua  |        |       |      |        |           |       |        |        |         |          |       |      |          |       |        |           |       |
| Planta|        |       |      |        |           |       |        |        |         |          |       |      |          |       |        |           |       |
| Eléctrico|     |       |      |        |           |       |        |        |         |          |       |      |          |       |        |           |       |
| Lucha |        |       |      |        |           |       |        |        |         |          |       |      |          |       |        |           |       |
| Veneno|        |       |      |        |           |       |        |        |         |          |       |      |          |       |        |           |       |
| Tierra|        |       |      |        |           |       |        |        |         |          |       |      |          |       |        |           |       |
| Volador|       |       |      |        |           |       |        |        |         |          |       |      |          |       |        |           |       |
| Psíquico|      |       |      |        |           |       |        |        |         |          |       |      |          |       |        |           |       |
| Bicho  |       |       |      |        |           |       |        |        |         |          |       |      |          |       |        |           |       |
| Roca   |       |       |      |        |           |       |        |        |         |          |       |      |          |       |        |           |       |
| Fantasma|      |       |      |        |           |       |        |        |         |          |       |      |          |       |        |           |       |
| Hielo  |       |       |      |        |           |       |        |        |         |          |       |      |          |       |        |           |       |
| Dragón |       |       |      |        |           |       |        |        |         |          |       |      |          |       |        |           |       |
| Siniestro|     |       |      |        |           |       |        |        |         |          |       |      |          |       |        |           |       |
| Acero  |       |       |      |        |           |       |        |        |         |          |       |      |          |       |        |           |       |


