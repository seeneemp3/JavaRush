package com.javarush.task.pro.task09.task0908;

import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Binary number " + binaryNumber + " is equal to hex " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Hex number " + hexNumber + " is equal to " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        StringBuilder hex = new StringBuilder();

        if (binaryNumber == null)return hex.toString();

        for(char a : binaryNumber.toCharArray()){
            if (a != '1') {
                if (a != '0') return hex.toString();
            }
        }

        StringBuilder sb = new StringBuilder(binaryNumber);
        while (sb.length() % 4 != 0) sb.insert(0, "0");
        binaryNumber = sb.toString();

        for (int i = 0; i < binaryNumber.length(); i += 4) {
                hex.append(getHex(binaryNumber.substring(i, i + 4)));
        }
     return hex.toString();
    }

    public static String toBinary(String hexNumber) {

        StringBuilder bin = new StringBuilder();

        if (hexNumber == null){
            return bin.toString();
        }

        for(char ch : hexNumber.toCharArray()){
            if(getBin(ch).charAt(0) == 'x') return bin.toString();
        }


        for(char ch : hexNumber.toCharArray()){
            bin.append(getBin(ch));
        }
        return bin.toString();
    }
    public static String getHex(String s){
        return switch (s){
           case  "0000" -> "0"; case  "0001" -> "1"; case  "0010" -> "2"; case  "0011" -> "3"; case  "0100" -> "4"; case  "0101" -> "5"; case  "0110" -> "6"; case  "0111" -> "7";
           case  "1000" -> "8"; case  "1001" -> "9"; case  "1010"->"a"; case  "1011"->"b"; case  "1100"->"c"; case  "1101"->"d"; case  "1110"->"e"; case  "1111"->"f";
            default -> "";
        };
    }
    public static String getBin(char s){
        return switch (s){
            case  '0' -> "0000"; case  '1' -> "0001"; case  '2' -> "0010"; case  '3' -> "0011"; case  '4' -> "0100"; case  '5' -> "0101"; case  '6' -> "0110"; case  '7' -> "0111";
            case  '8' -> "1000"; case  '9' -> "1001"; case  'a' -> "1010"; case  'b' -> "1011"; case  'c' -> "1100"; case  'd' -> "1101";case  'e' -> "1110"; case  'f' -> "1111";
            default -> "x";
        };
    }
}
