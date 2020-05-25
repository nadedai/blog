package com.hhtt.blog.pojo;


import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author hhtt
 * @date 2020/5/18 11:46
 * description:
 */
public class Type {
    private int id;

    @NotBlank(message = "类型不能为空")
    private String name;

    private List<Blog> blogs;

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

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
