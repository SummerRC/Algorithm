package base.quarterSecond;

import base.Sort;
import utils.ArrayUtils;

/**
 * Created by SummerRC on 18/8/1.
 * Description: 选择排序  包括算法实现及其优化
 *      算法思想:
 *              从待排序数组中选择一个元素,将其插入已排序数组的末端,使
 *              已排序数组继续有序,重复上诉过程,直到数组完全有序
 */
public class SelectSort<T extends Comparable<? super T>> extends Sort<T> {

    @Override
    public void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        //外层循环针对[0, n-1]的位置,为其选择合适元素
        for (int i=0; i<array.length; i++) {
            // 寻找[i, length) 区间里的最小值
            int minValuePosition = i;       //待排序数组中最小值的数组下标
            for (int j=i+1; j<array.length; j++) {
                if (array[j].compareTo(array[minValuePosition]) < 0) {
                    minValuePosition = j;
                }
            }
            ArrayUtils.swipe(array, i, minValuePosition);
        }
    }
}
