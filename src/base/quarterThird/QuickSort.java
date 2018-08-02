package base.quarterThird;

import base.Sort;
import base.quarterSecond.InsertSort;
import utils.ArrayUtils;

import java.util.Random;

/**
 * Created by SummerRC on 2018/8/2.
 * Description: 快速排序
 *      算法思想：通过一次排序将待排序数组分成左右两个，使左边的数都比标兵小，右边的数都比标兵大，重复
 *              上述过程，知道数组完全有序
 *      优化：   1. 在元素少的时候采用插入排序
 *              2. 针对近乎有序的数组进行优化（数组近乎有序的情况下，生成的递归树不平衡，很可能比logn要高）
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
        if (right - left < 15) {
            InsertSort<T> sort = new InsertSort<>();
            sort.sort(array, left, right);
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
        T v = array[left];

        //array[left+1...j] <= v ; array[j+1...i) > v
        int j = left;
        for (int i=left+1; i<=right; i++) {
            if (array[i].compareTo(v) <= 0) {
                j++;
                ArrayUtils.swap(array, i, j);
            }
        }
        ArrayUtils.swap(array, left, j);
        return j;
    }

    @Override
    public void optimizedSort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        optimizedQuickSort(array, 0, array.length-1);
    }

    /**
     * 优化点一: 元素少时采用插入排序
     */
    private void optimizedQuickSort(T[] array, int left, int right) {
        if (right - left < 15) {
            InsertSort<T> sort = new InsertSort<>();
            sort.sort(array, left, right);
            return;
        }
        int p = optimizedPartition(array, left, right);
        optimizedQuickSort(array, left, p-1);
        optimizedQuickSort(array, p+1, right);
    }

    /**
     * 优化点二：partition的时候随机选取一个元素
     */
    private int optimizedPartition(T[] array, int left, int right) {
        int rand = (new Random()).nextInt(right-left) + left;
        ArrayUtils.swap(array, left, rand);
        T v = array[left];

        //array[left+1...j] <= v ; array[j+1...i) > v
        int j = left;
        for (int i=left+1; i<=right; i++) {
            if (array[i].compareTo(v) <= 0) {
                j++;
                ArrayUtils.swap(array, i, j);
            }
        }
        ArrayUtils.swap(array, left, j);
        return j;
    }
}
