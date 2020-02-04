import com.sxlg.gbolet.network.worker.DefultAcceptWorket;
import com.sxlg.goblet.deserialization.JSONTransform;
import com.sxlg.goblet.model.JoyQueueMessage;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.io.IOException;

public class Accept {

    @Test
    public void test() throws IOException {
        JoyQueueMessage message1 = JSONTransform.StringToObject("{\"data\":[{\"id\":\"1\"}],\"database\":\"test\",\"es\":1580700265000,\"id\":34,\"isDdl\":false,\"mysqlType\":{\"id\":\"varchar(8)\"},\"old\":null,\"pkNames\":null,\"sql\":\"\",\"sqlType\":{\"id\":12},\"table\":\"test\",\"ts\":1580700265215,\"type\":\"INSERT\"}", JoyQueueMessage.class);
        byte[] serialize = SerializationUtils.serialize(message1);
        System.out.println(serialize.length);
    }
}
