package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;
import p1.i0;
import p1.o;
import p1.s;
import r1.a;

public abstract class f implements Parcelable.Creator {
    public PlayerEntity a(Parcel parcel0) {
        int v = b.v(parcel0);
        String s = null;
        String s1 = null;
        Uri uri0 = null;
        Uri uri1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        a a0 = null;
        o o0 = null;
        String s5 = null;
        String s6 = null;
        Uri uri2 = null;
        String s7 = null;
        Uri uri3 = null;
        String s8 = null;
        i0 i00 = null;
        s s9 = null;
        String s10 = null;
        int v1 = 0;
        boolean z = false;
        boolean z1 = false;
        boolean z2 = false;
        long v2 = -1L;
        long v3 = 0L;
        long v4 = 0L;
        while(parcel0.dataPosition() < v) {
            int v5 = b.o(parcel0);
            switch(((char)v5)) {
                case 1: {
                    s = b.e(parcel0, v5);
                    break;
                }
                case 2: {
                    s1 = b.e(parcel0, v5);
                    break;
                }
                case 3: {
                    uri0 = (Uri)b.d(parcel0, v5, Uri.CREATOR);
                    break;
                }
                case 4: {
                    uri1 = (Uri)b.d(parcel0, v5, Uri.CREATOR);
                    break;
                }
                case 5: {
                    v3 = b.r(parcel0, v5);
                    break;
                }
                case 6: {
                    v1 = b.q(parcel0, v5);
                    break;
                }
                case 7: {
                    v4 = b.r(parcel0, v5);
                    break;
                }
                case 8: {
                    s2 = b.e(parcel0, v5);
                    break;
                }
                case 9: {
                    s3 = b.e(parcel0, v5);
                    break;
                }
                case 14: {
                    s4 = b.e(parcel0, v5);
                    break;
                }
                case 15: {
                    a0 = (a)b.d(parcel0, v5, a.CREATOR);
                    break;
                }
                case 16: {
                    o0 = (o)b.d(parcel0, v5, o.CREATOR);
                    break;
                }
                case 18: {
                    z = b.l(parcel0, v5);
                    break;
                }
                case 19: {
                    z1 = b.l(parcel0, v5);
                    break;
                }
                case 20: {
                    s5 = b.e(parcel0, v5);
                    break;
                }
                case 21: {
                    s6 = b.e(parcel0, v5);
                    break;
                }
                case 22: {
                    uri2 = (Uri)b.d(parcel0, v5, Uri.CREATOR);
                    break;
                }
                case 23: {
                    s7 = b.e(parcel0, v5);
                    break;
                }
                case 24: {
                    uri3 = (Uri)b.d(parcel0, v5, Uri.CREATOR);
                    break;
                }
                case 25: {
                    s8 = b.e(parcel0, v5);
                    break;
                }
                case 29: {
                    v2 = b.r(parcel0, v5);
                    break;
                }
                case 33: {
                    i00 = (i0)b.d(parcel0, v5, i0.CREATOR);
                    break;
                }
                case 35: {
                    s9 = (s)b.d(parcel0, v5, s.CREATOR);
                    break;
                }
                case 36: {
                    z2 = b.l(parcel0, v5);
                    break;
                }
                case 37: {
                    s10 = b.e(parcel0, v5);
                    break;
                }
                default: {
                    b.u(parcel0, v5);
                }
            }
        }
        b.j(parcel0, v);
        return new PlayerEntity(s, s1, uri0, uri1, v3, v1, v4, s2, s3, s4, a0, o0, z, z1, s5, s6, uri2, s7, uri3, s8, v2, i00, s9, z2, s10);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new PlayerEntity[v];
    }
}

