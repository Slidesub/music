package org.unicome.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import org.unicome.demo.po.User;

@Transactional
public interface UserRepository extends CrudRepository<User, Integer>{

	@Query("select u from User u where u.expiredDate is null and u.phone = ?")
	User findByPhone(String phone);
}
