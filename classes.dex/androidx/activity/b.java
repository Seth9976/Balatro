package androidx.activity;

public final class b implements Runnable {
    public final ComponentActivity e;

    public b(ComponentActivity componentActivity0) {
        this.e = componentActivity0;
    }

    @Override
    public final void run() {
        this.e.B();
    }
}

