package org.unicome.demo.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.unicome.demo.po.Sheet;
import org.unicome.demo.po.SheetMusic;

public interface SheetMusicRepository extends PagingAndSortingRepository<SheetMusic, Integer>{

    @Query("select sm from SheetMusic sm where sm.expiredDate is null and sm.sheet = ?")
    List<SheetMusic> listSheetMusicBySheet(Sheet sheet, Pageable pageable);

    @Query("select count(sm) from SheetMusic sm where sm.expiredDate is null and sm.sheet = ?")
    int getCountBySheet(Sheet sheet);
}