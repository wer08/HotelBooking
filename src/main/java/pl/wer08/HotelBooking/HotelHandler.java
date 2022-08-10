package pl.wer08.HotelBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HotelHandler
{
    @Autowired
    HotelRepository hotelRepository;
    public List<Hotel> setChosen(String input)
    {
        return hotelRepository.getChosen(input);
    }
}
