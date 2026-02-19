package l1;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class g {
    public static void a(Closeable closeable0) {
        if(closeable0 != null) {
            try {
                closeable0.close();
            }
            catch(IOException unused_ex) {
            }
        }
    }

    public static long b(InputStream inputStream0, OutputStream outputStream0, boolean z, int v) {
        byte[] arr_b = new byte[v];
        long v1 = 0L;
        try {
            int v3;
            while((v3 = inputStream0.read(arr_b, 0, v)) != -1) {
                v1 += (long)v3;
                outputStream0.write(arr_b, 0, v3);
            }
            return v1;
        }
        finally {
            if(z) {
                g.a(inputStream0);
                g.a(outputStream0);
            }
        }
    }

    public static byte[] c(InputStream inputStream0, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        g.b(inputStream0, byteArrayOutputStream0, z, 0x400);
        return byteArrayOutputStream0.toByteArray();
    }
}

