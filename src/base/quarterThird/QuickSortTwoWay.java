package base.quarterThird;

import base.Sort;
import base.quarterSecond.InsertSort;
import utils.ArrayUtils;

import java.util.Random;

/**
 * Created by SummerRC on 2018/8/2.
 * Description: 两路快排
 *      算法思想：我们可以分别将大小两部分放在数组的两头，从数组两边向中间渐进，每在数组左边找到一个大于v的元
 *              素就去右边找一个小于v的元素互相交换位置，直到遍历完数组。这样针对重复元素较多的情况，就能尽量
 *              保证重复元素平均分布在数组两边，使递归树尽量平衡。
 *
 *      思考：   如果每次将数组分成三部分，左边的小于v, 中间的等于v, 右边的大于v, 这样在有重复键值的情况下效率会更加高效
 */
public class QuickSortTwoWay<T extends Comparable<? super T>> extends Sort<T> {

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
        T v = array[left];

        //array[left+1...i) <= v ; array(j...right} >= v
        int i = left + 1;
        int j = right;
        while (true) {
            while (i <= right && array[i].compareTo(v)  < 0) {
                i++;
            }
            while (j >= left && array[j].compareTo(v) > 0) {
                j--;
            }
            if (i > j) {        //已经遍历完了
                break;
            }
            ArrayUtils.swap(array, i, j);
            i++;
            j--;
        }
        ArrayUtils.swap(array, left, i-1);
        return i-1;
    }

    @Override
    public void optimizedSort(T[] array) {
    }

}
