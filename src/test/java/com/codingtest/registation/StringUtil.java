package com.codingtest.registation

import java.io.IOException;
import java.util.Scanner;

public class StringUtil {

    public static void main(String... args) throws IOException {

        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.println("Enter the string lenghts with space separated");
            String lenghtParams = scanner.nextLine();
            
            System.out.println("Enter first string \n");
            String firstString = scanner.nextLine();
            
            System.out.println("Enter second string \n");
            String secondString = scanner.nextLine();
            
            System.out.println("Inputs received Processing...\n");
            
            String[] stringLenghts = lenghtParams.split(" ");
            if(stringLenghts.length != 2)
                throw new IllegalStateException("provide two lenghts with space seperated");
            int n = Integer.valueOf(stringLenghts[0]);
            int k = Integer.valueOf(stringLenghts[1]);
            
            if((firstString.length() != n) ||  (secondString.length() != k)) {
                throw new IllegalStateException("Invalid input strings");
            }

            compareString(n, k, firstString, secondString);
        }

    }

    public static void compareString(int n, int k, String str1, String str2) {

        if (n < 1 && n > 100) {
            throw new IllegalArgumentException("lenght of the string (n) should be in 1 to 100 range");
        }

        if (k < 1 && k > 100) {
            throw new IllegalArgumentException("lenght of the string (n) should be in 1 to 100 range");
        }
        
        System.out.println("Result Is:: ");
        if(n > k) {
            System.out.println("NO");
        } else {
            boolean isMatched = false;
            for(int i = 0; i< k; i++) {
                int j = i;
                int matchCount = 0;
                for(int p =0; p < n; p++) {
                    if(j + p >= k) {
                        isMatched = false;
                        break;
                    }
                    if(str2.charAt(j + p) == str1.charAt(p)) {
                        matchCount++;
                        continue;
                    }
                    
                }
                if(matchCount == n) {
                    isMatched = true;
                    break;
                }
            }
           if(isMatched) {
               System.out.println("YES");
           } else {
               System.out.println("NO");
           }
        }

    }

}
