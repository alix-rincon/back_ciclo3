package com.usa.ciclo3.reto3.service;

import java.util.List;
import java.util.Optional;
import com.usa.ciclo3.reto3.model.Reservation;
import com.usa.ciclo3.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    /**
     * 
     * @return
     */
    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    /**
     * 
     * @param reservationId
     * @return
     */
    public Optional<Reservation> getReservationId(int reservationId) {
        return reservationRepository.getReservationId(reservationId);
    }

    /**
     * 
     * @param reservation
     * @return
     */
    public Reservation saveReservation(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.saveReservation(reservation);
        } else {
            Optional<Reservation> e = reservationRepository.getReservationId(reservation.getIdReservation());
            if (e.isEmpty()) {
                return reservationRepository.saveReservation(reservation);
            } else {
                return reservation;
            }
        }
    }

    /**
     * 
     * @param reservation
     * @return
     */
    public Reservation updateReservation(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> e = reservationRepository.getReservationId(reservation.getIdReservation());
            if (!e.isEmpty()) {

                if (reservation.getStartDate() != null) {
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    e.get().setStatus(reservation.getStatus());
                }
                reservationRepository.saveReservation(e.get());
                return e.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    /**
     * 
     * @param reservationId
     * @return
     */
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservationId(reservationId).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}