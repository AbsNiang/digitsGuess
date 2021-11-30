package com.company;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        mainMenu();
    }

    public static int[] computerGenPassword() {
        Random random = new Random();
        int[] fourDigitCode = new int[4];
        for (int i = 0; i < 4; i++) {
            fourDigitCode[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(fourDigitCode));
        return fourDigitCode;
    }

    public static int[] userGuessMenu() {
        Scanner input = new Scanner(System.in);
        boolean validCode = false;
        int[] userGuess = new int[4];
        while (!validCode) {
            try {
                System.out.println("Type a four digit code number by number.");
                for (int i = 0; i < 4; i++) {
                    userGuess[i] = input.nextInt();
                }
                validCode = true;
            } catch (InputMismatchException e) {
                System.out.println("You haven't typed a number");
                input.next();
            }

        }
        return userGuess;
    }

    public static int guessCompare(int[] computerCode, int[] userGuess) {
        int correctNumbers = 0;
        System.out.println(Arrays.toString(userGuess));
        System.out.println(Arrays.toString(computerCode));
        for (int i = 0; i < 4; i++) {
            if (computerCode[i] == userGuess[i]) {
                System.out.println("The digit in location " + (i + 1) + " is correct.");
                correctNumbers++;
            }
        }
        System.out.println("You have " + correctNumbers + " digits correctly in the correct place");
        if (userGuess[0] == computerCode[1] || userGuess[0] == computerCode[2] || userGuess[0] == computerCode[3]) {
            System.out.println("The 1st digit is correct but in the wrong place.");
        }
        if (userGuess[1] == computerCode[2] || userGuess[1] == computerCode[3] || userGuess[1] == computerCode[0]) {
            System.out.println("The 2nd digit is correct but in the wrong place.");
        }
        if (userGuess[2] == computerCode[1] || userGuess[2] == computerCode[0] || userGuess[2] == computerCode[3]) {
            System.out.println("The 3rd digit is correct but in the wrong place.");
        }
        if (userGuess[3] == computerCode[1] || userGuess[3] == computerCode[0] || userGuess[3] == computerCode[2]) {
            System.out.println("The 4th digit is correct but in the wrong place.");
        }
        return correctNumbers;
    }
    public static void mainMenu(){
        int[] computerPassword = computerGenPassword();
        int guesses = 12;
        while (guesses > 0) {
            System.out.println("You have " + guesses + " left.");
            if(guessCompare(computerPassword, userGuessMenu())==4){
                break;
            }
            guesses--;
        }
        if(guesses>0) {
            System.out.println("You win.");
        }else{
            System.out.println("You lost");
        }
    }
}
