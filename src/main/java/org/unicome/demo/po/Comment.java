package org.unicome.demo.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "up_comment")
public class Comment extends BaseEntity{

    private static final long serialVersionUID = -708838310815251890L;
    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;
    @JoinColumn(name = "share_id")
    @ManyToOne
    private Share share;
    
    @Column(name = "comment")
    private String comment;
    @Column(name = "is_up")
    private Boolean isUp;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Share getShare() {
        return share;
    }
    public void setShare(Share share) {
        this.share = share;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public Boolean getIsUp() {
        return isUp;
    }
    public void setIsUp(Boolean isUp) {
        this.isUp = isUp;
    }

    @Override
    public String toString() {
        return "Comment [user=" + user + ", share=" + share + "]";
    }

}
