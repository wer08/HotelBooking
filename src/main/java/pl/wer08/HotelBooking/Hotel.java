package pl.wer08.HotelBooking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Hotel
{
    private int id;
    private String name;
    private int number_of_rooms_1;
    private int number_of_rooms_2;
    private int number_of_rooms_3;
    private float price;
    String city;

    @Override
    public String toString()
    {
        return  city + " " +
                 name + " " +
                + price +"PLN"
                ;
    }
}
