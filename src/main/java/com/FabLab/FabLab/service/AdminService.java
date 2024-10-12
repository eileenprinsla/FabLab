package com.FabLab.FabLab.service;


import com.FabLab.FabLab.entity.Admin;
import com.FabLab.FabLab.entity.Booking;
import com.FabLab.FabLab.entity.Techie;
import com.FabLab.FabLab.entity.Users;
import com.FabLab.FabLab.exception.NotFoundException;
import com.FabLab.FabLab.repository.AdminRepository;
import com.FabLab.FabLab.repository.BookingRepository;
import com.FabLab.FabLab.repository.TechieRepository;
import com.FabLab.FabLab.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final TechieRepository techieRepository;
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;

    public AdminService(AdminRepository adminRepository, TechieRepository techieRepository, UserRepository userRepository, BookingRepository bookingRepository) {
        this.adminRepository = adminRepository;
        this.techieRepository = techieRepository;
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
    }

    public Admin CreateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public String LoginAdmin(String email, String password) {
         adminRepository.findByEmail(email);
        return "Invalid password";
    }

    public List<Techie> getTechie(){
        return techieRepository.findByIsActiveTrue();
    }

    public Techie getTechieById(int id){
        return techieRepository.findByIdAndIsActiveTrue(id)
                .orElseThrow(() -> new NotFoundException("Techie not found or inactive")); // Fetch active techie by id
    }


    public List<Users> getUser(){
        return userRepository.findAll();
    }


    public Users getUserById(int id){
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
    }

    public List<Booking> getAllBookedSlot(){
       return bookingRepository.findAll();
    }

    public Booking getBookedSlotById(int id){
        return  bookingRepository.findById(id).orElseThrow(() -> new NotFoundException("Booked slot not found"));

    }

    public void MapBookedSlotToTechie(int bookingId) {

    }

}


