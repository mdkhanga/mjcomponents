package com.heavyduty.services.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "transactions")
public class TransactionsEntity {

    @EmbeddedId
    private AccountId accountId;

    @Column(name = "amount")
    private float amount;

    @Column(name = "operation")
    private float operation;

    @Column(name = "updated")
    private Timestamp updated  ;
}
