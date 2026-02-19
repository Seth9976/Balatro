package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode;
import android.util.Log;
import androidx.core.provider.g.b;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.nio.channels.FileChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import jeb.synthetic.TWR;

public abstract class p {
    static abstract class a {
        static ParcelFileDescriptor a(ContentResolver contentResolver0, Uri uri0, String s, CancellationSignal cancellationSignal0) {
            return contentResolver0.openFileDescriptor(uri0, s, cancellationSignal0);
        }
    }

    public static void a(Closeable closeable0) {
        if(closeable0 != null) {
            try {
                closeable0.close();
            }
            catch(IOException unused_ex) {
            }
        }
    }

    public static ByteBuffer b(Context context0, Resources resources0, int v) {
        File file0 = p.e(context0);
        if(file0 == null) {
            return null;
        }
        try {
            return !p.c(file0, resources0, v) ? null : p.g(file0);
        }
        finally {
            file0.delete();
        }
    }

    public static boolean c(File file0, Resources resources0, int v) {
        InputStream inputStream0;
        try {
            inputStream0 = resources0.openRawResource(v);
            return p.d(file0, inputStream0);
        }
        finally {
            p.a(inputStream0);
        }
    }

    public static boolean d(File file0, InputStream inputStream0) {
        StrictMode.ThreadPolicy strictMode$ThreadPolicy0 = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream0 = null;
        try {
            fileOutputStream0 = new FileOutputStream(file0, false);
            byte[] arr_b = new byte[0x400];
            int v1;
            while((v1 = inputStream0.read(arr_b)) != -1) {
                fileOutputStream0.write(arr_b, 0, v1);
            }
            return true;
        }
        catch(IOException iOException0) {
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + iOException0.getMessage());
            return false;
        }
        finally {
            p.a(fileOutputStream0);
            StrictMode.setThreadPolicy(strictMode$ThreadPolicy0);
        }
    }

    public static File e(Context context0) {
        File file0 = context0.getCacheDir();
        if(file0 == null) {
            return null;
        }
        String s = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for(int v = 0; v < 100; ++v) {
            File file1 = new File(file0, s + v);
            try {
                if(file1.createNewFile()) {
                    return file1;
                }
            }
            catch(IOException unused_ex) {
            }
        }
        return null;
    }

    public static ByteBuffer f(Context context0, CancellationSignal cancellationSignal0, Uri uri0) {
        ContentResolver contentResolver0 = context0.getContentResolver();
        try(ParcelFileDescriptor parcelFileDescriptor0 = a.a(contentResolver0, uri0, "r", cancellationSignal0)) {
            if(parcelFileDescriptor0 != null) {
                FileInputStream fileInputStream0 = new FileInputStream(parcelFileDescriptor0.getFileDescriptor());
                TWR.declareResource(fileInputStream0);
                TWR.useResource$NT(fileInputStream0);
                FileChannel fileChannel0 = fileInputStream0.getChannel();
                long v = fileChannel0.size();
                return fileChannel0.map(FileChannel.MapMode.READ_ONLY, 0L, v);
            }
        }
        catch(IOException unused_ex) {
        }
        return null;
    }

    private static ByteBuffer g(File file0) {
        try(FileInputStream fileInputStream0 = new FileInputStream(file0)) {
            FileChannel fileChannel0 = fileInputStream0.getChannel();
            long v = fileChannel0.size();
            return fileChannel0.map(FileChannel.MapMode.READ_ONLY, 0L, v);
        }
        catch(IOException unused_ex) {
            return null;
        }
    }

    public static Map h(Context context0, b[] arr_g$b, CancellationSignal cancellationSignal0) {
        HashMap hashMap0 = new HashMap();
        for(int v = 0; v < arr_g$b.length; ++v) {
            b g$b0 = arr_g$b[v];
            if(g$b0.b() == 0) {
                Uri uri0 = g$b0.d();
                if(!hashMap0.containsKey(uri0)) {
                    hashMap0.put(uri0, p.f(context0, cancellationSignal0, uri0));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap0);
    }
}

