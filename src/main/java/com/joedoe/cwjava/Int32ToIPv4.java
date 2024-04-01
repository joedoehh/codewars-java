package com.joedoe.cwjava;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Int32ToIPv4 {

    private final long input;

    public Int32ToIPv4(long input) {
        this.input = input;
    }

    public String solution() {
        try {
            return InetAddress.getByName(String.valueOf(input)).getHostAddress();
        } catch (UnknownHostException e) {
            return "0.0.0.0";
        }
    }

    public static String longToIP(long ip) {
        return new Int32ToIPv4(ip).solution();
    }

}