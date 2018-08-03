import base.Sort;
import base.quarterFourth.HeapSort;
import base.quarterSecond.InsertSort;
import base.quarterSecond.SelectSort;
import base.quarterThird.*;
import other.IntToString;
import other.IsPrime;
import utils.ArrayUtils;
import utils.TestUtils;

public class AlgorithmTest<T extends Comparable<? super T>> {

    public static void main(String[] args) {
        AlgorithmTest<Integer> test = new AlgorithmTest<>();

        Integer array[] = TestUtils.getRandomArray(400, 10000);
        Integer nearlyOrderedArray[] = TestUtils.getRandomArray(10000, 10);
        array = nearlyOrderedArray;
        System.out.println("数组排序前为: ");
        System.out.println("数组排序前为: ");
        ArrayUtils.printArray(array);

        //选择排序
        Integer[] copyArrayForSS = ArrayUtils.copyArray(array);
        test.testSelectSort(copyArrayForSS);
        //插入排序
        Integer[] copyArrayForIS = ArrayUtils.copyArray(array);
        test.testInsertSort(copyArrayForIS);
        //优化后的插入排序
        Integer[] copyArrayForOIS = ArrayUtils.copyArray(array);
        test.testOptimizedInsertSort(copyArrayForOIS);
        //归并排序
        Integer[] copyArrayForMS = ArrayUtils.copyArray(array);
        test.testMergeSort(copyArrayForMS);
        //优化后的归并排序
        Integer[] copyArrayForOMS = ArrayUtils.copyArray(array);
        test.testOptimizedMergeSort(copyArrayForOMS);
        //自下而上的非递归的归并排序
        Integer[] copyArrayForMSBU = ArrayUtils.copyArray(array);
        test.testMergeSortBU(copyArrayForMSBU);
        //优化后的自下而上的非递归的归并排序
        Integer[] copyArrayForOMSBU = ArrayUtils.copyArray(array);
        test.testOptimizedMergeSortBU(copyArrayForOMSBU);
        //快速并排序
        Integer[] copyArrayForQS = ArrayUtils.copyArray(array);
        test.testQuickSort(copyArrayForQS);
        //优化后的快速并排序
        Integer[] copyArrayForOQS = ArrayUtils.copyArray(array);
        test.testOptimizedQuickSort(copyArrayForOQS);
        //二路快排
        Integer[] copyArrayForQSTwo = ArrayUtils.copyArray(array);
        test.testQuickSortTwoWay(copyArrayForQSTwo);
        //三路快排
        Integer[] copyArrayForQSThree = ArrayUtils.copyArray(array);
        test.testQuickSortThreeWay(copyArrayForQSThree);
        //堆排序
        Integer[] copyArrayForHS = ArrayUtils.copyArray(array);
        test.testHeapSort(copyArrayForHS);
    }


    /**
     * 测试选择排序算法
     */
    private void testSelectSort(T[] array) {
        System.out.println();
        Sort<T> sort = new SelectSort<>();
        long timeBeforeSort = System.nanoTime();
        sort.sort(array);
        long timeUsed = System.nanoTime() - timeBeforeSort;
        System.out.println("选择排序: " + (timeUsed / 1000000.0f) + "ms");
        System.out.print("数组排序后为: ");
        ArrayUtils.printArray(array, 10);
        assert ArrayUtils.isSorted(array) : "数组无序";
    }

    /**
     * 测试插入排序算法
     */
    private void testInsertSort(T[] array) {
        System.out.println();
        Sort<T> sort = new InsertSort<>();
        long timeBeforeSort = System.nanoTime();
        sort.sort(array);
        long timeUsed = System.nanoTime() - timeBeforeSort;
        System.out.println("插入排序: " + (timeUsed / 1000000.0f) + "ms");
        System.out.print("数组排序后为: ");
        ArrayUtils.printArray(array, 10);
        assert ArrayUtils.isSorted(array) : "数组无序";
    }

    /**
     * 测试优化后的插入排序算法
     */
    private void testOptimizedInsertSort(T[] array) {
        System.out.println();
        Sort<T> sort = new InsertSort<>();
        long timeBeforeSort = System.nanoTime();
        sort.optimizedSort(array);
        long timeUsed = System.nanoTime() - timeBeforeSort;
        System.out.println("优化后的插入排序: " + (timeUsed / 1000000.0f) + "ms");
        System.out.print("数组排序后为: ");
        ArrayUtils.printArray(array, 10);
        assert ArrayUtils.isSorted(array) : "数组无序";
    }

    /**
     * 测试归并排序算法(自上而下的递归实现)
     */
    private void testMergeSort(T[] array) {
        System.out.println();
        Sort<T> sort = new MergeSort<>();
        long timeBeforeSort = System.nanoTime();
        sort.sort(array);
        long timeUsed = System.nanoTime() - timeBeforeSort;
        System.out.println("归并排序: " + (timeUsed / 1000000.0f) + "ms");
        System.out.print("数组排序后为: ");
        ArrayUtils.printArray(array, 10);
        assert ArrayUtils.isSorted(array) : "数组无序";
    }

