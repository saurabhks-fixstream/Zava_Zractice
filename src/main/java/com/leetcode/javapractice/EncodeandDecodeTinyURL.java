package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

class TinyURLCodec {
    List<String> urls = new ArrayList<String>();

    public String encode(String longUrl) {
        urls.add(longUrl);
        return String.valueOf(urls.size() - 1);
    }

    public String decode(String shortUrl) {
        int index = Integer.valueOf(shortUrl);
        return (index < urls.size()) ? urls.get(index) : "";
    }
}

public class EncodeandDecodeTinyURL {

    public static void main(String[] args) {

        TinyURLCodec codec = new TinyURLCodec();
        String encode = codec.encode("https://leetcode.com/problems/design-tinyurl");
        System.out.println(encode);
        String decode = codec.decode(encode);
        System.out.println(decode);
    }
}
