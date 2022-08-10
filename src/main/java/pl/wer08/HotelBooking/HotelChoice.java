package pl.wer08.HotelBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class HotelChoice
{

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton searchButton;
    public JPanel HotelChoice;
    private JComboBox comboBox1;
    private String input;
    private ComboBoxModel model;


    public HotelChoice(HotelHandler hotelHandler)
    {
        searchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                comboBox1.removeAllItems();
                input = textField3.getText();
                if(textField3.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"You have to enter city or name");
                }
                else
                {
                    List<Hotel> hotelList = new ArrayList<>();
                    hotelList = hotelHandler.setChosen(input);
                    for (Hotel hotel : hotelList)
                    {

                        comboBox1.addItem(hotel.getName() + " Price per person: " + hotel.getPrice());
                    }
                }
            }
        });
    }
}
