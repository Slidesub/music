package org.unicome.demo.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import org.unicome.demo.po.Music;

@Transactional
public interface MusicRepository extends CrudRepository<Music, Integer> {

    @Query("select m from Music m where m.expiredDate is null")
    List<Music> listMusic(Pageable pageable);

}
