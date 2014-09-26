package everything.algorithms;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: Makar Kalancha
 * Date: 12/03/14
 * Time: 10:50 AM
 */
public abstract class Search {
    protected static final SimpleDateFormat LOG_TIME_FORMAT = new SimpleDateFormat("yyyy-MMMM-dd HH:mm:ss:SS");
//    protected static final String DIFF_FORMAT = "HH:mm:ss:SS";
    abstract  public int find(Integer[] hayStack, int needle);

    protected void timeSpeed(Date start, Date end){
        DateTime startDT = new DateTime(start.getTime());
        DateTime endDT = new DateTime(end.getTime());
        PeriodFormatter pf = new PeriodFormatterBuilder()
                .printZeroAlways().appendHours().appendSeparator(":")
                .appendMinutes().appendSeparator(":")
                .appendSeconds().appendSeparator(":")
                .appendMillis3Digit().toFormatter();
        System.out.println(pf.print(new Period(startDT, endDT, PeriodType.time())));
    }
}
