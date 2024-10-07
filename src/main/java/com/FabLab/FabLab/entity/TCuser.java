package com.FabLab.FabLab.entity;

import jakarta.persistence.*;

@Entity
public class TCuser{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String email;

    private String regNo;

    @ManyToOne
    @JoinColumn(name = "tcbookingID", nullable = false)
    private TCBooking tcBooking;
}
