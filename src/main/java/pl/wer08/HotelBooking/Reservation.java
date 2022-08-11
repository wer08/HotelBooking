package pl.wer08.HotelBooking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Reservation
{
    public Reservation(int id_hotel, Date date_of_arrival, Date date_of_leave)
    {
        this.id_hotel = id_hotel;
        this.date_of_arrival = date_of_arrival;
        this.date_of_leave = date_of_leave;
    }

    private int id;
    private int id_hotel;
    private Date date_of_arrival;
    private Date date_of_leave;
}
