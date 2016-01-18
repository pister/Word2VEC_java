package com.ansj.vec.util;

/**
 * User: huangsongli
 * Date: 16/1/18
 * Time: 下午3:08
 */
public class CachedCharBuffer {

    private char[] buf;

    private int pos = 0;

    public CachedCharBuffer(int initialCap) {
        if (initialCap < 0) {
            throw new IllegalArgumentException();
        }
        this.buf = new char[initialCap];
    }

    public CachedCharBuffer() {
        this(16);
    }

    public void reset() {
        this.pos = 0;
    }

    public int length() {
        return pos;
    }

    public String getString() {
        return new String(buf, 0, pos);
    }

    public void append(char c) {
        if (pos >= buf.length) {
            resize();
        }
        buf[pos++] = c;
    }

    private void resize() {
        final int nSize = nextSize();
        char[] newBuf = new char[nSize];
        System.arraycopy(buf, 0, newBuf, 0, pos);
        buf = newBuf;
    }

    private int nextSize() {
        final int len = buf.length;
        if (len < 8) {
            return 16;
        }
        if (len < 16) {
            return 32;
        }
        if (len < 32) {
            return 64;
        }
        if (len < 64) {
            return 128;
        }
        if (len < 128) {
            return 256;
        }
        if (len < 256) {
            return 512;
        }
        if (len < 512) {
            return 1024;
        }
        return len * 2 + 512;
    }


}
