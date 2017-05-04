package org.unicome.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.unicome.demo.dao.UserMusicRepository;
import org.unicome.demo.dao.UserRepository;
import org.unicome.demo.po.User;
import org.unicome.demo.po.UserMusic;
import org.unicome.demo.service.UserMusicService;

@Service
public class UserMusicServiceImpl implements UserMusicService {

    @Autowired
    private UserMusicRepository userMusicRepo;
    @Autowired
    private UserRepository userRepo;

    @Override
    public List<UserMusic> listUserMusic(int currentPage, int pageSize, int userId) {
    	User user = userRepo.findOne(userId);
        Sort sort = new Sort(Direction.ASC, "createDate");
        Pageable pageable = new PageRequest(currentPage - 1, pageSize, sort);
        List<UserMusic> userMusics = (List<UserMusic>) userMusicRepo.listUserMusic(user, pageable);
        return userMusics;
    }

    @Override
    public int findCount(int userId) {
    	User user = userRepo.findOne(userId);
    	int count = (int) userMusicRepo.findCount(user);
    	return count;
    }
}
