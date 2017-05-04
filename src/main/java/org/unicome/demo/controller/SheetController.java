package org.unicome.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.unicome.demo.po.Sheet;
import org.unicome.demo.service.SheetService;

@RestController
@RequestMapping("/sheet")
public class SheetController {

	@Autowired
	private SheetService sheetService;

	@RequestMapping("/listSheet")
	@ResponseBody
	public List<Sheet> listSheet(
			@RequestParam(name="currentPage", defaultValue = "1") int currentPage,
            @RequestParam(name="pageSize", defaultValue = "10") int pageSize,
            @RequestParam(name="userId", defaultValue = "") int userId) {
		List<Sheet> sheets = sheetService.listSheetByUser(currentPage, pageSize, userId);
		return sheets;
	}
}
