package com.everything.utils.fileUtils;

import me.tongfei.progressbar.ProgressBar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Makar Kalancha
 * Date: 22/09/14
 * Time: 10:16 AM
 */
public class FileAppender {
    private static List<String> _fileLines = new ArrayList<>();
    public static void main(String[] args) {
        List<String> filePaths = new ArrayList<>();
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\023_Analytics_global_visits.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\024_Product_ForeignID_size.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\025_User_Url.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\026_Coutries.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\027_Sponsor_jRevision.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\028_Booth_Color.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\029_PurchasedPromo_SmartAction.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\030_Localized_pgDateMediumFormat.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\031_PurchasedPromo_OrganizerId.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\032_Push_Notification.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\033_Edition_TimeZone.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\034_GeoZone_FillColor.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\035_PushNotification_SmartAction.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\036_StatEvent_Indexes.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\037_StatEvent_Indexes.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\038_mail.callbackrequest.subject.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\039_ExibitorDealCategory_Trigger.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\040_ExibitorDealCategories_Trigger.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\041_ExibitorDeal_Deleted.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\042_GeoLocation.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\043_DemogQuestionAnswerTrigger.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\044_GeoLocation_Trigger.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\045_DemogQuestionAnswerTrigger2.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\046_demog_categories_table.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\047_agg_leader_board.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\048_new_stats_aggregates.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\049_beacons.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\050_article_category_article_deleted.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\051_translation_trigger.sql");
        filePaths.add("D:\\SRC\\PHP\\1.9.2\\migrations\\052_agg_rankboard.sql");
        String fileDestPath = "D:\\Tasks\\093_licensingb2013_to_migrate\\migration_file.sql";
        try{
            ProgressBar pbReading = new ProgressBar("Copy file lines", filePaths.size());
            pbReading.start(); // the progress bar starts timing
            for(String filePath : filePaths){
                pbReading.step(); // step by 1
                _fileLines.add("--" + filePath);
                FileUtils.readFileIntoLineCollection(filePath, _fileLines);
                pbReading.setExtraMessage("Reading..."); // Set extra message to display at the end of the bar
            }
            pbReading.setExtraMessage("Done!");
            pbReading.stop();

            ProgressBar pbWritting = new ProgressBar("Write lines in a file", _fileLines.size());
            pbWritting.start(); // the progress bar starts timing
            for (String line : _fileLines){
//                System.out.println(line);
                pbWritting.step(); // step by 1
                FileUtils.writeFile(fileDestPath,line,true);
                pbWritting.setExtraMessage("Writting..."); // Set extra message to display at the end of the bar
            }
            pbWritting.setExtraMessage("Done!");
            pbWritting.stop();
        } catch (IOException e){
            e.printStackTrace();
        }



    }



}
