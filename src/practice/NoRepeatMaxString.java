package practice;

import java.util.HashSet;

/**
 * 无重复字符的最长子串
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class NoRepeatMaxString {
    static int maxString(String text) {
        int n = text.length();
        if (n < 1) {
            return n;
        }
        int r = 1, l = 0, maxSize = 0;
        HashSet<Character> set = new HashSet<>();
        set.add(text.charAt(l));
        while (r < n) {
            //内层循环停止的时候，那么就是滑动窗口右边r滑的时候出现重复值了;
            //这个重复值在l - r之间任何一个数值都可能，此时需要移动左边l了，直到把重复值从左边移出去；
            while (r < n && !set.contains(text.charAt(r))) {
                set.add(text.charAt(r));
                r++;
            }
            //此时需要移动左边l了，直到把重复值从左边移出去
            set.remove(text.charAt(l));
            maxSize = Math.max(maxSize, r - l);
            l++;
        }
        return maxSize;
    }


    public static void main(String[] args) {
        String a = "abcdec";
        System.out.println(maxString(a));
    }
}
