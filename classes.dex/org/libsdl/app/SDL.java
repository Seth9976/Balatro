package org.libsdl.app;

import android.content.Context;

public class SDL {
    protected static Context mContext;

    public static Context getContext() {
        return SDL.mContext;
    }

    public static void initialize() {
        SDL.setContext(null);
        SDLActivity.initialize();
        SDLAudioManager.initialize();
        SDLControllerManager.initialize();
    }

    public static void loadLibrary(String s) {
        if(s == null) {
            throw new NullPointerException("No library name provided.");
        }
        try {
            Class class0 = SDL.mContext.getClassLoader().loadClass("com.getkeepsafe.relinker.ReLinker");
            Class class1 = SDL.mContext.getClassLoader().loadClass("com.getkeepsafe.relinker.ReLinker$LoadListener");
            Class class2 = SDL.mContext.getClassLoader().loadClass("android.content.Context");
            Class class3 = SDL.mContext.getClassLoader().loadClass("java.lang.String");
            Object object0 = class0.getDeclaredMethod("force").invoke(null);
            object0.getClass().getDeclaredMethod("loadLibrary", class2, class3, class3, class1).invoke(object0, SDL.mContext, s, null, null);
        }
        catch(Throwable unused_ex) {
            System.loadLibrary(s);
        }
    }

    public static void setContext(Context context0) {
        SDLAudioManager.setContext(context0);
        SDL.mContext = context0;
    }

    public static void setupJNI() {
        SDLActivity.nativeSetupJNI();
        SDLAudioManager.nativeSetupJNI();
        SDLControllerManager.nativeSetupJNI();
    }
}

