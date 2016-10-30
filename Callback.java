public interface Callback<T> {
    void onResult(T result);
    void onError(Exception e);
}
