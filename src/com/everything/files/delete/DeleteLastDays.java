package com.everything.files.delete;

import java.io.File;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by mcalancea
 * Date: 19 Jan 2018
 * Time: 15:02
 */
public class DeleteLastDays extends DeleteLast<Long> {

    public DeleteLastDays(String pathStr) {
        super(pathStr);
    }

    @Override
    protected void addInMap(LocalDate date,File file) {
        dateToFilesMap.put(ChronoUnit.DAYS.between(Constants.EPOCH, date), file);
    }
}
