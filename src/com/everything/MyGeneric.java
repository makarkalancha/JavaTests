package com.everything;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Makar Kalancha
 * Date: 02/04/14
 * Time: 11:33 AM
 */
public class MyGeneric {
    public static void main(String[] args) {
        CategoryOne cOne1 = new CategoryOne("a", "letter a", "domain");
        CategoryOne cOne2 = new CategoryOne("b", "letter b", "domain");
        CategoryOne cOne3 = new CategoryOne("c", "letter c", "domain");
        CategoryOne[] arrCatOne = new CategoryOne[]{cOne1,cOne2,cOne3};
        CategoryTwo cTwo1 = new CategoryTwo("x", "letter x", "niamod");
        CategoryTwo cTwo2 = new CategoryTwo("y", "letter y", "niamod");
        CategoryTwo cTwo3 = new CategoryTwo("z", "letter z", "niamod");
        CategoryTwo[] arrCatTwo = new CategoryTwo[]{cTwo1,cTwo2,cTwo3};

        Map<String, CategoryOne> mapCategoryOne = new HashMap<>();
//        mapCategoryOne.put(cOne1.ProdID, cOne1);
//        mapCategoryOne.put(cOne2.ProdID, cOne2);
//        mapCategoryOne.put(cOne3.ProdID, cOne3);

        Map<String, CategoryTwo> mapCategoryTwo = new HashMap<>();
//        mapCategoryTwo.put(cTwo1.CategoryID, cTwo1);
//        mapCategoryTwo.put(cTwo2.CategoryID, cTwo2);
//        mapCategoryTwo.put(cTwo3.CategoryID, cTwo3);

        createShowSherpaCategory(mapCategoryOne,CategoryOne.class);
    }

    public static <T> void createShowSherpaCategory(Map<String, T> categories, Class clazz) {
//        Type[] pt = categories.getClass().getGenericInterfaces();
//        ParameterizedType pt = (ParameterizedType)
//        for(Type t : pt){
//            System.out.println(t);
//        }
//        System.out.println((T instanceof CategoryOne));
//        System.out.println(clazz.getSimpleName());


//        if (!StringUtil.isEmpty(_showCode))
//        {
//            SherpaCategory cat = (SherpaCategory)categories.get(_showCode);
//            if (cat == null)
//            {
//                cat = new SherpaCategory();
//                cat.CategoryID = _showCode;
//                cat.CategoryName = _categoryName;
//                cat.Domain = Category.DOMAIN_SHOW;
//                categories.put(cat.CategoryID, cat);
//            }
//        }
    }

    private static class CategoryOne{
        String ProdID;
        String Display;
        String Domain;
        CategoryOne(String prodid, String display, String domain) {
            this.ProdID = prodid;
            this.Display = display;
            this.Domain = domain;
        }
    }

    private static class CategoryTwo{
        String CategoryID;
        String CategoryName;
        String Domain;
        CategoryTwo(String categoryID, String categoryName, String domain) {
            this.CategoryID = categoryID;
            this.CategoryName = categoryName;
            this.Domain = domain;
        }
    }
}


