package org.unicome.demo.service;

import java.util.List;

import org.unicome.demo.exception.ValidateException;
import org.unicome.demo.po.Sheet;

public interface SheetService {

	public int getCountByUser(int userId);

	public List<Sheet> listSheetByUser(int curPage, int pageSize, int userId);

	public Sheet createSheet(String jsonString) throws ValidateException;

}
