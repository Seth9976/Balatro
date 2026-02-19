package com.google.android.datatransport.cct;

import h0.b;
import j0.g;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class a implements g {
    private final String a;
    private final String b;
    static final String c;
    static final String d;
    private static final String e;
    private static final Set f;
    public static final a g;
    public static final a h;

    // 去混淆评级： 低(25)
    static {
        a.c = "https://firebaselogging.googleapis.com/v0cc/log/batch?format=json_proto3";
        a.d = "https://firebaselogging-pa.googleapis.com/v1/firelog/legacy/batchlog";
        a.e = "AIzaSyCckkiH8i2ZARwOs1LEzFKld15aOG8ozKo";
        a.f = Collections.unmodifiableSet(new HashSet(Arrays.asList(new b[]{b.b("proto"), b.b("json")})));
        a.g = new a("https://firebaselogging.googleapis.com/v0cc/log/batch?format=json_proto3", null);
        a.h = new a("https://firebaselogging-pa.googleapis.com/v1/firelog/legacy/batchlog", "AIzaSyCckkiH8i2ZARwOs1LEzFKld15aOG8ozKo");
    }

    public a(String s, String s1) {
        this.a = s;
        this.b = s1;
    }

    @Override  // j0.f
    public byte[] a() {
        return this.d();
    }

    @Override  // j0.g
    public Set b() {
        return a.f;
    }

    @Override  // j0.f
    public String c() {
        return "cct";
    }

    public byte[] d() {
        String s = this.b;
        if(s == null && this.a == null) {
            return null;
        }
        Object[] arr_object = {"1$", this.a, "\\", null};
        if(s == null) {
            s = "";
        }
        arr_object[3] = s;
        return String.format("%s%s%s%s", arr_object).getBytes(Charset.forName("UTF-8"));
    }

    public static a e(byte[] arr_b) {
        String s = new String(arr_b, Charset.forName("UTF-8"));
        if(!s.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] arr_s = s.substring(2).split("\\Q\\\\E", 2);
        if(arr_s.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String s1 = arr_s[0];
        if(s1.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String s2 = arr_s[1];
        if(s2.isEmpty()) {
            s2 = null;
        }
        return new a(s1, s2);
    }

    public String f() {
        return this.b;
    }

    public String g() {
        return this.a;
    }
}

