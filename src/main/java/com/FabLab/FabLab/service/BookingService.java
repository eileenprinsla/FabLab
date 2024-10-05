package com.FabLab.FabLab.service;

import com.FabLab.FabLab.entity.Booking;
import com.FabLab.FabLab.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public void CreateRequest(Booking booking){

        bookingRepository.save(booking);
    }

    public Booking ReadRequest(String bookingID) {

        return bookingRepository.findById(Integer.valueOf(bookingID)).orElse(null);
    }

    public List<Booking> GetAllBooking() {

        return bookingRepository.findAll();
    }

    public void DeleteRequest(String bookingID){

        bookingRepository.deleteById(Integer.valueOf(bookingID));
    }

}
