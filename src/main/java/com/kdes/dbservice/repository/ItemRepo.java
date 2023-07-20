package com.kdes.dbservice.repository;

import com.kdes.dbservice.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemRepo extends JpaRepository<Item, UUID> {

}
