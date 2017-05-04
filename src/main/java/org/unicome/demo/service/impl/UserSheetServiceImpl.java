package org.unicome.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.unicome.demo.dao.UserRepository;
import org.unicome.demo.dao.UserSheetRepository;
import org.unicome.demo.po.User;
import org.unicome.demo.po.UserSheet;
import org.unicome.demo.service.UserSheetService;

@Service
public class UserSheetServiceImpl implements UserSheetService {

    @Autowired
    private UserSheetRepository userSheetRepo;
    @Autowired
    private UserRepository userRepo;

    @Override
    public List<UserSheet> listUserSheet(int currentPage, int pageSize, int userId) {
    	User user = userRepo.findOne(userId);
        Sort sort = new Sort(Direction.ASC, "createDate");
        Pageable pageable = new PageRequest(currentPage - 1, pageSize, sort);
        List<UserSheet> userSheets = (List<UserSheet>) userSheetRepo.listUserSheet(user, pageable);
        return userSheets;
    }
}
