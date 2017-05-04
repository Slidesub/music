package org.unicome.demo.vo;

import java.io.Serializable;

import org.unicome.demo.po.Comment;
import org.unicome.demo.po.Share;

public class ShareVO implements Serializable{

    private static final long serialVersionUID = -58172745820492504L;
    private int id;
    private String nicknameOfUser;
    private int idOfUser;
    private String avatarOfUser;
    private int idOfMusic;
    private String nameOfMusic;
    private String srcOfMusic;
    private boolean isUpOfComment;
    private String description;
    private int up;
    
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNicknameOfUser() {
        return nicknameOfUser;
    }


    public void setNicknameOfUser(String nicknameOfUser) {
        this.nicknameOfUser = nicknameOfUser;
    }


    public int getIdOfUser() {
        return idOfUser;
    }


    public void setIdOfUser(int idOfUser) {
        this.idOfUser = idOfUser;
    }


    public String getAvatarOfUser() {
        return avatarOfUser;
    }


    public void setAvatarOfUser(String avatarOfUser) {
        this.avatarOfUser = avatarOfUser;
    }


    public int getIdOfMusic() {
        return idOfMusic;
    }


    public void setIdOfMusic(int idOfMusic) {
        this.idOfMusic = idOfMusic;
    }


    public String getNameOfMusic() {
        return nameOfMusic;
    }


    public void setNameOfMusic(String nameOfMusic) {
        this.nameOfMusic = nameOfMusic;
    }


    public String getSrcOfMusic() {
        return srcOfMusic;
    }


    public void setSrcOfMusic(String srcOfMusic) {
        this.srcOfMusic = srcOfMusic;
    }


    public boolean getIsUpOfComment() {
        return isUpOfComment;
    }


    public void setIsUpOfComment(boolean isUpOfComment) {
        this.isUpOfComment = isUpOfComment;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public int getUp() {
        return up;
    }


    public void setUp(int up) {
        this.up = up;
    }

    public ShareVO toShareVO(Share share) {
        if (null == share) {
            return null;
        }
        ShareVO vo = new ShareVO();
        vo.setId(share.getId());
        vo.setNicknameOfUser(share.getUser().getNickname());
        vo.setIdOfUser(share.getUser().getId());
        vo.setAvatarOfUser(share.getUser().getAvatar());
        vo.setIdOfMusic(share.getMusic().getId());
        vo.setNameOfMusic(share.getMusic().getName());
        vo.setSrcOfMusic(share.getMusic().getSrc());
        //vo.setIsUpOfComment(share.getComments().get(0).getIsUp());
        vo.setDescription(share.getDescription());
        return vo;
    }
}
