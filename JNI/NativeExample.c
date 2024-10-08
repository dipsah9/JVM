// JNI/NativeExample.c
#include <jni.h>
#include "JNI_NativeExample.h"

// Implement the native method
JNIEXPORT jint JNICALL Java_NativeExample_add(JNIEnv *env, jobject obj, jint a, jint b) {
    return a + b; // Return the sum
}
