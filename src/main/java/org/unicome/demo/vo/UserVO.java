package org.unicome.demo.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.unicome.demo.po.User;

public class UserVO implements Serializable {

    private static final long serialVersionUID = -7617337064212151619L;

    private int id;
    private String username;
    private String nickname;
    private String avatar;
    private String phone;
    private String school;
    private String gender;
    private String address;
    private String email;
    private String note;
    private List<UserVO> followeds;
    private Date birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<UserVO> getFolloweds() {
        return followeds;
    }

    public void setFolloweds(List<UserVO> followeds) {
        this.followeds = followeds;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public static UserVO toUserVO(User user) {
        if (null == user) {
            return null;
        }
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());
        userVO.setUsername(user.getName());
        userVO.setNickname(user.getNickname());
        userVO.setAvatar(user.getAvatar());
        userVO.setPhone(user.getPhone());
        userVO.setSchool(user.getSchool());
        userVO.setGender(user.getGender());
        userVO.setAddress(user.getAddress());
        userVO.setEmail(user.getEmail());
        userVO.setNote(user.getNote());
        userVO.setFolloweds(toUserVOList(user.getFolloweds()));
        userVO.setBirthday(user.getBirthday());
        return userVO;
    }

    public static List<UserVO> toUserVOList(List<User> userList) {
        if (null == userList || userList.size() == 0) {
            return null;
        }
        List<UserVO> userVOList = new ArrayList<UserVO>();
        for (User user: userList) {
            userVOList.add(toUserVO(user));
        }
        return userVOList;
    }
}
