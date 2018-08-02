package base.quarterThird;

import base.Sort;
import base.quarterSecond.InsertSort;

import java.lang.reflect.Array;

/**
 * Created by SummerRC on 18/8/1.
 * Description: 归并排序(自上而下的实现)
 * 算法思想: 将待排序数组分成左右两部分, 然后将左右两部分再两两划分, 直到划分成最小的元素个数,
 * 然后再依次两两归并成有序数组,直到数组完全有序.
 * 时间复杂度: logn次归并 * 每次时间复杂度n = O(nlogn)
 * 空间复杂度: n (任意时刻只需要一个临时数组)
 */
public class MergeSort<T extends Comparable<? super T>> extends Sort<T> {

    public MergeSort(Class<T> type) {
        super(type);
    }

    @Override
    public void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        mergeSort(array, 0, array.length - 1);
    }

    @Override
    public void optimizedSort(T[] array) {
        optimizedMergeSort(array, 0, array.length - 1);
    }

    /**
     * 递归使用归并排序, 对array[left, right]区间的数据进行排序
     */
    private void mergeSort(T[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);
        merge(array, middle, left, right);
    }


    /**
     * 跟方法 mergeSort 基本一致
     * 优化点有两个：
     *      1. 在待归并元素很少的时候采用更加高效的插入排序
     *      2. 在需要的时候才对左右两部分进行归并 (这种优化在数组近乎有序的情况下非常有效)
     */
    private void optimizedMergeSort(T[] array, int left, int right) {
        if (right - left < 15) {
            InsertSort<T> sort = new InsertSort<>();
            sort.sort(array, left, right);
            return;
        }
        int middle = (left + right) / 2;
        optimizedMergeSort(array, left, middle);
        optimizedMergeSort(array, middle + 1, right);

        if (array[middle].compareTo(array[middle + 1]) > 0) {      // 只有归并之后的左半部分有大于右半部分的元素,才进行merge操作
            merge(array, middle, left, right);
        }
    }


    @SuppressWarnings("unchecked")
    private void merge(T[] array, int middle, int left, int right) {
        //开辟一块新的内存空间存储数组元素
        T[] tmpArray = (T[]) Array.newInstance(mType, right - left + 1);
        for (int i = left; i <= right; i++) {
            tmpArray[i - left] = array[i];
        }
        int position = left;        //游标从left开始
        int i = left;
        int j = middle + 1;
        while (position <= right) {
            if (i <= middle && j <= right) {        //左右两部分均还有值的情况
                if (tmpArray[i - left].compareTo(tmpArray[j - left]) <= 0) {
                    array[position] = tmpArray[i - left];
                    i++;
                } else {
                    array[position] = tmpArray[j - left];
                    j++;
                }
            } else if (i <= middle) {               //左边有值的情况
                array[position] = tmpArray[i - left];
                i++;
            } else {                                //右边有值的情况
                array[position] = tmpArray[j - left];
                j++;
            }
            position++;
        }
    }
}
