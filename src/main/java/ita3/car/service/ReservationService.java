package ita3.car.service;
import org.springframework.data.web

//Implement a Service method that will allow Members to make a reservation for a Car
// (assume he had used another endpoint to get the ID for the car, and have decided for a date)

import ita3.car.dto.ReservationDTO;
import ita3.car.entity.Car;
import ita3.car.entity.Member;
import ita3.car.entity.Reservation;
import ita3.car.repository.ICarRepository;
import ita3.car.repository.IMemberRepository;
import ita3.car.repository.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    @Autowired
    private IReservationRepository reservationRepository;

    public List<ReservationDTO> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ReservationDTO getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)

                //.orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + id));
        return convertToDTO(reservation);

    }

    public ReservationDTO createReservation(ReservationDTO reservationDTO) {
        Reservation reservation = convertToEntity(reservationDTO);
        Reservation savedReservation = reservationRepository.save(reservation);
        return convertToDTO(savedReservation);
    }


    public ReservationDTO updateReservation(Long id, ReservationDTO reservationDTO) {
        Reservation existingReservation = reservationRepository.findById(id)
                //.orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + id));

        // Update car attributes from reservationDTO

        Reservation updatedReservation = reservationRepository.save(existingReservation);
        return convertToDTO(updatedReservation);
    }

    public void deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                //.orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + id));
        reservationRepository.delete(reservation);
    }

    private ReservationDTO convertToDTO(Reservation reservation) {
        // Konverter Car til CarDTO
    }

    private Reservation convertToEntity(ReservationDTO carDTO) {
        // Konverter CarDTO til Car
    }
}





    public void reserveCar(Member member, Car car) {
        IReservationRepository reservation = new Reservation(car, member);






    }
}


