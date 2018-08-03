package base.quarterFourth;

import utils.ArrayUtils;

import java.lang.reflect.Array;

/**
 * Created by SummerRC on 2018/8/3.
 * Description: 最大堆
 */
public class MaxHeap<T extends Comparable<? super T>> {
    private T[] mData;      //存储堆节点元素的数组（从1开始计数）
    private int mCapacity;  //堆的容量
    private int mCount;     //堆中元素的个数

    /**
     * @param capacity      堆的容量
     * @param type          具体数据类型
     */
    @SuppressWarnings("unchecked")
    public MaxHeap(int capacity, Class<T> type) {
        mCapacity = capacity;
        mData = (T[]) Array.newInstance(type, mCapacity + 1);
        mCount = 0;
    }

    /**
     * 向堆中添加一个元素
     */
    public void insert(T v) {
        assert mCount < mCapacity : "堆可插入的元素个数大于堆的容量";
        mCount++;
        mData[mCount] = v;
        shiftUp(mCount);
    }

    /**
     * 提取最大值
     */
    public T extractMax() {
        assert mCount > 0 : "堆为空!";
        T max = mData[1];
        mData[1] = mData[mCount];
        mCount--;
        shiftDown(1);
        return max;
    }


    /**
     * 将mData[k]尝试向上移动来维持堆的结构
     */
    private void shiftUp(int k) {
        while (k>1 && mData[k].compareTo(mData[k/2]) > 0) {
            ArrayUtils.swap(mData, k, k/2);
            k = k / 2;
        }
    }

    /**
     * 将mData[k]尝试向下移动来维持堆的结构
     */
    private void shiftDown(int k) {
        if (k < 1) {
            return;
        }
        while ((2*k<=mCount && mData[k].compareTo(mData[2*k])<0) || 2*k+1<=mCount && mData[k].compareTo(mData[2*k+1])<0) {
            if (2*k+1<=mCount && mData[2*k].compareTo(mData[2*k+1]) < 0) {
                ArrayUtils.swap(mData, k, 2*k+1);
                k = 2 * k + 1;
            } else {
                ArrayUtils.swap(mData, k, 2*k);
                k = 2 * k;
            }
        }
    }

    /**
     * @return  返回堆中元素的个数
     */
    public int size() {
        return mCount;
    }

    /**
     * @return  堆是否为空
     */
    public boolean isEmpty() {
        return mCount == 0;
    }

    /**
     * 获取堆的深度
     */
    private int getHeight() {
        int h = 1;
        for (int i=mCount; i>1; i=i/2) {
            h++;
        }
        return h;
    }

    /**
     * 打印出堆，未完成
     */
    public void printLn() {
        for (int i=1; i<=mCount; i++) {
            System.out.print(" " + mData[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)  {
        MaxHeap<Integer> heap = new MaxHeap<>(10, Integer.class);
        System.out.println("测试向堆中插入元素: ");
        for (int i=1; i<=10; i++) {
            heap.insert(i);
            heap.printLn();
        }
        System.out.println("测试向堆中提取元素: ");
        for (int i=1; i<=10; i++) {
            System.out.println("extractMax: " + heap.extractMax());
            heap.printLn();
        }
    }
}
