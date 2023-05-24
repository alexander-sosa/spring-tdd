package com.example.tdd;

import static org.junit.Assert.*;

import com.example.tdd.calculadora.Calculadora;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculadoraTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void emptyString() throws Exception{
        // 1. Preparacion de la prueba
        Calculadora c = new Calculadora();

        // 2. Logica de la prueba
        String resultado = c.suma("");

        // 3. Verificacion o Assert
        assertNotNull(resultado);
        assertEquals("0", resultado);
    }

    @Test
    public void twoNumbersAddition()throws Exception{
        // 1. Preparacion de la prueba
        Calculadora c = new Calculadora();

        // 2. Logica de la prueba
        String resultado = c.suma("2,3");

        // 3. Verificacion o Assert
        assertNotNull(resultado);
        assertEquals("5", c.suma("2,3"));
        assertEquals("3", c.suma("0,3"));
        assertEquals("55", c.suma("44,11"));
        assertEquals("20", c.suma("10,10"));
    }

    @Test
    public void threeNumbersAddition()throws Exception{
        // 1. Preparacion de la prueba
        Calculadora c = new Calculadora();

        // 2. Logica de la prueba

        // 3. Verificacion o Assert
        assertEquals("10", c.suma("2,3,5"));
        assertEquals("3", c.suma("0,3,0"));
        assertEquals("56", c.suma("44,11,1"));
    }

    @Test
    public void ignoreNumbersGreaterThan1000()throws Exception{
        // 1. Preparacion de la prueba
        Calculadora c = new Calculadora();

        // 2. Logica de la prueba

        // 3. Verificacion o Assert
        assertEquals("10", c.suma("1001,10"));
    }

    @Test
    public void negativeNumbersException()throws Exception{
        // 1. Preparacion de la prueba
        Calculadora c = new Calculadora();

        // 2. Logica de la prueba

        // 3. Verificacion o Assert
        exception.expect(Exception.class);
        assertEquals("10", c.suma("1001,-10"));
    }
}
