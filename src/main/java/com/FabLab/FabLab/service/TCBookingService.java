package com.FabLab.FabLab.service;

import com.FabLab.FabLab.entity.TCBooking;
import com.FabLab.FabLab.repository.BookingRepository;
import com.FabLab.FabLab.repository.TCBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TCBookingService {

    @Autowired
    private TCBookingRepository tcbookingRepository;

    public void CreateRequest(TCBooking tcbooking){

        tcbookingRepository.save(tcbooking);
    }

    public TCBooking ReadRequest(String tcbookingID) {

        return tcbookingRepository.findById(Integer.valueOf(tcbookingID)).orElse(null);
    }

    public List<TCBooking> GetAllBooking() {

        return tcbookingRepository.findAll();
    }

    public void DeleteRequest(String tcbookingID){

        tcbookingRepository.deleteById(Integer.valueOf(tcbookingID));
    }

}
