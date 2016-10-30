import java.util.List;

import android.net.Uri;

public interface Api {
    List<Cat> queryCats(String query);
    Uri store(Cat cat);
}
