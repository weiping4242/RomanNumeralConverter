package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.RomanNumeralConverterDTO;


@Service
public class RomanNumeralConverterService {
	private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMANS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	
	public RomanNumeralConverterDTO romanToDecimal(String romanNumeral) {
		System.out.println("romanToDecimal romanNumeral: " + romanNumeral);
		RomanNumeralConverterDTO res = new RomanNumeralConverterDTO();
        int result = 0;
        int prevValue = 0;
        
        boolean isValidRomanNum = isValidRomanNumeral(romanNumeral);
        if(isValidRomanNum == false){
        	System.out.println(romanNumeral + " is not a valid roman numeral.");
        	res.setNumericInt(-1);
        	
        	return res;
        }

        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
            int currentValue = getValue(romanNumeral.charAt(i));
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            prevValue = currentValue;
        }
        
        res.setNumericInt(result);
        return res;
    }
    


    public RomanNumeralConverterDTO numberToRoman(int number) {
    	System.out.println("numberToRoman number: " + number);
		RomanNumeralConverterDTO res = new RomanNumeralConverterDTO();
        StringBuilder sb = new StringBuilder();
        
        if (number <= 0 || number >= 4000) {
        	System.out.println("numberToRoman number cannot exceed 4000");
            res.setRomanNumeralString("Invalid");
            res.setNumericInt(-1);
            return res;
        }

        for (int i = 0; i < VALUES.length; i++) {
            while (number >= VALUES[i]) {
                sb.append(ROMANS[i]);
                number -= VALUES[i];
            }
        }
        
        res.setRomanNumeralString(sb.toString());

        return res;
    }

    private int getValue(char romanChar) {
        switch (romanChar) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
    
    private boolean isValidRomanNumeral(String roman) {
        // Check for empty string
        if (roman == null || roman.isEmpty()) {
            return false;
        }

        // Regular expression pattern for valid Roman numerals
        String pattern = "^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";

        // Check if the Roman numeral matches the pattern
        return roman.matches(pattern);
    }
}
