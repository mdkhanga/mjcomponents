package com.heavyduty.services.repository;

import com.heavyduty.services.entities.AccountId;
import com.heavyduty.services.entities.AccountsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountsRepository extends CrudRepository<AccountsEntity, Integer> {

    List<AccountsEntity> findAllByUserName(String username) ;


}
