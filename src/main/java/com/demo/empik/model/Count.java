package com.demo.empik.model;


import jakarta.persistence.*;

@Entity
@Table(name = "count")
public class Count {


    @Column
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idcount;
    @Column
    private String login;
    @Column
    private Integer requestedCount;
}
