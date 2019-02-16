package calculator;

import java.util.HashMap;
import java.util.TreeMap;

public class Converter {
    private HashMap<Character, Integer> romanToArab = new HashMap<>();
    private TreeMap<Integer, String> arabToRoman = new TreeMap<>();

    {
        romanToArab.put('I',1);
        romanToArab.put('X',10);
        romanToArab.put('C',100);
        romanToArab.put('M',1000);
        romanToArab.put('V',5);
        romanToArab.put('L',50);
        romanToArab.put('D',500);
    }
    {
        arabToRoman.put(1000, "M");
        arabToRoman.put(900, "CM");
        arabToRoman.put(500, "D");
        arabToRoman.put(400, "CD");
        arabToRoman.put(100, "C");
        arabToRoman.put(90, "XC");
        arabToRoman.put(50, "L");
        arabToRoman.put(40, "XL");
        arabToRoman.put(10, "X");
        arabToRoman.put(9, "IX");
        arabToRoman.put(5, "V");
        arabToRoman.put(4, "IV");
        arabToRoman.put(1, "I");
    }

    public int convertRomanToArab(String num){

        int intNum=0;
        int prev = 0;
        for(int i = num.length()-1; i>=0 ; i--){

            int temp = romanToArab.get(num.charAt(i));
            if(temp < prev)
                intNum-=temp;
            else
                intNum+=temp;
            prev = temp;
        }
        return intNum;
    }

    public String convertArabToRoman(int number) {
        int l =  arabToRoman.floorKey(number);
        if ( number == l ) {
            return arabToRoman.get(number);
        }
        return arabToRoman.get(l) + convertArabToRoman(number-l);
    }

    public boolean isDigitArabic(String digit){
        try{
            double a = Double.parseDouble(digit);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
