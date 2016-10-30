import java.util.Collections;
import java.util.List;

import android.net.Uri;

public class CatsHelper{

    ApiWrapper apiWrapper;

    public void saveTheCutestCat(String query, final Callback<Uri> cutestCatCallback){
        apiWrapper.queryCats(query, new Callback<List<Cat>>() {
            @Override
            public void onResult(List<Cat> cats) {
                Cat cutest = findCutest(cats);
                apiWrapper.store(cutest, cutestCatCallback);
            }

            @Override
            public void onError(Exception e) {
                cutestCatCallback.onError(e);
            }
        });
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
