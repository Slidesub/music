package org.unicome.demo.service;

import java.util.List;

import org.unicome.demo.po.Music;

public interface MusicService {

	public List<Music> listMusic(int curSize, int pageSize);
	
	public Music getMusic(int id);
}
