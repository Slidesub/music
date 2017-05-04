package org.unicome.demo.service;

import java.util.List;

import org.unicome.demo.po.SheetMusic;

public interface SheetMusicService {

	public List<SheetMusic> listSheetMusicBySheet(int currentPage, int pageSize, int sheetId);

	public int getCountBySheet(int sheetId);
}
