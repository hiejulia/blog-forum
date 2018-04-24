package com.project.blogforum.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.elasticsearch.annotations.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "post")
@EntityListeners(AuditingEntityListener.class)
@XmlRootElement(name="post")
@XmlAccessorType(XmlAccessType.PROPERTY)
@JsonIgnoreProperties({"createdAt","date"})
public class Post implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @NotEmpty
    @Field(type = FieldType.String)
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "content")
    private String content;

    @Column(name = "summary")
    private String summany;

    @Column(name = "date", length = 50)
    private String date;


    // join author = user
    @Column(name = "author", length = 50)
    @CreatedBy
    private String author;

    @Field(type = FieldType.String)
    @Column(name = "category")
    private String category;

    @Column(name = "createdAt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @CreatedDate
    private Date createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
    private Date lastModifiedDate;



    // Post created date



    // Post updated date

    // comment
    @OneToMany
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    @OrderBy
    @Size(min=1, max = 10)
    private List<Comment> commentList;

    @OneToMany
    @JoinColumn(name = "post_id",referencedColumnName = "id")
//    @ManyToMany(cascade=CascadeType.ALL)
//    @JoinTable(name="blogpost_tag", joinColumns={@JoinColumn(name="tag_id")},
//            inverseJoinColumns={@JoinColumn(name="blogpost_id")})
    private List<Tag> tagList;

    public Post() {
    }

    public Post(String title, String subtitle, String content, String date, String author) {
        this.title = title;
        this.subtitle = subtitle;
        this.content = content;
        this.date = date;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) &&
                Objects.equals(title, post.title) &&
                Objects.equals(subtitle, post.subtitle) &&
                Objects.equals(content, post.content) &&
                Objects.equals(date, post.date) &&
                Objects.equals(author, post.author) &&
                Objects.equals(commentList, post.commentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, subtitle, content, date, author, commentList);
    }

    @Override
    public String toString() {
        return "Post{" +
                "commentList=" + commentList +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", title='" + title + '\'' +
                ", id=" + id +
                '}';
    }
}
