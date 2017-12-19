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
    private String address = "";

    public Camera(int cameraNum) {
        address = "/dev/video" + cameraNum;
    }

    public Camera(String path) {
        address = path;
    }

    public void open() {
        if (!address.isEmpty()) {
            handle = Jv4l2JNI.open(address);
        }
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
