package com.everything.json_utils.parent_child.test001;

//import com.fasterxml.jackson.databind.annotation.JsonDeserialize; !!!!


/**
 * Created by mcalancea
 * Date: 24 Apr 2018
 * Time: 12:06
 */
public class Item1 {
    private int id;
    private String name;
    private User1 user;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User1 getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(User1 user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}
