package pl.wer08.HotelBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientHandler
{
    @Autowired
    ClientRepository clientRepository;

    public Client getNames(String username)
    {
        return clientRepository.setName(username);
    }
    public void addClient(Client client)
    {
        clientRepository.addClient(client);
    }
    public boolean checkLogin(String username)
    {
        return clientRepository.checkClient(username);
    }
    public Client checkPassword(String username, String password)
    {
        return clientRepository.checkPassword(username, password);
    }

}
