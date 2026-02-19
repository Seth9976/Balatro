package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.ReflectedParcelable;
import g1.q;
import h1.a;
import h1.c;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class BitmapTeleporter extends a implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    final int e;
    ParcelFileDescriptor f;
    final int g;
    private Bitmap h;
    private boolean i;
    private File j;

    static {
        BitmapTeleporter.CREATOR = new com.google.android.gms.common.data.a();
    }

    BitmapTeleporter(int v, ParcelFileDescriptor parcelFileDescriptor0, int v1) {
        this.e = v;
        this.f = parcelFileDescriptor0;
        this.g = v1;
        this.h = null;
        this.i = false;
    }

    public void j0(File file0) {
        if(file0 == null) {
            throw new NullPointerException("Cannot set null temp directory");
        }
        this.j = file0;
    }

    private static final void k0(Closeable closeable0) {
        try {
            closeable0.close();
        }
        catch(IOException iOException0) {
            Log.w("BitmapTeleporter", "Could not close stream", iOException0);
        }
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        FileOutputStream fileOutputStream0;
        File file1;
        if(this.f == null) {
            Bitmap bitmap0 = (Bitmap)q.i(this.h);
            ByteBuffer byteBuffer0 = ByteBuffer.allocate(bitmap0.getRowBytes() * bitmap0.getHeight());
            bitmap0.copyPixelsToBuffer(byteBuffer0);
            byte[] arr_b = byteBuffer0.array();
            File file0 = this.j;
            if(file0 == null) {
                throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
            }
            try {
                file1 = File.createTempFile("teleporter", ".tmp", file0);
            }
            catch(IOException iOException0) {
                throw new IllegalStateException("Could not create temporary file", iOException0);
            }
            try {
                fileOutputStream0 = new FileOutputStream(file1);
                this.f = ParcelFileDescriptor.open(file1, 0x10000000);
            }
            catch(FileNotFoundException unused_ex) {
                throw new IllegalStateException("Temporary file is somehow already deleted");
            }
            file1.delete();
            DataOutputStream dataOutputStream0 = new DataOutputStream(new BufferedOutputStream(fileOutputStream0));
            try {
                dataOutputStream0.writeInt(arr_b.length);
                dataOutputStream0.writeInt(bitmap0.getWidth());
                dataOutputStream0.writeInt(bitmap0.getHeight());
                dataOutputStream0.writeUTF(bitmap0.getConfig().toString());
                dataOutputStream0.write(arr_b);
            }
            catch(IOException iOException1) {
                throw new IllegalStateException("Could not write into unlinked file", iOException1);
            }
            finally {
                BitmapTeleporter.k0(dataOutputStream0);
            }
        }
        int v2 = c.a(parcel0);
        c.i(parcel0, 1, this.e);
        c.m(parcel0, 2, this.f, v | 1, false);
        c.i(parcel0, 3, this.g);
        c.b(parcel0, v2);
        this.f = null;
    }
}

