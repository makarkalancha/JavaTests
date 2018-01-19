package com.everything.files.delete;

import java.io.File;
import java.time.LocalDate;

/**
 * Created by mcalancea
 * Date: 19 Jan 2018
 * Time: 15:02
 */
public class DeleteLastYears extends DeleteLast<Integer> {

    public DeleteLastYears(String pathStr) {
        super(pathStr);
    }

    @Override
    protected void addInMap(LocalDate date,File file) {
        dateToFilesMap.put(date.getYear(), file);
    }
}
