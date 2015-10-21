package everything.java8tests.functionalprogramming.ch07.factorial;

/**
 * Created by mcalancea on 2015-10-16.
 */
public class TailCalls {
    public static<T> TailCall<T> call(final TailCall<T> nextCall) {
        return nextCall;
    }

    public static <T> TailCall<T> done(final T value){
        return new TailCall<T>() {
            @Override
            public boolean isCompleted() {
                return true;
            }

            @Override
            public T result() {
                return value;
            }

            @Override
            public TailCall<T> apply() {
                throw new Error("not implemented");
            }
        };
    }

}
