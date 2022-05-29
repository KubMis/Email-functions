package com.company.email;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int choice;
        User def = new User("Def", "123", "123");
        System.out.println("Create user (1)");
        System.out.println("Log in (2)");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    def.saveUser();
                    break;

                case 2:
                        def.readUser();


                        System.out.println("Write email (W) or Leave (L)");
                    if(!sc.hasNext()){
                        System.out.println("Wrong input");
                    }
                    String write=sc.next();
                    if (write.toUpperCase(Locale.ROOT).equals("L"))
                        break;
                    if (write.toUpperCase(Locale.ROOT).equals("W")) {
                        String content, subject, to;

                        System.out.println("To :");
                        to = sc.next();
                        System.out.println("Subject :");
                        subject = sc.next();
                        System.out.println("Write your message here");
                        content = sc.next();

                        Email email = new Email(content, subject, to);
                        email.setContent(content);
                        email.setSubject(subject);
                        email.setTo(to);

                        email.saveEmail(email);

                    }
                    else System.out.println("Wrong input");

                       break;

                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }

        }
