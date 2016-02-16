package everything.JDBC.h2_tests;

/**
 * Created by mcalancea on 2016-02-16.
 */
public class H2DbConstants {
    public static final String DB_DRIVER = "org.h2.Driver";
    public static final String DB_DIR = "~";
    public static final String DB_NAME = "test";
    public static final String DB_CONNECTION = "jdbc:h2:"+DB_DIR+"/"+DB_NAME+";IFEXISTS=TRUE";
    public static final String DB_DIR1 = "~/smart_finance";
    public static final String DB_NAME1 = "finance";
    public static final String DB_CONNECTION1 = "jdbc:h2:"+DB_DIR1+"/"+DB_NAME1;
    public static final String DB_CONNECTION1_IFEXISTS = "jdbc:h2:"+DB_DIR1+"/"+DB_NAME1+";IFEXISTS=TRUE";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "root";

}
