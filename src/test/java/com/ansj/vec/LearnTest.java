package com.ansj.vec;

import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;

/**
 * User: huangsongli
 * Date: 16/1/18
 * Time: 上午11:38
 */
public class LearnTest extends TestCase {

    public void testLearn() throws IOException {
        String path = "/Users/huangsongli/temp/learn/out.txt";
        String input = "/Users/huangsongli/work/open-source/third-projects/Word2VEC_java/src/test/resources/text8";
        Learn learn = new Learn();
        long start = System.currentTimeMillis() ;
        learn.learnFile(new File(input));
        System.out.println("use time "+(System.currentTimeMillis()-start));
        learn.saveModel(new File(path));

    }

}
