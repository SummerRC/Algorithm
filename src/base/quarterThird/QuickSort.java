package base.quarterThird;

import base.Sort;
import utils.ArrayUtils;

/**
 * Created by SummerRC on 2018/8/2.
 * Description: 快速排序
 *      算法思想：通过一次排序将待排序数组分成左右两个，使左边的数都比标兵小，右边的数都比标兵大，重复
 *              上述过程，知道数组完全有序
 */
public class QuickSort<T extends Comparable<? super T>> extends Sort<T> {

    @Override
    public void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        quickSort(array, 0, array.length-1);
    }

    /**
     * 对数组[left, right]区间的元素进行快速排序, 使[left+1, j]的元素都小于等于array[left],
     * [j+1, right]的元素都大于V
     */
    private void quickSort(T[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(array, left, right);
        quickSort(array, left, p-1);
        quickSort(array, p+1, right);
    }

    /**
     * 对[left, right] 进行partition操作
     * @return  返回数组元素下标p, 使得 array[left...p-1]<=array[p] ; array[p+1...right] > array[p]
     */
    private int partition(T[] array, int left, int right) {
        int p = left;
        for (int i=left+1; i<=right; i++) {
            if (array[i].compareTo(array[left]) <= 0) {
                p++;
                ArrayUtils.swipe(array, p, i);
            }
        }
        ArrayUtils.swipe(array, left, p);
        return p;
    }

    @Override
    public void optimizedSort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
    }
}
