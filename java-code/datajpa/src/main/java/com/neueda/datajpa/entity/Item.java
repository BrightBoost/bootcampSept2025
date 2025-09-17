package com.neueda.datajpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data //Getters and Setters
@ToString
@Entity
//@Table(name="item_table")
public class Item {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment
//    @Column(name="item_id")
    private Long id;
    private String name;
    private double price;


}
