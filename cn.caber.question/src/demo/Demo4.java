package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Demo4 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int len = minSubArrayLen(11, nums);
        System.out.println(len);
    }
    public static int minSubArrayLen(int s, int[] nums) {
        int tmp = 0;
        int count = 0;
        ArrayList<Integer> counts = new ArrayList<>();
        ArrayList<Integer> tmpNum = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (s <= nums[i]) {
                return 1;
            } else {
                tmpNum.add(nums[i]);
                count++;
                tmp += nums[i];
                if (tmp >= s) {
                    int minSum = 0;
                    for (Integer integer : tmpNum) {
                        minSum = tmp - integer;
                        if(minSum>=s){
                            count--;
                        }
                    }
                    counts.add(count);
                    tmp = 0;
                    count = 0;
                }
            }
        }
        System.out.println(counts);
        if(counts.size()>0){
            counts.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return -1;
                }
            });
            System.out.println(counts);
            return counts.get(0);
        }else {
            return 0;
        }

    }
}
