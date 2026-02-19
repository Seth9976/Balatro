package p1;

import com.google.android.gms.common.api.Scope;
import d1.a.a;
import d1.a.g;

public abstract class e {
    static final g a;
    private static final a b;
    private static final a c;
    public static final Scope d;
    public static final Scope e;
    public static final d1.a f;
    public static final Scope g;

    static {
        g a$g0 = new g();
        e.a = a$g0;
        w w0 = new w();
        e.b = w0;
        x x0 = new x();
        e.c = x0;
        e.d = new Scope("https://www.googleapis.com/auth/games");
        e.e = new Scope("https://www.googleapis.com/auth/games_lite");
        new Scope("https://www.googleapis.com/auth/drive.appdata");
        e.f = new d1.a("Games.API", w0, a$g0);
        e.g = new Scope("https://www.googleapis.com/auth/games.firstparty");
        new d1.a("Games.API_1P", x0, a$g0);
    }
}

