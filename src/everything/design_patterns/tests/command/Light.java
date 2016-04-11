package everything.design_patterns.tests.command;

/**
 * Created by mcalancea on 2016-04-11.
 */
public class Light {
    private boolean isOn;

    public void switchOn() {
        isOn = true;
    }

    public void switchOff() {
        isOn = false;
    }

}
