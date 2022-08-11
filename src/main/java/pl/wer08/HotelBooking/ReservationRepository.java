package pl.wer08.HotelBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
public class ReservationRepository
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addReservation(Reservation reservation)
    {
        int id_hotel = reservation.getId_hotel();
        Date date_of_arrival = reservation.getDate_of_arrival();
        Date date_of_leave = reservation.getDate_of_leave();
        jdbcTemplate.update("INSERT INTO reservation (id_hotel,day_of_arrival,dayn_of_leave) VALUES (?,?,?)", id_hotel,date_of_arrival,date_of_leave);
    }

}
