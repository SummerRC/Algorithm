package base.quarterThird;

import base.Sort;
import base.quarterSecond.InsertSort;

import java.lang.reflect.Array;

/**
 * Created by SummerRC on 18/8/1.
 * Description: 归并排序(自下而上的非递归实现)
 */
public class MergeSortBU<T extends Comparable<? super T>> extends Sort<T> {

    public MergeSortBU(Class<T> type) {
        super(type);
    }

    @Override
    public void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

    }

    @Override
    public void optimizedSort(T[] array) {

    }

}
