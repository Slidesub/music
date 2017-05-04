package org.unicome.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.unicome.demo.dao.MusicRepository;
import org.unicome.demo.po.Music;
import org.unicome.demo.service.MusicService;

@Service
public class MusicServiceImpl implements MusicService{

	@Autowired
	MusicRepository musicRepo;

	@Override
	public List<Music> listMusic(int curPage, int pageSize) {
		Pageable pageable = new PageRequest(curPage - 1, pageSize);
		List<Music> musics = (List<Music>) musicRepo.listMusic(pageable);
		return musics;
	}

	@Override
	public Music getMusic(int id) {
		Music music = musicRepo.findOne(id);
		return music;
	}


}
