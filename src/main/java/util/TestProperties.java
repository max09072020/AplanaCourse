package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    private final Properties myproperties = new Properties();
    private static TestProperties INSTANCE = null;

    private TestProperties(){
        try{
            myproperties.load(new FileInputStream(new File("./" + "app.properties")));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static TestProperties getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new TestProperties();
        }
        return INSTANCE;
    }
    public Properties getProperties() { return myproperties ;}
}
