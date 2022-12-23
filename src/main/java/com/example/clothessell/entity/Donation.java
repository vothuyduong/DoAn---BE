package com.example.clothessell.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "donation")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String picture;

    private int quantity;

    private Timestamp takeTime;

    private String takeAddress;

    private int statu;

    private int idVolunteer;

    private int idCustomer;

    private Timestamp receivingTime;
}
