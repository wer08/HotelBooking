package pl.wer08.HotelBooking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.swing.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Client
{
    private int id;
    private String username;
    private String name;
    private String surname;
    private int age;
    private String password;

    public Client(String username, String name, String surname, int age, String password)
    {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.password = password;
    }

    public Client createClient(String username, String name, String surname, int age, String password)
    {
        return new Client(username,name,surname,age,password);
    }

}
