package org.bms.javasamples;

public interface SamplePredicate<T> {
    boolean test(T t);

    default SamplePredicate<T> and(final SamplePredicate<T> other) {
        return t -> test(t) && other.test(t);
    }

    static <E> SamplePredicate<E> equalTo(final E e) {
        return s -> s.equals(e);
    }
}
