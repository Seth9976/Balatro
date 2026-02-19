package androidx.emoji2.text;

import java.util.concurrent.ThreadFactory;

public final class a implements ThreadFactory {
    public final String a;

    public a(String s) {
        this.a = s;
    }

    @Override
    public final Thread newThread(Runnable runnable0) {
        return b.c(this.a, runnable0);
    }
}

