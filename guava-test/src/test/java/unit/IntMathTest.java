package unit;

import com.google.common.math.IntMath;
import org.junit.Test;

import java.math.BigInteger;
import java.math.RoundingMode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class IntMathTest {
    @Test
    public void mathTest() {
        //jdk也提供了类似的方法,只不过需要二次取值
        //二项式系数,n为底数,n<k illegalArgumentException
        System.out.println("返回的二项式系数为:"+IntMath.binomial(5, 1));
        //阶乘
        System.err.println("3的阶乘为:"+IntMath.factorial(3));
        System.out.println("2+3="+IntMath.checkedAdd(2, 3));
        //乘法
        System.err.println("2*3="+IntMath.checkedMultiply(2, 3));
        //返回b的k次幂
        System.out.println("2的3次幂为:"+IntMath.checkedPow(2, 3));
        System.err.println("3-4="+IntMath.checkedSubtract(3, 4));
        //RoundingMode常用的有7种，
        // UP是指总是取整离他最近的整数的最大值；DOWN是指总是取整离他最近的整数的最小值；
        // CEILING是指在趋向正无穷的方向上取离他最近的整数；FLOOR是指在趋向负无穷方向上取离他最近的整数；
        // HALF_UP是四舍五入取整数，如果出现0.5的小数，就向上取整；HALF_DOWN是四舍五入取整数，如果出现0.5的小数，就向下取整；
        // HALF_EVEN是四舍五入取整数，如果出现0.5的小数，就向着偶数的方向取整。
        assertThat(IntMath.divide(6, 12, RoundingMode.HALF_EVEN),equalTo(0));
        //返回最大公约数
        System.out.println("返回的最大公约数为:"+IntMath.gcd(6, 12));
        System.err.println("8是2的整数次幂:"+IntMath.isPowerOfTwo(8));
        System.out.println("log10(100)="+IntMath.log10(100, RoundingMode.HALF_UP));
        System.err.println("log2(8)="+IntMath.log2(8, RoundingMode.HALF_EVEN));
        System.out.println("6和-3的算术平均值(取整):"+IntMath.mean(6, -3));
        //返回x%m,m必须>0
        System.err.println("3%4="+IntMath.mod(3, 4));
        System.out.println("2的3次幂为:"+IntMath.pow(2, 3));
        System.err.println(IntMath.sqrt(8, RoundingMode.FLOOR));
    }
}
