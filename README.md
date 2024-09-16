# Calculadora Científica

Esta calculadora científica ofrece una variedad de funciones matemáticas para realizar cálculos complejos.

## Funcionalidad

* Operaciones aritméticas básicas (suma, resta, multiplicación, división)
* Ecuación cuadrática
* Cálculos geométricos (perímetro y área de figuras)
* Sistema de ecuaciones
* Ecuación de una recta

## Manejo de Excepciones

* *Divisor cero*: Si se intenta ingresar un cero como divisor, la calculadora lanzará una excepción de tipo ArithmeticException con el mensaje "/ by zero".
* *Base y exponente cero*: No se ha implementado una función de potencia en esta calculadora, por lo que no se puede ingresar una base y exponente cero.
* *Variable de entrada no numérica*: Si se intenta ingresar una variable de entrada no numérica, la calculadora lanzará una excepción de tipo InputMismatchException con un mensaje que indica que la entrada no es válida.

## Uso

Para utilizar la calculadora, simplemente ejecuta el programa y sigue las instrucciones en pantalla. Selecciona la función que deseas utilizar y sigue las instrucciones para ingresar los valores necesarios.

## Notas

* La calculadora utiliza la clase Scanner para leer la entrada del usuario.
* La calculadora utiliza la clase ArithmeticException para manejar las excepciones de división por cero.
* La calculadora utiliza la clase InputMismatchException para manejar las excepciones de entrada no numérica.
