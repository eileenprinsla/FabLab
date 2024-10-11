package com.FabLab.FabLab.controller;

import com.FabLab.FabLab.dto.AppResponse;
import com.FabLab.FabLab.entity.Booking;
import com.FabLab.FabLab.entity.Slot;
import com.FabLab.FabLab.entity.TCBooking;
import com.FabLab.FabLab.entity.Users;
import com.FabLab.FabLab.service.BookingService;
import com.FabLab.FabLab.service.SlotService;
import com.FabLab.FabLab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping
public class UserController {

    private final UserService userService;
    private final BookingService bookingService;
    private final SlotService slotService;

    public UserController(UserService userService, BookingService bookingService, SlotService slotService) {
        this.userService = userService;
        this.bookingService = bookingService;
        this.slotService = slotService;
    }

    @GetMapping("/user/read/{id}")
    public ResponseEntity<Users> readUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.GetUser(id));
    }

    @PostMapping("/users/slot/book")
    public void bookSlot(@RequestBody Booking booking){
        bookingService.CreateRequest(booking);
    }

    @PostMapping("/users/tc/book")
    public void bookTC(@RequestBody TCBooking  tcBooking){

    }
    @GetMapping("/users/slot/read/{userId}")
    public ResponseEntity<AppResponse<List<Slot>>>  readBookedSlot(@PathVariable int userId){
     var slots = bookingService.readBookedSlotByUserId(userId);
        AppResponse<List<Slot>> response = new AppResponse<>(HttpStatus.OK.value(), slots);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<AppResponse<List<Slot>>> readAllSlot(){
        var response =  slotService.ReadAllSlots();
        AppResponse<List<Slot>> responseData = new AppResponse<>(HttpStatus.OK.value(), response);
        return ResponseEntity.ok(responseData);
    }

}
