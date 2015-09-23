package everything.java8tests.functionalprogramming.ch05.cleanup_resources;

/**
 * Created by mcalancea on 2015-09-23.
 */
@FunctionalInterface
public interface UseInstance<T,X extends Throwable> {
    void accept(T instance) throws X;

}
