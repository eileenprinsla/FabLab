package com.FabLab.FabLab.controller;

import com.FabLab.FabLab.dto.AppResponse;
import com.FabLab.FabLab.entity.Booking;
import com.FabLab.FabLab.entity.Slot;
import com.FabLab.FabLab.entity.Techie;
import com.FabLab.FabLab.entity.Users;
import com.FabLab.FabLab.service.AdminService;
import com.FabLab.FabLab.service.BookingService;
import com.FabLab.FabLab.service.SlotService;
import com.FabLab.FabLab.service.TechieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RestController
public class AdminController {

    private final AdminService adminService;
    private final SlotService slotService;
    private final BookingService bookingService;


    public AdminController(AdminService adminService, SlotService slotService, BookingService bookingService) {
        this.adminService = adminService;
        this.slotService = slotService;
        this.bookingService = bookingService;
    }

    @GetMapping("/admins/users")
    public ResponseEntity<AppResponse<?>> getUsers(@RequestParam(required = false) Integer id){
        if (id == null) {
            // If id is null, fetch all booked slots
            var user = adminService.getUser();
            AppResponse<List<Users>> responseData = new AppResponse<>(HttpStatus.OK.value(), user);
            return ResponseEntity.ok(responseData);
        } else {
            // If id is provided, fetch the specific booked slot
           var user =  adminService.getUserById(id);
            AppResponse<Users> responseData = new AppResponse<>(HttpStatus.OK.value(), user);
            return ResponseEntity.ok(responseData);
        }
    }


    @GetMapping("/admins/techies")
    public ResponseEntity<AppResponse<?>> getTechies(@RequestParam(required = false)Integer id){
        if (id == null) {
            // If id is null, fetch all booked slots
            var techies = adminService.getTechie();
            AppResponse<List<Techie>> responseData = new AppResponse<>(HttpStatus.OK.value(), techies);
            return ResponseEntity.ok(responseData);
        } else {
            // If id is provided, fetch the specific booked slot
            var techie = adminService.getTechieById(id);
            AppResponse<Techie> responseData = new AppResponse<>(HttpStatus.OK.value(), techie);
            return ResponseEntity.ok(responseData);
        }
    }

    @PostMapping("/slot/create")
    public ResponseEntity<AppResponse<String>> UploadSlot(@RequestBody Slot slot) throws IOException {
        slotService.CreateSlot(slot);
        AppResponse<String> response = new AppResponse<>(HttpStatus.OK.value(), "Slot uploaded successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/admins/slot/booked")
    public ResponseEntity<AppResponse<?>> getBookedSlot(@RequestParam(required = false) Integer bookedId){

        if (bookedId == null) {
            // If id is null, fetch all booked slots
            var bookings = adminService.getAllBookedSlot();
            AppResponse<List<Booking>> response = new AppResponse<>(HttpStatus.OK.value(), bookings);
            return ResponseEntity.ok(response);
        } else {
            // If id is provided, fetch the specific booked slot
            var booking = adminService.getBookedSlotById(bookedId);
            AppResponse<Booking> response = new AppResponse<>(HttpStatus.OK.value(), booking);
            return ResponseEntity.ok(response);
        }
    }

    @PutMapping("/admin/status/update")
    public ResponseEntity<AppResponse<String>> UpdateBookedSlotStatus(@RequestParam Integer id, @RequestBody String status){
        bookingService.updateBookedSlotStatus(id , status);
        AppResponse<String> response = new AppResponse<>(HttpStatus.OK.value(), "Status updated successfully");
        return ResponseEntity.ok(response);
    }

}
