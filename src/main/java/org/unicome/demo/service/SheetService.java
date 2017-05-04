package org.unicome.demo.service;

import java.util.List;

import org.unicome.demo.po.Sheet;

public interface SheetService {


	int getCountByUser(int userId);

	List<Sheet> listSheetByUser(int curPage, int pageSize, int userId);

}
