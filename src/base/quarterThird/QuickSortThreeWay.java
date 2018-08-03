package base.quarterThird;

import base.Sort;
import base.quarterSecond.InsertSort;
import utils.ArrayUtils;

/**
 * Created by SummerRC on 2018/8/2.
 * Description: 三路快排
 *      算法思想：在二路排序的基础上，通过一次排序将待排序数组分成左右三部分，左边的小于v, 中间的等于v, 右边的大于v
 */
public class QuickSortThreeWay<T extends Comparable<? super T>> extends Sort<T> {

    @Override
    public void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        quickSort(array, 0, array.length-1);
    }

    /**
     * 对数组[left, right]区间的元素进行快速排序,
     * 使：
     *      [left, lt]  < v,
     *      (lt, mt)    = v,
     *      [mt, right] > v.
     */
    private void quickSort(T[] array, int left, int right) {
        if (right - left < 15) {
            InsertSort<T> sort = new InsertSort<>();
            sort.sort(array, left, right);
            return;
        }
        int[] p = partition(array, left, right);
        quickSort(array, left, p[0]);
        quickSort(array, p[1], right);
    }

    /**
     * 对[left, right] 进行partition操作
     * @return  返回数组p[],
     * 使:
     *      [left...lt]  < v,
     *      (lt...mt)    = v,
     *      [mt...right] > v.
     */
    private int[] partition(T[] array, int left, int right) {
        T v = array[left];

        //array[left...lt] <v ; array(lt...i) = v, array[mt, right] > v
        int lt = left - 1;
        int mt = right + 1;
        for (int i=left+1; i<mt; i++) {
            if (array[i].compareTo(v) < 0) {
                ArrayUtils.swap(array, i, lt+1);
                lt++;
            } else if (array[i].compareTo(v) > 0) {
                ArrayUtils.swap(array, i, mt-1);
                mt--;
                i--;
            }
        }
        return new int[]{lt, mt};
    }

    @Override
    public void optimizedSort(T[] array) {
    }
}
