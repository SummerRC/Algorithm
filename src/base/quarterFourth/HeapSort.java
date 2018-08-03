package base.quarterFourth;

import base.Sort;


/**
 * Created by SummerRC on 2018/8/3.
 * Description: 堆排序， 借助于自定义最大堆这个数据结构，可以实现堆排序
 */
public class HeapSort<T extends Comparable<? super T>> extends Sort<T> {

    @Override
    public void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        MaxHeap<T> maxHeap = new MaxHeap<>((Class<T>) array[0].getClass(), array.length);
        for (T t : array) {
            maxHeap.insert(t);
        }
        for (int i=array.length-1; i>=0; i--) {
            array[i] = maxHeap.extractMax();
        }
    }

    @Override
    public void optimizedSort(T[] array) {

    }
}
