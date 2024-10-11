package com.FabLab.FabLab.service;

import com.FabLab.FabLab.entity.Slot;
import com.FabLab.FabLab.exception.NotFoundException;
import com.FabLab.FabLab.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class SlotService {


    private final SlotRepository slotRepository;

    public SlotService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    public void CreateSlot(Slot slot) throws IOException {
        slotRepository.save(slot);
    }


    public Slot ReadSlot(int id) {
        return slotRepository.findById(id).orElseThrow(() -> new NotFoundException("Slot not found"));
    }

    public List<Slot> ReadAllSlots() {
        return slotRepository.findAll();
    }
}
