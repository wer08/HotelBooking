package pl.wer08.HotelBooking;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn
{

    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton logInButton;
    private JButton registerButton;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    public JPanel LogIn;



    public LogIn(Client client, ClientHandler clientHandler, HotelHandler hotelHandler, ReservationHandler reservationHandler)
    {
        registerButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String username = textField1.getText();
                String name = textField2.getText();
                String surname = textField3.getText();
                int age = Integer.parseInt(textField4.getText());
                String password = String.valueOf(passwordField1.getPassword());
                Client newClient = client.createClient(username,name,surname,age,password);
                clientHandler.addClient(newClient);
                JOptionPane.showConfirmDialog(null,"Username: "+username+"\n"+"Name: "+name+"\n"+
                        "Surname: "+surname+"\n"+"Age: "+age);
            }
        });
        logInButton.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(!(textField1.getText().isEmpty() || passwordField1.getPassword().length == 0))
                {
                    if (!(clientHandler.checkLogin(textField1.getText())))
                    {
                        JOptionPane.showMessageDialog(null, "There is no user with this username. Register or type another username");
                    }
                    else
                    {
                        Client client1 = clientHandler.checkPassword(textField1.getText(),String.valueOf(passwordField1.getPassword()));
                        if( client1 != null)
                        {
                            JFrame frame;
                            frame = (JFrame) logInButton.getRootPane().getParent();
                            frame.dispose();
                            JOptionPane.showMessageDialog(null, "You are logged in");
                            JFrame frame2 = new JFrame("HotelChoice");
                            frame2.setContentPane(new HotelChoice(hotelHandler,client1,reservationHandler).HotelChoice);
                            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame2.pack();
                            frame2.setVisible(true);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Wrong password");
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Username or password field is empty");
                }
            }
        });
    }


}
