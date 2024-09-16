import org.example.Calculadora;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculadoraTest {

    @Test
    public void testOperacionesAritmeticas() {
        Calculadora calculadora = new Calculadora();
        double num1 = 10;
        double num2 = 2;
        double sumaEsperada = 12;
        double restaEsperada = 8;
        double multiplicacionEsperada = 20;
        double divisionEsperada = 5;

        double suma = calculadora.suma(num1, num2);
        double resta = calculadora.resta(num1, num2);
        double multiplicacion = calculadora.multiplicacion(num1, num2);
        double division = calculadora.division(num1, num2);

        assertEquals(sumaEsperada, suma, 0);
        assertEquals(restaEsperada, resta, 0);
        assertEquals(multiplicacionEsperada, multiplicacion, 0);
        assertEquals(divisionEsperada, division, 0);
    }

    @Test
    public void testOperacionesAritmeticasDivisionPorCero() {
        Calculadora calculadora = new Calculadora();
        double num1 = 10;
        double num2 = 0;

        try {
            calculadora.division(num1, num2);
            fail("Debería lanzar una excepción");
        } catch (ArithmeticException e) {
            assertEquals("No se puede dividir entre 0", e.getMessage());
        }
    }

    @Test
    public void testEcuacionCuadratica() throws Exception {
        Calculadora calculadora = new Calculadora();
        double a = 1;
        double b = -3;
        double c = 2;
        double x1Esperado = 2;
        double x2Esperado = 1;

        double[] soluciones = calculadora.ecuacionCuadratica(a, b, c);
        assertEquals(x1Esperado, soluciones[0], 0);
        assertEquals(x2Esperado, soluciones[1], 0);
    }

    @Test
    public void testEcuacionCuadraticaSinSolucionesReales() {
        Calculadora calculadora = new Calculadora();
        double a = 1;
        double b = 2;
        double c = 5;

        try {
            calculadora.ecuacionCuadratica(a, b, c);
            fail("Debería lanzar una excepción");
        } catch (Exception e) {
            assertEquals("La ecuación no tiene soluciones reales", e.getMessage());
        }
    }

    @Test
    public void testCalculosGeometricosCuadrado() {
        Calculadora calculadora = new Calculadora();
        double lado = 4;
        double perimetroEsperado = 16;
        double areaEsperada = 16;

        double perimetro = calculadora.perimetroCuadrado(lado);
        double area = calculadora.areaCuadrado(lado);

        assertEquals(perimetroEsperado, perimetro, 0);
        assertEquals(areaEsperada, area, 0);
    }

    @Test
    public void testCalculosGeometricosCirculo() {
        Calculadora calculadora = new Calculadora();
        double radio = 5;
        double circunferenciaEsperada = 31.41592653589793;
        double areaEsperada = 78.53981633974483;

        double circunferencia = calculadora.circunferenciaCirculo(radio);
        double area = calculadora.areaCirculo(radio);

        assertEquals(circunferenciaEsperada, circunferencia, 0.00001);
        assertEquals(areaEsperada, area, 0.00001);
    }

    @Test
    public void testSistemaEcuaciones() throws Exception {
        Calculadora calculadora = new Calculadora();
        double a = 1;
        double b = 2;
        double c = 3;
        double d = 4;
        double e = 5;
        double f = 6;
        double xEsperado = -1;  // Cambiado a -1
        double yEsperado = 2;   // Cambiado a 2

        double[] soluciones = calculadora.sistemaEcuaciones(a, b, c, d, e, f);
        assertEquals(xEsperado, soluciones[0], 0);
        assertEquals(yEsperado, soluciones[1], 0);
    }

    @Test
    public void testSistemaEcuacionesSinSolucionUnica() {
        Calculadora calculadora = new Calculadora();
        double a = 1;
        double b = 2;
        double c = 3;
        double d = 2;
        double coefE = 4;  // Cambiamos el nombre de 'e' a 'coefE' para evitar el conflicto de nombres
        double f = 6;

        try {
            calculadora.sistemaEcuaciones(a, b, c, d, coefE, f);
            fail("Debería lanzar una excepción");
        } catch (Exception ex) {  // Cambiamos 'e' a 'ex' para evitar el conflicto
            assertEquals("El sistema no tiene solución única", ex.getMessage());
        }
    }

    @Test
    public void testEcuacionRecta() throws Exception {
        Calculadora calculadora = new Calculadora();
        double x1 = 1;
        double y1 = 2;
        double x2 = 3;
        double y2 = 4;
        double mEsperado = 1;
        double bEsperado = 1;

        double[] ecuacion = calculadora.ecuacionRecta(x1, y1, x2, y2);
        assertEquals(mEsperado, ecuacion[0], 0);
        assertEquals(bEsperado, ecuacion[1], 0);
    }

    @Test
    public void testEcuacionRectaVertical() {
        Calculadora calculadora = new Calculadora();
        double x1 = 1;
        double y1 = 2;
        double x2 = 1;
        double y2 = 4;

        try {
            calculadora.ecuacionRecta(x1, y1, x2, y2);
            fail("Debería lanzar una excepción");
        } catch (Exception e) {
            assertEquals("Los puntos tienen la misma x, la recta es vertical", e.getMessage());
        }
    }
}
