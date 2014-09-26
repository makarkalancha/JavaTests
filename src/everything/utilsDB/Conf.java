package everything.utilsDB;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * User: Makar Kalancha
 * Date: 12/08/14
 * Time: 2:08 PM
 */
public class Conf {
    private String _environment;
    private Properties _properties;

    public Conf(String env) {
        this._environment = env;
        this._properties = new Properties();
    }

    public void load(){
        try{
            InputStream in = this.getClass().getResourceAsStream("config." + _environment + ".properties");
            if(in != null){
                _properties.load(in);
            } else {
                throw new IllegalStateException("Configuration " + _environment + " not available");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return _properties;
    }
}
