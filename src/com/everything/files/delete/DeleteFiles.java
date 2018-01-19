package com.everything.files.delete;


import java.io.IOException;

/**
 * Created by mcalancea
 * Date: 19 Jan 2018
 * Time: 13:57
 */
public class DeleteFiles {
    private enum BACKUP_UNIT {
        DAYS,
        MONTHS,
        YEARS;
    }

    private final static String pathStr = "C:\\Users\\mcalancea\\smart_finance\\backups";

    public static int lastNumber = 1;
    public static BACKUP_UNIT backupUnit = BACKUP_UNIT.YEARS;

    public static void main(String[] args) throws IOException {
        DeleteLast deleteLast = null;
        switch (backupUnit){
            case DAYS:
                deleteLast = new DeleteLastDays(pathStr);
                break;
            case MONTHS:
                deleteLast = new DeleteLastMonths(pathStr);
                break;
            case YEARS:
                deleteLast = new DeleteLastYears(pathStr);
                break;
            default:
                System.out.println("ERROR!!");
        }

        deleteLast.deleteLast(lastNumber);

//        Multimap<LocalDate, File> dateToFilesMap = TreeMultimap.create();
//        for(File file : FileUtils.listFiles(new File(pathStr), new RegexFileFilter(REGEX_FILTER, IOCase.INSENSITIVE), null)){
//            Matcher matcher = PATTERN.matcher(file.getName());
//            if(matcher.find()){
//                LocalDate date = LocalDate.parse(matcher.group(1), DateTimeFormatter.ofPattern(BACKUP_FILENAME_TIMESTAMP));
//                dateToFilesMap.put(date, file);
//            }
//        }
//
//        System.out.println(dateToFilesMap);
    }

}
