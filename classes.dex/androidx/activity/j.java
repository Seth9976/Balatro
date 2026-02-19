package androidx.activity;

public final class j implements Runnable {
    public final OnBackPressedDispatcher e;

    public j(OnBackPressedDispatcher onBackPressedDispatcher0) {
        this.e = onBackPressedDispatcher0;
    }

    @Override
    public final void run() {
        this.e.f();
    }
}

