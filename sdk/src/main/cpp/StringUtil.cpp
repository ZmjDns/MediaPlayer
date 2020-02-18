#include <jni.h>
#include <stdlib.h>
#include <iostream>

using namespace std;

extern "C"
JNIEXPORT jstring
JNICALL
Java_com_zmj_sdk_util_StringUtil_getStringNDK(JNIEnv *env,jobject instance)
{
    string result = "Hello from NDK";
    return env->NewStringUTF(result.c_str());
}


