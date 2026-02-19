package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

final class k0 extends Writer {
    private final String e;
    private StringBuilder f;

    k0(String s) {
        this.f = new StringBuilder(0x80);
        this.e = s;
    }

    private void a() {
        if(this.f.length() > 0) {
            Log.d(this.e, this.f.toString());
            this.f.delete(0, this.f.length());
        }
    }

    @Override
    public void close() {
        this.a();
    }

    @Override
    public void flush() {
        this.a();
    }

    @Override
    public void write(char[] arr_c, int v, int v1) {
        for(int v2 = 0; v2 < v1; ++v2) {
            int v3 = arr_c[v + v2];
            if(v3 == 10) {
                this.a();
            }
            else {
                this.f.append(((char)v3));
            }
        }
    }
}

