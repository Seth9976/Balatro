package m3;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import k3.f;

public final class a extends l3.a {
    @Override  // l3.a
    public Random c() {
        Random random0 = ThreadLocalRandom.current();
        f.d(random0, "current()");
        return random0;
    }
}

