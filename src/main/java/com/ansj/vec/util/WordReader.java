package com.ansj.vec.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * User: huangsongli
 * Date: 16/1/18
 * Time: 下午2:53
 */
public class WordReader implements Closeable {

    private Reader reader;
    private Set<Character> stopTokens = new HashSet<Character>(
            Arrays.asList(' ', '\t', '\r', '\n', ',', '.', '?', '_', '\'',
                        '"', '>', '<', '|', '\\', '/', ':', ';', '@',
                            '!', '#', '$', '%', '&', '*', '(', ')',
                        '-', '+', '=', '[', ']', '{', '}', '`', '~'));
    private CachedCharBuffer charBuffer = new CachedCharBuffer(16);
    private CharStatus status = CharStatus.NEXT;

    public WordReader(Reader reader) {
        this.reader = reader;
    }

    public String readNext() throws IOException {
        if (status == CharStatus.END) {
            return null;
        }
        while (true) {
            while (status == CharStatus.NEXT) {
                int intValue = reader.read();
                if (intValue < 0) {
                    status = CharStatus.END;
                    break;
                }
                char c = (char) intValue;
                if (stopTokens.contains(c)) {
                    status = CharStatus.STOP;
                    break;
                }
                charBuffer.append(c);
            }
            int strLength = charBuffer.length();
            String token = charBuffer.getString();
            token = token.trim();
            charBuffer.reset();
            if (status == CharStatus.END) {
                return token;
            }
            status = CharStatus.NEXT;
            if (strLength > 0) {
                return token;
            }
        }
    }

    public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }

    private static enum CharStatus {
        NEXT,
        STOP,
        END;
    }


}
