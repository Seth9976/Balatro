package v1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import c2.f1;
import g1.q;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import l1.g;
import n1.a;
import q1.r;

public final class c extends r implements b {
    public static final Parcelable.Creator CREATOR;
    private a e;
    private static final Object f;

    static {
        c.f = new Object();
        c.CREATOR = new k();
    }

    public c(a a0) {
        this.e = a0;
    }

    @Override  // v1.b
    public final boolean G(byte[] arr_b) {
        return this.j0(0, arr_b, 0, arr_b.length, true);
    }

    @Override  // v1.b
    public final a a() {
        return this.e;
    }

    @Override  // v1.b
    public final byte[] a0() {
        byte[] arr_b;
        q.l(!this.u(), "Must provide a previously opened Snapshot");
        synchronized(c.f) {
            FileInputStream fileInputStream0 = new FileInputStream(this.e.j0().getFileDescriptor());
            BufferedInputStream bufferedInputStream0 = new BufferedInputStream(fileInputStream0);
            try {
                fileInputStream0.getChannel().position(0L);
                arr_b = g.c(bufferedInputStream0, false);
                fileInputStream0.getChannel().position(0L);
                return arr_b;
            }
            catch(IOException iOException0) {
                f1.h("SnapshotContentsEntity", "Failed to read snapshot data", iOException0);
                throw iOException0;
            }
        }
    }

    @Override  // v1.b
    public final void b() {
        this.e = null;
    }

    private final boolean j0(int v, byte[] arr_b, int v1, int v2, boolean z) {
        q.l(!this.u(), "Must provide a previously opened SnapshotContents");
        synchronized(c.f) {
            FileOutputStream fileOutputStream0 = new FileOutputStream(this.e.j0().getFileDescriptor());
            BufferedOutputStream bufferedOutputStream0 = new BufferedOutputStream(fileOutputStream0);
            try {
                FileChannel fileChannel0 = fileOutputStream0.getChannel();
                fileChannel0.position(((long)v));
                bufferedOutputStream0.write(arr_b, v1, v2);
                if(z) {
                    fileChannel0.truncate(((long)arr_b.length));
                }
                bufferedOutputStream0.flush();
                return true;
            }
            catch(IOException iOException0) {
                f1.e("SnapshotContentsEntity", "Failed to write snapshot data", iOException0);
                return false;
            }
        }
    }

    @Override  // v1.b
    public final boolean u() {
        return this.e == null;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = h1.c.a(parcel0);
        h1.c.m(parcel0, 1, this.e, v, false);
        h1.c.b(parcel0, v1);
    }
}

