package org.unicome.demo.dao;


import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.unicome.demo.po.Share;

@Transactional
public interface ShareRepository extends PagingAndSortingRepository<Share, Integer> {


    @Query("select s from Share s where s.expiredDate is null and s.createDate between :startDate and :endDate")
    List<Share> findShareByCreateDate(@Param(value = "startDate") Date startDate, 
            @Param(value = "endDate") Date endDate,
            Pageable pageable);

    @Modifying
    @Query("update Share set up = up + 1 where id = ?")
    void updateUp(Integer id);

    @Query("select count(s) from Share s where s.expiredDate is null and s.createDate between :startDate and :endDate")
	int findCount(@Param(value = "startDate") Date startDate, 
            @Param(value = "endDate") Date endDate);
}
