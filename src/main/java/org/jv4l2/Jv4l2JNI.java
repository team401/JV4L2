package org.jv4l2;
/*
 * JV4L2 - Created on 10/21/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 10/21/17
 */
public class Jv4l2JNI {
    static {
        System.loadLibrary("JV4L2");
    }

    static native int open(String address);
    static native void close(int handle);
    static native int setProperty(int handle, int property, int value);
}
