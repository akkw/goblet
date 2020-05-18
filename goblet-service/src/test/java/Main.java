import com.sxlg.goblet.store.service.core.GobletService;

public class Main {

    public static void main(String[] args) {
        GobletService service = new GobletService();
        service.beforeStart();
        service.start();
    }
}
