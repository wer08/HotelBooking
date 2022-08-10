package pl.wer08.HotelBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HotelRepository
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Hotel> getChosen(String input)
    {
        return jdbcTemplate.query("SELECT name,price FROM hotel WHERE city = ? OR name = ?", BeanPropertyRowMapper.newInstance(Hotel.class),input,input);
    }
}
