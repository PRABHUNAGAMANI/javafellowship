package coupon;

import java.util.Set;

public class CouponPrinter
{
    public void printCoupons(Set<Integer> coupons)
    {
        System.out.println("GENERATED UNIQUE COUPON NUMBERS");
        for (int coupon : coupons)
        {
            System.out.println(coupon);
        }
    }
}
