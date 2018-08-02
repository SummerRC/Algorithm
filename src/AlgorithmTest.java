import base.Sort;
import base.quarterSecond.InsertSort;
import base.quarterSecond.SelectSort;
import base.quarterThird.MergeSort;
import other.IntToString;
import other.IsPrime;
import utils.ArrayUtils;
import utils.TestUtils;

public class AlgorithmTest<T extends Comparable<? super T>> {

    public static void main(String[] args) {
        AlgorithmTest<Integer> test = new AlgorithmTest<>();

        Integer array[] = TestUtils.getRandomArray(400, 10000);
//        Integer nearlyOrderedArray[] = TestUtils.getRandomArray(50000, 1);
//        array = nearlyOrderedArray;
        System.out.println("数组排序前为: ");
        System.out.println("数组排序前为: ");
        ArrayUtils.printArray(array);

        //选择排序
        Integer[] copyArrayForSS = ArrayUtils.copyArray(array, Integer.class);
        test.testSelectSort(copyArrayForSS);
        //插入排序
        Integer[] copyArrayForIS = ArrayUtils.copyArray(array, Integer.class);
        test.testInsertSort(copyArrayForIS);
        //优化后的插入排序
        Integer[] copyArrayForOIS = ArrayUtils.copyArray(array, Integer.class);
        test.testOptimizedInsertSort(copyArrayForOIS);
        //归并排序
        Integer[] copyArrayForMS = ArrayUtils.copyArray(array, Integer.class);
        test.testMergeSort(copyArrayForMS, Integer.class);
        //优化后的归并排序
        Integer[] copyArrayForOMS = ArrayUtils.copyArray(array, Integer.class);
        test.testOptimizedMergeSort(copyArrayForOMS, Integer.class);
    }

    /**
     * 测试选择排序算法
     */
    private void testSelectSort(T[] array) {
        System.out.println();
        System.out.println("测试选择排序算法: ");
        Sort<T> sort = new SelectSort<>();
        long timeBeforeSort = System.nanoTime();
        sort.sort(array);
        long timeUsed = System.nanoTime() - timeBeforeSort;
        System.out.println("数组排序后为: ");
        ArrayUtils.printArray(array);
        assert ArrayUtils.isSorted(array) : "数组无序";
        System.out.println("算法用时: " + (timeUsed / 1000000.0f) + "ms");
    }

    /**
     * 测试插入排序算法
     */
    private void testInsertSort(T[] array) {
        System.out.println();
        System.out.println("测试插入排序算法: ");
        Sort<T> sort = new InsertSort<>();
        long timeBeforeSort = System.nanoTime();
        sort.sort(array);
        long timeUsed = System.nanoTime() - timeBeforeSort;
        System.out.println("数组排序后为: ");
        ArrayUtils.printArray(array);
        assert ArrayUtils.isSorted(array) : "数组无序";
        System.out.println("算法用时: " + (timeUsed / 1000000.0f) + "ms");
    }

    /**
     * 测试优化后的插入排序算法
     */
    private void testOptimizedInsertSort(T[] array) {
        System.out.println();
        System.out.println("测试优化后的插入排序算法: ");
        Sort<T> sort = new InsertSort<>();
        long timeBeforeSort = System.nanoTime();
        sort.optimizedSort(array);
        long timeUsed = System.nanoTime() - timeBeforeSort;
        System.out.println("数组排序后为: ");
        ArrayUtils.printArray(array);
        assert ArrayUtils.isSorted(array) : "数组无序";
        System.out.println("算法用时: " + (timeUsed / 1000000.0f) + "ms");
    }

    /**
     * 测试归并排序算法
     */
    private void testMergeSort(T[] array, Class<T> type) {
        System.out.println();
        System.out.println("测试归并排序算法: ");
        Sort<T> sort = new MergeSort<>(type);
        long timeBeforeSort = System.nanoTime();
        sort.sort(array);
        long timeUsed = System.nanoTime() - timeBeforeSort;
        System.out.println("数组排序后为: ");
        ArrayUtils.printArray(array);
        assert ArrayUtils.isSorted(array) : "数组无序";
        System.out.println("算法用时: " + (timeUsed / 1000000.0f) + "ms");
    }

    /**
     * 测试归并排序算法
     */
    private void testOptimizedMergeSort(T[] array, Class<T> type) {
        System.out.println();
        System.out.println("测试优化后的归并排序算法: ");
        Sort<T> sort = new MergeSort<>(type);
        long timeBeforeSort = System.nanoTime();
        sort.optimizedSort(array);
        long timeUsed = System.nanoTime() - timeBeforeSort;
        System.out.println("数组排序后为: ");
        ArrayUtils.printArray(array);
        assert ArrayUtils.isSorted(array) : "数组无序";
        System.out.println("算法用时: " + (timeUsed / 1000000.0f) + "ms");
    }

    /**
     * 测试字符串转换算法
     */
    private void testIntToStringAlgorithm() {
        System.out.println();
        System.out.println("测试字符串转换算法: ");
        IntToString.testAlgorithm();
    }

    /**
     * 测试素数算法
     */
    private void testIsPrimeAlgorithm() {
        System.out.println();
        System.out.println("测试素数算法: ");
        IsPrime.testAlgorithm();
    }
}
