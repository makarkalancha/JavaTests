package com.everything.files.delete;

import java.time.LocalDate;
import java.util.regex.Pattern;

/**
 * Created by mcalancea
 * Date: 19 Jan 2018
 * Time: 15:04
 */
public class Constants {
    public static final String BACKUP_FILENAME_TIMESTAMP = "yyyy-MM-dd'T'HH-mm-ss";
    public static final String BACKUP_FILENAME_SUFFIX = "_backup.zip";
    public static final String REGEX_FILTER = "^(\\d{4}\\-\\d{2}\\-\\d{2}T\\d{2}\\-\\d{2}\\-\\d{2})_.+_backup\\.zip$";
    public static final Pattern PATTERN = Pattern.compile("^(\\d{4}\\-\\d{2}\\-\\d{2}T\\d{2}\\-\\d{2}\\-\\d{2})_.+_backup\\.zip$");
    public static final LocalDate EPOCH = LocalDate.ofEpochDay(0);
}
