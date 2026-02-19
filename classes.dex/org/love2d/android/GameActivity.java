package org.love2d.android;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.DisplayCutout;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import org.libsdl.app.SDLActivity;

public class GameActivity extends SDLActivity {
    static final boolean $assertionsDisabled = false;
    public static final int EXTERNAL_STORAGE_REQUEST_CODE = 2;
    public static final int RECORD_AUDIO_REQUEST_CODE = 3;
    public static Context context = null;
    public boolean embed;
    protected final int[] externalStorageRequestDummy;
    private static String gamePath = "";
    private static boolean immersiveActive;
    private static DisplayMetrics metrics;
    private static boolean needToCopyGameInArchive;
    protected final int[] recordAudioRequestDummy;
    public int safeAreaBottom;
    public int safeAreaLeft;
    public int safeAreaRight;
    public int safeAreaTop;
    private boolean shortEdgesMode;
    private boolean storagePermissionUnnecessary;
    private static Vibrator vibrator;

    static {
    }

    public GameActivity() {
        this.externalStorageRequestDummy = new int[1];
        this.recordAudioRequestDummy = new int[1];
        this.storagePermissionUnnecessary = false;
        this.shortEdgesMode = false;
        this.embed = false;
        this.safeAreaTop = 0;
        this.safeAreaLeft = 0;
        this.safeAreaBottom = 0;
        this.safeAreaRight = 0;
    }

    private HashMap buildFileTree(AssetManager assetManager0, String s, HashMap hashMap0) {
        String[] arr_s;
        String s1 = s.endsWith("/") ? s.substring(0, s.length() - 1) : s;
        try {
            assetManager0.open(s1).close();
            hashMap0.put(s1, Boolean.FALSE);
        }
        catch(FileNotFoundException unused_ex) {
            try {
                arr_s = assetManager0.list(s1);
            }
            catch(IOException iOException1) {
                Log.e("GameActivity", s1, iOException1);
                arr_s = null;
            }
            hashMap0.put(s, Boolean.TRUE);
            if(s1 != s) {
                hashMap0.put(s1, Boolean.TRUE);
            }
            if(arr_s != null) {
                for(int v = 0; v < arr_s.length; ++v) {
                    this.buildFileTree(assetManager0, s + arr_s[v] + "/", hashMap0);
                }
            }
        }
        catch(IOException iOException0) {
            Log.e("GameActivity", s, iOException0);
        }
        return hashMap0;
    }

