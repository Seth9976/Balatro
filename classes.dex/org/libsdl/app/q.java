package org.libsdl.app;

import android.media.AudioDeviceInfo;
import java.util.function.Consumer;

public final class q implements Consumer {
    @Override
    public final void accept(Object object0) {
        org.libsdl.app.SDLAudioManager.1.lambda$onAudioDevicesAdded$0(((AudioDeviceInfo)object0));
    }
}

