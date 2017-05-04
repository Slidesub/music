package org.unicome.demo.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sheet")
public class Sheet extends BaseEntity {

    private static final long serialVersionUID = -8512668791485453662L;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @Column(name = "description")
    private String description;
    
    @Column(name = "src")
    private String src;
    
    @Column(name = "count")
    private String count;

    public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getSrc() {
		return src;
	}


	public void setSrc(String src) {
		this.src = src;
	}

	@Override
    public String toString() {
        return "Sheet [name=" + name + ", user=" + user + ", description=" + description + "]";
    }
}
