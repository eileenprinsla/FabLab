package com.FabLab.FabLab.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String email;

    private String regNo;

    private String password;

    private String role;

    private String year;

    private String contact;

    @OneToMany
    private List<Booking> bookings;

    @OneToMany
    private List<TCBooking> tcBookings;
}
