package pl.wer08.HotelBooking;

import org.springframework.cglib.core.Local;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Date;
import java.time.LocalDate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HotelChoice
{

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton searchButton;
    public JPanel HotelChoice;
    private JComboBox comboBox1;
    private JButton makeReservationButton;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JSpinner spinner4;
    private String input;
    private ComboBoxModel model;
    private String chosen;
    private boolean flag;
    private Hotel chosenHotel;


    public HotelChoice(HotelHandler hotelHandler, Client client, ReservationHandler reservationHandler)
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

                        comboBox1.addItem(hotel);
                    }
                }
            }
        });
        makeReservationButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(comboBox1.getSelectedIndex() == -1||textField1.getText().equals("")||textField2.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"All fields must be filled");

                else
                {
                    Hotel hotel = chosenHotel;
                        LocalDate startingDate = LocalDate.parse(textField1.getText());
                        LocalDate leavingDate = LocalDate.parse(textField2.getText());
                        Date startingDateSQL = Date.valueOf(startingDate);
                        Date leavingDateSQL = Date.valueOf(leavingDate);
                        Reservation reservation = makeReservation(hotel.getId(), startingDateSQL, leavingDateSQL);
                        int answer = JOptionPane.showConfirmDialog(null, client.getName() + " " + client.getSurname() + "\n"
                                + chosen+"\n"+startingDate+" - "+leavingDate );
                        if(answer == 0)
                        {
                            reservationHandler.setReservation(reservation);
                            JOptionPane.showMessageDialog(null,"Reservation succesful");
                        }
                    }

                }

        });
        comboBox1.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if(comboBox1.getSelectedItem()!=null)
                {
                    float price = chosenHotel.getPrice();
                    chosen = comboBox1.getSelectedItem().toString();
                    chosenHotel = (Hotel) comboBox1.getSelectedItem();
                }

            }
        });
    }
    private Reservation makeReservation(int id_hotel, Date date_of_arrival, Date date_of_leave)
    {
        return new Reservation(id_hotel,date_of_arrival,date_of_leave);
    }
}
