package com.everything.collections;

import com.google.common.collect.Lists;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by mcalancea on 2015-10-19.
 */
public class ListByBatches {

    public static void main(String[] args) {
        Integer[] array = ArrayUtils.toObject(new Random().ints(13, 1, 100).toArray());
        List<Integer> integerList = Arrays.asList(array);
        System.out.println(integerList.size());
        System.out.println(integerList);

        //batch
        List<List<Integer>> batch = Lists.partition(integerList, 3);
        System.out.println(batch);
        for (List<Integer> subList : batch) {
            StringBuilder inClause = new StringBuilder();
            inClause.append("(");
            inClause.append(StringUtils.join(subList, ","));
            inClause.append(")");
            System.out.println(inClause.toString());
        }

    }

}
