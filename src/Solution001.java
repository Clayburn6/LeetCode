/*

给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。

示例 2：
输入: "cbbd"
输出: "bb"
 */

public class Solution001 {
    public String longestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        String ss = sb.reverse().toString();
        int len = s.length();
        // 转变成求s 和 ss 的最长公共子串
        // array[i][j]表示以s[i-1]、ss[j-1]结尾的最长子串的长度
        // 如果 s[i+1] == s[j+1] 那么 array[i+1][j+1] = array[i][j] + 1
        int[][] array = new int[len + 1][len + 1];

        int maxValueLength = 0;
        int maxValueI = 0;
        int maxValueJ = 0;

        for (int i = 0; i < len; i ++) {
            for (int j = 0; j < len; j ++) {
                if (s.charAt(i) == ss.charAt(j)) {
                    array[i+1][j+1] = array[i][j] + 1;
                    if (i != j && array[i+1][j+1] > maxValueLength) {
                        maxValueLength = array[i+1][j+1];
                        maxValueI = i;
                        maxValueJ = j;
                    }
                }
            }
        }

        return s.substring(maxValueI - maxValueLength + 1, maxValueI + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution001().longestPalindrome("aacdefcaa"));
    }
}
