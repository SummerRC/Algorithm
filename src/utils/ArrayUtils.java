package utils;

import java.lang.reflect.Array;

/**
 * Created by SummerRC on 18/8/1.
 * Description: 处理数组相关的工具类
 */
public class ArrayUtils {

    /**
     * 交换数组下标为 i 和 j 的两个元素的位置
     */
    public static <T extends Comparable<? super T>> void swap(T array[], int i, int j) {
        if (array == null) {
            throw new RuntimeException("数组 array 为空!");
        }
        if (array.length <= i || array.length <= j) {
            throw new RuntimeException("数组越界!");
        }
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * 打印数组
     */
    public static <T extends Comparable<? super T>> void printArray(T array[]) {
        if (array == null || array.length == 0) {
            System.out.println("数组为空");
            return;
        }
        for (T i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 打印数组前n个元素
     */
    public static <T extends Comparable<? super T>> void printArray(T array[], int n) {
        if (array == null || array.length == 0) {
            System.out.println("数组为空");
            return;
        }
        for (int i=0; i<array.length && i<n; i++) {
            System.out.print(i + " ");
        }
        System.out.print("... ");
        System.out.println();
    }

    /**
     * 浅层拷贝一份数组
     */
    public static <T extends Comparable<? super T>> T[] copyArray(T array[], Class<T> type) {
        if (array == null || array.length == 0) {
            System.out.println("数组为空");
            return array;
        }
        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) Array.newInstance(type, array.length);
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    /**
     * 判断数组是否有序
     */
    public static <T extends Comparable<? super T>> boolean isSorted(T array[]) {
        if (array == null || array.length == 0) {
            return true;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}
