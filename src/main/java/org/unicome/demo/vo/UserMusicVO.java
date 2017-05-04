package org.unicome.demo.vo;

import org.unicome.demo.po.UserMusic;

public class UserMusicVO {

    private int id;
    private int userId;
    private int musicId;
    private String userName;
    private String musicName;
    private String musicSrc;
    private String musicSinger;
    private String musicTime;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMusicId() {
		return musicId;
	}
	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}
	public String getMusicSrc() {
		return musicSrc;
	}
	public void setMusicSrc(String musicSrc) {
		this.musicSrc = musicSrc;
	}
	public String getMusicSinger() {
		return musicSinger;
	}
	public void setMusicSinger(String musicSinger) {
		this.musicSinger = musicSinger;
	}
	public String getMusicTime() {
		return musicTime;
	}
	public void setMusicTime(String musicTime) {
		this.musicTime = musicTime;
	}

	public static UserMusicVO toUserMusicVO(UserMusic userMusic) {
        if (null == userMusic) {
            return null;
        }
        UserMusicVO userMusicVO = new UserMusicVO();
        userMusicVO.setId(userMusic.getId());
        userMusicVO.setUserId(userMusic.getUser().getId());
        userMusicVO.setUserId(userMusic.getUser().getId());
        userMusicVO.setUserName(userMusic.getUser().getName());
        return userMusicVO;
    }
}
