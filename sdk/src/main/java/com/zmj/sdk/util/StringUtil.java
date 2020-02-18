package com.zmj.sdk.util;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2020/2/18
 * Description :
 */
public class StringUtil {

    static {
        System.loadLibrary("native-lib");
    }

    public static String ndkString(){
        return getStringNDK();
    }

    private static native String getStringNDK();
}
