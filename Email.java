package com.company.email;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Email {
    private String content;
    private String subject;
    private String to;

    public Email( String content, String subject, String to) {

        this.content = content;
        this.subject = subject;
        this.to = to;
    }




    public void setContent(String content) {
        this.content = content;
    }

    public void setTo(String to) {this.to = to;}

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void saveEmail(Email email) throws IOException {
        FileOutputStream fileOutputStream =
                new FileOutputStream("email.txt");
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(email);
    }

}