    /**
     * 测试归并排序算法(自上而下的递归实现)
     */
    private void testOptimizedMergeSort(T[] array) {
        System.out.println();
        Sort<T> sort = new MergeSort<>();
        long timeBeforeSort = System.nanoTime();
        sort.optimizedSort(array);
        long timeUsed = System.nanoTime() - timeBeforeSort;
        System.out.println("优化后的归并排序: " + (timeUsed / 1000000.0f) + "ms");
        System.out.print("数组排序后为: ");
        ArrayUtils.printArray(array, 10);
        assert ArrayUtils.isSorted(array) : "数组无序";
    }

    /**
     * 测试归并排序算法(自下而上的非递归实现)
     */
    private void testMergeSortBU(T[] array) {
        System.out.println();
        Sort<T> sort = new MergeSortBU<>();
        long timeBeforeSort = System.nanoTime();
        sort.sort(array);
        long timeUsed = System.nanoTime() - timeBeforeSort;
        System.out.println("自下而上的非递归实现的的归并排序: " + (timeUsed / 1000000.0f) + "ms");
        System.out.print("数组排序后为: ");
        ArrayUtils.printArray(array, 10);
        assert ArrayUtils.isSorted(array) : "数组无序";
    }

    /**
     * 测试优化后的归并排序算法(自下而上的非递归实现)
     */
    private void testOptimizedMergeSortBU(T[] array) {
        System.out.println();
        Sort<T> sort = new MergeSortBU<>();
        long timeBeforeSort = System.nanoTime();
        sort.optimizedSort(array);
        long timeUsed = System.nanoTime() - timeBeforeSort;
        System.out.println("优化后的自下而上的非递归实现的的归并排序: " + (timeUsed / 1000000.0f) + "ms");
        System.out.print("数组排序后为: ");
        ArrayUtils.printArray(array, 10);
        assert ArrayUtils.isSorted(array) : "数组无序";
    }

    /**
     * 测试快速排序算法
     */
    private void testQuickSort(T[] array) {
        System.out.println();
        Sort<T> sort = new QuickSort<>();
        long timeBeforeSort = System.nanoTime();
        sort.sort(array);
        long timeUsed = System.nanoTime() - timeBeforeSort;
        System.out.println("快速排序: " + (timeUsed / 1000000.0f) + "ms");
        System.out.print("数组排序后为: ");
        ArrayUtils.printArray(array, 10);
        assert ArrayUtils.isSorted(array) : "数组无序";
    }

    /**
     * 测试优化后的快速排序算法
     */
    private void testOptimizedQuickSort(T[] array) {
        System.out.println();
        Sort<T> sort = new QuickSort<>();
        long timeBeforeSort = System.nanoTime();
        sort.optimizedSort(array);
        long timeUsed = System.nanoTime() - timeBeforeSort;
        System.out.println("优化后的快速排序: " + (timeUsed / 1000000.0f) + "ms");
        System.out.print("数组排序后为: ");
        ArrayUtils.printArray(array, 10);
        assert ArrayUtils.isSorted(array) : "数组无序";
    }

    /**
     * 测试二路快排
     */
    private void testQuickSortTwoWay(T[] array) {
        System.out.println();
        Sort<T> sort = new QuickSortTwoWay<>();
        long timeBeforeSort = System.nanoTime();
        sort.sort(array);
        long timeUsed = System.nanoTime() - timeBeforeSort;
        System.out.println("二路快排: " + (timeUsed / 1000000.0f) + "ms");
        System.out.print("数组排序后为: ");
        ArrayUtils.printArray(array, 10);
        assert ArrayUtils.isSorted(array) : "数组无序";
    }

    /**
     * 测试三路快排
     */
    private void testQuickSortThreeWay(T[] array) {
        System.out.println();
        Sort<T> sort = new QuickSortThreeWay<>();
        long timeBeforeSort = System.nanoTime();
        sort.sort(array);
        long timeUsed = System.nanoTime() - timeBeforeSort;
        System.out.println("三路快排: " + (timeUsed / 1000000.0f) + "ms");
        System.out.print("数组排序后为: ");
        ArrayUtils.printArray(array, 10);
        assert ArrayUtils.isSorted(array) : "数组无序";
    }

    /**
     * 测试堆排序
     */
    private void testHeapSort(T[] array) {
        System.out.println();
        Sort<T> sort = new HeapSort<>();
        long timeBeforeSort = System.nanoTime();
        sort.sort(array);
        long timeUsed = System.nanoTime() - timeBeforeSort;
        System.out.println("堆排序: " + (timeUsed / 1000000.0f) + "ms");
        System.out.print("数组排序后为: ");
        ArrayUtils.printArray(array, 10);
        assert ArrayUtils.isSorted(array) : "数组无序";
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
