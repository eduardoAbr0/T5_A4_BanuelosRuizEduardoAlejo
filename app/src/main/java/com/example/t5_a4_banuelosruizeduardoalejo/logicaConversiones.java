package com.example.t5_a4_banuelosruizeduardoalejo;

import java.text.DecimalFormat;

public class logicaConversiones {

    //DECIMAL
    public String conversionDecimalBinario(int n){
        DecimalFormat f = new DecimalFormat("0");
        int residuo;
        String bin = "";

        while (n>0){
            residuo = n%2;

            bin = residuo+bin;
            n /= 2;
        }
        return bin;
    }
}
