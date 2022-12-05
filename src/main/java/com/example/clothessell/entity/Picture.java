package com.example.clothessell.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "picture")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String uri;
    private int productId;

    public Picture(String name, String uri, int productId) {
        this.name = name;
        this.uri = uri;
        this.productId = productId;
    }
}
