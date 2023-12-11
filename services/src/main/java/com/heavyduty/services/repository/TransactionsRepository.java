package com.heavyduty.services.repository;

import com.heavyduty.services.entities.AccountId;
import com.heavyduty.services.entities.AccountsEntity;
import com.heavyduty.services.entities.TransactionsEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransactionsRepository extends CrudRepository<TransactionsEntity, Long> {


}
