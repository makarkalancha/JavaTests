package com.everything.json_utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mcalancea on 2016-04-07.
 */
public class TestClass {

    @S1erializedName("w-g-f-u-p-0.1")
    private boolean w_p_0_1;
    @S1erializedName("w-g-f-p")
    private List<LevelObject> w_p;
    @S1erializedName("w-g-f-u-c-0.1")
    private boolean w_c_0_1;
    @S1erializedName("w-g-f-c")
    private List<LevelObject> w_c;



    public void removeFiltersByColumnName(String columnName) {
        removeFiltersByColumnNameInLevel(w_p, columnName);
        removeFiltersByColumnNameInLevel(w_c, columnName);
    }

    public void removeFiltersByColumnNameInLevel(List<LevelObject> levelObjects, String columnName) {
//        if(levelObjects != null) {
            levelObjects.forEach(levelObject -> {
                    if(levelObject != null) {
                        levelObject.removeFiltersWithColumnName(columnName);
                    }
            });
//        }


//        if(levelObjects != null && levelObjects.size() > 0) {
//            for (LevelObject levelObject : levelObjects) {
//                levelObject.removeFiltersWithColumnName(columnName);
//            }
//        }
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "w_c=" + w_c +
                ", w_p_0_1=" + w_p_0_1 +
                ", w_p=" + w_p +
                ", w_c_0_1=" + w_c_0_1 +
                '}';
    }

    public static class LevelObject {
        private String name;
        private boolean isBestPractice;
        private boolean isNew;
        private List<Filter> filters;
        private Long applyOn;

        public void removeFiltersWithColumnName(String columnName) {
            List<Filter> newFilters = new ArrayList<>(filters);
            newFilters.removeIf(filter -> filter.columnId.equalsIgnoreCase(columnName));
            filters.clear();
            filters.addAll(newFilters);
        }

        @Override
        public String toString() {
            return "LevelObject{" +
                    "applyOn=" + applyOn +
                    ", name='" + name + '\'' +
                    ", isBestPractice=" + isBestPractice +
                    ", isNew=" + isNew +
                    ", filters=" + filters +
                    '}';
        }

        public static class Filter{
            private String columnId;
            private String operator;
            private Object value;
            private String valueType;

            @Override
            public String toString() {
                return "Filter{" +
                        "columnId='" + columnId + '\'' +
                        ", operator='" + operator + '\'' +
                        ", value=" + value +
                        '}';
            }
        }
    }
}
