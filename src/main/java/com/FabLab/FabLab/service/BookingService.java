package com.FabLab.FabLab.service;

import com.FabLab.FabLab.entity.Booking;
import com.FabLab.FabLab.entity.Slot;
import com.FabLab.FabLab.entity.enu.Status;
import com.FabLab.FabLab.exception.NotFoundException;
import com.FabLab.FabLab.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public void CreateRequest(Booking booking){
        booking.setStatus(Status.CREATED);
        bookingRepository.save(booking);
    }

    public List<Slot> readBookedSlotByUserId(int userId) {
     var response = bookingRepository.findByUserId(userId);
     List<Slot> slotList = new ArrayList<>();
     for (Booking responseBooking : response) {
         slotList.add(responseBooking.getSlot());
     }
     return slotList;
    }

    public void updateBookedSlotStatus(int id, String status) {
        var response = bookingRepository.findById(id).orElseThrow(() -> new NotFoundException("Booking not found"));
        response.setStatus(Status.valueOf(status));
        bookingRepository.save(response);
    }

}
