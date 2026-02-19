package m2;

import j2.b;
import j2.c;
import j2.g;

class i implements g {
    private boolean a;
    private boolean b;
    private c c;
    private final f d;

    i(f f0) {
        this.a = false;
        this.b = false;
        this.d = f0;
    }

    @Override  // j2.g
    public g a(String s) {
        this.c();
        this.d.f(this.c, s, this.b);
        return this;
    }

    @Override  // j2.g
    public g b(boolean z) {
        this.c();
        this.d.k(this.c, z, this.b);
        return this;
    }

    private void c() {
        if(this.a) {
            throw new b("Cannot encode a second value in the ValueEncoderContext");
        }
        this.a = true;
    }

    void d(c c0, boolean z) {
        this.a = false;
        this.c = c0;
        this.b = z;
    }
}

