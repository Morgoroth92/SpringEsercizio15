package com.example.SpringEsercizio15.Entities;

import jakarta.persistence.*;
import lombok.*;

@Table
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    private long id;
    private String description;
    private String fromAirport;
    private String toAirport;
    @Enumerated(EnumType.STRING)
    private FlighStatus status;
}