package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

final class e extends f {
    @Override  // com.google.android.gms.games.f
    public final PlayerEntity a(Parcel parcel0) {
        if(!GamesDowngradeableSafeParcel.m0(DowngradeableSafeParcel.k0()) && !DowngradeableSafeParcel.j0(PlayerEntity.class.getCanonicalName())) {
            String s = parcel0.readString();
            String s1 = parcel0.readString();
            String s2 = parcel0.readString();
            String s3 = parcel0.readString();
            long v = parcel0.readLong();
            String s4 = parcel0.readString();
            String s5 = parcel0.readString();
            Uri uri0 = s2 == null ? null : Uri.parse(s2);
            return s3 == null ? new PlayerEntity(s, s1, uri0, null, v, -1, -1L, null, null, null, null, null, true, false, s4, s5, null, null, null, null, -1L, null, null, false, null) : new PlayerEntity(s, s1, uri0, Uri.parse(s3), v, -1, -1L, null, null, null, null, null, true, false, s4, s5, null, null, null, null, -1L, null, null, false, null);
        }
        return super.a(parcel0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        return this.a(parcel0);
    }
}

