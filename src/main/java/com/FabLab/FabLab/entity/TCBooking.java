package com.FabLab.FabLab.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TCBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tcbookingID;

    private String userID;

    private String slotID;

    private LocalDate date;

    @Lob
    private String purpose;

    private LocalDate slotDate;

    private LocalTime startTime;

    private LocalTime endTime;

    private int memberCount;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "bookingID")
    private List<TCuser> TCTeam;
}




