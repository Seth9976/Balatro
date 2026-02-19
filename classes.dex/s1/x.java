package s1;

import android.content.Intent;
import android.util.Log;
import com.google.android.gms.games.internal.v2.appshortcuts.PlayGamesAppShortcutsActivity;
import g2.d;
import g2.h;

public final class x implements d {
    public final PlayGamesAppShortcutsActivity a;

    public x(PlayGamesAppShortcutsActivity playGamesAppShortcutsActivity0) {
        this.a = playGamesAppShortcutsActivity0;
    }

    @Override  // g2.d
    public final void a(h h0) {
        PlayGamesAppShortcutsActivity playGamesAppShortcutsActivity0 = this.a;
        if(!h0.q()) {
            Log.e("PGShortcutsActivity", "Failed to access intent.", h0.m());
            playGamesAppShortcutsActivity0.finish();
            return;
        }
        playGamesAppShortcutsActivity0.startActivityForResult(((Intent)h0.n()), 1005000000);
    }
}

