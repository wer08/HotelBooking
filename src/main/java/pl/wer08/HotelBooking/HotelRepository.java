package pl.wer08.HotelBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class HotelRepository
{
    @Autowired
    JdbcTemplate jdbcTemplate;
}
