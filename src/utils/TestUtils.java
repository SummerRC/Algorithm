package utils;

import java.util.Random;

/**
 * Created by SummerRC on 18/8/1.
 * Description: 测试算法用的工具类
 */
public class TestUtils {

    /**
     * @param length    数组长度
     * @param bound     最大值
     * @return  返回一个随机数组, 取值范围为[0, bound)
     */
    public static Integer[] getRandomArray(int length, int bound) {
        assert length > 0 : "length 必须大于 0";
        Integer[] array = new Integer[length];
        Random random = new Random();
        for (int i=0; i<length; i++) {
            array[i] = random.nextInt(bound);
        }
        return array;
    }

    /**
     * @param length    数组长度
     * @param swapTimes 对有序数组随机选取几对元素互相交换位置
     * @return  返回一个近乎有序的随机数组, 取值范围为[0, n)
     */
    public static Integer[] getNearlyOrderedArray(int length, int swapTimes) {
        assert length > 0 : "length 必须大于 0";
        assert length > 0 : "swapTimes 必须大于 0";
        Integer[] array = new Integer[length];
        for (int i=0; i<length; i++) {
            array[i] = i;
        }
        Random random = new Random();
        for (int i=0; i<swapTimes; i++) {
            int posX = random.nextInt(length);
            int posY = random.nextInt(length);
            ArrayUtils.swipe(array, posX, posY);
        }
        return array;
    }
}
