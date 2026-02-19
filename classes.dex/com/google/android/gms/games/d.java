package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;

public abstract class d implements Parcelable.Creator {
    public GameEntity a(Parcel parcel0) {
        int v = b.v(parcel0);
        boolean z = false;
        boolean z1 = false;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        String s = null;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        String s5 = null;
        Uri uri0 = null;
        Uri uri1 = null;
        Uri uri2 = null;
        String s6 = null;
        String s7 = null;
        String s8 = null;
        String s9 = null;
        String s10 = null;
        while(parcel0.dataPosition() < v) {
            int v4 = b.o(parcel0);
            int v5 = (char)v4;
            if(v5 == 28) {
                z8 = b.l(parcel0, v4);
            }
            else {
                switch(v5) {
                    case 1: {
                        s = b.e(parcel0, v4);
                        break;
                    }
                    case 2: {
                        s1 = b.e(parcel0, v4);
                        break;
                    }
                    case 3: {
                        s2 = b.e(parcel0, v4);
                        break;
                    }
                    case 4: {
                        s3 = b.e(parcel0, v4);
                        break;
                    }
                    case 5: {
                        s4 = b.e(parcel0, v4);
                        break;
                    }
                    case 6: {
                        s5 = b.e(parcel0, v4);
                        break;
                    }
                    case 7: {
                        uri0 = (Uri)b.d(parcel0, v4, Uri.CREATOR);
                        break;
                    }
                    case 8: {
                        uri1 = (Uri)b.d(parcel0, v4, Uri.CREATOR);
                        break;
                    }
                    case 9: {
                        uri2 = (Uri)b.d(parcel0, v4, Uri.CREATOR);
                        break;
                    }
                    case 10: {
                        z = b.l(parcel0, v4);
                        break;
                    }
                    case 11: {
                        z1 = b.l(parcel0, v4);
                        break;
                    }
                    case 12: {
                        s6 = b.e(parcel0, v4);
                        break;
                    }
                    case 13: {
                        v1 = b.q(parcel0, v4);
                        break;
                    }
                    case 14: {
                        v2 = b.q(parcel0, v4);
                        break;
                    }
                    case 15: {
                        v3 = b.q(parcel0, v4);
                        break;
                    }
                    case 16: {
                        z2 = b.l(parcel0, v4);
                        break;
                    }
                    case 17: {
                        z3 = b.l(parcel0, v4);
                        break;
                    }
                    case 18: {
                        s7 = b.e(parcel0, v4);
                        break;
                    }
                    case 19: {
                        s8 = b.e(parcel0, v4);
                        break;
                    }
                    case 20: {
                        s9 = b.e(parcel0, v4);
                        break;
                    }
                    case 21: {
                        z4 = b.l(parcel0, v4);
                        break;
                    }
                    case 22: {
                        z5 = b.l(parcel0, v4);
                        break;
                    }
                    case 23: {
                        z6 = b.l(parcel0, v4);
                        break;
                    }
                    case 24: {
                        s10 = b.e(parcel0, v4);
                        break;
                    }
                    case 25: {
                        z7 = b.l(parcel0, v4);
                        break;
                    }
                    default: {
                        b.u(parcel0, v4);
                    }
                }
            }
        }
        b.j(parcel0, v);
        return new GameEntity(s, s1, s2, s3, s4, s5, uri0, uri1, uri2, z, z1, s6, v1, v2, v3, z2, z3, s7, s8, s9, z4, z5, z6, s10, z7, z8);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new GameEntity[v];
    }
}

