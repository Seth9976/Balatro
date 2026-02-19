package org.libsdl.app;

import android.os.Process;
import android.util.Log;

class SDLMain implements Runnable {
    @Override
    public void run() {
        String s = SDLActivity.mSingleton.getMainSharedObject();
        String[] arr_s = SDLActivity.mSingleton.getArguments();
        try {
            Process.setThreadPriority(-4);
        }
        catch(Exception exception0) {
            Log.v("SDL", "modify thread properties failed " + exception0.toString());
        }
        Log.v("SDL", "Running main function SDL_main from library " + s);
        SDLActivity.nativeRunMain(s, "SDL_main", arr_s);
        Log.v("SDL", "Finished main function");
        if(!SDLActivity.mExitCalledFromJava && (SDLActivity.mSingleton != null && !SDLActivity.mSingleton.isFinishing())) {
            SDLActivity.mSDLThread = null;
            SDLActivity.mSingleton.finish();
        }
    }
}

