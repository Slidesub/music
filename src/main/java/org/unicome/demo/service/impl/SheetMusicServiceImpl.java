package org.unicome.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.unicome.demo.dao.SheetMusicRepository;
import org.unicome.demo.dao.SheetRepository;
import org.unicome.demo.po.Sheet;
import org.unicome.demo.po.SheetMusic;
import org.unicome.demo.service.SheetMusicService;

@Service
public class SheetMusicServiceImpl implements SheetMusicService{

	@Autowired
	private SheetRepository sheetRepo;
	@Autowired
	private SheetMusicRepository sheetMusicRepo;

	@Override
	public List<SheetMusic> listSheetMusicBySheet(int currentPage, int pageSize, int sheetId) {
        Sheet sheet = sheetRepo.findOne(sheetId);
        Sort sort = new Sort(Direction.ASC, "createDate");
        Pageable pageable = new PageRequest(currentPage - 1, pageSize, sort);
        List<SheetMusic> sheetMusics = (List<SheetMusic>) sheetMusicRepo.listSheetMusicBySheet(sheet, pageable);
        return sheetMusics;
	}

	@Override
	public int getCountBySheet(int sheetId) {
		Sheet sheet = sheetRepo.findOne(sheetId);
		int count = (int)sheetMusicRepo.getCountBySheet(sheet);
		return count;
	}
}