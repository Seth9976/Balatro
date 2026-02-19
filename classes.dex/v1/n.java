package v1;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import h1.b;

public final class n implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        GameEntity gameEntity0 = null;
        PlayerEntity playerEntity0 = null;
        String s = null;
        Uri uri0 = null;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        String s5 = null;
        long v1 = 0L;
        long v2 = 0L;
        long v3 = 0L;
        boolean z = false;
        float f = 0.0f;
        while(parcel0.dataPosition() < v) {
            int v4 = b.o(parcel0);
            switch(((char)v4)) {
                case 1: {
                    gameEntity0 = (GameEntity)b.d(parcel0, v4, GameEntity.CREATOR);
                    break;
                }
                case 2: {
                    playerEntity0 = (PlayerEntity)b.d(parcel0, v4, PlayerEntity.CREATOR);
                    break;
                }
                case 3: {
                    s = b.e(parcel0, v4);
                    break;
                }
                case 5: {
                    uri0 = (Uri)b.d(parcel0, v4, Uri.CREATOR);
                    break;
                }
                case 6: {
                    s1 = b.e(parcel0, v4);
                    break;
                }
                case 7: {
                    s2 = b.e(parcel0, v4);
                    break;
                }
                case 8: {
                    s3 = b.e(parcel0, v4);
                    break;
                }
                case 9: {
                    v1 = b.r(parcel0, v4);
                    break;
                }
                case 10: {
                    v2 = b.r(parcel0, v4);
                    break;
                }
                case 11: {
                    f = b.n(parcel0, v4);
                    break;
                }
                case 12: {
                    s4 = b.e(parcel0, v4);
                    break;
                }
                case 13: {
                    z = b.l(parcel0, v4);
                    break;
                }
                case 14: {
                    v3 = b.r(parcel0, v4);
                    break;
                }
                case 15: {
                    s5 = b.e(parcel0, v4);
                    break;
                }
                default: {
                    b.u(parcel0, v4);
                }
            }
        }
        b.j(parcel0, v);
        return new i(gameEntity0, playerEntity0, s, uri0, s1, s2, s3, v1, v2, f, s4, z, v3, s5);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new i[v];
    }
}

