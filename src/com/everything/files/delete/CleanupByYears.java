package com.everything.files.delete;

import java.io.File;
import java.time.LocalDate;

/**
 * Created by mcalancea
 * Date: 19 Jan 2018
 * Time: 15:02
 */
public class CleanupByYears extends Cleanup<Integer> {

    public CleanupByYears(String pathStr) {
        super(pathStr);
    }

    @Override
    protected void addInMap(LocalDate date,File file) {
        dateToFilesMap.put(date.getYear(), file);
    }
}
