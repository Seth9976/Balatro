package s1;

import com.google.android.gms.games.internal.v2.appshortcuts.PlayGamesAppShortcutsActivity;

public final class a implements Runnable {
    public final PlayGamesAppShortcutsActivity e;

    public a(PlayGamesAppShortcutsActivity playGamesAppShortcutsActivity0) {
        this.e = playGamesAppShortcutsActivity0;
    }

    @Override
    public final void run() {
        PlayGamesAppShortcutsActivity.a(this.e);
    }
}

