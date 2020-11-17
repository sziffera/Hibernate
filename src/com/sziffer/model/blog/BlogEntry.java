package com.sziffer.model.blog;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Blogentry")
public class BlogEntry {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String longName;
    private Date blogEntryDate;

    @OneToMany(mappedBy = "blogEntry")
    private Set<BlogEntryComment> comments;

    public Set<BlogEntryComment> getComments() {
        return comments;
    }

    public void setComments(Set<BlogEntryComment> comments) {
        this.comments = comments;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public Date getBlogEntryDate() {
        return blogEntryDate;
    }

    public void setBlogEntryDate(Date blogEntryDate) {
        this.blogEntryDate = blogEntryDate;
    }
}
