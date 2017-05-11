package org.unicome.demo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.unicome.demo.dao.SheetRepository;
import org.unicome.demo.dao.UserRepository;
import org.unicome.demo.exception.ValidateException;
import org.unicome.demo.po.Sheet;
import org.unicome.demo.po.User;
import org.unicome.demo.service.SheetService;
import org.unicome.demo.vo.UserVO;

import net.sf.json.JSONObject;

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

	@Override
	public Sheet createSheet(String jsonString) throws ValidateException {
		JSONObject json = JSONObject.fromObject(jsonString);
		Map map = (Map) json;
		String userId = map.get("userId").toString().trim();
		String name = map.get("name").toString().trim();
		User user = userRepo.findOne(Integer.parseInt(userId));
		List<Sheet> sheets = sheetRepo.findByUserIdAndName(user, name);
		if (null != sheets && sheets.size() != 0) {
			throw new ValidateException();
		} else {
			Sheet sheet = new Sheet();
			sheet.setUser(user);
			sheet.setCount(0);
			sheet.setDescription(map.get("desc").toString().trim());
			sheet.setCreateDate(new Date());
			sheet.setUpdateDate(new Date());
			sheet.setName(name);
			Sheet sheetInDB = sheetRepo.save(sheet);
			return sheetInDB;
		}
		
	}
}