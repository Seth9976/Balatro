package n2;

import java.io.IOException;
import java.io.StringWriter;
import p2.m;
import v2.c;

public abstract class g {
    // 去混淆评级： 低(30)
    public f e() {
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    // 去混淆评级： 低(30)
    public j n() {
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    // 去混淆评级： 低(30)
    public l o() {
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public boolean p() [...] // 潜在的解密器

    public boolean q() [...] // 潜在的解密器

    public boolean r() [...] // 潜在的解密器

    public boolean s() [...] // 潜在的解密器

    @Override
    public String toString() {
        try {
            StringWriter stringWriter0 = new StringWriter();
            c c0 = new c(stringWriter0);
            c0.w(true);
            m.a(this, c0);
            return stringWriter0.toString();
        }
        catch(IOException iOException0) {
            throw new AssertionError(iOException0);
        }
    }
}

