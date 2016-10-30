public interface Api {
    List<Cat> queryCats(String query);
    Uri store(Cat cat);
}
