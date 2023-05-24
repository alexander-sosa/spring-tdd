package com.example.tdd;

import com.example.tdd.calculadora.TresEnRaya;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TresEnRayaTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private TresEnRaya tresEnRaya;

    @Before
    public void before(){
        // ejecuta codigo antes de cualquier prueba
        tresEnRaya = new TresEnRaya();
    }

    @Test
    public void xOutOfRangeException() throws Exception{
        // 1. Preparacion de la prueba
        TresEnRaya tresEnRaya = new TresEnRaya();

        // 2. Logica de la prueba

        // 3. Verificacion o Assert
        exception.expect(Exception.class);
        tresEnRaya.jugar(5, 2);
    }

    @Test
    public void yOutOfRangeException() throws Exception{
        // 1. Preparacion de la prueba
        TresEnRaya tresEnRaya = new TresEnRaya();

        // 2. Logica de la prueba

        // 3. Verificacion o Assert
        exception.expect(Exception.class);
        tresEnRaya.jugar(2, 5);
    }

    @Test
    public void notAvailablePlaceException() throws Exception{
        // 1. Preparacion de la prueba
        TresEnRaya tresEnRaya = new TresEnRaya();

        // 2. Logica de la prueba
        exception.expect(Exception.class); // jugador +
        tresEnRaya.jugar(2, 2); // jugador X

        // 3. Verificacion o Assert
        exception.expect(Exception.class); // jugador +
        tresEnRaya.jugar(2, 2);
    }

    @Test
    public void firstStrikeGoesX() throws Exception {
        // 1. Preparacion de la prueba
        TresEnRaya tresEnRaya = new TresEnRaya();

        // 2. Logica de la prueba


        // 3. Verificacion o Assert
        assertEquals('X', tresEnRaya.siguienteTurno()); // jugadorX;
    }

    @Test
    public void ifFirstStrikeXNextGoesPlus() throws Exception {
        // 1. Preparacion de la prueba
        TresEnRaya tresEnRaya = new TresEnRaya();

        // 2. Logica de la prueba
        tresEnRaya.jugar(1, 3);

        // 3. Verificacion o Assert
        assertEquals('+', tresEnRaya.siguienteTurno()); // jugador +;
    }

    @Test
    public void ifPrevStrikePlusNextGoesX() throws Exception {
        // 1. Preparacion de la prueba
        TresEnRaya tresEnRaya = new TresEnRaya();

        // 2. Logica de la prueba
        tresEnRaya.jugar(1, 3);

        // 3. Verificacion o Assert
        assertEquals('+', tresEnRaya.siguienteTurno());

        // para X
        tresEnRaya.jugar(2, 3);
        assertEquals('X', tresEnRaya.siguienteTurno());
    }

    @Test
    public void whenTheresNoWinner() throws Exception {
        // 1. Preparacion de la prueba
        TresEnRaya tresEnRaya = new TresEnRaya();

        // 2. Logica de la prueba
        String resultado = tresEnRaya.jugar(1, 3);

        // 3. Verificacion o Assert
        assertEquals("No hay ganador aun", resultado);
    }

    @Test
    public void ifRowFullThenWin() throws Exception {
        // 1. Preparacion de la prueba
        TresEnRaya tresEnRaya = new TresEnRaya();

        // 2. Logica de la prueba
        tresEnRaya.jugar(1, 1);         // x
        tresEnRaya.jugar(1, 2);         // +
        tresEnRaya.jugar(2, 1);         // x
        tresEnRaya.jugar(2, 2);         // +
        String resultado = tresEnRaya.jugar(3, 1);         // x

        // 3. Verificacion o Assert
        assertEquals("X es el ganador", resultado);
    }

    @Test
    public void ifColumnFullThenWin() throws Exception {
        // 1. Preparacion de la prueba
        TresEnRaya tresEnRaya = new TresEnRaya();

        // 2. Logica de la prueba
        tresEnRaya.jugar(2, 1);         // x
        tresEnRaya.jugar(1, 1);         // +
        tresEnRaya.jugar(3, 1);         // x
        tresEnRaya.jugar(1, 2);         // +
        tresEnRaya.jugar(2, 2);         // x
        String resultado = tresEnRaya.jugar(1, 3);         // +

        // 3. Verificacion o Assert
        assertEquals("+ es el ganador", resultado);
    }
}
