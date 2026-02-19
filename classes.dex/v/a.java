package v;

import androidx.fragment.app.Fragment;
import k3.f;

public final class a extends g {
    private final String f;

    public a(Fragment fragment0, String s) {
        f.e(fragment0, "fragment");
        f.e(s, "previousFragmentId");
        super(fragment0, "Attempting to reuse fragment " + fragment0 + " with previous ID " + s);
        this.f = s;
    }
}

