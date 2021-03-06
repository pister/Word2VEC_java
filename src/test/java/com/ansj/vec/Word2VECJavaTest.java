package com.ansj.vec;

import junit.framework.TestCase;

import java.io.IOException;
import java.util.Arrays;

/**
 * User: huangsongli
 * Date: 16/1/18
 * Time: 上午11:33
 */
public class Word2VECJavaTest extends TestCase {

    public void testWord2Vec() throws IOException {
        Word2VEC vec = new Word2VEC();
        String path = "/Users/huangsongli/work/open-source/resources/nlp/news2_out_java.bin";
        vec.loadJavaModel(path);

         System.out.println("中国" + "\t" +
         Arrays.toString(vec.getWordVector("中国")));
        // ;
         System.out.println("毛泽东" + "\t" +
         Arrays.toString(vec.getWordVector("毛泽东")));
        // ;
         System.out.println("足球" + "\t" +
         Arrays.toString(vec.getWordVector("足球")));

        // Word2VEC vec2 = new Word2VEC();
        // vec2.loadGoogleModel("library/vectors.bin") ;
        //
        //
        String str = "美国";
        System.out.println(vec.distance(str));
        System.out.println(Arrays.toString(vec.getWordVector(str)));
        // System.out.println(vec2.distance(str));
        //
        //
        // //男人 国王 女人
        System.out.println(vec.analogy("邓小平", "毛泽东思想", "毛泽东"));
        System.out.println(vec.analogy("毛泽东", "毛泽东思想", "邓小平"));
    }

}
