//
// Created by cameronearle on 12/19/17.
//

#include <jni.h>

#include <libv4l2.h>
#include <linux/videodev2.h>
#include <fcntl.h>
#include <time.h>

#include "org_jv4l2_Jv4l2JNI.h"

JNIEXPORT jint JNICALL Java_org_jv4l2_Jv4l2JNI_open(JNIEnv *env, jclass clazz, jstring address) {
    const char *addr = (*env)->GetStringUTFChars(env, address, 0);
    int result = v4l2_open(addr, O_RDWR);
    (*env)->ReleaseStringUTFChars(env, address, addr);
    return result;
}

JNIEXPORT void JNICALL Java_org_jv4l2_Jv4l2JNI_close(JNIEnv *env, jclass clazz, jint handle) {
    v4l2_close(handle);
}

JNIEXPORT jint JNICALL Java_org_jv4l2_Jv4l2JNI_setProperty(JNIEnv *env, jclass clazz, jint handle, jint property, jint value) {
    struct v4l2_control c;
    c.id = (unsigned int) property;
    c.value = value;
    return v4l2_ioctl(handle, VIDIOC_S_CTRL, &c);
}