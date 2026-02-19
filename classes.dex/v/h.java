package v;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import k3.f;

public final class h extends g {
    private final ViewGroup f;

    public h(Fragment fragment0, ViewGroup viewGroup0) {
        f.e(fragment0, "fragment");
        f.e(viewGroup0, "container");
        super(fragment0, "Attempting to add fragment " + fragment0 + " to container " + viewGroup0 + " which is not a FragmentContainerView");
        this.f = viewGroup0;
    }
}