    public String[] buildFileTree() {
        HashMap hashMap0 = this.buildFileTree(this.getAssets(), "", new HashMap());
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: hashMap0.entrySet()) {
            arrayList0.add((((Boolean)((Map.Entry)object0).getValue()).booleanValue() ? "d" : "f") + ((String)((Map.Entry)object0).getKey()));
        }
        String[] arr_s = new String[arrayList0.size()];
        arrayList0.toArray(arr_s);
        return arr_s;
    }

    protected void checkLovegameFolder() {
        if(!this.embed) {
            Log.d("GameActivity", "fallback to lovegame folder");
            File file0 = this.getExternalFilesDir("games");
            if(new File(file0, "/lovegame/main.lua").exists()) {
                GameActivity.gamePath = file0.getPath() + "/lovegame/";
                this.storagePermissionUnnecessary = true;
            }
            else if(Build.VERSION.SDK_INT <= 28) {
                if(this.hasExternalStoragePermission()) {
                    File file1 = Environment.getExternalStorageDirectory();
                    if(new File(file1, "/lovegame/main.lua").exists()) {
                        GameActivity.gamePath = file1.getPath() + "/lovegame/";
                        this.storagePermissionUnnecessary = false;
                    }
                }
                else {
                    Log.d("GameActivity", "Cannot load game from /sdcard/lovegame: permission not granted");
                }
            }
            Log.d("GameActivity", "lovegame directory: ");
        }
    }

    boolean copyAssetFile(InputStream inputStream0, String s) {
        int v;
        BufferedOutputStream bufferedOutputStream0;
        boolean z = false;
        try {
            bufferedOutputStream0 = new BufferedOutputStream(new FileOutputStream(s, false));
        }
        catch(IOException iOException0) {
            Log.d("GameActivity", "Could not open destination file: " + iOException0.getMessage());
            bufferedOutputStream0 = null;
        }
        try {
            byte[] arr_b = new byte[0x400];
            v = 0;
            int v1 = inputStream0.read(arr_b);
            do {
                bufferedOutputStream0.write(arr_b, 0, v1);
                v += v1;
                v1 = inputStream0.read(arr_b);
            }
            while(v1 != -1);
        }
        catch(IOException iOException1) {
            Log.d("GameActivity", "Copying failed:" + iOException1.getMessage());
        }
        try {
            inputStream0.close();
            bufferedOutputStream0.close();
            z = true;
        }
        catch(IOException iOException2) {
            Log.d("GameActivity", "Copying failed: " + iOException2.getMessage());
        }
        Log.d("GameActivity", "Successfully copied stream to " + s + " (" + v + " bytes written).");
        return z;
    }

    private void copyGameInsideArchive() {
        try {
            InputStream inputStream0 = this.getAssets().open("game.love");
            String s = this.getCacheDir().getPath() + "/game.love";
            GameActivity.gamePath = this.copyAssetFile(inputStream0, s) ? s : "game.love";
            this.storagePermissionUnnecessary = true;
        }
        catch(IOException iOException0) {
            Log.d("GameActivity", "Could not open game.love from assets: " + iOException0.getMessage());
        }
    }

    public int getAudioFreq() {
        int v = Integer.parseInt(((AudioManager)this.getSystemService("audio")).getProperty("android.media.property.OUTPUT_SAMPLE_RATE"));
        return v > 0 ? v : 44100;
    }

    public int getAudioSMP() {
        int v = Integer.parseInt(((AudioManager)this.getSystemService("audio")).getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER"));
        return v > 0 ? v : 0x100;
    }

    // 去混淆评级： 低(20)
    public String getCRequirePath() {
        ApplicationInfo applicationInfo0 = this.getApplicationInfo();
        return this.isNativeLibsExtracted() ? applicationInfo0.nativeLibraryDir + "/?.so" : applicationInfo0.sourceDir + "!/lib/" + "arm64-v8a" + "/?.so";
    }

    // 去混淆评级： 低(34)
    public static String getGamePath() {
        GameActivity gameActivity0 = (GameActivity)SDLActivity.mSingleton;
        Log.d("GameActivity", "called getGamePath(), game path = ");
        if(GameActivity.needToCopyGameInArchive) {
            gameActivity0.copyGameInsideArchive();
            return "";
        }
        gameActivity0.checkLovegameFolder();
        return "";
    }

    public boolean getImmersiveMode() {
        return GameActivity.immersiveActive;
    }

    @Override  // org.libsdl.app.SDLActivity
    protected String[] getLibraries() {
        return new String[]{"c++_shared", "mpg123", "openal", "love"};
    }

    @Override  // org.libsdl.app.SDLActivity
    protected String getMainSharedObject() {
        String[] arr_s = this.getLibraries();
        return "lib" + arr_s[arr_s.length - 1] + ".so";
    }

    public static DisplayMetrics getMetrics() {
        return GameActivity.metrics;
    }

    protected void handleIntent(Intent intent0) {
        class a implements DialogInterface.OnClickListener {
            final GameActivity a;

            @Override  // android.content.DialogInterface$OnClickListener
            public void onClick(DialogInterface dialogInterface0, int v) {
                GameActivity.this.finish();
            }
        }

        Uri uri0 = intent0.getData();
        if(!this.embed && uri0 != null) {
            String s = uri0.getScheme();
            String s1 = uri0.getPath();
            if(s.equals("file")) {
                Log.d("GameActivity", "Received file:// intent with path: " + s1);
                List list0 = uri0.getPathSegments();
                GameActivity.gamePath = ((String)list0.get(list0.size() - 1)).equals("main.lua") ? s1.substring(0, s1.length() - 8) : s1;
            }
            else if(s.equals("content")) {
                Log.d("GameActivity", "Received content:// intent with path: " + s1);
                try {
                    String s2 = "game.love";
                    String[] arr_s = s1.split("/");
                    if(arr_s.length > 0) {
                        s2 = arr_s[arr_s.length - 1];
                    }
                    String s3 = this.getCacheDir().getPath() + "/" + s2.replaceAll("[^a-zA-Z0-9_\\\\-\\\\.]", "_");
                    if(this.copyAssetFile(this.getContentResolver().openInputStream(uri0), s3)) {
                        GameActivity.gamePath = s3;
                        this.storagePermissionUnnecessary = true;
                    }
                }
                catch(Exception exception0) {
                    Log.d("GameActivity", "could not read content uri " + uri0.toString() + ": " + exception0.getMessage());
                }
            }
            else {
                Log.e("GameActivity", "Unsupported scheme: \'" + uri0.getScheme() + "\'.");
                AlertDialog.Builder alertDialog$Builder0 = new AlertDialog.Builder(this);
                alertDialog$Builder0.setMessage("Could not load LÖVE game \'" + s1 + "\' as it uses unsupported scheme \'" + uri0.getScheme() + "\'. Please contact the developer.");
                alertDialog$Builder0.setTitle("LÖVE for Android Error");
                alertDialog$Builder0.setPositiveButton("Exit", new a(this));
                alertDialog$Builder0.setCancelable(false);
                alertDialog$Builder0.create().show();
            }
        }
        Log.d("GameActivity", "new gamePath: ");
    }

    public boolean hasBackgroundMusic() {
        return ((AudioManager)this.getSystemService("audio")).isMusicActive();
    }

    public boolean hasExternalStoragePermission() {
        if(androidx.core.content.a.a(this, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        Log.d("GameActivity", "Requesting permission and locking LÖVE thread until we have an answer.");
        androidx.core.app.a.e(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 2);
        synchronized(this.externalStorageRequestDummy) {
            try {
                this.externalStorageRequestDummy.wait();
            }
            catch(InterruptedException interruptedException0) {
                Log.d("GameActivity", "requesting external storage permission", interruptedException0);
                return false;
            }
        }
        return androidx.core.content.a.a(this, "android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    public boolean hasRecordAudioPermission() {
        return androidx.core.content.a.a(this, "android.permission.RECORD_AUDIO") == 0;
    }

    public boolean initializeSafeArea() {
        if(Build.VERSION.SDK_INT >= 28 && this.shortEdgesMode) {
            DisplayCutout displayCutout0 = this.getWindow().getDecorView().getRootWindowInsets().getDisplayCutout();
            if(displayCutout0 != null) {
                this.safeAreaTop = displayCutout0.getSafeInsetTop();
                this.safeAreaLeft = displayCutout0.getSafeInsetLeft();
                this.safeAreaBottom = displayCutout0.getSafeInsetBottom();
                this.safeAreaRight = displayCutout0.getSafeInsetRight();
                return true;
            }
        }
        return false;
    }

    public boolean isNativeLibsExtracted() {
        return (this.getApplicationInfo().flags & 0x10000000) != 0;
    }

    private static native void nativeSetDefaultStreamValues(int arg0, int arg1) {
    }

    @Override  // org.libsdl.app.SDLActivity
    protected void onCreate(Bundle bundle0) {
        Log.d("GameActivity", "started");
        GameActivity.context = this.getApplicationContext();
        if(this.checkCallingOrSelfPermission("android.permission.VIBRATE") == 0) {
            GameActivity.vibrator = (Vibrator)this.getSystemService("vibrator");
        }
        else {
            Log.d("GameActivity", "Vibration disabled: could not get vibration permission.");
        }
        GameActivity.gamePath = "";
        this.storagePermissionUnnecessary = false;
        boolean z = this.getResources().getBoolean(o.a);
        this.embed = z;
        GameActivity.needToCopyGameInArchive = z;
        if(!z) {
            Intent intent0 = this.getIntent();
            this.handleIntent(intent0);
            intent0.setData(null);
        }
        super.onCreate(bundle0);
        GameActivity.metrics = this.getResources().getDisplayMetrics();
        GameActivity.nativeSetDefaultStreamValues(this.getAudioFreq(), this.getAudioSMP());
        if(Build.VERSION.SDK_INT >= 28) {
            this.getWindow().getAttributes().layoutInDisplayCutoutMode = 2;
            this.shortEdgesMode = false;
        }
    }

    @Override  // org.libsdl.app.SDLActivity
    protected void onDestroy() {
        if(GameActivity.vibrator != null) {
            Log.d("GameActivity", "Cancelling vibration");
            GameActivity.vibrator.cancel();
        }
        super.onDestroy();
    }

    @Override  // android.app.Activity
    protected void onNewIntent(Intent intent0) {
        Log.d("GameActivity", "onNewIntent() with " + intent0);
        if(!this.embed) {
            this.handleIntent(intent0);
            this.resetNative();
            this.startNative();
        }
    }

    @Override  // org.libsdl.app.SDLActivity
    protected void onPause() {
        if(GameActivity.vibrator != null) {
            Log.d("GameActivity", "Cancelling vibration");
            GameActivity.vibrator.cancel();
        }
        super.onPause();
    }

    @Override  // org.libsdl.app.SDLActivity
    public void onRequestPermissionsResult(int v, String[] arr_s, int[] arr_v) {
        if(arr_v.length > 0) {
            Log.d("GameActivity", "Received a request permission result");
            switch(v) {
                case 2: {
                    if(arr_v[0] == 0) {
                        Log.d("GameActivity", "Permission granted");
                    }
                    else {
                        Log.d("GameActivity", "Did not get permission.");
                        if(androidx.core.app.a.f(this, "android.permission.READ_EXTERNAL_STORAGE")) {
                            this.showExternalStoragePermissionMissingDialog();
                        }
                    }
                    Log.d("GameActivity", "Unlocking LÖVE thread");
                    synchronized(this.externalStorageRequestDummy) {
                        this.externalStorageRequestDummy[0] = arr_v[0];
                        this.externalStorageRequestDummy.notify();
                    }
                    return;
                }
                case 3: {
                    Log.d("GameActivity", (arr_v[0] == 0 ? "Mic permission granted" : "Did not get mic permission."));
                    Log.d("GameActivity", "Unlocking LÖVE thread");
                    synchronized(this.recordAudioRequestDummy) {
                        this.recordAudioRequestDummy[0] = arr_v[0];
                        this.recordAudioRequestDummy.notify();
                    }
                    return;
                }
                default: {
                    super.onRequestPermissionsResult(v, arr_s, arr_v);
                }
            }
        }
    }

    @Override  // org.libsdl.app.SDLActivity
    public void onResume() {
        super.onResume();
    }

    public static boolean openURLFromLOVE(String s) {
        Log.d("GameActivity", "opening url = " + s);
        return SDLActivity.openURL(s) == 0;
    }

    public void requestRecordAudioPermission() {
        if(androidx.core.content.a.a(this, "android.permission.RECORD_AUDIO") == 0) {
            return;
        }
        Log.d("GameActivity", "Requesting mic permission and locking LÖVE thread until we have an answer.");
        androidx.core.app.a.e(this, new String[]{"android.permission.RECORD_AUDIO"}, 3);
        synchronized(this.recordAudioRequestDummy) {
            try {
                this.recordAudioRequestDummy.wait();
            }
            catch(InterruptedException interruptedException0) {
                Log.d("GameActivity", "requesting mic permission", interruptedException0);
            }
        }
    }

    public void setImmersiveMode(boolean z) {
        if(Build.VERSION.SDK_INT >= 28) {
            this.getWindow().getAttributes().layoutInDisplayCutoutMode = z ? 1 : 2;
            this.shortEdgesMode = z;
        }
        GameActivity.immersiveActive = z;
    }

    public void showExternalStoragePermissionMissingDialog() {
        new AlertDialog.Builder(SDLActivity.mSingleton).setTitle("Storage Permission Missing").setMessage("LÖVE for Android will not be able to run non-packaged games without storage permission.").setNeutralButton("Continue", null).create().show();
    }

    public void showRecordingAudioPermissionMissingDialog() {
        class b implements Runnable {
            final GameActivity e;

            @Override
            public void run() {
                class org.love2d.android.GameActivity.b.a implements DialogInterface.OnClickListener {
                    final b a;

                    @Override  // android.content.DialogInterface$OnClickListener
                    public void onClick(DialogInterface dialogInterface0, int v) {
                        synchronized(GameActivity.this.recordAudioRequestDummy) {
                            GameActivity.this.recordAudioRequestDummy.notify();
                        }
                    }
                }

                new AlertDialog.Builder(SDLActivity.mSingleton).setTitle("Audio Recording Permission Missing").setMessage("It appears that this game uses mic capabilities. The game may not work correctly without mic permission!").setNeutralButton("Continue", new org.love2d.android.GameActivity.b.a(this)).create().show();
            }
        }

        Log.d("GameActivity", "showRecordingAudioPermissionMissingDialog()");
        this.runOnUiThread(new b(this));
        synchronized(this.recordAudioRequestDummy) {
            try {
                this.recordAudioRequestDummy.wait();
            }
            catch(InterruptedException interruptedException0) {
                Log.d("GameActivity", "mic permission dialog", interruptedException0);
            }
        }
    }

    public static void vibrate(double f) {
        Vibrator vibrator0 = GameActivity.vibrator;
        if(vibrator0 != null) {
            vibrator0.vibrate(((long)(f * 1000.0)));
        }
    }
}

