package org.unicome.demo.po;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_sheet")
public class UserSheet extends BaseEntity{

    private static final long serialVersionUID = 8401330539994501936L;

    @JoinColumn(name = "sheetc_id")
    @OneToMany
    private List<Sheet> sheets;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "UserSheet [sheets=" + sheets + ", user=" + user + "]";
    }
}
