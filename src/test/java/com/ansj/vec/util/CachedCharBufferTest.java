package com.ansj.vec.util;

import junit.framework.TestCase;

/**
 * User: huangsongli
 * Date: 16/1/18
 * Time: 下午3:15
 */
public class CachedCharBufferTest extends TestCase {

    public void testGetString() {
        CachedCharBuffer cachedCharBuffer = new CachedCharBuffer(8);
        for (int i = 'a'; i <= 'z'; ++i) {
            cachedCharBuffer.append((char)i);
        }
        System.out.println(cachedCharBuffer.getString());
        cachedCharBuffer.reset();
        for (int i = '0'; i <= '9'; ++i) {
            cachedCharBuffer.append((char)i);
        }
        System.out.println(cachedCharBuffer.getString());
    }

}
