package androidx.activity.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public final class a implements Parcelable {
    class androidx.activity.result.a.a implements Parcelable.Creator {
        androidx.activity.result.a.a() {
            super();
        }

        public a a(Parcel parcel0) {
            return new a(parcel0);
        }

        public a[] b(int v) {
            return new a[v];
        }

        @Override  // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel0) {
            return this.a(parcel0);
        }

        @Override  // android.os.Parcelable$Creator
        public Object[] newArray(int v) {
            return this.b(v);
        }
    }

    public static final Parcelable.Creator CREATOR;
    private final int e;
    private final Intent f;

    static {
        a.CREATOR = new androidx.activity.result.a.a();
    }

    public a(int v, Intent intent0) {
        this.e = v;
        this.f = intent0;
    }

    a(Parcel parcel0) {
        this.e = parcel0.readInt();
        this.f = parcel0.readInt() == 0 ? null : ((Intent)Intent.CREATOR.createFromParcel(parcel0));
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Intent o() {
        return this.f;
    }

    public int s() {
        return this.e;
    }

    @Override
    public String toString() {
        return "ActivityResult{resultCode=" + a.x(this.e) + ", data=" + this.f + '}';
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.e);
        parcel0.writeInt((this.f == null ? 0 : 1));
        Intent intent0 = this.f;
        if(intent0 != null) {
            intent0.writeToParcel(parcel0, v);
        }
    }

    public static String x(int v) {
        switch(v) {
            case -1: {
                return "RESULT_OK";
            }
            case 0: {
                return "RESULT_CANCELED";
            }
            default: {
                return String.valueOf(v);
            }
        }
    }
}

