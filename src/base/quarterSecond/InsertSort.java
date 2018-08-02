package base.quarterSecond;

import base.Sort;
import utils.ArrayUtils;

/**
 * Created by SummerRC on 18/8/1.
 * Description: 插入排序
 *      算法思想:将一个元素插入到已排序数组中, 使已排序数组继续有序, 重复上述过程, 直到数组完全有序
 *      思考:
 *          插入排序在找到合适的位置时算法就停止了,所以在数组近乎有序的情况下,效率极高,甚至优于O(nlogn)的算法
 */
public class InsertSort<T extends Comparable<? super T>> extends Sort<T> {

    @Override
    public void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        //外层考虑从[1, length)的无序元素
        for (int i = 1; i < array.length; i++) {
            //寻找array[i]在区间[0, i]合适的插入位置
            for (int j = i; j > 0; j--) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    ArrayUtils.swipe(array, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 优化的插入排序算法
     */
    public void optimizeSort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        //外层考虑从[1, length)的无序元素
        for (int i=1; i<array.length; i++) {
            T e = array[i];     //待插入的元素
            int j;              //元素e应该插入的位置
            //寻找array[i]在区间[0, i]合适的插入位置
            for (j=i; j>0; j--) {
                if (e.compareTo(array[j-1]) < 0) {
                    array[j] = array[j-1];
                } else {
                    break;
                }
            }
            array[j] = e;
        }
    }

    /**
     * 对数组中[left, right]的元素进行插入排序
     */
    public void sort(T[] array, int left, int right) {
        if (array == null || left < 0 || right < 0 || left >= right ||
                left >= array.length || right >= array.length) {
            return;
        }
        //外层考虑从[left + 1, right}的无序元素
        for (int i = left + 1; i <= right; i++) {
            //寻找array[i]在区间[left, i]合适的插入位置
            for (int j = i; j > left; j--) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    ArrayUtils.swipe(array, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}
