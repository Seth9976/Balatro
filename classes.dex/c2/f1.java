package c2;

import g1.j;

public abstract class f1 {
    private static final j a;

    static {
        f1.a = new j("Games");
    }

    public static void a(String s, String s1) {
        String s2 = f1.i(s);
        f1.a.b(s2, s1);
    }

    public static void b(String s, String s1, Throwable throwable0) {
        f1.a.c("PlayGamesServices[GamesApiManager]", "Authentication task failed", throwable0);
    }

    public static void c(String s, String s1) {
        f1.a.d(f1.i(s), s1);
    }

    public static void d(String s, String s1, Throwable throwable0) {
        f1.a.e(f1.i(s), s1, throwable0);
    }

    public static void e(String s, String s1, Throwable throwable0) {
        f1.a.f("PlayGamesServices[SnapshotContentsEntity]", "Failed to write snapshot data", throwable0);
    }

    public static void f(String s, String s1) {
        f1.a.g(f1.i(s), s1);
    }

    public static void g(String s, String s1) {
        f1.a.h(f1.i(s), s1);
    }

    public static void h(String s, String s1, Throwable throwable0) {
        f1.a.i(f1.i(s), s1, throwable0);
    }

    private static String i(String s) [...] // 潜在的解密器
}

