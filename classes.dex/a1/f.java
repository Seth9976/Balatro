package a1;

import com.google.android.gms.common.api.Status;
import d1.g;
import d1.h;
import e1.m;
import g1.q;
import j1.a;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class f implements Runnable {
    private final String e;
    private final m f;
    private static final a g;

    static {
        f.g = new a("RevokeAccessOperation", new String[0]);
    }

    public f(String s) {
        this.e = q.f(s);
        this.f = new m(null);
    }

    public static g a(String s) {
        if(s == null) {
            return h.a(new Status(4), null);
        }
        f f0 = new f(s);
        new Thread(f0).start();
        return f0.f;
    }

    @Override
    public final void run() {
        Status status0;
        try {
            status0 = Status.l;
            HttpURLConnection httpURLConnection0 = (HttpURLConnection)new URL("https://accounts.google.com/o/oauth2/revoke?token=" + this.e).openConnection();
            httpURLConnection0.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            int v = httpURLConnection0.getResponseCode();
            if(v == 200) {
                status0 = Status.j;
            }
            else {
                f.g.b("Unable to revoke access!", new Object[0]);
            }
            f.g.a("Response Code: " + v, new Object[0]);
        }
        catch(IOException iOException0) {
            f.g.b("IOException when revoking access: " + iOException0.toString(), new Object[0]);
        }
        catch(Exception exception0) {
            f.g.b("Exception when revoking access: " + exception0.toString(), new Object[0]);
        }
        this.f.h(status0);
    }
}

