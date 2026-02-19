package androidx.activity.result;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public final class e implements Parcelable {
    class a implements Parcelable.Creator {
        a() {
            super();
        }

        public e a(Parcel parcel0) {
            return new e(parcel0);
        }

        public e[] b(int v) {
            return new e[v];
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

    public static final class b {
        private IntentSender a;
        private Intent b;
        private int c;
        private int d;

        public b(PendingIntent pendingIntent0) {
            this(pendingIntent0.getIntentSender());
        }

        public b(IntentSender intentSender0) {
            this.a = intentSender0;
        }

        public e a() {
            return new e(this.a, this.b, this.c, this.d);
        }

        public b b(Intent intent0) {
            this.b = intent0;
            return this;
        }

        public b c(int v, int v1) {
            this.d = v;
            this.c = v1;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    private final IntentSender e;
    private final Intent f;
    private final int g;
    private final int h;

    static {
        e.CREATOR = new a();
    }

    e(IntentSender intentSender0, Intent intent0, int v, int v1) {
        this.e = intentSender0;
        this.f = intent0;
        this.g = v;
        this.h = v1;
    }

    e(Parcel parcel0) {
        this.e = (IntentSender)parcel0.readParcelable(IntentSender.class.getClassLoader());
        this.f = (Intent)parcel0.readParcelable(Intent.class.getClassLoader());
        this.g = parcel0.readInt();
        this.h = parcel0.readInt();
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Intent o() {
        return this.f;
    }

    public int s() {
        return this.g;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeParcelable(this.e, v);
        parcel0.writeParcelable(this.f, v);
        parcel0.writeInt(this.g);
        parcel0.writeInt(this.h);
    }

    public int x() {
        return this.h;
    }

    public IntentSender z() {
        return this.e;
    }
}

