package com.FabLab.FabLab.entity;

import com.FabLab.FabLab.entity.enu.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String BookingId;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Lob
    private byte[] modelFile;

    @Lob
    private String description;

    private LocalDate deadline;

    @Lob
    private String specification;

    @Lob
    private byte[] countFile;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @OneToOne
    private Slot slot;
}



