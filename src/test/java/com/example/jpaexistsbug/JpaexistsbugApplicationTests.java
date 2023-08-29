package com.example.jpaexistsbug;

import com.example.jpaexistsbug.repository.FancyItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootTest
@EnableJpaRepositories
class JpaexistsbugApplicationTests {

	@Autowired
	FancyItemRepository fancyItemRepository;

	@Test
	void repositoryTestExistsJoinedInheritance() {
		// Fails when using Hibernate 6.2.3 or higher
		//
		// Generated SQL:
		//
		//   select f1_0.id from fancy_item f1_0
		//   left join owner o1_0 on o1_0.id=f1_0.owner_id
		//   where o1_0.alive and f1_0.serial_number=? and f1_1.field1=?
		//   fetch first ? rows only
		//
		// Expected SQL:
		//
		//   select f1_0.id from fancy_item f1_0
		//   inner join item f1_1 on f1_1.id=f1_0.id
		//   left join owner o1_0 on o1_0.id=f1_0.owner_id
		//   where o1_0.alive and f1_0.serial_number=? and f1_1.field1=?
		//   fetch first ? rows only
		//
		fancyItemRepository.existsByOwnerAliveIsTrueAndSerialNumberAndField1(4, "2");
	}

}
