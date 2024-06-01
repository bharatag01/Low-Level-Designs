package controller;

import dto.CarBookingRequestDTO;
import dto.CarBookingResponseDTO;
import model.Reservation;
import service.RentalSystem;

public class BookingCarController {

    private RentalSystem rentalSystem;
    CarBookingResponseDTO bookCar(CarBookingRequestDTO carBookingRequestDTO)
    {
        CarBookingResponseDTO carBookingResponseDTO= new CarBookingResponseDTO();

        try {
           Reservation reservation= rentalSystem.bookcarOnRent(carBookingRequestDTO.getStartDate(),
                    carBookingRequestDTO.getEndDate(),
                    carBookingRequestDTO.getMake(),
                    carBookingRequestDTO.getModel());
            carBookingResponseDTO.setReservationId(reservation.getReservationId());
            carBookingResponseDTO.setMessage("Reservation Successfully");
        }
        catch(Exception e)
        {
            carBookingResponseDTO.setMessage("Reservation is not completed");
        }
        return carBookingResponseDTO;
    }
}
