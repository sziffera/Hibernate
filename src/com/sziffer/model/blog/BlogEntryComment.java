package com.sziffer.model.blog;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Blogentrycomment")
public class BlogEntryComment {

    @Id
    @GeneratedValue
    private int id;
    private String commentText;
    private Date commentDate;

    @ManyToOne
    @JoinColumn(name = "blog_entry_id", nullable = false)
    private BlogEntry blogEntry;

    public BlogEntry getBlogEntry() {
        return blogEntry;
    }

    public void setBlogEntry(BlogEntry blogEntry) {
        this.blogEntry = blogEntry;
    }

    public BlogEntryComment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
}
