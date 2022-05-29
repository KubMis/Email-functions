package com.company.email;

import java.io.*;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class User implements Serializable {
    private  int id;
    public String username;
    private String login;
    private String password;


    public User( String username, String login, String password) {
        id=0;
        Random random=new Random();
        id=random.nextInt(0,50);
        this.username = username;
        this.login = login;
        this.password = password;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getLogin() {
        return login;
    }

    public void saveUser() throws FileNotFoundException, IOException {
        Scanner sc=new Scanner(System.in);

            System.out.println("Insert Login");
        String login = sc.next();
            System.out.println("Insert password");
        String password = sc.next();
            System.out.println("Insert username");
        String username = sc.next();

        User user = new User(username, login, password);


        FileOutputStream fileOutputStream =
                new FileOutputStream("usersData.txt");
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user);

    }

    public void readUser() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fileInputStream =
                new FileInputStream("usersData.txt");
        ObjectInputStream objectInputStream =
                new ObjectInputStream(fileInputStream);
        User user = (User) objectInputStream.readObject();

        Scanner sc=new Scanner(System.in);

        System.out.println("Login : ");
            String checkLogin = sc.next();
        System.out.println("Password : ");
            String checkPassword = sc.next();

        if(user.password.equals(checkPassword) && user.login.equals(checkLogin)){
            System.out.println("Hello "+ user.username.toUpperCase(Locale.ROOT));
        }
        else{ System.out.println("Incorrect credentials");
        System.exit(1);}






    }
}
