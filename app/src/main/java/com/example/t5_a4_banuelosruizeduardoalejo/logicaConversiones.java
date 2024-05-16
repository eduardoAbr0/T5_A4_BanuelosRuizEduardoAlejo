package com.example.t5_a4_banuelosruizeduardoalejo;

import java.text.DecimalFormat;

public class logicaConversiones {

    //DECIMAL
    public String conversionDecimalBinario(int n) {
        int residuo;
        String bin = "";

        while (n > 0) {
            residuo = n % 2;

            bin = residuo + bin;
            n /= 2;
        }
        return bin;
    }

    public String conversionDecimalOctal(int n) {
        int residuo;
        String oct = "";

        while (n % 7 >= 1) {
            residuo = n % 8;

            oct = residuo + oct;
            n /= 8;
        }
        return oct;
    }

    //BINARIO
    public String conversionBinarioOctal(String bin ) {
        //String bin = String.valueOf(n);
        String oct = "";

        while ((bin.length()) % 3 != 0) {
            bin = "0"+bin;
        }

        int div = bin.length() / 3;

        for (int i = 0; i < div; i++) {
            String grupo = bin.substring(0, 3);

            System.out.println("grupo :"+grupo);

            switch (grupo) {
                case "000":
                    oct += "0";
                    break;
                case "001":
                    oct += "1";
                    break;
                case "010":
                    oct += "2";
                    break;
                case "011":
                    oct += "3";
                    break;
                case "100":
                    oct += "4";
                    break;
                case "101":
                    oct += "5";
                    break;
                case "110":
                    oct += "6";
                    break;
                case "111":
                    oct += "7";
                    break;
            }

            bin = bin.substring(3);
        }


        return oct;
    }

    //OCTAL
    public String conversionOctalDecimal(int n) {
        String nS = String.valueOf(n);
        int oct = 0;
        int j = nS.length() - 1;
        for (int i = 0; i < nS.length(); i++) {
            int valorN = Character.getNumericValue(nS.charAt(i));
            oct += valorN * (int) Math.pow(8, j);
            j--;
        }

        return String.valueOf(oct);
    }

    public String conversionOctalBinario(int n) {
        int conV = Integer.parseInt(conversionOctalDecimal(n));

        return conversionDecimalBinario(conV);
    }

    //HEXADECIMAL
    public String conversionHexaBin(String n) {
        String hexa = "";
        for (int i = 0; i < n.length(); i++) {
            switch (String.valueOf(n.charAt(i))) {
                case "0":
                    hexa += "0000";
                    break;
                case "1":
                    hexa += "0001";
                    break;
                case "2":
                    hexa += "0010";
                    break;
                case "3":
                    hexa += "0011";
                    break;
                case "4":
                    hexa += "0100";
                    break;
                case "5":
                    hexa += "0101";
                    break;
                case "6":
                    hexa += "0110";
                    break;
                case "7":
                    hexa += "0111";
                    break;
                case "8":
                    hexa += "1000";
                    break;
                case "9":
                    hexa += "1001";
                    break;
                case "A":
                    hexa += "1010";
                    break;
                case "B":
                    hexa += "1011";
                    break;
                case "C":
                    hexa += "1100";
                    break;
                case "D":
                    hexa += "1101";
                    break;
                case "E":
                    hexa += "1110";
                    break;
                case "F":
                    hexa += "1111";
                    break;

            }
        }
        return hexa;
    }

    public String conversionHexDecimal(String n){
        String hex = "";

        return hex;
    }
}
