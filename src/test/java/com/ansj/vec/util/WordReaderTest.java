package com.ansj.vec.util;

import junit.framework.TestCase;

import java.io.StringReader;

/**
 * User: huangsongli
 * Date: 16/1/18
 * Time: 下午3:23
 */
public class WordReaderTest extends TestCase {

    public void testReadNext() throws Exception {
        WordReader wordReader = new WordReader(new StringReader("hello world, I am Pister!\n what's your name? haha    jack"));
        String word;
        while ((word = wordReader.readNext()) != null) {
            System.out.println(word);
        }
        wordReader.close();
    }
}
