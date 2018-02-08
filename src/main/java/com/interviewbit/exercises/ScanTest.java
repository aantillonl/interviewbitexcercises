package com.interviewbit.exercises;

import java.util.Scanner;

class ScanTest implements ProblemInterface{
    public void Test(){
        System.out.println("Enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Your username is " + username);
    }
}