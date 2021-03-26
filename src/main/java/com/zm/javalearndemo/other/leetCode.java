package com.zm.javalearndemo.other;

import org.junit.Test;

/**
 * @Tile: NTS20110100148  广州一体化项目Oracle环境测试、问题修复
 * @Author: xiaoping.duan 医保研发5部 CN32219
 * @Date 2021/2/18
 */
public class leetCode {
    // 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
    //
    //比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
    //
    //P   A   H   N
    //A P L S I I G
    //Y   I   R

    // 输入：s = "PAYPALISHIRING", numRows = 4
    //输出："PINALSIGYAHRPI"
    //解释：
    //P     I    N
    //A   L S  I G
    //Y A   H R
    //P     I

    @Test
    public void arrangeZ() {
        int rows = 3;
        char[][] arr = new char[rows][20];
        int col = 0;
        int row = 0;
        String s = "ABCDEFGHIJKLMNOPQ";
        int charCount = 0;
        System.out.println(s.length());
        while (charCount < s.length()) {
            if (col % rows == 0 && row < rows-1) {
                arr[row++][col] = s.charAt(charCount++);
            }else if (row == rows - 1 || col % rows != 0) {
                arr[row--][col++] = s.charAt(charCount++);
            }else {
                arr[row++][col++] = s.charAt(charCount++);
            }
        }

        for (row = 0; row < rows; row++) {
            for (col = 0; col < arr[row].length; col++){
                System.out.println(arr[row][col]);
            }
            System.out.println();
        }
    }
}
