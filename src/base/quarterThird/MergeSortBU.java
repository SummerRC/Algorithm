package base.quarterThird;

import base.quarterSecond.InsertSort;

/**
 * Created by SummerRC on 18/8/1.
 * Description: 归并排序(自下而上的非递归实现)
 *      算法思想: 从最小粒度的一个元素进行归并开始，一次归并2、4、... length/2、length个元素，知道元素最后有序(其中最后一个size在区间[length/2, length))
 *      时间复杂度: nlogn
 *      空间复杂度: n
 */
public class MergeSortBU<T extends Comparable<? super T>> extends MergeSort<T> {

    public MergeSortBU(Class<T> type) {
        super(type);
    }

    @Override
    public void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        mergeSort(array);
    }

    private void mergeSort(T[] array) {
        //自下而上每次需要归并的左右两部分元素个数为size，其取值为[1, 2, ... ,length/2, length)
        for (int size=1; size<array.length; size+=size) {
            //针对每种size，得到归并的次数后，循环归并需要归并的左右两部分
            for (int i=0; i+size<array.length; i+=2*size) {
                //对[i, i+size-1] 和 [i+size, i+size+size-1]归并
                merge(array, i, i+size-1, Math.min(i+size+size-1, array.length-1));
            }
        }
    }

    /**
     * 优化思路同递归实现的插入排序：
     *      一是在数组元素较少的时候采用插入排序；
     *      二是在两部分有序的情况下不再调用merge函数
     */
    @Override
    public void optimizedSort(T[] array) {
        //自下而上每次需要归并的左右两部分元素个数为size，其取值为[1, 2, ... ,length/2, length)
        for (int size=1; size<array.length; size+=size) {
            //针对每种size，得到归并的次数后，循环归并需要归并的左右两部分
            for (int i=0; i+size<array.length; i+=2*size) {
                //有序时不再排序
                if (array[i+size-1].compareTo(array[i+size]) <= 0) {
                    continue;
                }
                //数量少时采用插入排序
                if (size <= 8) {
                    InsertSort<T> sort = new InsertSort<>();
                    sort.sort(array, i, Math.min(i+size+size-1, array.length-1));
                    continue;
                }
                //对[i, i+size-1] 和 [i+size, i+size+size-1]归并
                merge(array, i, i+size-1, Math.min(i+size+size-1, array.length-1));
            }
        }
    }
}
