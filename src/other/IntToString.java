package other;

/**
 * Created by SummerRC on 18/7/20.
 * Description: int 类型数字转字符串
 */
public class IntToString {

    private String intToString(int num) {
        String s = "";
        String symbol = "";     //符号

        //处理0
        if (num == 0) {
            s = "0";
        }

        //对负数作处理
        if (num < 0) {
            symbol += "-";
            num = Math.abs(num);
        }

        //数字转字符串
        while (num != 0) {
            s += (char)('0'  + num % 10);
            num /= 10;

            System.out.println(s);
        }

        //s = new StringBuffer(s).reverse().toString();
        s = reverse(s);
        return symbol + s;
    }

    /**
     * 字符串反转
     */
    private String reverse(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        char[] chars = str.toCharArray();
        str = "";
        for (int i = chars.length; i > 0; i--) {
            str += chars[i - 1];
        }
        return str;
    }

    public static void testAlgorithm() {
        IntToString util = new IntToString();
        System.out.println("带转换的数字为: 1034");
        System.out.println("转换后的字符串为: " + util.intToString(1034));

        System.out.println("带转换的数字为: -1034");
        System.out.println("转换后的字符串为: " + util.intToString(-1034));
    }
}
