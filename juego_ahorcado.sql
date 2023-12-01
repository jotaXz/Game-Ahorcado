-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 30-11-2023 a las 21:04:39
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `juego_ahorcado`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `palabras`
--

DROP TABLE IF EXISTS `palabras`;
CREATE TABLE IF NOT EXISTS `palabras` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pregunta` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `respuesta` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `palabras`
--

INSERT INTO `palabras` (`id`, `pregunta`, `respuesta`) VALUES
(1, '¿Nombre del primer presidente de Estados Unidos?', 'Washington'),
(2, '¿Canción más reproducida en Spotify?', 'Despacito'),
(3, '¿Capital de Australia?', 'Canberra'),
(5, '¿Instrumento de cuerda pulsada?', 'Guitarra'),
(6, '¿Científico famoso por la teoría de la relatividad?', 'Einstein'),
(45, '¿Quién pintó la \'Mona Lisa\'?', 'davinci'),
(10, '¿Nombre del creador de Facebook?', 'Zuckerberg'),
(11, '¿Serie de TV sobre un detective en Baker Street?', 'Sherlock'),
(12, '¿Símbolo químico del oro?', 'Au'),
(13, '¿Montaña más alta del mundo?', 'Everest'),
(14, '¿Fruto de la planta de la vid?', 'Uva'),
(44, '¿Cuál es el deporte que se juega con un bate y una pelota en un diamante?', 'beisbol'),
(43, '¿En qué año comenzó la Primera Guerra Mundial?', '1914'),
(17, '¿País conocido como la Tierra del Sol Naciente?', 'Japon'),
(18, '¿Palabra que describe la capacidad de vuelo de un pájaro?', 'Vuelo'),
(19, '¿Elemento químico esencial para la vida en la Tierra?', 'Oxigeno'),
(20, '¿Género musical originario de Jamaica?', 'Reggae'),
(22, '¿Capital de Canadá?', 'Ottawa'),
(23, '¿Deporte de invierno con descenso a gran velocidad?', 'Esquí'),
(24, '¿Instrumento de viento de metal en una orquesta?', 'Trompeta'),
(25, '¿Teoría que sugiere que todos los organismos evolucionan?', 'Evolución'),
(26, '¿Fruta con una cáscara gruesa y espinosa?', 'Piña'),
(27, '¿Ciencia que estudia la composición de los materiales?', 'Química'),
(42, '¿Cuál es el juego de mesa con fichas y damas?', 'ajedrez'),
(29, '¿Nombre del creador de Microsoft?', 'Gates'),
(41, '¿Quién fue el autor de \'Cien años de soledad\'?', 'garciamarquez'),
(32, '¿Cordillera que atraviesa Sudamérica?', 'Andes'),
(33, '¿Fruto de la planta de la manzana?', 'Manzana'),
(40, 'En qué deporte se utiliza la expresión \'gol olímpico\'?', 'futbol'),
(35, '¿Autor de \"1984\"?', 'Orwell'),
(36, '¿País conocido como la Tierra de las Maravillas?', 'Australia'),
(37, '¿Palabra que describe la repetición de sonidos al final de los versos?', 'Rima'),
(38, '¿Elemento químico presente en las lámparas fluorescentes?', 'Mercurio'),
(39, '¿Género musical originario de Nueva Orleans?', 'Jazz'),
(46, '¿Cómo se llama el personaje principal en la saga de libros de Harry Potter?', 'harry'),
(47, '¿En qué año se firmó la Declaración de Independencia de los Estados Unidos?', '1776'),
(48, '¿Qué deporte se juega en una cancha dividida por una red y con una pelota pequeña?', 'tenis'),
(49, '¿Cuál es la capital de Francia?', 'paris'),
(50, '¿Cómo se llama el director de la trilogía \'El Señor de los Anillos\'?', 'peterjackson'),
(52, '¿En qué deporte se destacó Muhammad Ali?', 'boxeo'),
(53, '¿Quién es el autor de \'Romeo y Julieta\'?', 'shakespeare'),
(54, '¿Cómo se llama el protagonista en \'La Odisea\' de Homero?', 'ulises'),
(55, '¿En qué año llegó el hombre a la Luna por primera vez?', '1969'),
(56, '¿Cuál es el único deporte que se juega en todas las lunas del sistema solar?', 'golf'),
(57, '¿Quién escribió la obra \'Don Quijote de la Mancha\'?', 'cervantes'),
(58, '¿Cómo se llama el juego de cartas en el que se busca formar pares?', 'memorama'),
(59, '¿En qué año se cayó el Muro de Berlín?', '1989'),
(60, '¿Qué equipo ha ganado más títulos de la NBA?', 'celtics'),
(61, '¿Cuál es la obra más conocida de Frida Kahlo?', 'lasdosfridas'),
(62, '¿Cómo se llama el famoso ratón de Disney?', 'mickey'),
(63, '¿En qué año se fundó la Organización de las Naciones Unidas (ONU)?', '1945'),
(64, '¿Cuál es el país de origen de Usain Bolt, el corredor más rápido del mundo?', 'jamaica'),
(65, '¿Quién escribió la obra de teatro \'Hamlet\'?', 'shakespeare'),
(66, '¿Cómo se llama la nave espacial en \'Star Trek\'?', 'enterprise'),
(67, '¿En qué año se independizó México?', '1821'),
(68, '¿Cuál es el deporte más popular en la India?', 'cricket'),
(69, '¿Cuál es el nombre del museo más famoso de París?', 'louvre'),
(70, '¿Cómo se llama el protagonista de la película \'Forrest Gump\'?', 'forrest'),
(71, '¿En qué año se proclamó la independencia de Argentina?', '1816'),
(72, '¿Cuál es el deporte acuático que se practica con una tabla y una vela?', 'windsurf'),
(73, '¿Quién fue el autor de la \'Odisea\'?', 'homero'),
(74, '¿Cómo se llama el juego de palabras cruzadas más famoso?', 'scrabble'),
(75, '¿En qué año se llevó a cabo la Revolución Rusa?', '1917'),
(76, '¿Qué equipo ha ganado más títulos en la Serie A italiana de fútbol?', 'juventus'),
(77, '¿Cuál es la capital de Japón?', 'tokio'),
(78, '¿Cómo se llama el primer libro de la saga \'Canción de hielo y fuego\'?', 'juegodetronos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas_programacion`
--

