import com.sxlg.goblet.data.CreateObject;
import javassist.CannotCompileException;
import javassist.NotFoundException;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

public class CreateObjectTest {
    CreateObject createObject = new CreateObject();
    private Properties properties = new Properties();

    @Test
    public void createTest() throws IOException {
        URL path = getClass().getClassLoader().getResource("table");
        File file = new File(path.getPath());
        File[] files = file.listFiles();
        for (String s :
                file.list()) {
            System.out.println(s);
        }
        for (File f : files) {
            InputStream in = new FileInputStream(f);
            properties.load(in);
            Enumeration<?> enumeration = properties.propertyNames();
            while (enumeration.hasMoreElements()) {
                String o1 = (String) enumeration.nextElement();
                System.out.println(o1 + " ->" + properties.get(o1));
            }
        }



//        createObject.createObject();
    }

    @Test
    public void createObjectTest() throws IllegalAccessException, InstantiationException, IOException, CannotCompileException, NotFoundException, NoSuchFieldException {
        createObject.buildObject();
    }
}
