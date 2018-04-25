package com.everything.json_utils.parent_child.test001;

/**
 * Created by mcalancea
 * Date: 24 Apr 2018
 * Time: 12:05
 */
public class User1 {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
