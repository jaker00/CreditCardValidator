/**
 * Created by jakereisner on 10/14/16.
 */

import javax.swing.*;

public class CreditCardValidator {
    public static int[] create_array(String a) { //original number
        int[] numbers = new int[11];
        for (int i = 0; i <= 10; i++) {
            numbers[i] = Character.getNumericValue(a.charAt(i));
        }
        return numbers;
    }
    public static int[] first_numbers(int[] create_array){ //number with doubled every other and sum digits
        int[] first_numbers = new int[11];
        for(int i =0;i<=10;i++){
            first_numbers[i]=create_array[i];
        }
        for(int i = 0;i<=9;i++){
            if (i%2==1)
                first_numbers[i]=create_array[i]*2;
        }
        for(int i=1;i<=5;i++) {
            if (first_numbers[2 * i - 1] > 9)
                first_numbers[2 * i - 1] = 1 + (first_numbers[2 * i - 1] % 10);
        }
        return first_numbers;
    }

    public static int[] new_numbers(int[] first_numbers, int[] create_array){ //original number with check digit
        int[] new_numbers = new int[11];
        int sum = first_numbers[0]+first_numbers[1]+first_numbers[2]+first_numbers[3]+first_numbers[4]+first_numbers[5]+first_numbers[6]+first_numbers[7]
        +first_numbers[8]+first_numbers[9];
        int x = 10-(sum%10);
        new_numbers[10]=x;
        for (int i=0; i<=9;i++)
            new_numbers[i]=create_array[i];
        return new_numbers;
    }
    public static boolean final_result(int[] first_numbers, int[] new_numbers, int[] create_array){
        int first_numbers_sum = first_numbers[0]+first_numbers[1]+first_numbers[2]+first_numbers[3]+first_numbers[4]+
        first_numbers[5]+first_numbers[6]+first_numbers[7]+first_numbers[8]+first_numbers[9];

        if (first_numbers_sum+new_numbers[10]==first_numbers_sum+create_array[10])
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        String a = JOptionPane.showInputDialog("enter credit card number");
        System.out.println(final_result(first_numbers(create_array(a)),new_numbers(first_numbers(create_array(a)),create_array(a)),create_array(a)));
    }
}
