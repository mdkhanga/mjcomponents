package com.heavyduty.services.entities;

import javax.persistence.*;

@Entity
@Table(name = "monthly")
public class MBalanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;

    @Column(name = "username")
    private String userName;

    @OneToOne(cascade = CascadeType.ALL)
    private AccountsEntity account;
}
