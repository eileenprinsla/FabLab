package com.FabLab.FabLab.controller;

import com.FabLab.FabLab.entity.TCBooking;
import com.FabLab.FabLab.service.TCBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping
public class TCBookingController {

    @Autowired
    private TCBookingService tcbookingService;


    @PostMapping("/tcbook/request")
    public ResponseEntity<String> CreateRequest(@RequestBody TCBooking tcbooking){

        return ResponseEntity.ok("Booking was successfully created");
    }


    @GetMapping("/tcbook/read/{tcbookingID}")
    public ResponseEntity<TCBooking> ReadRequest(@PathVariable String tcbookingID){

        return ResponseEntity.ok(tcbookingService.ReadRequest(tcbookingID));
    }

    @GetMapping("/tcbook/read/all")
    public ResponseEntity<List<TCBooking>> ReadAllBooking(){

        List<TCBooking> tcbookingList = tcbookingService.GetAllBooking();
        return ResponseEntity.ok(tcbookingList);
    }

    @GetMapping("/tcbook/delete/{tcbookingID}")
    public ResponseEntity<String> DeleteRequest(@PathVariable String tcbookingID){

        tcbookingService.DeleteRequest(tcbookingID);
        return ResponseEntity.ok("TCBooking deleted successfully");
    }

}
