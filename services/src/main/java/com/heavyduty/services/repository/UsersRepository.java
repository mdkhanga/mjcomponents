package com.heavyduty.services.repository;

import com.heavyduty.services.entities.UsersEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UsersEntity, String> {
}
