package com.TextEncryption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public List<Integer> encrypt(int e, int mod, String message){
        List<Integer> asciiArray = new ArrayList<>();
        for(char c: message.toCharArray()) {
            asciiArray.add((int) c);
        }
        List<Integer> encryptedAscii = new ArrayList<>();
        for(int ascii: asciiArray){
            encryptedAscii.add(modularExponentiation(ascii, e, mod));
        }
        return encryptedAscii;
    }

    public static String decrypt(int d, int mod, List<Integer> encryptedMessage){
        StringBuilder sb = new StringBuilder();
        for(Integer encryptedAscii : encryptedMessage){
            sb.append((char) modularExponentiation(encryptedAscii, d, mod));
        }
        return sb.toString();
    }

    public static int modularExponentiation(int base, int exponent, int mod){
        int modularEquivalent = base;
        int power = exponentRaised(exponent);
        List<Integer> summedNumbers = numbersToSum(exponent);
        List<Integer> numbersToMultiply = new ArrayList<>();
        // Squares the base number and finds its modular equivalence in the mod
        // keeping the number small
        for (int i = 0; i < power; i++) {
            modularEquivalent = (int) Math.pow(modularEquivalent, 2);
            modularEquivalent = modularEquivalent % mod;
            if (summedNumbers.contains((int) Math.pow(2, i + 1))) {
                numbersToMultiply.add(modularEquivalent);
            }
        }
        if(exponent%2 != 0)
            numbersToMultiply.add(base);
        int product = numbersToMultiply.get(0);
        for (int i = 1; i < numbersToMultiply.size(); i++) {
            product *= numbersToMultiply.get(i);
            product = product%mod;
        }
        System.out.println(product%mod);
        return product%mod;
    }

    public static List<Integer> numbersToSum(int target){
        List<Integer> twosPowers = new ArrayList<>();
        int sum = 0;
        int num = 1;
        for (int i = 1; num < target; i++) {
            twosPowers.add(num);
            num = (int) Math.pow(2, i);
        }
        Collections.reverse(twosPowers);
        int index = 0;
        List<Integer> numSummed = new ArrayList<>();
        while(sum != target){
            sum += twosPowers.get(index);
            if(sum > target){
                sum -= twosPowers.get(index);
            }else
                numSummed.add(twosPowers.get(index));
            index++;
        }
        return numSummed;
    }
    // Finds the
    public static int exponentRaised(int target){
        return (int) ((Math.log(target))/(Math.log(2)));
    }

}
