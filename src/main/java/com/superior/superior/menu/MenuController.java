package com.superior.superior.menu;

import com.superior.superior.users.Role;
import com.superior.superior.users.User;

import java.util.Scanner;

public class MenuController {

    private static Scanner scnr = new Scanner(System.in);

    public static void showMenu(User user) {
        if (user == null) return;

        boolean exit = false;
        while (!exit) {
            switch (user.getRole()) {
                case CLIENT:
                    exit = clientMenu();
                    break;
                case EMPLOYEE:
                    exit = employeeMenu();
                    break;
                case OWNER:
                    exit = ownerMenu();
                    break;
            }
        }
    }

    private static boolean clientMenu() {
        System.out.println("\n--- CLIENT MENU ---");
        System.out.println("1. View my notes");
        System.out.println("2. Pay invoice");
        System.out.println("0. Logout");

        String choice = scnr.nextLine();

        switch (choice) {
            case "1":
                System.out.println("Viewing client notes...");
                break;
            case "2":
                System.out.println("Paying invoice...");
                break;
            case "0":
                return true; // exit menu
            default:
                System.out.println("Invalid option, try again.");
        }
        return false;
    }

    private static boolean employeeMenu() {
        System.out.println("\n--- EMPLOYEE MENU ---");
        System.out.println("1. View assigned clients");
        System.out.println("2. Add private note");
        System.out.println("3. Clock in/out");
        System.out.println("0. Logout");

        String choice = scnr.nextLine();

        switch (choice) {
            case "1":
                System.out.println("Viewing assigned clients...");
                break;
            case "2":
                System.out.println("Adding private note...");
                break;
            case "3":
                System.out.println("Clocking in/out...");
                break;
            case "0":
                return true; // exit menu
            default:
                System.out.println("Invalid option, try again.");
        }
        return false;
    }

    private static boolean ownerMenu() {
        System.out.println("\n--- OWNER MENU ---");
        System.out.println("1. View all clients");
        System.out.println("2. View employee notes");
        System.out.println("3. Send invoices");
        System.out.println("4. Add/remove employees");
        System.out.println("0. Logout");

        String choice = scnr.nextLine();

        switch (choice) {
            case "1":
                System.out.println("Viewing all clients...");
                break;
            case "2":
                System.out.println("Viewing employee notes...");
                break;
            case "3":
                System.out.println("Sending invoices...");
                break;
            case "4":
                System.out.println("Adding/removing employees...");
                break;
            case "0":
                return true; // exit menu
            default:
                System.out.println("Invalid option, try again.");
        }
        return false;
    }
}

