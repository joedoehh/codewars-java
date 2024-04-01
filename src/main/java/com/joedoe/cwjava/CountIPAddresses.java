package com.joedoe.cwjava;

public class CountIPAddresses {

    public static long ipsBetween(String start, String end) {
        return new CountIPAddresses(start, end).solution();
    }

    private final String start;
    private final String end;

    public CountIPAddresses(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public long solution() {
        return convertToLong(end) - convertToLong(start);
    }

    private long convertToLong(String ip) {
        long res = 0;
        for (String s : ip.split("[.]")) {
            res = res * 256 + Long.parseLong(s);
        }
        return res;
    }
}
