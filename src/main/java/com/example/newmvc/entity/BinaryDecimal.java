package com.example.newmvc.entity;

public class BinaryDecimal {
    public static String toBinary(int decimalNumber) {
        String binaryNumber = "";
        if (decimalNumber <= 0){
            binaryNumber = "You need a number greater than zero";
            return binaryNumber;
        }
        while (decimalNumber != 0){
            binaryNumber = decimalNumber % 2 + binaryNumber;
            decimalNumber = decimalNumber / 2;
        }
        return binaryNumber;
    }

    public static int toDecimal(String binaryNumber) {
        int decimalNumber = 0;
        if (binaryNumber == null){
            return decimalNumber;
        }
        for (int i = 0; i < binaryNumber.length(); i++) {
            decimalNumber <<= 1;
            if (binaryNumber.charAt(i) == '1') decimalNumber++;
        }
        return decimalNumber;
    }
}
