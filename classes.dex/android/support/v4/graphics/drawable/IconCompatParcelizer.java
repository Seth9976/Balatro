package android.support.v4.graphics.drawable;

import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;

public final class IconCompatParcelizer extends androidx.core.graphics.drawable.IconCompatParcelizer {
    @Override  // androidx.core.graphics.drawable.IconCompatParcelizer
    public static IconCompat read(a a0) {
        return androidx.core.graphics.drawable.IconCompatParcelizer.read(a0);
    }

    @Override  // androidx.core.graphics.drawable.IconCompatParcelizer
    public static void write(IconCompat iconCompat0, a a0) {
        androidx.core.graphics.drawable.IconCompatParcelizer.write(iconCompat0, a0);
    }
}

