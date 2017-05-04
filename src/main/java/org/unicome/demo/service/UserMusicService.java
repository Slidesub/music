package org.unicome.demo.service;

import java.util.List;

import org.unicome.demo.po.UserMusic;

public interface UserMusicService {

    public List<UserMusic> listUserMusic(int currentPage, int pageSize, int userId);

	int findCount(int userId);
}
