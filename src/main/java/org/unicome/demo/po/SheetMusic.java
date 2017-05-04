package org.unicome.demo.po;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sheet_music")
public class SheetMusic extends BaseEntity{

    private static final long serialVersionUID = 8401330539994501936L;

//    @JoinColumn(name = "sheet_id")
//    @OneToMany
//    private List<Music> musics;
//
//    @ManyToOne
//    @JoinColumn(name = "sheet_id")
//    private Sheet sheet;
//
//    public List<Music> getMusics() {
//		return musics;
//	}
//
//	public void setMusics(List<Music> musics) {
//		this.musics = musics;
//	}
    @OneToOne
    @JoinColumn(name = "sheet_id")
    private Sheet sheet;

    @OneToOne
    @JoinColumn(name = "music_id")
    private Music music;

    public Music getMusic() {
		return music;
	}

	public void setMusics(Music music) {
		this.music = music;
	}

	public Sheet getSheet() {
		return sheet;
	}

	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}

	@Override
    public String toString() {
        return "SheetMusic [music=" + music + ", sheet=" + sheet + "]";
    }
}
