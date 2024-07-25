package example;

import java.util.HashSet;

public class NoRepeatString {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }
        int l = 0, r = 1;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(l));
        int res = 0;
        while (r < n) {
            while (r < n && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }
            res = Math.max(res, r - l);
            set.remove(s.charAt(l));
            l++;
        }
        return res;
    }
}
