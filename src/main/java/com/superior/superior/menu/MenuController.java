package com.superior.superior.menu;

import com.superior.superior.users.Role;
import com.superior.superior.users.User;

public class MenuController {

    public static void showMenu(User user) {

        if (user == null) {
            return;
        }

        switch (user.getRole()) {
            case CLIENT:
                showClientMenu();
                break;
            case OWNER:
                showOwnerMenu();
                break;
            case EMPLOYEE:
                showEmployeeMenu();
                break;
        }
    }

    private static void showClientMenu() {
        System.out.println("\n=== CLIENT MENU ===");
        System.out.println("1. View my notes");
        System.out.println("2. Pay invoice");
    }

    private static void showOwnerMenu() {
        System.out.println("\n=== OWNER MENU ===");
        System.out.println("1. View all clients");
        System.out.println("2. View employee notes");
        System.out.println("3. Send Invoices");
        System.out.println("4. Add/remove employees");
    }

    private static void showEmployeeMenu() {
        System.out.println("\n=== EMPLOYEE MENU ===");
        System.out.println("1. View assigned clients");
        System.out.println("2. Add private note");
        System.out.println("3. Clock in/out");
    }
}
