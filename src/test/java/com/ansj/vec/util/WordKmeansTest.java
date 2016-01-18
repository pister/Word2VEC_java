package com.ansj.vec.util;

import com.ansj.vec.Word2VEC;
import junit.framework.TestCase;

import java.io.IOException;

/**
 * User: huangsongli
 * Date: 16/1/18
 * Time: 上午11:30
 */
public class WordKmeansTest extends TestCase {

    public void testWordKmeans() throws IOException {
        Word2VEC vec = new Word2VEC();
        vec.loadGoogleModel("vectors.bin");
        System.out.println("load model ok!");
        WordKmeans wordKmeans = new WordKmeans(vec.getWordMap(), 50, 50);
        WordKmeans.Classes[] explain = wordKmeans.explain();

        for (int i = 0; i < explain.length; i++) {
            System.out.println("--------" + i + "---------");
            System.out.println(explain[i].getTop(10));
        }

    }

}
