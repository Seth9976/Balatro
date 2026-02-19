package v1;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.a;
import com.google.android.gms.games.b;
import f1.d;
import p1.l;

public final class j extends d implements e {
    private final p1.d h;
    private final l i;

    public j(DataHolder dataHolder0, int v) {
        super(dataHolder0, v);
        this.h = new a(dataHolder0, v);
        this.i = new b(dataHolder0, v, null);
    }

    @Override  // v1.e
    public final long E() {
        return this.z("duration");
    }

    @Override  // v1.e
    public final l F() {
        return this.i;
    }

    @Override  // v1.e
    public final long O() {
        return this.z("progress_value");
    }

    @Override  // v1.e
    public final float R() {
        float f = this.s("cover_icon_image_height");
        return Float.compare(f, 0.0f) == 0 ? 0.0f : this.s("cover_icon_image_width") / f;
    }

    @Override  // v1.e
    public final long T() {
        return this.z("last_modified_timestamp");
    }

    @Override  // v1.e
    public final String Y() {
        return this.C("unique_name");
    }

    @Override  // v1.e
    public final String a() {
        return this.C("title");
    }

    @Override  // v1.e
    public final boolean c0() {
        return this.x("pending_change_count") > 0;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final boolean equals(Object object0) {
        return i.l0(this, object0);
    }

    @Override  // v1.e
    public final String f0() {
        return this.C("external_snapshot_id");
    }

    @Override  // v1.e
    public String getCoverImageUrl() {
        return this.C("cover_icon_image_url");
    }

    @Override
    public final int hashCode() {
        return i.j0(this);
    }

    @Override  // v1.e
    public final String i() {
        return this.C("description");
    }

    @Override  // v1.e
    public final p1.d i0() {
        return this.h;
    }

    @Override  // v1.e
    public final String n() {
        return this.C("device_name");
    }

    @Override
    public final String toString() {
        return i.k0(this);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        new i(this).writeToParcel(parcel0, v);
    }

    @Override  // v1.e
    public final Uri y() {
        return this.U("cover_icon_image_uri");
    }
}

