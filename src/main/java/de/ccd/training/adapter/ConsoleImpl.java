package de.ccd.training.adapter;

import java.util.Scanner;

public class ConsoleImpl implements Console {

    @Override
    public void display(String message) {
        System.out.println(message);
    }

    @Override
    public char readKey() {
        Scanner s = new Scanner(System.in);
        var input = s.nextLine();
        return input.charAt(0);
    }

}
