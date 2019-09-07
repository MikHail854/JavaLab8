package ru.eltex.app.lab2;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "Credentials")
public class Credentials implements Serializable {

    @Id
    @Type(type = "uuid-char")
    private UUID ID;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "middlename")
    private String middlename;

    @Column(name = "email")
    private String email;

    public Credentials(){
    }

    public Credentials(String firstname, String lastname, String middlename, String email){
        ID = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.email = email;
    }

    public void show(){
        System.out.println("Покупатель");
        System.out.println("ID = " + ID);
        System.out.println("Lastname = " + lastname);
        System.out.println("Firstname = " + firstname);
        System.out.println("Middlename = " + middlename);
        System.out.println("Email = " + email);
    }

    public void showShort(){
        System.out.println(lastname+" "+firstname+"("+email+")");
    }
}
