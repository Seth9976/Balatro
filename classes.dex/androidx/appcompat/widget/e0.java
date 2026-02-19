package androidx.appcompat.widget;

class e0 {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;

    e0() {
        this.a = 0;
        this.b = 0;
        this.c = 0x80000000;
        this.d = 0x80000000;
        this.e = 0;
        this.f = 0;
        this.g = false;
        this.h = false;
    }

    // 去混淆评级： 低(20)
    public int a() {
        return this.g ? this.a : this.b;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    // 去混淆评级： 低(20)
    public int d() {
        return this.g ? this.b : this.a;
    }

    public void e(int v, int v1) {
        this.h = false;
        if(v != 0x80000000) {
            this.e = v;
            this.a = v;
        }
        if(v1 != 0x80000000) {
            this.f = v1;
            this.b = v1;
        }
    }

    public void f(boolean z) {
        int v;
        if(z == this.g) {
            return;
        }
        this.g = z;
        if(!this.h) {
            this.a = this.e;
            v = this.f;
        }
        else if(z) {
            this.a = this.d == 0x80000000 ? this.e : this.d;
            v = this.c;
            if(v == 0x80000000) {
                v = this.f;
            }
        }
        else {
            this.a = this.c == 0x80000000 ? this.e : this.c;
            v = this.d;
            if(v == 0x80000000) {
                v = this.f;
            }
        }
        this.b = v;
    }

    public void g(int v, int v1) {
        this.c = v;
        this.d = v1;
        this.h = true;
        if(this.g) {
            if(v1 != 0x80000000) {
                this.a = v1;
            }
            if(v != 0x80000000) {
                this.b = v;
            }
        }
        else {
            if(v != 0x80000000) {
                this.a = v;
            }
            if(v1 != 0x80000000) {
                this.b = v1;
            }
        }
    }
}

