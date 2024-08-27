package test1;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: BM22 比较版本号
 * Author: 行空XKong
 * Date: 2024-08-27
 * Time: 17:38
 * Version:
 */
class Solution {
    public int compare(String version1, String version2) {
        // // 方法一（双指针遍历截取）
        // int len1 = version1.length(), len2 = version2.length();
        // int i = 0, j = 0;
        // while (i < len1 || j < len2) {// 处理长度不一致的情况
        //     long num1 = 0;
        //     while (i < len1 && version1.charAt(i) != '.') {
        //         num1 = num1 * 10 + version1.charAt(i) - '0';
        //         ++i;
        //     }
        //     ++i;// 跳过 '.'
        //     long num2 = 0;
        //     while (j < len2 && version2.charAt(j) != '.') {
        //         num2 = num2 * 10 + version2.charAt(j) - '0';
        //         ++j;
        //     }
        //     ++j;// 跳过 '.'
        //     // 每遇到一次 '.' 比较一次
        //     if (num1 > num2) {
        //         return 1;
        //     }
        //     if (num1 < num2) {
        //         return -1;
        //     }
        // }
        // return 0;

        // 方法二（分割截取）
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        int i = 0;
        while (i < strs1.length || i < strs2.length) {// 处理长度不一致的情况
            String str1 = i < strs1.length ? strs1[i] : "0";
            String str2 = i < strs2.length ? strs2[i] : "0";
            long num1 = 0;
            for (int k = 0; k < str1.length(); ++k) {
                num1 = num1 * 10 + str1.charAt(k) - '0';
            }
            long num2 = 0;
            for (int k = 0; k < str2.length(); ++k) {
                num2 = num2 * 10 + str2.charAt(k) - '0';
            }
            System.out.println(num1 + " " + num2);
            if (num1 > num2) {
                return 1;
            }
            if (num1 < num2) {
                return -1;
            }
            ++i;
        }
        return 0;
    }
}
