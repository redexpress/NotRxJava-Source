import java.util.Collections;
import java.util.List;

import android.net.Uri;

public class CatsHelper {

    Api api;

    public Uri saveTheCutestCat(String query){
        List<Cat> cats = api.queryCats(query);
        Cat cutest = findCutest(cats);
        Uri savedUri = api.store(cutest);
        return savedUri;
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
