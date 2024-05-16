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
        System.out.println("PASO DECIMAL BINARIO");
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

    public String conversionDecimalHex(int n){
        String hex = "";
        int residuo;

        while (n >0){
            residuo = n%16;
            n /= 16;

            switch (residuo){
                case 0:
                    hex = "0"+hex;
                    break;
                case 1:
                    hex = "1"+hex;
                    break;
                case 2:
                    hex = "2"+hex;
                    break;
                case 3:
                    hex = "3"+hex;
                    break;
                case 4:
                    hex = "4"+hex;
                    break;
                case 5:
                    hex = "5"+hex;
                    break;
                case 6:
                    hex = "6"+hex;
                    break;
                case 7:
                    hex = "7"+hex;
                    break;
                case 8:
                    hex = "8"+hex;
                    break;
                case 9:
                    hex = "9"+hex;
                    break;
                case 10:
                    hex = "A"+hex;
                    break;
                case 11:
                    hex = "B"+hex;
                    break;
                case 12:
                    hex = "C"+hex;
                    break;
                case 13:
                    hex = "D"+hex;
                    break;
                case 14:
                    hex = "E"+hex;
                    break;
                case 15:
                    hex = "F"+hex;
                    break;
            }
        }

        return hex;
    }

    //BINARIO
    public String conversionBinarioOctal(String bin ) {
        String oct = "";

        while ((bin.length()) % 3 != 0) {
            bin = "0"+bin;
        }

        int div = bin.length() / 3;

        for (int i = 0; i < div; i++) {
            String grupo = bin.substring(0, 3);

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

    public String conversionBinHex(String b){
        String hex = "";

        while ((b.length()%4)!=0){
            b = "0"+b;
        }
        int div = b.length() / 4;

        for (int i =0; i<div;i++){
            String grupo = b.substring(0, 4);
            switch (grupo){
                case "0000":
                    hex += "0";
                    break;
                case "0001":
                    hex += "1";
                    break;
                case "0010":
                    hex += "2";
                    break;
                case "0011":
                    hex += "3";
                    break;
                case "0100":
                    hex += "4";
                    break;
                case "0101":
                    hex += "5";
                    break;
                case "0110":
                    hex += "6";
                    break;
                case "0111":
                    hex += "7";
                    break;
                case "1000":
                    hex += "8";
                    break;
                case "1001":
                    hex += "9";
                    break;
                case "1010":
                    hex += "A";
                    break;
                case "1011":
                    hex += "B";
                    break;
                case "1100":
                    hex += "C";
                    break;
                case "1101":
                    hex += "D";
                    break;
                case "1110":
                    hex += "E";
                    break;
                case "1111":
                    hex += "F";
                    break;
            }

            b = b.substring(4);
        }
        System.out.println("PASO OCTAL HEX");
        return hex;
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
        System.out.println("PASO OCTAL DECIMAL");
        return String.valueOf(oct);
    }

    public String conversionOctalBinario(int n) {
        int conV = Integer.parseInt(conversionOctalDecimal(n));
        System.out.println("PASO OCTAL BINARIO");
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
}
