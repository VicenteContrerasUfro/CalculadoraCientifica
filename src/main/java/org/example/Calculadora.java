package org.example;

import java.util.InputMismatchException;
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

            try {
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
                        System.out.println("Cerrando el sistema. ¡Adiós!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                scanner.next();
            }
        }

        scanner.close();
    }

    public static void operacionesAritmeticas(Scanner scanner) {
        try {
            System.out.print("Ingrese el primer número: ");
            double num1 = scanner.nextDouble();
            System.out.print("Ingrese el segundo número: ");
            double num2 = scanner.nextDouble();

            Calculadora calculadora = new Calculadora();
            double suma = calculadora.suma(num1, num2);
            double resta = calculadora.resta(num1, num2);
            double multiplicacion = calculadora.multiplicacion(num1, num2);

            if (num2 != 0) {
                double division = calculadora.division(num1, num2);
                System.out.println("División: " + division);
            } else {
                System.out.println("Error: No se puede dividir entre 0.");
            }

            System.out.println("Suma: " + suma);
            System.out.println("Resta: " + resta);
            System.out.println("Multiplicación: " + multiplicacion);

        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar un valor numérico.");
            scanner.next();
        }
    }

    public double suma(double num1, double num2) {
        return num1 + num2;
    }

    public double resta(double num1, double num2) {
        return num1 - num2;
    }

    public double multiplicacion(double num1, double num2) {
        return num1 * num2;
    }

    public double division(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("No se puede dividir entre 0");
        }
        return num1 / num2;
    }

    public static void ecuacionCuadratica(Scanner scanner) {
        try {
            System.out.print("Ingrese el coeficiente A: ");
            double a = scanner.nextDouble();
            System.out.print("Ingrese el coeficiente B: ");
            double b = scanner.nextDouble();
            System.out.print("Ingrese el coeficiente C: ");
            double c = scanner.nextDouble();

            Calculadora calculadora = new Calculadora();
            double[] soluciones = calculadora.ecuacionCuadratica(a, b, c);

            if (soluciones.length == 2) {
                System.out.println("Soluciones:");
                System.out.println("x1 = " + soluciones[0]);
                System.out.println("x2 = " + soluciones[1]);
            } else {
                System.out.println("Solución única:");
                System.out.println("x = " + soluciones[0]);
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar un valor numérico.");
            scanner.next();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public double[] ecuacionCuadratica(double a, double b, double c) throws Exception {
        double discriminante = b * b - 4 * a * c;
        if (discriminante < 0) {
            throw new Exception("La ecuación no tiene soluciones reales");
        }
        double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
        double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
        return new double[]{x1, x2};
    }

    public static void calculosGeometricos(Scanner scanner) {
        try {
            System.out.println("Seleccione la figura:\n1. Cuadrado\n2. Rectángulo\n3. Círculo\n4. Esfera\n5. Cubo\n6. Cono");
            int opcion = scanner.nextInt();

            Calculadora calculadora = new Calculadora();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el lado del cuadrado: ");
                    double lado = scanner.nextDouble();
                    System.out.println("Perímetro: " + calculadora.perimetroCuadrado(lado));
                    System.out.println("Área: " + calculadora.areaCuadrado(lado));
                    break;
                case 3:
                    System.out.print("Ingrese el radio del círculo: ");
                    double radio = scanner.nextDouble();
                    System.out.println("Circunferencia: " + calculadora.circunferenciaCirculo(radio));
                    System.out.println("Área: " + calculadora.areaCirculo(radio));
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar un valor numérico.");
            scanner.next();
        }
    }

    public double perimetroCuadrado(double lado) {
        return 4 * lado;
    }

    public double areaCuadrado(double lado) {
        return lado * lado;
    }

    public double circunferenciaCirculo(double radio) {
        return 2 * Math.PI * radio;
    }

    public double areaCirculo(double radio) {
        return Math.PI * radio * radio;
    }

    public static void sistemaEcuaciones(Scanner scanner) {
        try {
            System.out.print("Ingrese A, B y C de la primera ecuación (Ax + By = C): ");
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            double c = scanner.nextDouble();

            System.out.print("Ingrese D, E y F de la segunda ecuación (Dx + Ey = F): ");
            double d = scanner.nextDouble();
            double e = scanner.nextDouble();
            double f = scanner.nextDouble();

            Calculadora calculadora = new Calculadora();
            double[] soluciones = calculadora.sistemaEcuaciones(a, b, c, d, e, f);

            System.out.println("Solución del sistema:");
            System.out.println("x = " + soluciones[0]);
            System.out.println("y = " + soluciones[1]);

        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar un valor numérico.");
            scanner.next();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public double[] sistemaEcuaciones(double a, double b, double c, double d, double e, double f) throws Exception {
        double denominador = a * e - b * d;

        if (denominador == 0) {
            throw new Exception("El sistema no tiene solución única");
        }

        double x = (c * e - b * f) / denominador;
        double y = (a * f - c * d) / denominador;

        return new double[]{x, y};
    }

    public static void ecuacionRecta(Scanner scanner) {
        try {
            System.out.print("Ingrese las coordenadas del primer punto (x1, y1): ");
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();

            System.out.print("Ingrese las coordenadas del segundo punto (x2, y2): ");
            double x2 = scanner.nextDouble();
            double y2 = scanner.nextDouble();

            Calculadora calculadora = new Calculadora();
            double[] ecuacion = calculadora.ecuacionRecta(x1, y1, x2, y2);

            System.out.println("Ecuación de la recta:");
            System.out.println("Pendiente (m) = " + ecuacion[0]);
            System.out.println("Intercepto (b) = " + ecuacion[1]);

        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar un valor numérico.");
            scanner.next();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public double[] ecuacionRecta(double x1, double y1, double x2, double y2) throws Exception {
        if (x1 == x2) {
            throw new Exception("Los puntos tienen la misma x, la recta es vertical");
        }
        double pendiente = (y2 - y1) / (x2 - x1);
        double intercepto = y1 - pendiente * x1;
        return new double[]{pendiente, intercepto};
    }
}
