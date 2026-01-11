package coupon;

import java.util.Set;

public class CouponApp
{
    public static void main(String[] args)
    {

        CouponService service = new CouponService();
        CouponPrinter printer = new CouponPrinter();

        Set<Integer> coupons = service.generateUniqueCoupons(10);
        printer.printCoupons(coupons);
    }
}
