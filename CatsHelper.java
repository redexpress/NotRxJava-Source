import java.util.Collections;
import java.util.List;

import android.net.Uri;

public class CatsHelper {

    ApiWrapper apiWrapper;

    public AsyncJob<Uri> saveTheCutestCat(String query) {
        AsyncJob<List<Cat>> catsListAsyncJob = apiWrapper.queryCats(query);
        final AsyncJob<Cat> cutestCatAsyncJob = catsListAsyncJob.map(new Func<List<Cat>, Cat>() {
            @Override
            public Cat call(List<Cat> cats) {
                return findCutest(cats);
            }
        });

        AsyncJob<Uri> storedUriAsyncJob = cutestCatAsyncJob.flatMap(new Func<Cat, AsyncJob<Uri>>() {
            @Override
            public AsyncJob<Uri> call(Cat cat) {
                return apiWrapper.store(cat);
            }
        });
        return storedUriAsyncJob;
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
