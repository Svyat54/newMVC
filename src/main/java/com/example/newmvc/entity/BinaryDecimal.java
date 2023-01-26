package com.example.newmvc.entity;

import org.springframework.stereotype.Service;

public class BinaryDecimal {
    public String getToBinary(int x){
        return toBinary(x);
    }

    public int getToDecimal(String str){
        return toDecimal(str);
    }
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
