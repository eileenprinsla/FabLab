package com.FabLab.FabLab.service;

import com.FabLab.FabLab.entity.TCBooking;
import com.FabLab.FabLab.repository.BookingRepository;
import com.FabLab.FabLab.repository.TCBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TCBookingService {

    private final TCBookingRepository tcbookingRepository;

    public TCBookingService(TCBookingRepository tcbookingRepository) {
        this.tcbookingRepository = tcbookingRepository;
    }

    public void CreateRequest(TCBooking tcbooking){

        tcbookingRepository.save(tcbooking);
    }

    public TCBooking ReadRequest(String id) {

        return tcbookingRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    public List<TCBooking> GetAllBooking() {

        return tcbookingRepository.findAll();
    }

}
