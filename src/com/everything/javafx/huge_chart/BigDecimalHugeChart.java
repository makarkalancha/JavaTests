package com.everything.javafx.huge_chart;

import javafx.scene.chart.XYChart;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * User: Makar Kalancha
 * Date: 02/12/2018
 * Time: 03:09
 */
public class BigDecimalHugeChart extends GenericHugeChart<BigDecimal> {
    private List<BigDecimal> numbers = new ArrayList<>();

    @Override
    public List<XYChart.Data<String, BigDecimal>> fillData() {
        readFile();
        LocalDate firstDay = LocalDate.of(2011, Month.JANUARY, 1);
        int low = -5000;
        int high = 5000;
        DateTimeFormatter DATE_DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault());
        List<XYChart.Data<String, BigDecimal>> data = new ArrayList<>();
        for (int i = 0; i < 10_002; i++) {
//        for (int i = 0; i < 9_407; i++) {
//        for (int i = 0; i < 398; i++) {
//            BigDecimal number = new BigDecimal(
//                    RandomNumbers.getRandomIntNumber(low, high)
////                                    i
//            );
//            System.out.println("numbers.add(new BigDecimal(" + number + "));\n");
            data.add(
                    new XYChart.Data<>(
                            DATE_DTF.format(firstDay.plusDays(i)),
//                            number
                            numbers.get(i)
                    )
            );
        }

        return data;
    }

    private void readFile(){
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            try {
                String rootFolder = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
                String specificFolder = this.getClass().getCanonicalName().replace(".", File.separator);
                int lastIndexOf = specificFolder.lastIndexOf(this.getClass().getSimpleName());
                specificFolder = rootFolder+specificFolder.substring(0, lastIndexOf)+"10_002_numbers.txt";
                //#2000 min value of -8999
                //#8000 max value of 9001

                inputStream = new FileInputStream(specificFolder);
                sc = new Scanner(inputStream, "UTF-8");
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    numbers.add(new BigDecimal(line));
                    // System.out.println(line);
                }
                // note that Scanner suppresses exceptions
                if (sc.ioException() != null) {
                    throw sc.ioException();
                }
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (sc != null) {
                    sc.close();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public BigDecimal convertDoubleToV(double d) {
        return new BigDecimal(Double.toString(d));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
