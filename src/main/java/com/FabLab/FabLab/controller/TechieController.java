package com.FabLab.FabLab.controller;

import com.FabLab.FabLab.dto.AppResponse;
import com.FabLab.FabLab.entity.Techie;
import com.FabLab.FabLab.entity.Users;
import com.FabLab.FabLab.service.BookingService;
import com.FabLab.FabLab.service.TechieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TechieController {

    private final TechieService techieService;
    private final BookingService bookingService;

    public TechieController(TechieService techieService, BookingService bookingService) {
        this.techieService = techieService;
        this.bookingService = bookingService;
    }


    @GetMapping("/techies/slots/{id}")
   public void readAssignedSlot(@PathVariable  int id){
       techieService.fetchAssignedSlots(id);
   }

    @PutMapping("admin/status/update")
    public ResponseEntity<AppResponse<String>> UpdateBookedSlotStatus(@RequestParam Integer id, @RequestBody String status){
        bookingService.updateBookedSlotStatus(id , status);
        AppResponse<String> response = new AppResponse<>(HttpStatus.OK.value(), "Status updated successfully");
        return ResponseEntity.ok(response);
    }
}
