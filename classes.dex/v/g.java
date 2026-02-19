package v;

import androidx.fragment.app.Fragment;
import k3.f;

public abstract class g extends RuntimeException {
    private final Fragment e;

    public g(Fragment fragment0, String s) {
        f.e(fragment0, "fragment");
        super(s);
        this.e = fragment0;
    }

    public final Fragment a() {
        return this.e;
    }
}

