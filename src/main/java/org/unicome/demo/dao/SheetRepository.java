package org.unicome.demo.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import org.unicome.demo.po.Sheet;
import org.unicome.demo.po.User;

@Transactional
public interface SheetRepository extends CrudRepository<Sheet, Integer>{

    @Query("SELECT s from Sheet s where s.expiredDate is null and s.user = ?")
    List<Sheet> listSheetByUser(User user, Pageable pageable);

    @Query("SELECT count(s) from Sheet s where s.expiredDate is null and s.user = ?")
    int getCountByUser(User user);
}
