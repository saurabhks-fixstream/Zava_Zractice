package com.leetcode.javapractice;

class Reader4 {

    static char[] file = new char[] {'a', 'b', 'c'};
    static int idx = 0;

    public static int read4(char[] buf4) {
        int i = 0;
        while (i < 4 && idx < file.length) {
            buf4[i++] = file[idx++];
        }
        return i;
    }
}

public class ReadNCharactersGivenRead4 extends Reader4 {

    public static int read(char[] buf, int n) {
        int copiedChars = 0;
        int readChars = 4;
        char[] buf4 = new char[4];
        while (copiedChars < n && readChars == 4) {
            readChars = read4(buf4);
            for (int i = 0; i < readChars; ++i) {
                if (copiedChars == n) {
                    return copiedChars;
                }
                buf[copiedChars] = buf4[i];
                ++copiedChars;
            }
        }
        return copiedChars;
    }

    public static void main(String[] args) {

        char[] buf = new char[4];
        int length = read(buf, 4);
        System.out.println(new String(buf, 0, length));
    }
}
