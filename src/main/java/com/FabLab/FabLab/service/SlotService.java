package com.FabLab.FabLab.service;

import com.FabLab.FabLab.entity.Slot;
import com.FabLab.FabLab.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class SlotService {

    @Autowired
    private SlotRepository slotRepository;


    public void CreateSlot(String slotName, String slotID, MultipartFile image) throws IOException {
        Slot slot = new Slot();
        slot.setSlotName(slotName);
        slot.setSlotID(slotID);
        slot.setImage(image.getBytes());
        slotRepository.save(slot);
    }


    public Optional<Slot> ReadSlot(int id) {

        return slotRepository.findById(id);
    }


    public void DeleteSlot(int id) {

        slotRepository.deleteById(id);
    }
}
