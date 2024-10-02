package com.FabLab.FabLab.controller;

import com.FabLab.FabLab.entity.Slot;
import com.FabLab.FabLab.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String uploadSlot(@RequestParam("slotName") String slotName,
                             @RequestParam("slotID") String slotID,
                             @RequestParam("image") MultipartFile image) throws IOException {
        slotService.CreateSlot(slotName, slotID, image);
        return "Slot uploaded successfully";
    }

    // API to get slot by ID
    @GetMapping("/slot/read/{id}")
    public Optional<Slot> getSlot(@PathVariable int id) {
        return slotService.GetSlot(id);
    }

    // API to delete slot by ID
    @DeleteMapping("/delete/{id}")
    public String deleteSlot(@PathVariable int id) {
        slotService.DeleteSlot(id);
        return "Slot deleted successfully";
    }
}
