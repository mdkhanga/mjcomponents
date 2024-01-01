package com.heavyduty.services.repository;

import com.heavyduty.services.entities.AccountId;
import com.heavyduty.services.entities.AccountsEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountsRepository extends CrudRepository<AccountsEntity, Integer> {


}
