package org.unicome.demo.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;
import org.unicome.demo.po.User;
import org.unicome.demo.po.UserMusic;

@Transactional
public interface UserMusicRepository extends PagingAndSortingRepository<UserMusic, Integer> {

	@Query("select um from UserMusic um where um.expiredDate is null and um.user = ?")
	List<UserMusic> listUserMusic(User user, Pageable pageable);

	@Query("select count(um) from UserMusic um where um.expiredDate is null and um.user = ?")
	int findCount(User user);
}
