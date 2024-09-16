package org.example;

import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 6) {
            System.out.println("\nCalculadora Científica:");
            System.out.println("1. Operaciones aritméticas básicas");
            System.out.println("2. Ecuación Cuadrática");
            System.out.println("3. Cálculos geométricos");
            System.out.println("4. Sistema de Ecuaciones");
            System.out.println("5. Ecuación de una Recta");
            System.out.println("6. Cerrar Sistema\n");
            System.out.print("Ingresa el número de opción: ");

            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    operacionesAritmeticas(scanner);
                    break;
                case 2:
                    ecuacionCuadratica(scanner);
                    break;
                case 3:
                    calculosGeometricos(scanner);
                    break;
                case 4:
                    sistemaEcuaciones(scanner);
                    break;
                case 5:
                    ecuacionRecta(scanner);
                    break;
                case 6:
                    System.out.println("Cerrando el sistema.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }

        scanner.close();
    }

    public static void operacionesAritmeticas(Scanner scanner) {
        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();

        double suma = num1 + num2;
        double resta = num1 - num2;
        double multiplicacion = num1 * num2;
        double division = (num2 != 0) ? num1 / num2 : 0;

        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicación: " + multiplicacion);
        if (num2 != 0) {
            System.out.println("División: " + division);
        } else {
            System.out.println("División: No se puede dividir entre 0.");
        }
    }

    public static void ecuacionCuadratica(Scanner scanner) {
        System.out.print("Ingrese el coeficiente A: ");
        double a = scanner.nextDouble();
        System.out.print("Ingrese el coeficiente B: ");
        double b = scanner.nextDouble();
        System.out.print("Ingrese el coeficiente C: ");
        double c = scanner.nextDouble();

        double discriminante = b * b - 4 * a * c;

        if (discriminante > 0) {
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("Soluciones:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else if (discriminante == 0) {
            double x = -b / (2 * a);
            System.out.println("Solución única:");
            System.out.println("x = " + x);
        } else {
            System.out.println("La ecuación no tiene soluciones reales.");
        }
    }

    public static void calculosGeometricos(Scanner scanner) {
        System.out.println("Seleccione la figura:\n1. Cuadrado\n2. Rectángulo\n3. Círculo\n4. Esfera\n5. Cubo\n6. Cono");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1: // Cuadrado
                System.out.print("Ingrese el lado del cuadrado: ");
                double lado = scanner.nextDouble();
                System.out.println("Perímetro: " + (4 * lado));
                System.out.println("Área: " + (lado * lado));
                break;
            case 2: // Rectángulo
                System.out.print("Ingrese el largo: ");
                double largo = scanner.nextDouble();
                System.out.print("Ingrese el ancho: ");
                double ancho = scanner.nextDouble();
                System.out.println("Perímetro: " + (2 * (largo + ancho)));
                System.out.println("Área: " + (largo * ancho));
                break;
            case 3: // Círculo
                System.out.print("Ingrese el radio del círculo: ");
                double radio = scanner.nextDouble();
                System.out.println("Circunferencia: " + (2 * Math.PI * radio));
                System.out.println("Área: " + (Math.PI * radio * radio));
                break;
            case 4: // Esfera
                System.out.print("Ingrese el radio de la esfera: ");
                double radioEsfera = scanner.nextDouble();
                System.out.println("Volumen: " + ((4.0 / 3.0) * Math.PI * Math.pow(radioEsfera, 3)));
                break;
            case 5: // Cubo
                System.out.print("Ingrese el lado del cubo: ");
                double ladoCubo = scanner.nextDouble();
                System.out.println("Volumen: " + (Math.pow(ladoCubo, 3)));
                break;
            case 6: // Cono
                System.out.print("Ingrese el radio del cono: ");
                double radioCono = scanner.nextDouble();
                System.out.print("Ingrese la altura del cono: ");
                double alturaCono = scanner.nextDouble();
                System.out.println("Volumen: " + ((Math.PI * Math.pow(radioCono, 2) * alturaCono) / 3));
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    public static void sistemaEcuaciones(Scanner scanner) {
        System.out.print("Ingrese A, B y C de la primera ecuación (Ax + By = C): ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        System.out.print("Ingrese D, E y F de la segunda ecuación (Dx + Ey = F): ");
        double d = scanner.nextDouble();
        double e = scanner.nextDouble();
        double f = scanner.nextDouble();

        double denominador = a * e - b * d;
        if (denominador != 0) {
            double x = (c * e - b * f) / denominador;
            double y = (a * f - c * d) / denominador;
            System.out.println("Solución del sistema:");
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        } else {
            System.out.println("El sistema no tiene solución única.");
        }
    }

    public static void ecuacionRecta(Scanner scanner) {
        System.out.print("Ingrese las coordenadas del primer punto (x1, y1): ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.print("Ingrese las coordenadas del segundo punto (x2, y2): ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        if (x1 != x2) {
            double m = (y2 - y1) / (x2 - x1); // Pendiente de la recta
            double b = y1 - m * x1; // Intersección con el eje Y
            System.out.println("La ecuación de la recta es: Y = " + m + "X + " + b);
        } else {
            System.out.println("Los puntos tienen la misma x, la recta es vertical.");
        }
    }
}
