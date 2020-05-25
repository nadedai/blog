package com.hhtt.blog.pojo;

/**
 * @author hhtt
 * @date 2020/5/22 20:50
 * description:
 */
public class Img {
    private Integer id;
    private String name;
    private String rowname;
    private String md5;

    public Img(){}
    public Img(Integer id, String name, String rowname, String md5) {
        this.id = id;
        this.name = name;
        this.rowname = rowname;
        this.md5 = md5;
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

    public String getRowName() {
        return rowname;
    }

    public void setRowName(String rowName) {
        this.rowname = rowName;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Override
    public String toString() {
        return "Img{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rowName='" + rowname + '\'' +
                ", md5='" + md5 + '\'' +
                '}';
    }
}
