package com.FabLab.FabLab.controller;

import com.FabLab.FabLab.entity.Slot;
import com.FabLab.FabLab.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping
public class SlotController {

    @Autowired
    private SlotService slotService;

    @PostMapping("/slot/create")
    public ResponseEntity<String> UploadSlot(@RequestParam("slotName") String slotName,
                                     @RequestParam("slotID") String slotID,
                                     @RequestParam("image") MultipartFile image) throws IOException {
        slotService.CreateSlot(slotName, slotID, image);
        return ResponseEntity.ok("Slot uploaded successfully");
    }


    @GetMapping("/slot/read/{id}")
    public ResponseEntity<Optional<Slot>> ReadSlot(@PathVariable int id) {

        return ResponseEntity.ok(slotService.ReadSlot(id));
    }


    @DeleteMapping("/slot/delete/{id}")
    public ResponseEntity<String> DeleteSlot(@PathVariable int id) {
        slotService.DeleteSlot(id);
        return ResponseEntity.ok("Slot deleted successfully");
    }
}
