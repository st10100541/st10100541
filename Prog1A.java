/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keletso.tryagain;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.*;

/**
 *
 * @author kmotl
 */
public class Prog1A {

    public static void main(String[] args) {

        //sc is the object reference
        // scanner allows user to insert values 
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter first name");
        String Fname = sc.nextLine();
        System.out.println("enter last name");
        String lname = sc.nextLine();
        String username, password;
        do {
            System.out.println("enter username");
            username = sc.next();
            if (checkUserName(username) == false) {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters");
            } else {
                System.out.println("username succesfully captured");
            }

        } while (checkUserName(username) == false);
        do {
            System.out.println("Please enter a Password: ");
            password = sc.next();
            if (chechPasswordComplexity(password) == true) {
                System.out.println("******************************USER DETAILS*****************************************");
                System.out.println("*\tname:\t\t\t" + Fname + "\n*\tSurname:\t\t" + lname + "\n*\tUsername:\t\t" + username + "\n*\tPassword:\t\t" + password);
                System.out.println("************************************************************************************"
                        + "\n\tWelcome " + Fname + ", " + lname + " it is great to see you again.");
                System.out.println("");
                Scanner input = new Scanner(System.in);
                System.out.println("Please choose between one of the following features: \n1- add task \n2- show report \n3-quit ");
                choice = input.nextInt();
                if (choice == 1) {

                    int task;
                    do {
                        System.out.println("Enter a number of task(they can't be more than 5)");
                        task = input.nextInt();
                    } while (task > 5);
                    String task_name[] = new String[task];
                    String developer_name[] = new String[task];
                    String Task_status[] = new String[task];
                    String task_description[] = new String[task];
                    int task_duration[] = new int[task];

                    int a[] = new int[task];
                    for (int i = 0; i < a.length; i++) {
                        System.out.println("task" + i);
                        System.out.println();
                        System.out.println("enter task name");
                        task_name[i] = input.next();
                        System.out.println("enter name of the developer");
                        developer_name[i] = input.next();
                        System.out.println("enter task duration");
                        task_duration[i] = input.nextInt();
                        System.out.println("select task status: \n1- to do \n2-doing \n3-done");
                        int task_choice = input.nextInt();
                        if (task_choice == 1) {
                            Task_status[i] = "to do";
                        }
                        if (task_choice == 2) {
                            Task_status[i] = "doing";
                        }
                        if (task_choice == 3) {
                            Task_status[i] = "done ";
                        }
                        do {
                            System.out.println("enter task description(maximum characters is 50)");
                            task_description[i] = input.nextLine();
                            checkTaskDescription(task_description[i]);
                        } while (checkTaskDescription(task_description[i]) == false);
                        sc.next();
                    }

                    for (int i = 0; i < a.length; i++) {
                        System.out.println("*************************************************************************************");
                        System.out.println("\t\tTASK" + i);
                        System.out.println("*************************************************************************************");
                        System.out.println("Task name:\t\t\t" + task_name[i]);
                        System.out.println("task description:\t\t" + task_description[i]);
                        System.out.println("Developer name:\t\t" + developer_name[i]);
                        System.out.println("Task duration:\t " + task_duration[i]);
                        createtaskID();
                        System.out.println("Task Status\t" + Task_status[i]);
                        System.out.println("*************************************************************************************");

                    }
                }
                if (choice == 2) {
                    System.out.println("****************************************************************************************");
                    System.out.println("********************************COMING SOON**********************************************");
                    System.out.println("****************************************************************************************");

                }
                if(choice == 3){
                    break;
                }

            } else {
                System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters,"
                        + "\n a capital letter, \n"
                        + "a number and a special character");
            }
        } while (chechPasswordComplexity(password) == false);

    }

    public static boolean checkUserName(String name) {
        //allows letters from a to z
        //\\w means word character
        //maximum characters should be 5
        String regex = "[a-z0-9]\\w{0,5}$";
        Pattern p = Pattern.compile(regex);
        if (name.matches(regex)) {
            return true;
        }
        Matcher m = p.matcher(name);
        return m.matches();
    }

    public static boolean chechPasswordComplexity(String password) {
        //return true if and only if password:
        //1. have at least eight characters.
        //2. consists of only letters and a digit.
        //3. must contain at least one digit.
        //4. must contain at least one capital letter.
        String regex = "[a-z0-9@!&]\\w{0,8}$";
        Pattern p = Pattern.compile(regex);
        if (password.matches(regex)) {
            return false;
        }
        Matcher m = p.matcher(password);
        return true;
    }

    public static boolean checkTaskDescription(String txt) {
        int count =0;
        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i)!= ' ') {
              count++;  
            }
            if (count<50) {
                return true;
            }
        }
        return false;
    }

    public static void createtaskID() {
        Random rand = new Random();
        System.out.println("task ID:\tID" + rand.nextInt(1000));
    }

    private static void scanf(String string, char[] buffer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
