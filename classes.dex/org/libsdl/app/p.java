package org.libsdl.app;

import android.media.AudioDeviceInfo;
import java.util.function.Consumer;

public final class p implements Consumer {
    @Override
    public final void accept(Object object0) {
        org.libsdl.app.SDLAudioManager.1.lambda$onAudioDevicesRemoved$1(((AudioDeviceInfo)object0));
    }
}

