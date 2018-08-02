package base;

/**
 * Created by SummerRC on 18/8/1.
 * Description:
 */
public abstract class Sort<T extends Comparable<? super T>> {

    protected Class<T> mType;

    public Sort() {}

    public Sort(Class<T> type) {
        this.mType = type;
    }

    public abstract void sort(T[] array);
}
