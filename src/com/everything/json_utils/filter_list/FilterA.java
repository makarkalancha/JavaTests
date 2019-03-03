package com.everything.json_utils.filter_list;

/**
 * User: Makar Kalancha
 * Date: 07/10/2017
 * Time: 14:06
 */
public class FilterA implements Filter{
    private final String name;
    private final String criterion;

    public FilterA(String name, String criterion) {
        this.name = name;
        this.criterion = criterion;
    }

    @Override
    public void filter() {
        System.out.println("name:" + name + "; criterion:" + criterion);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCriterion() {
        return criterion;
    }

    @Override
    public String toString() {
        return "FilterA{" +
                "name='" + name + '\'' +
                ", criterion='" + criterion + '\'' +
                '}';
    }
}
