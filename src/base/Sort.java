package base;

/**
 * Created by SummerRC on 18/8/1.
 * Description:
 */
public abstract class Sort<T extends Comparable<? super T>> {

    public Sort() {}

    /**
     * 未优化的排序算法
     */
    public abstract void sort(T[] array);

    /**
     * 优化的排序算法
     */
    public abstract void optimizedSort(T[] array);
}
