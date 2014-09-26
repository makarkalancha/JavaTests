package everything.filetodb;

/**
 * User: Makar Kalancha
 * Date: 17/06/14
 * Time: 3:06 PM
 */
public class FileToDB {
    String _inFile;
    public FileToDB(String inFile) {
        this._inFile = inFile;
    }

    public static void main(String[] args) {
        String outSt = "D:\\Tasks\\065_aggregate\\20140617\\jrevision_updates.txt";
        FileToDB fileToDB = new FileToDB(outSt);
    }
}
