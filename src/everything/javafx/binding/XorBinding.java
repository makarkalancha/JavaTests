package everything.javafx.binding;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Makar Kalancha
 * Date: 06 Oct 2016
 * Time: 13:36
 */
public class XorBinding {
    public static void main(String[] args) {
        BooleanProperty first = new SimpleBooleanProperty(true);
        BooleanProperty second = new SimpleBooleanProperty(true);
        BooleanProperty third = new SimpleBooleanProperty(true);
        BooleanProperty fourth = new SimpleBooleanProperty(true);

        BooleanBinding booleanBinding =
                (
                first
                .or(second)
                .or(third)
                .or(fourth)
                ).and(Bindings.not(
                        first
                        .and(second)
                        .and(third)
                        .and(fourth)
                ))
//        bind
//                first
//                .or(second)
//                .or(third)
//                .or(fourth)
                ;
        System.out.println("booleanBinding.get(): " + booleanBinding.get());

        String a = "";
        String b = "a";
        String c = "a";
        String d = "a";

//        boolean disableBoolean =
//                (a == null || b == null || c == null || d == null)
//                &&
//                (!(a == null && b == null && c == null && d == null))
//                ;
        boolean disableBoolean =
                (StringUtils.isBlank(a) || StringUtils.isBlank(b) || StringUtils.isBlank(c) || StringUtils.isBlank(d))
                        &&
                        (!(StringUtils.isBlank(a) && StringUtils.isBlank(b) && StringUtils.isBlank(c) && StringUtils.isBlank(d)))
                ;
        System.out.println("disableBoolean: " + disableBoolean);


    }
}
