import java.util.Collections;
import java.util.List;

import android.net.Uri;

import rx.Observable;

public class CatsHelper {

    ApiWrapper apiWrapper;

    public Observable<Uri> saveTheCutestCat(String query) {
        Observable<List<Cat>> catsListAsyncJob = apiWrapper.queryCats(query);
        Observable<Cat> cutestCatAsyncJob = catsListAsyncJob.map(cats -> findCutest(cats));
        Observable<Uri> storedUriAsyncJob = cutestCatAsyncJob.flatMap(cat -> apiWrapper.store(cat));
        return storedUriAsyncJob;
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
