package org.libsdl.app;

import android.media.AudioDeviceInfo;
import java.util.function.Predicate;

public final class n implements Predicate {
    public final int a;

    public n(int v) {
        this.a = v;
    }

    @Override
    public final boolean test(Object object0) {
        return SDLAudioManager.lambda$getOutputAudioDeviceInfo$1(this.a, ((AudioDeviceInfo)object0));
    }
}

