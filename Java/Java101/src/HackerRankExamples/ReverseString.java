package HackerRankExamples;

import java.util.Scanner;

public class ReverseString {

    public static String FirstReverse(String str) {
        String reverse="";
        for(int i=str.length()-1;i>=0;i--){
            reverse+=str.charAt(i);
        }
        return reverse;
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print("String : ");
        System.out.print("Reverse String : "+FirstReverse(s.nextLine()));
    }
}
