package com.FabLab.FabLab.controller;

import com.FabLab.FabLab.entity.Booking;
import com.FabLab.FabLab.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping
public class BookingController {

    @Autowired
    private BookingService bookingService;


    @PostMapping("/book/request")
    public ResponseEntity<String> CreateRequest(
            @RequestParam("bookingID") String bookingID,
            @RequestParam("userID") String userID,
            @RequestParam("slotID") String slotID,
            @RequestParam("date") LocalDate date,
            @RequestParam("modelFile") MultipartFile modelFile,
            @RequestParam("description") String description,
            @RequestParam("deadline")  LocalDate deadline,
            @RequestParam("specification") String specification,
            @RequestParam("countFile") MultipartFile countFile
    ) throws IOException {

        Booking booking = new Booking();
        booking.setBookingID(bookingID);
        booking.setUserID(userID);
        booking.setSlotID(slotID);
        booking.setDate(date);
        booking.setModelFile(modelFile.getBytes());
        booking.setDescription(description);
        booking.setDeadline(deadline);
        booking.setSpecification(specification);
        booking.setCountFile(countFile.getBytes());

        bookingService.CreateRequest(booking);

        return ResponseEntity.ok("Booking was successfully created");
    }


    @GetMapping("/book/read/{bookingID}")
    public ResponseEntity<Booking> ReadRequest(@PathVariable String bookingID){

        return ResponseEntity.ok(bookingService.ReadRequest(bookingID));
    }

    @GetMapping("/book/read/all")
    public ResponseEntity<List<Booking>> ReadAllBooking(){

        List<Booking> bookingList = bookingService.GetAllBooking();
        return ResponseEntity.ok(bookingList);
    }

    @GetMapping("/book/delete/{bookingID}")
    public ResponseEntity<String> DeleteRequest(@PathVariable String bookingID){

        bookingService.DeleteRequest(bookingID);
        return ResponseEntity.ok("Booking deleted successfully");
    }

}
