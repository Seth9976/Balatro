package org.libsdl.app;

import android.media.AudioDeviceInfo;
import java.util.function.ToIntFunction;

public final class l implements ToIntFunction {
    @Override
    public final int applyAsInt(Object object0) {
        return ((AudioDeviceInfo)object0).getId();
    }
}

