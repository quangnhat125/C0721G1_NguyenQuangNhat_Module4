package com.codegym.blog.model;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String blogTitle;
    @Column(length = 500)
    private String bloghead;
    @Column(length = 5000)
    private String blogcontent;
    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    private Date date;

    public Blog() {
    }

    public Blog( String blogTitle, String bloghead, String blogcontent) {
        this.blogTitle = blogTitle;
        this.bloghead = bloghead;
        this.blogcontent = blogcontent;
    }

    public Blog(String blogTitle, String bloghead, String blogcontent, Category category, Date date) {
        this.blogTitle = blogTitle;
        this.bloghead = bloghead;
        this.blogcontent = blogcontent;
        this.category = category;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBloghead() {
        return bloghead;
    }

    public void setBloghead(String bloghead) {
        this.bloghead = bloghead;
    }

    public String getBlogcontent() {
        return blogcontent;
    }

    public void setBlogcontent(String blogcontent) {
        this.blogcontent = blogcontent;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
