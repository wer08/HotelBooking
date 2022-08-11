package pl.wer08.HotelBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationHandler
{
    @Autowired
    ReservationRepository reservationRepository;

    public void setReservation(Reservation reservation)
    {
        reservationRepository.addReservation(reservation);
    }
}
