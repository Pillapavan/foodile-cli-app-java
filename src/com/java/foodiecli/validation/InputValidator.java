package com.java.foodiecli.validation;

import com.java.foodiecli.ui.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {
    public int getValidMenuChoice(){
        Scanner sc = new Scanner(System.in);
        int input=0;
        try {
            boolean vaildInput = false;
            while (!vaildInput) {
                input = sc.nextInt();
                if (input >= 1 && input <= 5) {
                    vaildInput = true;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Please Enter Number between 1 to 5");
        }
        return input;
    }
}