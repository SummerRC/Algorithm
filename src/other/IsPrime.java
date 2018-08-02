package other;

/**
 * Created by SummerRC on 18/7/20.
 * Description: 判断一个数是否是素数(只能被1和本身整除的数).
 *      算法思路: 对于一个正整数n, 只需要判断n能否被 2 - 根号n 之间的数整除即可.
 *              例如 101 , 只需判断 2 - 10  之间的数即可.( 10 * 10 < 101).
 *              1 不是素数, 2是素数. 素数又称质数.
 */
public class IsPrime {

    private boolean isPrime(int num) {
        assert (num > 0) : "num 必须大于0";

        if (num == 1) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void testAlgorithm() {
        IsPrime util = new IsPrime();

        System.out.println("101 是否为素数: " + util.isPrime(101));
        System.out.println("102 是否为素数: " + util.isPrime(102));
    }
}
