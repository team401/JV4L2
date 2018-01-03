package org.jv4l2;/*
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
public class Camera {
    private int handle = -1;

    public void open(String address) {
        if (address != null) {
            handle = Jv4l2JNI.open(address);
        } else {
            throw new IllegalArgumentException("'address' cannot be null!");
        }
    }

    public void open(int id) {
        handle = Jv4l2JNI.open("/dev/video" + id);
    }

    public int setProperty(int property, int value) {
        if (handle >= 0) {
            return Jv4l2JNI.setProperty(handle, property, value);
        }
        return -1;
    }

    public void close() {
        Jv4l2JNI.close(handle);
    }
}
