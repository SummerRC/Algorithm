package base.quarterFourth;

import base.Sort;


/**
 * Created by SummerRC on 2018/8/3.
 * Description: 堆排序， 借助于自定义最大堆这个数据结构，可以实现堆排序
 *         优化: 我们可以直接将数组转化成最大堆，而不是一个一个的插入堆中。我们可以将所有的叶子节都看成
 *              一个最大堆，然后从最后一个非叶子节点（n/2)开始采用shiftDown操作，使新的节点成为最大堆，
 *              一直到对第一个非叶子节点结束（1）也采用shiftDown操作，此时整个完全二叉树即成为一个最大堆。
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
        if (array == null || array.length <= 1) {
            return;
        }
        MaxHeap<T> maxHeap = new MaxHeap<>(array);
        for (int i=array.length-1; i>=0; i--) {
            array[i] = maxHeap.extractMax();
        }
    }
}
