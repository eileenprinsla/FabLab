package com.FabLab.FabLab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
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
    private int Id;

    private String name;

    private String email;

    private String regNo;

    private LocalDate date;

    @Lob
    private String purpose;

    private LocalDate slotDate;

//    @NotNull
    private LocalTime startTime;

//    @NotNull
//    @Max(value = 18 * 60 + 30, message = "End time cannot exceed 18:30")
    private LocalTime endTime;

    private int memberCount;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;
}




