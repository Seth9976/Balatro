package org.libsdl.app;

import android.media.AudioDeviceInfo;
import java.util.function.Predicate;

public final class m implements Predicate {
    public final int a;

    public m(int v) {
        this.a = v;
    }

    @Override
    public final boolean test(Object object0) {
        return SDLAudioManager.lambda$getInputAudioDeviceInfo$0(this.a, ((AudioDeviceInfo)object0));
    }
}

