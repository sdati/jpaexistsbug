package com.example.jpaexistsbug.repository;

import com.example.jpaexistsbug.model.FancyItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FancyItemRepository extends JpaRepository<FancyItem, Long> {

	boolean existsByOwnerAliveIsTrueAndSerialNumberAndField1(Integer serialNumber, String field1);

	FancyItem findFirstByOwnerAliveIsTrueAndSerialNumberAndField1(Integer serialNumber, String field1);
}
