package com.crackingthecodinginterview.javapractice;

public class URLify {

    public static String replaceSpaces(String str, int trueLength) {
        char[] schar = str.toCharArray();
        int spaces = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str.charAt(i) == ' ') {
                spaces++;
            }
        }
        int index = trueLength + spaces * 2;
        for (int i = trueLength - 1; i >= 0; i--) {
            if (schar[i] == ' ') {
                schar[index - 1] = '0';
                schar[index - 2] = '2';
                schar[index - 3] = '%';
                index -= 3;
            } else {
                schar[index - 1] = schar[i];
                index--;
            }
        }
        str = new String(schar);
        return str;
    }

    public static void main(String[] args) {

        String str = "Mr John Smith    ";
        int trueLength = 13;
        System.out.println(replaceSpaces(str, trueLength));
    }
}
