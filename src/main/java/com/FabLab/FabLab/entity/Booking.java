package com.FabLab.FabLab.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String bookingID;

    private String userID;

    private String slotID;

    private LocalDate date;

    @Lob
    private byte[] modelFile;

    @Lob
    private String description;

    private LocalDate deadline;

    @Lob
    private String specification;

    @Lob
    private byte[] countFile;
}



