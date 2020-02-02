import com.sxlg.goblet.serializable.SerializationUtils;
import org.junit.Test;

import java.nio.ByteBuffer;

public class SerializationTest {



    @Test
    public void test(){
        SerializationUtils utils = new SerializationUtils();
        String str = "123";
        String str1 = "12345678";
        byte[] serialize1 = org.apache.commons.lang3.SerializationUtils.serialize(str1);
        Object deserialize1 = org.apache.commons.lang3.SerializationUtils.deserialize(serialize1);

        byte[] serialize = org.apache.commons.lang3.SerializationUtils.serialize(str);
        Object deserialize = org.apache.commons.lang3.SerializationUtils.deserialize(serialize);
        System.out.println(deserialize1);
        System.out.println(deserialize);
    }
}
