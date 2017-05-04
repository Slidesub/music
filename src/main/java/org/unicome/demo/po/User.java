package org.unicome.demo.po;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user")
public class User extends BaseEntity{

    private static final long serialVersionUID = -239231458004547747L;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "password", nullable = true)
    private String password;

    @Column(name = "nickname", nullable = true)
    private String nickname;

    @Column(name = "phone", nullable = true)
    private String phone;

    @Column(name = "avatar", nullable = true)
    private String avatar;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday", nullable = true)
    private Date birthday;

    @Column(name = "background", nullable = true)
    private String background;

    @Column(name = "gender", nullable = true)
    private String gender;

    @Column(name = "school", nullable = true)
    private String school;

    @Column(name = "note", nullable = true)
    private String note;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "email", nullable = true)
    private String email;

//    @JoinTable(name = "friend")
//    @Column(name = "user_id1", nullable = true)
//    @OneToMany
//    private List<User> followers;

//    @JoinTable(name = "friend")
//    @OneToMany(mappedBy = "friend", targetEntity = User.class)
//    @Column(name = "followed_id", nullable = false)
    @OneToMany()
    @JoinTable(name="friend", 
    	joinColumns={@JoinColumn(name="follower_id", referencedColumnName="id")},
    	inverseJoinColumns={@JoinColumn(name="followed_id", referencedColumnName="id")})
    private List<User> followeds;

//    @OneToMany()
//    @JoinTable(name="share", 
//    	joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
//    	inverseJoinColumns={@JoinColumn(name="music_id", referencedColumnName="id")})
//    private List<Music> shares;

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    @Override
    public String toString() {
        return "User [id=" + this.id + "]";
    }

//    public List<User> getFollowers() {
//        return followers;
//    }
//
//    public void setFollowers(List<User> followers) {
//        this.followers = followers;
//    }

    public List<User> getFolloweds() {
        return followeds;
    }

    public void setFolloweds(List<User> followeds) {
        this.followeds = followeds;
    }
//    public List<Music> getShares() {
//		return shares;
//	}
//
//	public void setShares(List<Music> shares) {
//		this.shares = shares;
//	}
}
