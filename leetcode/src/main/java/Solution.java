import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.primitives.Ints;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author hewei
 */
public class Solution {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0,len = nums.length ; i < len; i++) {
            int s = target -nums[i];
            if (map.containsKey(s)){
                return  new int[]{map.get(s),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    /**
     * 3. 无重复字符的最长子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0,j=0; j < s.length();j++) {
            boolean contains = set.contains(s.charAt(j));
            if (contains){
                maxLen = Math.max(j-i,maxLen);
                set.remove(s.charAt(i++));
                j--;
            }else {
                set.add(s.charAt(j));
            }
            maxLen = Math.max(j-i+1,maxLen);
        }
        return maxLen;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        int aver = (length1+length2)/2;
        int i=1,j;
        for (;i<aver;i++){
            if (nums1[i]<=nums2[aver-i]){

            }

        }
        return 1;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.lengthOfLongestSubstring("abcabcbb"));

    }
}
