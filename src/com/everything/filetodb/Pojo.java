package com.everything.filetodb;

import java.sql.Timestamp;

/**
 * User: Makar Kalancha
 * Date: 17/06/14
 * Time: 3:07 PM
 */
public class Pojo {
    public String targettype;
    public int targetid;
    public String foreignid;
    public int r_visited;
    public int r_shortlisted;
    public boolean deleted;
    public Timestamp created;
    public Timestamp updated;
}
