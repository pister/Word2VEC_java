package com.ansj.vec.util;

import junit.framework.TestCase;

import java.io.*;

/**
 * User: huangsongli
 * Date: 16/1/18
 * Time: 下午4:38
 */
public class CodeTransformUtil extends TestCase {

    private static final int BUF_SIZE = 1024;

    public void testTransform() throws IOException {
        String f1 = "/Users/huangsongli/Downloads/199801(人民日报语料).txt";
        String f2 = "/Users/huangsongli/Downloads/1998_out.txt";
        gbk2utf8(f1, f2);
    }

    public static void gbk2utf8(String f1, String f2) throws IOException {
        FileInputStream fis = new FileInputStream(f1);
        InputStreamReader reader = new InputStreamReader(fis, "gbk");
        char[] buf = new char[BUF_SIZE];
        Writer out = new FileWriter(f2);
        while (true) {
            int len = reader.read(buf, 0, BUF_SIZE);
            if (len < 0) {
                break;
            }
            String raw = new String(buf, 0, len);
            String result = new String(raw.getBytes("utf-8"), "gbk");
            out.write(result);
        }
        fis.close();
        out.close();
    }

}
