package coupon;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CouponService
{
    public Set<Integer> generateUniqueCoupons(int count)
    {

        Set<Integer> coupons = new HashSet<>();
        Random random = new Random();

        while (coupons.size() < count)
        {
            int coupon = 10000 + random.nextInt(90000);
            coupons.add(coupon);
        }
        return coupons;
    }
}
