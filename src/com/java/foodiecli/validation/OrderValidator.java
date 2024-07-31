package com.java.foodiecli.validation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderValidator {
    public int getValidOrderChoice(){
        Scanner sc = new Scanner(System.in);
        int input=0;
        try {
            boolean vaildInput = false;
            while (!vaildInput) {
                input = sc.nextInt();
                if (input >= 1 && input <= 4) {
                    vaildInput = true;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Please Enter Number between 1 to 4");
        }
        return input;
    }
    public String getVaildOrderId() {
        System.out.println("Enter id(At least 3 numbers):");
        Scanner sc = new Scanner(System.in);
        String id = "";
        boolean validId = false;
        while (!validId) {
            id = sc.nextLine();
            if (id != null && id.matches("\\d{3,}")) {
                validId = true;
                if (id.charAt(0)!='O') {
                    id = "O" + id;
                }
            } else {
                System.out.println("Invalid id. Please enter an id with at least 3 numbers.");
            }
        }
        return id;
    }

}
