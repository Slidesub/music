package org.unicome.demo.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Share")
public class Share extends BaseEntity{

	private static final long serialVersionUID = -3544179316348444203L;
	@JoinColumn(name="user_id")
	@ManyToOne
	private User user;
	@JoinColumn(name="music_id")
	@ManyToOne
	private Music music;
	@Column(name="description")
	private String description;
	@Column(name="up")
	private Integer up;
//	@JoinColumn(name="upComment_id")
//	@OneToMany
//	List<Comment> comments;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Music getMusic() {
		return music;
	}
	public void setMusic(Music music) {
		this.music = music;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getUp() {
		return up;
	}
	public void setUp(Integer up) {
		this.up = up;
	}
//	public List<Comment> getComments() {
//		return comments;
//	}
//	public void setComments(List<Comment> comments) {
//		this.comments = comments;
//	}
	@Override
	public String toString() {
		return "Share [user=" + user + ", music=" + music + "]";
	}
}
