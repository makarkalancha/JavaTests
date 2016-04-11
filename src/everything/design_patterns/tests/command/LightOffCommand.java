package everything.design_patterns.tests.command;

/**
 * Created by mcalancea on 2016-04-11.
 */
public class LightOffCommand implements Command{
    private final Light light;

    public LightOffCommand(Light l){
        this.light = l;
    }

    @Override
    public void execute() {
        this.light.switchOff();
    }
}
