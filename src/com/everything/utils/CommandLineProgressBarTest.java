package com.everything.utils;

import me.tongfei.progressbar.ProgressBar;

/**
 * Created by mcalancea
 * Date: 12/03/2019
 * Time: 13:09
 */
public class CommandLineProgressBarTest {
    public static void main(String[] args) throws Exception{
        ProgressBar pb = new ProgressBar("Test", 100); // name, initial max
        // Use ProgressBar("Test", 100, ProgressBarStyle.ASCII) if you want ASCII output style
        pb.start(); // the progress bar starts timing
// Or you could combine these two lines like this:
//   ProgressBar pb = new ProgressBar("Test", 100).start();
        for(int i = 0 ; i < 10; i++){
            pb.step(); // step by 1
//            pb.stepBy(2); // step by n
//            pb.stepTo(1); // step directly to n
//            pb.maxHint(1);
            // reset the max of this progress bar as n. This may be useful when the program
            // gets new information about the current progress.
            // Can set n to be less than zero: this means that this progress bar would become
            // indefinite: the max would be unknown.
            pb.setExtraMessage("Reading..."); // Set extra message to display at the end of the bar
            Thread.sleep(500L);
        }
        pb.setExtraMessage("Done!");
        pb.stop();
    }
}
