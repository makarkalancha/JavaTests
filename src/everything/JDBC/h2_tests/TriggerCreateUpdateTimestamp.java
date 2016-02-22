package everything.JDBC.h2_tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import org.h2.api.Trigger;

/**
 * Created by mcalancea on 2016-02-16.
 */
//http://www.h2database.com/javadoc/org/h2/api/Trigger.html
public class TriggerCreateUpdateTimestamp implements Trigger{
    private String schemaName;
    private String triggerName;
    private String tableName;
    private int action; //    int INSERT = 1;    int UPDATE = 2;    int DELETE = 4;    int SELECT = 8;
    private boolean before;

    @Override
    public void close() throws SQLException {
        System.out.println("close");
    }

    @Override
    public void init(Connection connection, String s, String s1, String s2, boolean b, int i) throws SQLException {
        System.out.println("init");
        this.schemaName = s;
        this.triggerName = s1;
        this.tableName = s2;
        this.before = b;
        this.action = i;
    }

    @Override
    public void fire(Connection connection, Object[] oldRow, Object[] newRow) throws SQLException {
        System.out.println("fire start: "+this);
        Timestamp currentTime = new Timestamp(new Date().getTime());
//        Long id = null;
//        String query = null;

        if(action == Trigger.INSERT) {
//            id = (Long) newRow[0];
//            query = "UPDATE " + tableName + " SET T_CREATEDON =  ? WHERE ID = ?";
            newRow[3] = currentTime;
        }

//        PreparedStatement preparedStatement = connection.prepareStatement(
//                query
//        );
//        preparedStatement.setTimestamp(1, currentTime);
//        preparedStatement.setLong(2, id);
//        preparedStatement.executeUpdate();
        System.out.println("fire end: "+this);
    }

    @Override
    public void remove() throws SQLException {
        System.out.println("remove");
    }

    @Override
    public String toString() {
        return "TriggerCreateUpdateTimestamp{" +
                "action=" + action +
                ", schemaName='" + schemaName + '\'' +
                ", triggerName='" + triggerName + '\'' +
                ", tableName='" + tableName + '\'' +
                ", before=" + before +
                '}';
    }
}
