package com.example.tdd.calculadora;

public class TresEnRaya {

    private Character[][] tablero = {{'0', '0', '0'},
                                     {'0', '0', '0'},
                                     {'0', '0', '0'}};

    private final int Size = 3;
    private char ultimoJugador = '+';

    public String jugar(int x, int y) throws Exception {
        // Fuera de rango
        axisVerify(x);
        axisVerify(y);

        // cambiar de turno
        ultimoJugador = siguienteTurno();

        // Posicion ocupada
        assignPosition(x, y);

        // Verificar ganador
        if (theresWinner()){
            return ultimoJugador + " es el ganador";
        }
        return "No hay ganador aun";
    }

    private boolean theresWinner(){
        for (int i = 0; i<3; i++){
            if (tablero[0][i] + tablero[1][i] + tablero[2][i] == ultimoJugador*Size)
                return true;
            if (tablero[i][0] + tablero[i][1] + tablero[i][2] == ultimoJugador*Size)
                return true;
        }
        return false;
    }

    private void axisVerify(int axis) throws Exception {
        if(axis < 1 || axis > 3) throw new Exception("El valor esta fuera del cuadro");
    }

    private void assignPosition(int x, int y) throws Exception{
        if(tablero[x-1][y-1] != '0') throw new Exception("La posicion ya esta ocupada");
        else {
            System.out.println("Assigning: " + (x-1) + ", " + (y-1));
            tablero[x - 1][y - 1] = ultimoJugador;
        }
    }

    public char siguienteTurno(){
        if(ultimoJugador == 'X'){
            return '+';
        }
        else {
            return 'X';
        }
    }
}
