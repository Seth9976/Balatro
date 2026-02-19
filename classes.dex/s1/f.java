package s1;

import android.content.pm.ShortcutManager;
import java.util.List;

public final class f implements g2.f {
    public final ShortcutManager a;

    public f(ShortcutManager shortcutManager0) {
        this.a = shortcutManager0;
    }

    @Override  // g2.f
    public final void e(Object object0) {
        List list0 = ((com.google.android.gms.games.internal.v2.appshortcuts.f)object0).m0();
        ShortcutManager shortcutManager0 = this.a;
        if(list0 != null && !list0.isEmpty()) {
            shortcutManager0.removeDynamicShortcuts(list0);
        }
        List list1 = ((com.google.android.gms.games.internal.v2.appshortcuts.f)object0).j0();
        if(list1 != null && !list1.isEmpty()) {
            shortcutManager0.addDynamicShortcuts(list1);
        }
        List list2 = ((com.google.android.gms.games.internal.v2.appshortcuts.f)object0).k0();
        if(list2 != null && !list2.isEmpty()) {
            shortcutManager0.disableShortcuts(list2);
        }
        List list3 = ((com.google.android.gms.games.internal.v2.appshortcuts.f)object0).l0();
        if(list3 != null && !list3.isEmpty()) {
            shortcutManager0.enableShortcuts(list3);
        }
    }
}

