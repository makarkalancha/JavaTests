package com.everything.json_utils.parent_child.test002;

/**
 * Created by mcalancea
 * Date: 24 Apr 2018
 * Time: 12:05
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class User2 {
    private final int id;
//    @JsonIgnore
    private final String name;

    public User2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

//    public void setName(String name) {
//        this.name = name;
//    }

    @Override
    public String toString() {
        return "User2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
