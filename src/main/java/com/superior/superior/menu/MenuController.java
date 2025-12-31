package com.superior.superior.menu;

import com.superior.superior.clients.Client;
import com.superior.superior.employees.Employee;
import com.superior.superior.employees.Owner;
import com.superior.superior.notes.Note;
import com.superior.superior.users.Role;
import com.superior.superior.users.User;

import java.util.List;
import java.util.Scanner;

public class MenuController {

    private static Scanner scnr = new Scanner(System.in);

    public static void showMenu(User user, List<Employee> employees) {
        if (user == null) return;

        boolean exit = false;
        while (!exit) {
            switch (user.getRole()) {
                case CLIENT:
                    exit = clientMenu(user);
                    break;
                case EMPLOYEE:
                    exit = employeeMenu(user);
                    break;
                case OWNER:
                    exit = ownerMenu(user, employees);
                    break;
            }
        }
    }

    private static boolean clientMenu(User user) {
        System.out.println("\n--- CLIENT MENU ---");
        System.out.println("1. View my notes");
        System.out.println("2. Pay invoice");
        System.out.println("0. Logout");

        String choice = scnr.nextLine();

        switch (choice) {
            case "1":
                Client client = (Client) user;
                client.viewNotes();
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

    private static boolean employeeMenu(User user) {
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
                Employee employee = (Employee) user;
                System.out.println("Enter private note: ");
                String noteText = scnr.nextLine();
                employee.addPrivateNote(new Note(noteText, employee.getName()));
                System.out.println("Private note added");
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

    private static boolean ownerMenu(User user, List<Employee> employees) {
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
                Owner owner = (Owner) user;

                if (employees.isEmpty()) {
                    System.out.println("No employees found");
                    break;
                }

                for (Employee emp : employees) {
                    owner.viewEmployeeNotes(emp);
                }
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

