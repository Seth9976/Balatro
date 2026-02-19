package com.google.android.gms.internal.play_billing;

abstract class d4 {
    static void a(byte b, byte b1, byte b2, byte b3, char[] arr_c, int v) {
        if(d4.e(b1) || (b << 28) + (b1 + 0x70) >> 30 != 0 || d4.e(b2) || d4.e(b3)) {
            throw x1.c();
        }
        int v1 = (b & 7) << 18 | (b1 & 0x3F) << 12 | (b2 & 0x3F) << 6 | b3 & 0x3F;
        arr_c[v] = (char)((v1 >>> 10) + 0xD7C0);
        arr_c[v + 1] = (char)((v1 & 0x3FF) + 0xDC00);
    }

    static void b(byte b, byte b1, byte b2, char[] arr_c, int v) {
        if(!d4.e(b1)) {
            if(b != 0xFFFFFFE0) {
            label_4:
                if(b != -19) {
                label_7:
                    if(!d4.e(b2)) {
                        arr_c[v] = (char)((b & 15) << 12 | (b1 & 0x3F) << 6 | b2 & 0x3F);
                        return;
                    }
                }
                else if(b1 < 0xFFFFFFA0) {
                    b = -19;
                    goto label_7;
                }
            }
            else if(b1 >= 0xFFFFFFA0) {
                b = (byte)0xE0;
                goto label_4;
            }
        }
        throw x1.c();
    }

    static void c(byte b, byte b1, char[] arr_c, int v) {
        if(b < -62 || d4.e(b1)) {
            throw x1.c();
        }
        arr_c[v] = (char)((b & 0x1F) << 6 | b1 & 0x3F);
    }

    static boolean d(byte b) {
        return b >= 0;
    }

    private static boolean e(byte b) {
        return b > -65;
    }
}

