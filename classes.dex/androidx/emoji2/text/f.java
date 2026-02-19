package androidx.emoji2.text;

import java.util.concurrent.ThreadPoolExecutor;

public final class f implements Runnable {
    public final b e;
    public final h f;
    public final ThreadPoolExecutor g;

    public f(b emojiCompatInitializer$b0, h e$h0, ThreadPoolExecutor threadPoolExecutor0) {
        this.e = emojiCompatInitializer$b0;
        this.f = e$h0;
        this.g = threadPoolExecutor0;
    }

    @Override
    public final void run() {
        this.e.d(this.f, this.g);
    }
}

