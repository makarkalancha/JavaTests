package com.everything.json_utils.parent_child.test002;

//import com.fasterxml.jackson.databind.annotation.JsonDeserialize; !!!!


import org.codehaus.jackson.map.annotate.JsonDeserialize;

/**
 * Created by mcalancea
 * Date: 24 Apr 2018
 * Time: 12:06
 */
//@JsonDeserialize(using = ItemDeserialize.class)
public class Item2 {
    private /*final*/ int id;
    private /*final*/ String name;
    @JsonDeserialize(using = UserDeserialize.class)
//    @JsonIgnore
    private /*final*/ User2 user;

//    public Item2(int id, String name, User2 user) {
//        this.id = id;
//        this.name = name;
//        this.user = user;
//    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User2 getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(User2 user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Item2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}
