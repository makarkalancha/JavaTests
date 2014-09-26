package everything.fileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.nio.file.*;

/**
 * User: Makar Kalancha
 * Date: 12/09/14
 * Time: 9:50 AM
 */
public class FileDeleteFromList {
    private String _listPath;
    private String _pathWithFiles;
    private Set<String> _fileSet = new HashSet<>();

    public FileDeleteFromList(String listPath, String pathWithFiles) {
        this._listPath = listPath;
        this._pathWithFiles = pathWithFiles;
    }

    public static void main(String[] args) throws IOException{
        String listPath = "D:\\Tasks\\070_7243_ivew2014_dt\\2-data\\handouts_session\\VEW 2014 handouts_20140909_short\\list_to_delete.txt";
        String pathWithFiles = "D:\\Tasks\\070_7243_ivew2014_dt\\2-data\\handouts_session\\VEW 2014 handouts_20140909_short\\VEW 2014 handouts";

        new FileDeleteFromList(listPath,pathWithFiles).process();
    }

    public void process() throws IOException {
//        readFileIntoLineCollection();
        FileUtils.readFileIntoLineCollection(_listPath, _fileSet);
        deleteFiles();
    }



    private void deleteFiles() throws IOException{
        for(String file : _fileSet){
//            Path fileToDelete = Paths.get(_pathWithFiles + FileSystems.getDefault().getSeparator() + file);
            File fileToDelete = new File(_pathWithFiles + FileSystems.getDefault().getSeparator() + file);
            if(fileToDelete.exists()){
                System.out.println(">>>exists: "+fileToDelete.getAbsolutePath());
                Files.delete(fileToDelete.toPath());
            } else{
                System.out.println("---does NOT exist: "+fileToDelete.getAbsolutePath());
            }

        }
    }
}
