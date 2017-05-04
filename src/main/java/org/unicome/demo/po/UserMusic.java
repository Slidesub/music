package org.unicome.demo.po;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_music")
public class UserMusic extends BaseEntity{

    private static final long serialVersionUID = 8401330539994501936L;

    //@OneToMany(targetEntity=org.unicome.demo.po.Music.class, cascade=CascadeType.ALL, mappedBy="userMusic")

//    @OneToMany(cascade={CascadeType.ALL})
//    @JoinTable(name="ref_customer_address",
//      joinColumns={@JoinColumn(name="customer_id", referencedColumnName="id")},
//      inverseJoinColumns={@JoinColumn(name="address_id",referencedColumnName="id")}
//   )
//    @OneToMany(targetEntity=org.unicome.demo.po.Music.class, cascade=CascadeType.ALL, mappedBy="id")
//    private List<Music> musics;

    @OneToOne
    @JoinColumn(name = "music_id")
    private Music music;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


//    public List<Music> getMusics() {
//		return musics;
//	}
//
//	public void setMusics(List<Music> musics) {
//		this.musics = musics;
//	}

	public User getUser() {
		return user;
	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
    public String toString() {
        return "UserMusic [music=" + music + ", user=" + user + "]";
    }
}
