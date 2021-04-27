

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author hewei
 */
public class Solution {
    static int findLastEqual(int[] array, int key) {
        System.out.println("aa");
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] <= key) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        if (right >= 0 && array[right] == key) {
            return right;
        }
        return -1;
    }
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
        //flag为false 长度之和为奇数
        boolean flag = false;
        if (length1>length2){
            return findMedianSortedArrays(nums2,nums1);
        }
        int aver = (length1+length2)/2;
        if ((length1+length2)%2==0){
            flag = true;
        }
        if (length1==1){
            if (length1==length2){
                return (nums1[0]+nums2[0])/2.0;
            }
            for (int i = length2/2; i < length2;) {
                if (nums2[i]>nums1[0]&&nums2[0]<nums1[0]){

                }
            }
        }
        //考虑nums1中数全部小于nums2的情况
        if (nums1[length1-1]<=nums2[0]){
            if (flag){
                return (nums2[aver-length1]+nums2[aver-length1-1])/2;
            }
            return nums2[aver-length1];
        }
        //考虑nums2中数全部小于nums1的情况
        if (nums2[length2-1]<=nums1[0]){
            if (flag){
                return (nums2[aver]+nums2[aver-1])/2;
            }
            return nums2[aver];
        }

        int i;
        for (i = length1/2; i < length1;) {
            if (nums1[i]>nums2[aver-i]){
                //改用二分查找
                i=i/2;
                continue;
            }
            if (nums2[aver-i-1]>nums1[i+1]){
                //改用二分查找
                i++;
                continue;
            }
            break;
        }
        if (flag){
            return (nums1[i]+nums2[aver-i])/2.0;
        }
        return Math.max(nums1[i],nums2[aver-i-1]);
    }
    public static void main(String[] args) {

        int[] b={1,5,6,7,7,7,7,8,9,10,12};
        System.out.println(Solution.findLastEqual(b, 7));
        Solution solution = new Solution();
        int[] arr2 = {1,3};
        int[] arr1 = {2};
        System.err.println(solution.findMedianSortedArrays(arr2,arr1));
    }
}
