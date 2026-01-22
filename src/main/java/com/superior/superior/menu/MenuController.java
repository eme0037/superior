package com.superior.superior.menu;

import com.superior.superior.clients.Client;
import com.superior.superior.employees.Employee;
import com.superior.superior.employees.Owner;
import com.superior.superior.notes.Note;
import com.superior.superior.users.User;
import com.superior.superior.billing.Invoice;

import java.util.List;
import java.util.Scanner;

public class MenuController {

    private static Scanner scnr = new Scanner(System.in);

    public static void showMenu(User user, List<Client> clients, List<Employee> employees) {
        if (user == null) return;

        boolean exit = false;
        while (!exit) {
            switch (user.getRole()) {
                case CLIENT:
                    exit = clientMenu(user, employees);
                    break;
                case EMPLOYEE:
                    exit = employeeMenu(user);
                    break;
                case OWNER:
                    exit = ownerMenu(user, clients, employees);
                    break;
            }
        }
    }

    private static boolean clientMenu(User user, List<Employee> employees) {
        Client client = (Client) user;

        System.out.println("\n--- CLIENT MENU ---");
        System.out.println("1. View my notes");
        System.out.println("2. View my invoices");
        System.out.println("3. Pay invoice");
        System.out.println("0. Logout");

        String choice = scnr.nextLine();

        switch (choice) {
            case "1":
                if (client.getNotes().isEmpty()) {
                    System.out.println("No notes");
                }
                else {
                    for (Note note : client.getNotes()) {
                        System.out.println(note.getCreatedBy() + ": " + note.getText() + " at " + note.getCreatedAt());
                    }
                }
                break;
            case "2":
                List<Invoice> unpaid = client.getUnpaidInvoices();
                if (unpaid.isEmpty()) {
                    System.out.println("No unpaid invoices");
                    break;
                }

                System.out.println("Unpaid invoices: ");
                for (int i = 0; i < unpaid.size(); i++) {
                    System.out.println((i + 1) + ". " + unpaid.get(i));
                }

                System.out.println("Select invoice to pay: ");
                int index;
                try {
                    index = Integer.parseInt(scnr.nextLine()) - 1;
                    if (index < 0 || index >= unpaid.size()) {
                        System.out.println("Invalid selection");
                        break;
                    }
                    unpaid.get(index).pay();
                    System.out.println("Invoice paid successfully");
                } catch (Exception e) {
                    System.out.println("Invlaid input");
                }
                break;
            case "3":
                List<Invoice> unpaidInvoices = client.getInvoices().stream().filter(i -> !i.isPaid()).toList();

                if (unpaidInvoices.isEmpty()) {
                    System.out.println("No unpaid invoices");
                    break;
                }

                System.out.println("Select invoice to pay: ");
                for (int i = 0; i < unpaidInvoices.size(); i++) {
                    System.out.println((i + 1) + ". " + unpaidInvoices.get(i));
                }

                try {
                    int invoiceIndex = Integer.parseInt(scnr.nextLine()) - 1;
                    unpaidInvoices.get(invoiceIndex).pay();
                    System.out.println("Invoice paid successfully");
                }
                catch (Exception e) {
                    System.out.println("Invalid selection");
                }
                break;

            case "0":
                return true; // exit menu
            default:
                System.out.println("Invalid option, try again.");
        }
        return false;
    }

    private static boolean employeeMenu(User user) {
        Employee employee = (Employee) user;

        System.out.println("\n--- EMPLOYEE MENU ---");
        System.out.println("1. View assigned clients");
        System.out.println("2. Add private note");
        System.out.println("3. Clock in/out");
        System.out.println("0. Logout");

        String choice = scnr.nextLine();

        switch (choice) {
            case "1":
                Employee emp = (Employee) user;
                if(employee.getAssignedClients().isEmpty()) {
                    System.out.println("No assigned clients");
                } else {
                    System.out.println("Assigned Clients:");
                    for (Client c : emp.getAssignedClients()) {
                        System.out.println("- " + c.getName());
                    }
                }
                break;
            case "2":
                System.out.println("Enter private note: ");
                String noteText = scnr.nextLine();
                employee.addPrivateNote(new Note(noteText, employee.getName()));
                System.out.println("Private note added");
                break;
            case "3":
                employee.clockInOut();
                if (employee.isClockedIn()) {
                    System.out.println("Clocked In");
                }
                else {
                    System.out.println("Clocked Out");
                }
                break;
            case "0":
                return true; // exit menu
            default:
                System.out.println("Invalid option, try again.");
        }
        return false;
    }

