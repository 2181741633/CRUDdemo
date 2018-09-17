package net.s.anli2.common.entity;

import net.s.anli2.common.utils.DataUtil;

import java.io.Serializable;
import java.util.Date;

public class Clazz implements Serializable {
    private String id;
    private String name;
    private String teacher;
    private int count;
    private Date createTime;
    private String createTimeText;

    public String getCreateTimeText() {
        if (createTime != null){
            return DataUtil.formatData2String(createTime);
        }
        return null;
    }

    public Clazz() {
    }

    public Clazz(String id, String name, String teacher, int count, Date createTime) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.count = count;
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                ", count=" + count +
                '}';
    }
}
