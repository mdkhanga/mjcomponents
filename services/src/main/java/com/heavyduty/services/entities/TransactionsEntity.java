package com.heavyduty.services.entities;

import com.heavyduty.services.api.Operation;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "transaction")
public class TransactionsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int transactionId;

    @Embedded
    private AccountId accountId;

    @Column(name = "amount")
    private float amount;

    @Column(name = "operation")
    private String operation;

    @CreationTimestamp
    @Column(name = "updated")
    private Timestamp updated  ;

    public TransactionsEntity(AccountId a, float f, Operation o) {
        accountId = a;
        amount = f;
        operation = o.name();
    }

    public long getTransactionId() {
        return transactionId;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public float getAmount() {
        return amount;
    }

    public Operation getOperation() {
        return Operation.valueOf(operation);
    }
}