    private static boolean ownerMenu(User user, List<Client> clients, List<Employee> employees) {
        Owner owner = (Owner) user;

        System.out.println("\n--- OWNER MENU ---");
        System.out.println("1. View all clients");
        System.out.println("2. View employee notes");
        System.out.println("3. Send invoices");
        System.out.println("4. Assign client to employee");
        System.out.println("5. Add/remove employees");
        System.out.println("0. Logout");

        String choice = scnr.nextLine();

        switch (choice) {
            case "1":
                System.out.println("Viewing all clients...");
                break;
            case "2":
                if (employees.isEmpty()) {
                    System.out.println("No employees found");
                    break;
                }

                for (Employee emp : employees) {
                    owner.viewEmployeeNotes(emp);
                }
                break;
            case "3": // create invoice
                if (clients.isEmpty()) {
                    System.out.println("No clients available");
                    break;
                }

                System.out.println("Select client: ");
                for (int i = 0; i < clients.size(); i++) {
                    System.out.println((i + 1) + ". " + clients.get(i).getName());
                }

                int clientIndex;
                try {
                    clientIndex = Integer.parseInt(scnr.nextLine()) - 1;
                } catch (Exception e) {
                    System.out.println("Invalid selection");
                    break;
                }

                Client selectedClient = clients.get(clientIndex);

                System.out.println("Enter invoice amount: ");
                double amount;
                try {
                    amount = Double.parseDouble(scnr.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid amount");
                    break;
                }

                Invoice invoice = new Invoice(System.currentTimeMillis(), selectedClient.getName(), amount);

                selectedClient.addInvoice(invoice);

                System.out.println("Invoice sent to " + selectedClient.getName());
                break;
            case "4":
                if (employees.isEmpty()) {
                    System.out.println("No employees to assign");
                    break;
                }
                if (clients.isEmpty()) {
                    System.out.println("No clients available");
                    break;
                }

                System.out.println("Select employee to assign a client: ");
                for (int i = 0; i < employees.size(); i++) {
                    System.out.println((i + 1) + ". " + employees.get(i).getName());
                }

                int empIndex;
                try {
                    empIndex = Integer.parseInt(scnr.nextLine()) - 1;
                } catch (Exception e) {
                    System.out.println("Invalid employee index");
                    break;
                }

                Employee selectedEmployee = employees.get(empIndex);

                System.out.println("Select client to assign: ");
                for (int i = 0; i < clients.size(); i++) {
                    System.out.println((i + 1) + ". " + clients.get(i).getName());
                }

               // int clientIndex;
                try {
                    clientIndex = Integer.parseInt(scnr.nextLine()) - 1;
                } catch (Exception e) {
                    System.out.println("Invalid selection");
                    break;
                }
                if (clientIndex < 0 || clientIndex >= clients.size()) {
                    System.out.println("Invalid client index");
                    break;
                }

                Client clientToAssign = clients.get(clientIndex);

                selectedEmployee.assignClient(clientToAssign);
                System.out.println("Assigned client " + clientToAssign.getName() + " to employee " + selectedEmployee.getName());
                break;
            case "5":
                System.out.println("\n1. Add Employee");
                System.out.println("2. Remove Employee");
                System.out.println("0. Back");

                String empChoice = scnr.nextLine();

                switch (empChoice) {
                    case "1":
                        System.out.println("Enter new employee name: ");
                        String name = scnr.nextLine();

                        System.out.println("Enter new employee email: ");
                        String email = scnr.nextLine();
                        ;

                        System.out.println("Enter new employee password: ");
                        String password = scnr.nextLine();

                        long id = System.currentTimeMillis(); // gives a simple unique ID
                        Employee newEmployee = new Employee(id, email, password, name);
                        employees.add(newEmployee);

                        System.out.println("Employee added: " + name);
                        break;
                    case "2":
                        if (employees.isEmpty()) {
                            System.out.println("No employees to remove");
                            break;
                        }

                        System.out.println("Select employee to remove: ");
                        for (int i = 0; i < employees.size(); i++) {
                            System.out.println((i + 1) + ". " + employees.get(i).getName());
                        }

                        int removeIndex;
                        try {
                            removeIndex = Integer.parseInt(scnr.nextLine()) - 1;
                        } catch (Exception e) {
                            System.out.println("Invalid selection");
                            break;
                        }

                        if (removeIndex < 0 || removeIndex >= employees.size()) {
                            System.out.println("Invalid index");
                            break;
                        }

                        Employee removed = employees.remove(removeIndex);
                        System.out.println("Removed employee: " + removed.getName());
                        break;
                    case "0":
                        break;
                    default:
                        System.out.println("Invalid option");
                }
                break;
            case "0":
                return true; // exit menu
            default:
                System.out.println("Invalid option, try again.");
        }
        return false;
    }
}

