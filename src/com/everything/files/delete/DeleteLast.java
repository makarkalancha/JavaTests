package com.everything.files.delete;

import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.RegexFileFilter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created by mcalancea
 * Date: 19 Jan 2018
 * Time: 15:01
 */
public abstract class DeleteLast<T extends Number & Comparable> {
//    protected Multimap<T, File> dateToFilesMap = TreeMultimap.create((o1, o2) -> o2.compareTo(o1), (o1, o2) -> o1.compareTo(o2));
    protected Multimap<T, File> dateToFilesMap = TreeMultimap.create();
//    protected Multimap<T, File> dateToFilesMap = HashMultimap.create();
    protected final File dir;

    public DeleteLast(String dirPathStr) {
        this.dir = new File(dirPathStr);
    }

    public void deleteLast(int number) throws IOException {
        fillMap();

        List<File> filesToDelete = new ArrayList<>();
        Iterator<T> iterator = dateToFilesMap.keySet().iterator();
        for (int i = 0; iterator.hasNext() && i < (dateToFilesMap.keySet().size() - number); i++) {
            filesToDelete.addAll(dateToFilesMap.get(iterator.next()));
        }

        for(File file : filesToDelete) {
            Files.deleteIfExists(file.toPath());
        }
//        System.out.println("dateToFilesMap:\n" + dateToFilesMap);
//        System.out.println("temp:\n" + filesToDelete);
    };

    private void fillMap(){
        for(File file : FileUtils.listFiles(dir, new RegexFileFilter(Constants.REGEX_FILTER, IOCase.INSENSITIVE), null)){
            Matcher matcher = Constants.PATTERN.matcher(file.getName());
            if(matcher.find()){
                LocalDate date = LocalDate.parse(matcher.group(1), DateTimeFormatter.ofPattern(Constants.BACKUP_FILENAME_TIMESTAMP));
                addInMap(date, file);
            }
        }
    }

    protected abstract void addInMap(LocalDate date, File file);
}