DROP TABLE IF EXISTS `preguntas_programacion`;
CREATE TABLE IF NOT EXISTS `preguntas_programacion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pregunta` varchar(255) NOT NULL,
  `respuesta` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=128 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `preguntas_programacion`
--

INSERT INTO `preguntas_programacion` (`id`, `pregunta`, `respuesta`) VALUES
(1, '¿Qué significa el acrónimo \"SQL\"?', 'estructurado'),
(2, '¿Cuál es el lenguaje de programación principal utilizado para el desarrollo de aplicaciones Android?', 'java'),
(3, '¿Cuál es el concepto fundamental detrás de la programación orientada a objetos?', 'encapsulamiento'),
(4, '¿Qué es un \"array\" en programación?', 'colección'),
(5, '¿Cuál es la función principal del comando \"git pull\" en Git?', 'actualizar'),
(6, '¿Qué significa la sigla \"HTML\" en desarrollo web?', 'lenguaje'),
(7, '¿Cuál es el propósito principal de un \"índice\" en bases de datos?', 'optimizar'),
(8, '¿Qué es un \"middleware\" en el contexto de desarrollo de software?', 'intermediario'),
(9, '¿Cuál es el paradigma de programación asociado con JavaScript?', 'orientado'),
(10, '¿Cuál es el término que se utiliza para describir el acto de encontrar y corregir errores en un programa?', 'depuración'),
(11, '¿Qué significa la sigla \"API\" en el contexto de desarrollo de software?', 'interfaz'),
(12, '¿Cuál es el término para el proceso de convertir un lenguaje de alto nivel en un lenguaje de bajo nivel?', 'compilación'),
(13, '¿Cuál es el propósito de la sentencia \"if\" en la programación?', 'condicional'),
(14, '¿Qué es un \"framework\" en el desarrollo de software?', 'estructura'),
(15, '¿Cuál es el lenguaje de programación comúnmente asociado con el desarrollo de aplicaciones iOS?', 'swift'),
(16, '¿Cuál es el término para describir un fragmento de código reutilizable que realiza una tarea específica?', 'función'),
(17, '¿Cuál es el propósito de un \"constructor\" en programación orientada a objetos?', 'inicializar'),
(18, '¿Qué es un \"protocolo\" en el contexto de redes de computadoras?', 'reglas'),
(19, '¿Cuál es el lenguaje de programación utilizado para la manipulación de datos en páginas web?', 'javascript'),
(20, '¿Qué es un \"sistema de control de versiones\" y para qué se utiliza comúnmente?', 'rastrear'),
(21, '¿Cuál es el propósito de la sentencia \"switch\" en programación?', 'seleccionar'),
(22, '¿Qué significa la sigla \"REST\" en el desarrollo de servicios web?', 'transferencia'),
(23, '¿Cuál es el término para el proceso de convertir datos en un formato comprensible para la transmisión?', 'codificación'),
(24, '¿Qué es un \"algoritmo\" en programación?', 'secuencia'),
(25, '¿Cuál es el propósito de la sentencia \"for\" en programación?', 'bucle'),
(26, '¿Qué es un \"puntero\" en lenguajes de programación como C o C++?', 'dirección'),
(27, '¿Cuál es el término para describir la capacidad de un programa para manejar errores y fallos de manera elegante?', 'robustez'),
(28, '¿Qué es un \"lenguaje de programación de bajo nivel\"?', 'ensamblador'),
(29, '¿Cuál es el término para la práctica de escribir código de manera que sea fácil de entender y mantener?', 'legibilidad'),
(30, '¿Qué significa la sigla \"CSS\" en el desarrollo web?', 'hojas'),
(31, '¿Cuál es el propósito de un \"índice invertido\" en bases de datos?', 'búsqueda'),
(32, '¿Qué es un \"map\" en el contexto de programación funcional en lenguajes como JavaScript?', 'transformar'),
(33, '¿Cuál es el término para el proceso de encontrar y corregir problemas de rendimiento en un programa?', 'optimización'),
(34, '¿Qué significa la sigla \"URL\" en el contexto de direcciones web?', 'localizador'),
(35, '¿Cuál es el propósito de la sentencia \"while\" en programación?', 'bucle'),
(36, '¿Qué es un \"proceso hijo\" en sistemas operativos?', 'subproceso'),
(37, '¿Cuál es el término para describir el acto de dividir un programa grande en módulos más pequeños y manejables?', 'modularidad'),
(38, '¿Qué es la \"refactorización\" en el desarrollo de software?', 'mejorar'),
(39, '¿Cuál es el lenguaje de programación comúnmente asociado con el desarrollo de aplicaciones de inteligencia artificial?', 'python'),
(40, '¿Cuál es el propósito de la sentencia \"try...catch\" en programación?', 'manejar'),
(41, '¿Qué es un \"patrón de diseño\" en el desarrollo de software?', 'solución'),
(42, '¿Cuál es el término para describir la práctica de escribir código que es fácil de cambiar y extender?', 'flexibilidad'),
(43, '¿Qué significa la sigla \"MVC\" en el contexto de arquitectura de software?', 'modelo'),
(44, '¿Cuál es el propósito de la sentencia \"finally\" en programación?', 'código'),
(45, '¿Qué es un \"algoritmo de ordenamiento\" y cuál es su importancia en programación?', 'organizar'),
(46, '¿Cuál es el término para describir la relación entre dos tablas en una base de datos mediante una clave externa?', 'relación'),
(47, '¿Qué significa la sigla \"ORM\" en el desarrollo de software?', 'mapeo'),
(48, '¿Cuál es el propósito de un \"índice no clusterizado\" en bases de datos?', 'acceso'),
(49, '¿Qué es un \"patrón singleton\" en programación orientada a objetos?', 'instancia'),
(50, '¿Cuál es el término para la práctica de escribir pruebas automatizadas para el código de un programa?', 'pruebas'),
(51, '¿Qué significa la sigla \"JWT\" en el contexto de autenticación de usuarios?', 'token'),
(52, '¿Cuál es el propósito de la sentencia \"throw\" en programación?', 'lanzar'),
(53, '¿Qué es un \"marco de trabajo de prueba\" en desarrollo de software?', 'automatizar'),
(54, '¿Cuál es el término para describir el acto de cambiar el tipo de datos de una variable en programación?', 'cambio'),
(55, '¿Qué significa la sigla \"DRY\" en el contexto de buenas prácticas de programación?', 'repite'),
(56, '¿Cuál es el propósito de un \"constructor privado\" en programación orientada a objetos?', 'controlar'),
(57, '¿Qué es un \"algoritmo de búsqueda\" y cuál es su importancia en programación?', 'encontrar'),
(58, '¿Cuál es el término para describir la técnica de escribir código que realiza múltiples tareas simultáneamente?', 'concurrencia'),
(59, '¿Qué significa la sigla \"CI/CD\" en el desarrollo de software?', 'entrega'),
(60, '¿Cuál es el propósito de un \"método abstracto\" en programación orientada a objetos?', 'implementado'),
(61, '¿Qué es una \"cláusula JOIN\" en consultas SQL?', 'combina'),
(62, '¿Cuál es el término para describir la práctica de escribir código que se ejecuta solo cuando es necesario?', 'perezoso'),
(63, '¿Qué significa la sigla \"UDP\" en el contexto de protocolos de red?', 'datagrama'),
(64, '¿Cuál es el propósito de la sentencia \"break\" en programación?', 'interrumpir'),
(65, '¿Qué es un \"marco de trabajo de desarrollo\" en el desarrollo de software?', 'facilitar'),
(66, '¿Cuál es el término para describir la práctica de dividir un programa en funciones o métodos más pequeños?', 'descomposición'),
(67, '¿Qué significa la sigla \"OOP\" en programación orientada a objetos?', 'programación'),
(68, '¿Cuál es el propósito de un \"procedimiento almacenado\" en bases de datos?', 'almacenar'),
(69, '¿Qué es un \"patrón de arquitectura\" en el desarrollo de software?', 'estructura'),
(70, '¿Cuál es el término para describir la técnica de escribir código que se ejecuta paso a paso?', 'depuración'),
(71, '¿Qué significa la sigla \"VCS\" en el contexto de control de versiones de código fuente?', 'sistema'),
(72, '¿Cuál es el propósito de un \"lenguaje de consulta\" como SQL?', 'consultar'),
(73, '¿Qué es un \"sistema de gestión de paquetes\" en el desarrollo de software?', 'instala'),
(74, '¿Cuál es el término para describir la práctica de escribir código que es fácil de entender y usar?', 'usabilidad'),
(75, '¿Qué significa la sigla \"SDK\" en el contexto de desarrollo de software?', 'desarrollo'),
(76, '¿Cuál es el propósito de la sentencia \"continue\" en programación?', 'saltar'),
(77, '¿Qué es un \"lenguaje de programación interpretado\"?', 'ejecutado'),
(78, '¿Cuál es el término para describir la práctica de escribir código que se puede utilizar en diferentes partes de un programa?', 'reutilización'),
(79, '¿Qué significa la sigla \"DNS\" en el contexto de internet?', 'sistema'),
(80, '¿Cuál es el propósito de un \"patrón de diseño de fábrica\" en programación orientada a objetos?', 'creación'),
(81, '¿Cuál es el propósito del patrón de diseño \"Observer\" en programación?', 'notificación'),
(82, '¿Qué es la \"programación reactiva\" y en qué se diferencia de la programación imperativa?', 'flujo'),
(83, '¿Cuál es el término para describir la técnica de programación que permite ejecutar múltiples hilos de manera coordinada?', 'concurrencia'),
(84, '¿Qué es la \"inyección de dependencias\" en el desarrollo de software y cuál es su beneficio?', 'desacoplamiento'),
(85, '¿Cuál es el propósito de los \"tipos genéricos\" en lenguajes de programación como Java o C#?', 'reutilización'),
(86, '¿Qué es el \"código asincrónico\" y cómo se utiliza en programación?', 'asíncrono'),
(87, '¿Cuál es la diferencia entre \"pruebas unitarias\" y \"pruebas de integración\" en el desarrollo de software?', 'componentes'),
(88, '¿Qué significa el principio \"SOLID\" en el diseño de software y cuáles son sus cinco principios?', 'responsabilidad'),
(89, '¿Cuál es el propósito del patrón de diseño \"Strategy\" y en qué situaciones se aplica?', 'algoritmo'),
(90, '¿Qué es la \"arquitectura hexagonal\" en el desarrollo de software y cuáles son sus componentes clave?', 'capas'),
(91, '¿Cuál es la diferencia entre \"compilador\" e \"intérprete\" en el contexto de lenguajes de programación?', 'código'),
(92, '¿Qué es un \"contenedor de inversión de control\" (IoC) y cuándo se utiliza en el desarrollo de software?', 'gestiona'),
(93, '¿Cuál es el propósito de la \"memoria caché\" en arquitecturas de hardware y cómo afecta al rendimiento del software?', 'almacenar'),
(94, '¿Qué significa el término \"polimorfismo\" en programación orientada a objetos y cuáles son sus tipos?', 'múltiple'),
(95, '¿Cuál es el papel del \"patrón de diseño de cadena de responsabilidad\" en el manejo de solicitudes en programación?', 'responsabilidades'),
(96, '¿Qué es la \"programación funcional\" y cuáles son sus principios fundamentales?', 'inmutabilidad'),
(97, '¿Cuál es la importancia de la \"escalabilidad\" en el diseño de sistemas informáticos y cómo se logra?', 'crecimiento'),
(98, '¿Qué es el \"análisis estático de código\" y cuáles son las herramientas utilizadas para realizarlo?', 'revisiones'),
(99, '¿Cuál es la diferencia entre \"herencia\" y \"composición\" en programación orientada a objetos?', 'jerarquía'),
(100, '¿Qué es la \"arquitectura de microservicios\" y cuáles son sus beneficios en el desarrollo de software?', 'desacoplada'),
(101, '¿Cuál es el propósito del \"principio de responsabilidad única\" en el diseño de clases y funciones?', 'modificar'),
(102, '¿Qué es el \"refactoring\" en programación y cuál es su importancia en el ciclo de vida del software?', 'mejorar'),
(103, '¿Cuál es la importancia de la \"seguridad informática\" en el desarrollo de aplicaciones web y cómo se abordan las vulnerabilidades?', 'proteger'),
(104, '¿Qué es un \"lenguaje de programación de bajo nivel\" y cuáles son ejemplos comunes?', 'ensamblador'),
(105, '¿Cuál es el propósito del \"patrón de diseño de fachada\" y cómo simplifica la interfaz de un sistema complejo?', 'sencilla'),
(106, '¿Qué es el \"control de versiones distribuido\" y cuál es su diferencia con el control de versiones centralizado?', 'autónomo'),
(107, '¿Cuál es la diferencia entre \"criptografía simétrica\" y \"criptografía asimétrica\" en seguridad de la información?', 'claves'),
(108, '¿Qué es el \"principio de mínima sorpresa\" en diseño de interfaces de usuario y por qué es importante?', 'predecible'),
(109, '¿Cuál es la importancia de la \"automatización de pruebas\" en el desarrollo ágil de software?', 'validar'),
(110, '¿Qué es el \"patrón de diseño de observador\" y cómo se utiliza para notificar cambios en un sistema?', 'suscripción'),
(111, '¿Cuál es la diferencia entre \"desarrollo ágil\" y \"desarrollo en cascada\" en la gestión de proyectos de software?', 'iterativo'),
(112, '¿Qué es la \"programación reactiva\" y cuándo se utiliza en el desarrollo de aplicaciones?', 'flujos'),
(113, '¿Cuál es el propósito de la \"optimización de código\" y cuáles son las técnicas comunes utilizadas?', 'eficiencia'),
(114, '¿Qué es un \"sistema de control de versiones\" y cuál es su importancia en el desarrollo colaborativo de software?', 'historial'),
(115, '¿Cuál es la diferencia entre \"encapsulamiento\" y \"abstracción\" en programación orientada a objetos?', 'detalles'),
(116, '¿Qué es el \"testing de regresión\" y cómo ayuda a asegurar la calidad del software durante los cambios?', 'modificaciones'),
(117, '¿Cuál es el propósito del \"patrón de diseño de prototipo\" y cómo se utiliza para crear nuevos objetos?', 'clonación'),
(118, '¿Cuál es el propósito del \"modelo de desarrollo en espiral\" en ingeniería de software y cuándo se utiliza?', 'riesgos'),
(119, '¿Qué es la \"arquitectura de eventos\" en el desarrollo de sistemas distribuidos y cómo facilita la comunicación?', 'notificaciones'),
(120, '¿Cuál es la diferencia entre \"turing completo\" y \"turing incompleto\" en términos de lenguajes de programación?', 'algoritmo'),
(121, '¿Qué es el \"patrón de diseño de adaptador\" y en qué situaciones se aplica para integrar sistemas?', 'interfaz'),
(122, '¿Cuál es la importancia de la \"cohesión\" en el diseño de módulos y cómo afecta a la mantenibilidad del software?', 'relacionados'),
(123, '¿Qué es el \"teorema CAP\" y cómo influye en el diseño de sistemas distribuidos?', 'consistencia'),
(124, '¿Cuál es el propósito del \"patrón de diseño de cadena de responsabilidad\" y cómo se relaciona con el manejo de eventos?', 'procesamiento'),
(125, '¿Qué es el \"lenguaje de consulta estructurado\" (SQL) y cuáles son sus principales categorías de comandos?', 'consulta'),
(126, '¿Cuál es la diferencia entre \"devops\" y \"agile\" en términos de metodologías de desarrollo y operaciones?', 'colaboración'),
(127, '¿Qué es el \"patrón de diseño de memento\" y cómo se utiliza para la gestión de estados en un objeto?', 'restaurar');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `puntuacion` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `password`, `puntuacion`) VALUES
(1, 'Juan Manuel', '1234', 1000),
(2, '1', '1', 95),
(3, '2', '2', 410),
(4, '3', '3', 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
