package pl.wer08.HotelBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Repository
public class ClientRepository
{
    @Autowired
    JdbcTemplate jdbcTemplate;
    List<Client> clients = new ArrayList<>();


    public boolean checkClient(String username)
    {
        clients = jdbcTemplate.query("SELECT username FROM client", BeanPropertyRowMapper.newInstance(Client.class));
        for (Client client:clients)
        {
            if(client.getUsername().equals(username))
                return true;
        }
        return false;
    }
    public Client setName(String username)
    {
        Client client = jdbcTemplate.queryForObject("SELECT name,surname FROM client WHERE username =?",BeanPropertyRowMapper.newInstance(Client.class),username);
        return client;
    }
    public Client checkPassword(String username, String password)
    {
        Client client = jdbcTemplate.queryForObject("SELECT username,password,name,surname FROM client WHERE username = ?", BeanPropertyRowMapper.newInstance(Client.class),username);
        if(client.getPassword().equals(password))
        {
            return client;
        }
        else
        {
            return null;
        }
    }

    public void addClient(Client client)
    {
        String username = client.getUsername();
        String name = client.getName();
        String  surname = client.getSurname();
        int age = client.getAge();
        String password = client.getPassword();
        int update = jdbcTemplate.update("INSERT INTO client (username,name,surname,age,password) VALUES (?,?,?,?,?)",username, name, surname, age, password);
    }
}
