import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Random;

public class HashTest {
    GeneralHashFunctionLibrary generalHashFunctionLibrary = new GeneralHashFunctionLibrary();
    String testKye = "123";

    @Test
    public void test() {
        Random random = new Random();
        long l = System.currentTimeMillis();
        double sum = 0;
//        int[] APHash = new int[32];

//        for (int i = 0; i < 10000000; i++) {
//            APHash[mod(generalHashFunctionLibrary.APHash(RandomStringUtils.random(random.nextInt(99))), 32)]++;
//        }
//        System.out.println("APHash time " + ( System.currentTimeMillis() - l) / 1000 + "s");
//
//        for (int num : APHash) {
//            double mul = mul(div(num, 10000000), 100);
//            sum += mul;
//            System.out.println(mul + "%");
//        }
//        System.out.println("总和：" + sum);
//        int[] BKDRHash = new int[32];
//        l = System.currentTimeMillis();
//        for (int i = 0; i < 10000000; i++) {
//            BKDRHash[mod(generalHashFunctionLibrary.BKDRHash(RandomStringUtils.random(random.nextInt(99))), 32)]++;
//        }
//        System.out.println("BKDRHash time " + ( System.currentTimeMillis() - l) / 1000 + "s");
//        sum = 0;
//        for (int num : BKDRHash) {
//            double mul = mul(div(num, 10000000), 100);
//            sum += mul;
//            System.out.println(mul + "%");
//        }
//        System.out.println("总和：" + sum);
//        int[] BPHash = new int[32];
//        l = System.currentTimeMillis();
//        for (int i = 0; i < 10000000; i++) {
//            BPHash[mod(generalHashFunctionLibrary.BPHash(RandomStringUtils.random(random.nextInt(99))), 32)]++;
//        }
//        System.out.println("BPHash time " + ( System.currentTimeMillis() - l) / 1000 + "s");
//        sum = 0;
//        for (int num : BPHash) {
//            double mul = mul(div(num, 10000000), 100);
//            sum += mul;
//            System.out.println(mul + "%");
//        }
//        System.out.println("总和：" + sum);
//        int[] DEKHash = new int[32];
//        l = System.currentTimeMillis();
//        for (int i = 0; i < 10000000; i++) {
//            DEKHash[mod(generalHashFunctionLibrary.DEKHash(RandomStringUtils.random(random.nextInt(99))), 32)]++;
//        }
//        System.out.println("DEKHash time " + ( System.currentTimeMillis() - l) / 1000 + "s");
//        sum = 0;
//        for (int num : DEKHash) {
//            double mul = mul(div(num, 10000000), 100);
//            sum += mul;
//            System.out.println(mul + "%");
//        }
//        System.out.println("总和：" + sum);
        int[] FNVHashPro = new int[32];
        l = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            FNVHashPro[mod(generalHashFunctionLibrary.FNVHashPro(RandomStringUtils.random(random.nextInt(99))), 32)]++;
        }
        System.out.println("FNVHashPro time " + ( System.currentTimeMillis() - l) / 1000 + "s");
        sum = 0;
        for (int num : FNVHashPro) {
            double mul = mul(div(num, 10000000), 100);
            sum += mul;
            System.out.println(mul + "%");
        }
        System.out.println("总和：" + sum);
        int[] FNVHash = new int[32];
        l = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            FNVHash[mod(generalHashFunctionLibrary.FNVHash(RandomStringUtils.random(random.nextInt(99))), 32)]++;
        }
        System.out.println("DEKHash time " + ( System.currentTimeMillis() - l) / 1000 + "s");
        sum = 0;
        for (int num : FNVHash) {
            double mul = mul(div(num, 10000000), 100);
            sum += mul;
            System.out.println(mul + "%");
        }
        System.out.println("总和：" + sum);
    }
    //默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;
    //构造器私有化，让这个类不能实例化

    //提供精确的加法运算
    public static double add(double v1, double v2)
    {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.add(b2).doubleValue();
    }
    //精确的减法运算
    public static double sub(double v1, double v2)
    {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.subtract(b2).doubleValue();
    }
    //精确的乘法运算
    public static double mul(double v1, double v2)
    {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.multiply(b2).doubleValue();
    }
    //提供（相对）精确的除法运算，当发生除不尽的情况时
    //精确到小数点后10位的数字四舍五入
    public static double div(double v1, double v2)
    {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.divide(b2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static int mod(long a, long b) {
       return (int) (a&(b-1));
    }

}
