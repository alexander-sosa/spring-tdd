package com.example.tdd.calculadora;

public class Calculadora {

    private final int MAX = 1000;

    public String suma(String sumandos) throws Exception{
        if(sumandos != null && sumandos.equals("")) return "0";

        int total = 0;
        String[] sums = sumandos.split(",");
        for(int i = 0; i<sums.length; i++){
            int s = Integer.parseInt(sums[i]);
            if(s < 0) throw new Exception("El numero es negativo");
            if(s <= MAX) total += s;
        }
        return Integer.toString(total);
    }

}
