package org.unicome.demo.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;
import org.unicome.demo.po.User;
import org.unicome.demo.po.UserSheet;

@Transactional
public interface UserSheetRepository extends PagingAndSortingRepository<UserSheet, Integer> {

	@Query("select us from UserSheet us where us.expiredDate is null and us.user = ?")
	List<UserSheet> listUserSheet(User user, Pageable pageable);
}
