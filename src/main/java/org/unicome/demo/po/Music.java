package org.unicome.demo.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "music")
public class Music extends BaseEntity{

    private static final long serialVersionUID = 7942505199669538114L;

    @Column(name = "name", nullable = true)
    private String name;
    @Column(name = "src", nullable = true)
    private String src;
    @Column(name = "cover", nullable = true)
    private String cover;
    @Column(name = "description", nullable = true)
    private String description;
    @Column(name = "singer", nullable = true)
    private String singer;
    @Column(name = "time", nullable = true)
    private String time;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSrc() {
        return src;
    }
    public void setSrc(String src) {
        this.src = src;
    }
    public String getCover() {
        return cover;
    }
    public void setCover(String cover) {
        this.cover = cover;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getSinger() {
        return singer;
    }
    public void setSinger(String singer) {
        this.singer = singer;
    }
    public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
    public String toString() {
        return "Music [id=" + id + ", name=" + name + "]";
    }
}
