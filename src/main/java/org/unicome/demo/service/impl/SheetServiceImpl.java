package org.unicome.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.unicome.demo.dao.SheetRepository;
import org.unicome.demo.dao.UserRepository;
import org.unicome.demo.po.Sheet;
import org.unicome.demo.po.User;
import org.unicome.demo.service.SheetService;

@Service
public class SheetServiceImpl implements SheetService{

    @Autowired
    private SheetRepository sheetRepo;
    @Autowired
    private UserRepository userRepo;
    @Override
    public List<Sheet> listSheetByUser(int curPage, int pageSize, int userId) {
    	User user = userRepo.findOne(userId);
        Sort sort = new Sort(Direction.ASC, "createDate");
        Pageable pageable = new PageRequest(curPage - 1, pageSize, sort);
        List<Sheet> sheets = (List<Sheet>) sheetRepo.listSheetByUser(user, pageable);
        return sheets;
    }

	@Override
	public int getCountByUser(int userId) {
		User user = userRepo.findOne(userId);
		int count = (int) sheetRepo.getCountByUser(user);
		return count;
	}
}