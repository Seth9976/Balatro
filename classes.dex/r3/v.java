package r3;

public abstract class v extends c {
    public abstract v d();

    protected final String e() {
        v v1;
        v v0 = l.b();
        if(this == v0) {
            return "Dispatchers.Main";
        }
        try {
            v1 = null;
            v1 = v0.d();
        }
        catch(UnsupportedOperationException unused_ex) {
        }
        return this == v1 ? "Dispatchers.Main.immediate" : null;
    }
}

