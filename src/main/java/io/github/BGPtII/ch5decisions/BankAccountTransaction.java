package io.github.BGPtII.ch5decisions;

import java.util.Scanner;

/**
 * Simulates a bank transaction between a saving & checking account.
 * User provides the balances of both accounts (application does NOT accept 0 or negative values).
 * Loops an interface that prompts the user to deposit, withdrawal and transfer from each account (REJECTS offers that overdraw an account)
 */
public class BankAccountTransaction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double savingBalance = -1;
        double checkingBalance = -1;
        boolean runApp = true;
        boolean runInitialEntry = true;
        boolean runMainMenu = false;
        boolean runSavingMenu = false;
        boolean runCheckingMenu = false;



        System.out.println("Bank Transaction App | \"q\" to quit at any prompt");
        while (runApp) {
            if (runInitialEntry) {
                if (savingBalance <= 0) {
                    System.out.print("Enter initial saving balance (MUST BE GREATER THAN 0): ");
                    if (scanner.hasNext("q")) {
                        System.out.println("Exiting application...");
                        break;
                    }
                    else if (scanner.hasNextDouble()) {
                        double input = scanner.nextDouble();
                        if (input > 0) {
                            savingBalance = input;
                        }
                        else {
                            System.out.println("Initial saving balance must be greater than 0.");
                        }
                    }
                    else {
                        System.out.println("Initial saving balance must be a number greater than 0.");
                        scanner.next();
                    }
                }
                else if (checkingBalance <= 0) {
                    System.out.print("Enter initial checking balance (MUST BE GREATER THAN 0): ");
                    if (scanner.hasNext("q")) {
                        System.out.println("Exiting application...");
                        break;
                    }
                    else if (scanner.hasNextDouble()) {
                        double input = scanner.nextDouble();
                        if (input > 0) {
                            checkingBalance = input;
                        }
                        else {
                            System.out.println("Initial checking balance must be greater than 0.");
                        }
                    }
                    else {
                        System.out.println("Initial checking balance must be a number greater than 0.");
                        scanner.next();
                    }
                }
                else {
                    runInitialEntry = false;
                    runMainMenu = true;
                }
            }
            else if (runMainMenu) {
                System.out.println("Bank Transaction App | Main Menu");
                System.out.printf("1. Saving Menu | Balance: $%.2f\n", savingBalance);
                System.out.printf("2. Checking Menu | Balance: $%.2f\n", checkingBalance);
                System.out.print("Enter option index: ");
                if (scanner.hasNext("q")) {
                    System.out.println("Exiting application...");
                    break;
                }
                else if (scanner.hasNextInt()) {
                    int input = scanner.nextInt();
                    if (input == 1) {
                        runMainMenu = false;
                        runSavingMenu = true;
                    }
                    else if (input == 2) {
                        runMainMenu = false;
                        runCheckingMenu = true;
                    }
                    else {
                        System.out.println("Invalid menu index (options: 1 OR 2).");
                    }
                }
                else {
                    System.out.println("Menu option index must be either: 1 OR 2.");
                    scanner.next();
                }
            }
            else if (runSavingMenu) {
                System.out.printf("Saving Menu | Balance: $%.2f\n", savingBalance);
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Transfer (to Checking Account)");
                System.out.println("4. Return to Main Menu");
                System.out.print("Enter option index: ");
                if (scanner.hasNext("q")) {
                    System.out.println("Exiting application...");
                    break;
                }
                else if (scanner.hasNextInt()) {
                    int input = scanner.nextInt();
                    if (input == 1) {
                        System.out.print("Enter deposit amount: ");
                        if (scanner.hasNextDouble()) {
                            double deposit = scanner.nextDouble();
                            if (deposit > 0) {
                                savingBalance += deposit;
                                System.out.println("Deposit successful.");
                            }
                            else {
                                System.out.println("Deposit denied: amount must be greater than 0.");
                            }
                        }
                        else {
                            System.out.println("Deposit denied: amount must be a number greater than 0.");
                            scanner.next();
                        }
                    }
                    else if (input == 2) {
                        System.out.print("Enter withdraw amount: ");
                        if (scanner.hasNextDouble()) {
                            double withdraw = scanner.nextDouble();
                            if (withdraw > 0) {
                                if (savingBalance - withdraw >= 0) {
                                    savingBalance -= withdraw;
                                    System.out.println("Withdraw successful.");
                                }
                                else {
                                    System.out.println("Withdraw denied: Balance can't go below $0.");
                                }
                            }
                            else {
                                System.out.println("Withdraw denied: amount must be greater than 0.");
                            }
                        }
                        else {
                            System.out.println("Withdraw denied: amount must be a number greater than 0.");
                            scanner.next();
                        }
                    }
                    else if (input == 3) {
                        System.out.print("Enter transfer amount: ");
                        if (scanner.hasNextDouble()) {
                            double transfer = scanner.nextDouble();
                            if (transfer > 0) {
                                if (savingBalance >= transfer) {
                                    savingBalance -= transfer;
                                    checkingBalance += transfer;
                                    System.out.println("Transfer successful.");
                                }
                                else {
                                    System.out.println("Transfer denied: amount exceeds saving balance.");
                                }
                            }
                            else {
                                System.out.println("Transfer denied: amount must be greater than 0.");
                            }
                        }
                        else {
                            System.out.println("Transfer denied: amount must be a number greater than 0.");
                            scanner.next();
                        }
                    }
                    else if (input == 4) {
                        runSavingMenu = false;
                        runMainMenu = true;
                    }
                    else {
                        System.out.println("Menu option index must be: 1, 2, 3 OR 4.");
                    }
                }
                else {
                    System.out.println("Menu option index must be numbers: 1-4.");
                    scanner.next();
                }
            }
            else if (runCheckingMenu) {
                System.out.printf("Checking Menu | Balance: $%.2f\n", checkingBalance);
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Transfer (to Saving Account)");
                System.out.println("4. Return to Main Menu");
                System.out.print("Enter option index: ");
                if (scanner.hasNext("q")) {
                    System.out.println("Exiting application...");
                    break;
                }
                else if (scanner.hasNextInt()) {
                    int input = scanner.nextInt();
                    if (input == 1) {
                        System.out.print("Enter deposit amount: ");
                        if (scanner.hasNextDouble()) {
                            double deposit = scanner.nextDouble();
                            if (deposit > 0) {
                                checkingBalance += deposit;
                                System.out.println("Deposit successful.");
                            }
                            else {
                                System.out.println("Deposit denied: amount must be greater than 0.");
                            }
                        }
                        else {
                            System.out.println("Deposit denied: amount must be a number greater than 0.");
                            scanner.next();
                        }
                    }
                    else if (input == 2) {
                        System.out.print("Enter withdraw amount: ");
                        if (scanner.hasNextDouble()) {
                            double withdraw = scanner.nextDouble();
                            if (withdraw > 0) {
                                if (checkingBalance - withdraw >= 0) {
                                    checkingBalance -= withdraw;
                                    System.out.println("Withdraw successful.");
                                }
                                else {
                                    System.out.println("Withdraw denied: Balance can't go below $0.");
                                }
                            }
                            else {
                                System.out.println("Withdraw denied: amount must be greater than 0.");
                            }
                        }
                        else {
                            System.out.println("Withdraw denied: amount must be a number greater than 0.");
                            scanner.next();
                        }
                    }
                    else if (scanner.nextInt() == 3) {
                        System.out.print("Enter transfer amount: ");
                        if (scanner.hasNextDouble()) {
                            double transfer = scanner.nextDouble();
                            if (scanner.nextDouble() > 0) {
                                if (checkingBalance >= transfer) {
                                    checkingBalance -= transfer;
                                    savingBalance += transfer;
                                    System.out.println("Transfer successful.");
                                }
                                else {
                                    System.out.println("Transfer denied: amount exceeds checking balance.");
                                }
                            }
                            else {
                                System.out.println("Transfer denied: amount must be greater than 0.");
                            }
                        }
                        else {
                            System.out.println("Transfer denied: amount must be a number greater than 0.");
                            scanner.next();
                        }
                    }
                    else if (input == 4) {
                        runCheckingMenu = false;
                        runMainMenu = true;
                    }
                    else {
                        System.out.println("Menu option index must be: 1, 2, 3 OR 4.");
                    }
                }
                else {
                    System.out.println("Menu option index must be numbers: 1-4.");
                    scanner.next();
                }
            }
        }
    }
}
