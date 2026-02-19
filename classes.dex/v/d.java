package v;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import k3.f;

public final class d extends g {
    private final ViewGroup f;

    public d(Fragment fragment0, ViewGroup viewGroup0) {
        f.e(fragment0, "fragment");
        super(fragment0, "Attempting to use <fragment> tag to add fragment " + fragment0 + " to container " + viewGroup0);
        this.f = viewGroup0;
    }
}

