package com.hhtt.blog.pojo;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import java.util.List;


/**
 * @author hhtt
 * @date 2020/5/18 10:49
 * description:
 */
public class Blog {
    private int id;
    private String title;
    private String content;
    private String firstPicture;
    private String introduction;
    private int watched;
    private String author;
    private Type type;
    private User user;
    private boolean state;
    private boolean canComment;
    private boolean canReprint;
    private boolean canAdmire;
    private boolean top;
    private List<Comment> commentList;

    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getWatched() {
        return watched;
    }

    public void setWatched(int watched) {
        this.watched = watched;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public Type getType() {
        return type;
    }

    public void setType(String type) {
        Type _type = new Type();
        _type.setName(type);
        this.type = _type;
    }

    public void setType(Type type) {
        this.type = type;
    }



    public Date getCreateDate() {
        return createDate;
    }


    public Date getUpdateDate() {
        return updateDate;
    }

    public boolean isCanComment() {
        return canComment;
    }

    public void setCanComment(boolean canComment) {
        this.canComment = canComment;
    }

    public boolean isCanReprint() {
        return canReprint;
    }

    public void setCanReprint(boolean canReprint) {
        this.canReprint = canReprint;
    }

    public boolean isCanAdmire() {
        return canAdmire;
    }

    public void setCanAdmire(boolean canAdmire) {
        this.canAdmire = canAdmire;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        Blog blog = (Blog)obj;
        return this.id == blog.getId();
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", introduction='" + introduction + '\'' +
                ", watched=" + watched +
                ", author='" + author + '\'' +
                ", type=" + type +
                ", state=" + state +
                ", canComment=" + canComment +
                ", canReprint=" + canReprint +
                ", canAdmire=" + canAdmire +
                ", top=" + top +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
