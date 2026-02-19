package org.libsdl.app;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.AlertDialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.Surface;
import android.view.View.OnClickListener;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Hashtable;
import java.util.Locale;

public class SDLActivity extends Activity implements View.OnSystemUiVisibilityChangeListener {
    public static enum NativeState {
        INIT,
        RESUMED,
        PAUSED;

        private static NativeState[] $values() [...] // Inlined contents
    }

    public static class SDLCommandHandler extends Handler {
        @Override  // android.os.Handler
        public void handleMessage(Message message0) {
            Context context0 = SDL.getContext();
            if(context0 == null) {
                Log.e("SDL", "error handling message, getContext() returned null");
                return;
            }
            int v = message0.arg1;
            switch(v) {
                case 1: {
                    if(context0 instanceof Activity) {
                        ((Activity)context0).setTitle(((String)message0.obj));
                        return;
                    }
                    Log.e("SDL", "error handling message, getContext() returned no Activity");
                    return;
                label_12:
                    if(context0 instanceof SDLActivity && !((SDLActivity)context0).onUnhandledMessage(v, message0.obj)) {
                        Log.e("SDL", "error handling message, command is " + message0.arg1);
                        return;
                    }
                    break;
                }
                case 2: {
                    if(!(context0 instanceof Activity)) {
                        Log.e("SDL", "error handling message, getContext() returned no Activity");
                        return;
                    }
                    Window window0 = ((Activity)context0).getWindow();
                    if(window0 != null) {
                        if(message0.obj instanceof Integer && ((int)(((Integer)message0.obj))) != 0) {
                            window0.getDecorView().setSystemUiVisibility(0x1706);
                            window0.addFlags(0x400);
                            window0.clearFlags(0x800);
                            SDLActivity.mFullscreenModeActive = true;
                            return;
                        }
                        window0.getDecorView().setSystemUiVisibility(0x100);
                        window0.addFlags(0x800);
                        window0.clearFlags(0x400);
                        SDLActivity.mFullscreenModeActive = false;
                        return;
                    }
                    break;
                }
                case 3: {
                    DummyEdit dummyEdit0 = SDLActivity.mTextEdit;
                    if(dummyEdit0 != null) {
                        dummyEdit0.setLayoutParams(new RelativeLayout.LayoutParams(0, 0));
                        ((InputMethodManager)context0.getSystemService("input_method")).hideSoftInputFromWindow(SDLActivity.mTextEdit.getWindowToken(), 0);
                        SDLActivity.mScreenKeyboardShown = false;
                        SDLActivity.mSurface.requestFocus();
                        return;
                    }
                    break;
                }
                case 5: {
                    if(context0 instanceof Activity) {
                        Window window1 = ((Activity)context0).getWindow();
                        if(window1 != null) {
                            if(message0.obj instanceof Integer && ((int)(((Integer)message0.obj))) != 0) {
                                window1.addFlags(0x80);
                                return;
                            }
                            window1.clearFlags(0x80);
                            return;
                        }
                    }
                    break;
                }
                default: {
                    goto label_12;
                }
            }
        }
    }

    static class ShowTextInputTask implements Runnable {
        static final int HEIGHT_PADDING = 15;
        public int h;
        public int w;
        public int x;
        public int y;

        public ShowTextInputTask(int v, int v1, int v2, int v3) {
            this.x = v;
            this.y = v1;
            this.w = v2;
            this.h = v3;
            if(v2 <= 0) {
                this.w = 1;
            }
            if(v3 + 15 <= 0) {
                this.h = -14;
            }
        }

        @Override
        public void run() {
            RelativeLayout.LayoutParams relativeLayout$LayoutParams0 = new RelativeLayout.LayoutParams(this.w, this.h + 15);
            relativeLayout$LayoutParams0.leftMargin = this.x;
            relativeLayout$LayoutParams0.topMargin = this.y;
            DummyEdit dummyEdit0 = SDLActivity.mTextEdit;
            if(dummyEdit0 == null) {
                SDLActivity.mTextEdit = new DummyEdit(SDL.getContext());
                SDLActivity.mLayout.addView(SDLActivity.mTextEdit, relativeLayout$LayoutParams0);
            }
            else {
                dummyEdit0.setLayoutParams(relativeLayout$LayoutParams0);
            }
            SDLActivity.mTextEdit.setVisibility(0);
            SDLActivity.mTextEdit.requestFocus();
            ((InputMethodManager)SDL.getContext().getSystemService("input_method")).showSoftInput(SDLActivity.mTextEdit, 0);
            SDLActivity.mScreenKeyboardShown = true;
        }
    }

    static final int COMMAND_CHANGE_TITLE = 1;
    static final int COMMAND_CHANGE_WINDOW_STYLE = 2;
    static final int COMMAND_SET_KEEP_SCREEN_ON = 5;
    static final int COMMAND_TEXTEDIT_HIDE = 3;
    protected static final int COMMAND_USER = 0x8000;
    private static final int SDL_MAJOR_VERSION = 2;
    private static final int SDL_MICRO_VERSION = 5;
    private static final int SDL_MINOR_VERSION = 28;
    protected static final int SDL_ORIENTATION_LANDSCAPE = 1;
    protected static final int SDL_ORIENTATION_LANDSCAPE_FLIPPED = 2;
    protected static final int SDL_ORIENTATION_PORTRAIT = 3;
    protected static final int SDL_ORIENTATION_PORTRAIT_FLIPPED = 4;
    protected static final int SDL_ORIENTATION_UNKNOWN = 0;
    private static final int SDL_SYSTEM_CURSOR_ARROW = 0;
    private static final int SDL_SYSTEM_CURSOR_CROSSHAIR = 3;
    private static final int SDL_SYSTEM_CURSOR_HAND = 11;
    private static final int SDL_SYSTEM_CURSOR_IBEAM = 1;
    private static final int SDL_SYSTEM_CURSOR_NO = 10;
    private static final int SDL_SYSTEM_CURSOR_SIZEALL = 9;
    private static final int SDL_SYSTEM_CURSOR_SIZENESW = 6;
    private static final int SDL_SYSTEM_CURSOR_SIZENS = 8;
    private static final int SDL_SYSTEM_CURSOR_SIZENWSE = 5;
    private static final int SDL_SYSTEM_CURSOR_SIZEWE = 7;
    private static final int SDL_SYSTEM_CURSOR_WAIT = 2;
    private static final int SDL_SYSTEM_CURSOR_WAITARROW = 4;
    private static final String TAG = "SDL";
    Handler commandHandler;
    public static boolean mBrokenLibraries;
    protected static SDLClipboardHandler mClipboardHandler;
    protected static Locale mCurrentLocale;
    public static NativeState mCurrentNativeState;
    protected static int mCurrentOrientation;
    protected static Hashtable mCursors;
    public static boolean mExitCalledFromJava;
    protected static boolean mFullscreenModeActive;
    protected static HIDDeviceManager mHIDDeviceManager;
    public static boolean mHasFocus;
    public static final boolean mHasMultiWindow;
    public static boolean mIsResumedCalled;
    protected static int mLastCursorID;
    protected static ViewGroup mLayout;
    protected static SDLGenericMotionListener_API12 mMotionListener;
    public static NativeState mNextNativeState;
    protected static Thread mSDLThread;
    protected static boolean mScreenKeyboardShown;
    protected static SDLActivity mSingleton;
    protected static SDLSurface mSurface;
    protected static DummyEdit mTextEdit;
    protected final int[] messageboxSelection;
    private final Runnable rehideSystemUi;

    static {
        SDLActivity.mHasMultiWindow = Build.VERSION.SDK_INT >= 24;
        SDLActivity.mBrokenLibraries = true;
    }

    public SDLActivity() {
        this.commandHandler = new SDLCommandHandler();
        this.messageboxSelection = new int[1];
        this.rehideSystemUi = new Runnable() {
            @Override
            public void run() {
                SDLActivity.this.getWindow().getDecorView().setSystemUiVisibility(0x1706);
            }
        };
    }

    private void appQuitFinish() {
        if(SDLActivity.mSDLThread != null) {
            SDLActivity.nativeSendQuit();
            try {
                SDLActivity.mSDLThread.join();
            }
            catch(Exception exception0) {
                Log.v("SDL", "Problem stopping SDLThread: " + exception0);
            }
        }
        SDLActivity.nativeQuit();
    }

    public static String clipboardGetText() {
        return SDLActivity.mClipboardHandler.clipboardGetText();
    }

    public static boolean clipboardHasText() {
        return SDLActivity.mClipboardHandler.clipboardHasText();
    }

    public static void clipboardSetText(String s) {
        SDLActivity.mClipboardHandler.clipboardSetText(s);
    }

    public static int createCustomCursor(int[] arr_v, int v, int v1, int v2, int v3) {
        Bitmap bitmap0 = Bitmap.createBitmap(arr_v, v, v1, Bitmap.Config.ARGB_8888);
        ++SDLActivity.mLastCursorID;
        if(Build.VERSION.SDK_INT >= 24) {
            try {
                SDLActivity.mCursors.put(SDLActivity.mLastCursorID, PointerIcon.create(bitmap0, ((float)v2), ((float)v3)));
                return SDLActivity.mLastCursorID;
            }
            catch(Exception unused_ex) {
            }
        }
        return 0;
    }

    protected SDLSurface createSDLSurface(Context context0) {
        return new SDLSurface(context0);
    }

    public static void destroyCustomCursor(int v) {
        if(Build.VERSION.SDK_INT >= 24) {
            try {
                SDLActivity.mCursors.remove(v);
            }
            catch(Exception unused_ex) {
            }
        }
    }

    @Override  // android.app.Activity
    public boolean dispatchKeyEvent(KeyEvent keyEvent0) {
        if(SDLActivity.mBrokenLibraries) {
            return false;
        }
        switch(keyEvent0.getKeyCode()) {
            case 24: 
            case 25: 
            case 27: 
            case 0xA8: 
            case 0xA9: {
                return false;
            }
            default: {
                return super.dispatchKeyEvent(keyEvent0);
            }
        }
    }

    protected String[] getArguments() {
        return new String[0];
    }

    public static View getContentView() {
        return SDLActivity.mLayout;
    }

    public static Context getContext() {
        return SDL.getContext();
    }

    public static int getCurrentOrientation() {
        Activity activity0 = (Activity)SDLActivity.getContext();
        if(activity0 == null) {
            return 0;
        }
        int v = 1;
        int v1 = activity0.getWindowManager().getDefaultDisplay().getRotation();
    alab1:
        switch(v1) {
            case 0: {
                return 3;
            label_8:
                v = 2;
                switch(v1) {
                    case 2: {
                        return 4;
                    }
                    case 3: {
                        break alab1;
                    }
                    default: {
                        return 0;
                    }
                }
            }
            case 1: {
                break;
            }
            default: {
                goto label_8;
            }
        }
        return v;
    }

    public static double getDiagonal() {
        DisplayMetrics displayMetrics0 = new DisplayMetrics();
        Activity activity0 = (Activity)SDLActivity.getContext();
        if(activity0 == null) {
            return 0.0;
        }
        activity0.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics0);
        double f = ((double)displayMetrics0.widthPixels) / ((double)displayMetrics0.xdpi);
        double f1 = ((double)displayMetrics0.heightPixels) / ((double)displayMetrics0.ydpi);
        return Math.sqrt(f * f + f1 * f1);
    }

    public static DisplayMetrics getDisplayDPI() {
        return SDLActivity.getContext().getResources().getDisplayMetrics();
    }

    protected String[] getLibraries() {
        return new String[]{"SDL2", "main"};
    }

    protected String getMainFunction() [...] // Inlined contents

    protected String getMainSharedObject() {
        String[] arr_s = SDLActivity.mSingleton.getLibraries();
        if(arr_s.length > 0) {
            String s = "lib" + arr_s[arr_s.length - 1] + ".so";
            return SDLActivity.getContext().getApplicationInfo().nativeLibraryDir + "/" + s;
        }
        return SDLActivity.getContext().getApplicationInfo().nativeLibraryDir + "/" + "libmain.so";
    }

    public static boolean getManifestEnvironmentVariables() {
        try {
            if(SDLActivity.getContext() == null) {
                return false;
            }
            Bundle bundle0 = SDLActivity.getContext().getPackageManager().getApplicationInfo("com.playstack.balatro.android", 0x80).metaData;
            if(bundle0 == null) {
                return false;
            }
            for(Object object0: bundle0.keySet()) {
                String s = (String)object0;
                if(s.startsWith("SDL_ENV.")) {
                    SDLActivity.nativeSetenv(s.substring(8), bundle0.get(s).toString());
                }
            }
            return true;
        }
        catch(Exception exception0) {
            Log.v("SDL", "exception " + exception0.toString());
            return false;
        }
    }

    protected static SDLGenericMotionListener_API12 getMotionListener() {
        SDLGenericMotionListener_API12 sDLGenericMotionListener_API120;
        if(SDLActivity.mMotionListener == null) {
            int v = Build.VERSION.SDK_INT;
            if(v >= 26) {
                sDLGenericMotionListener_API120 = new SDLGenericMotionListener_API26();
            }
            else if(v >= 24) {
                sDLGenericMotionListener_API120 = new SDLGenericMotionListener_API24();
            }
            else {
                sDLGenericMotionListener_API120 = new SDLGenericMotionListener_API12();
            }
            SDLActivity.mMotionListener = sDLGenericMotionListener_API120;
            return SDLActivity.mMotionListener;
        }
        return SDLActivity.mMotionListener;
    }

    public static Surface getNativeSurface() {
        return SDLActivity.mSurface == null ? null : SDLActivity.mSurface.getNativeSurface();
    }

    public static boolean handleKeyEvent(View view0, int v, KeyEvent keyEvent0, InputConnection inputConnection0) {
        int v1 = keyEvent0.getDeviceId();
        int v2 = keyEvent0.getSource();
        if(v2 == 0) {
            InputDevice inputDevice0 = InputDevice.getDevice(v1);
            if(inputDevice0 != null) {
                v2 = inputDevice0.getSources();
            }
        }
        if(SDLControllerManager.isDeviceSDLJoystick(v1)) {
            switch(keyEvent0.getAction()) {
                case 0: {
                    if(SDLControllerManager.onNativePadDown(v1, v) == 0) {
                        return true;
                    }
                    break;
                }
                case 1: {
                    if(SDLControllerManager.onNativePadUp(v1, v) == 0) {
                        return true;
                    }
                }
            }
        }
        if((v2 & 0x2002) == 0x2002 && (v == 4 || v == 0x7D)) {
            switch(keyEvent0.getAction()) {
                case 0: 
                case 1: {
                    return true;
                }
            }
        }
        switch(keyEvent0.getAction()) {
            case 0: {
                if(SDLActivity.isTextInputEvent(keyEvent0)) {
                    String s = String.valueOf(((char)keyEvent0.getUnicodeChar()));
                    if(inputConnection0 == null) {
                        SDLInputConnection.nativeCommitText(s, 1);
                    }
                    else {
                        inputConnection0.commitText(s, 1);
                    }
                }
                SDLActivity.onNativeKeyDown(v);
                return true;
            }
            case 1: {
                SDLActivity.onNativeKeyUp(v);
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static void handleNativeState() {
        NativeState sDLActivity$NativeState0 = SDLActivity.mNextNativeState;
        if(sDLActivity$NativeState0 == SDLActivity.mCurrentNativeState) {
            return;
        }
        if(sDLActivity$NativeState0 != NativeState.INIT) {
            if(SDLActivity.mNextNativeState != NativeState.PAUSED) {
                goto label_11;
            }
            if(SDLActivity.mSDLThread != null) {
                SDLActivity.nativePause();
            }
            SDLSurface sDLSurface0 = SDLActivity.mSurface;
            if(sDLSurface0 != null) {
                sDLSurface0.handlePause();
                SDLActivity.mCurrentNativeState = SDLActivity.mNextNativeState;
                return;
            label_11:
                if(SDLActivity.mNextNativeState == NativeState.RESUMED && SDLActivity.mSurface.mIsSurfaceReady && SDLActivity.mHasFocus && SDLActivity.mIsResumedCalled) {
                    if(SDLActivity.mSDLThread == null) {
                        SDLActivity.mSDLThread = new Thread(new SDLMain(), "SDLThread");
                        SDLActivity.mSurface.enableSensor(1, true);
                        SDLActivity.mSDLThread.start();
                    }
                    else {
                        SDLActivity.nativeResume();
                    }
                    SDLActivity.mSurface.handleResume();
                    SDLActivity.mCurrentNativeState = SDLActivity.mNextNativeState;
                }
                return;
            }
        }
        SDLActivity.mCurrentNativeState = SDLActivity.mNextNativeState;
    }

    public static void initTouch() {
        int[] arr_v = InputDevice.getDeviceIds();
        for(int v = 0; v < arr_v.length; ++v) {
            InputDevice inputDevice0 = InputDevice.getDevice(arr_v[v]);
            if(inputDevice0 != null && ((inputDevice0.getSources() & 0x1002) == 0x1002 || inputDevice0.isVirtual())) {
                int v1 = inputDevice0.getId();
                if(v1 < 0) {
                    --v1;
                }
                SDLActivity.nativeAddTouch(v1, inputDevice0.getName());
            }
        }
    }

    public static void initialize() {
        SDLActivity.mSingleton = null;
        SDLActivity.mSurface = null;
        SDLActivity.mTextEdit = null;
        SDLActivity.mLayout = null;
        SDLActivity.mClipboardHandler = null;
        SDLActivity.mCursors = new Hashtable();
        SDLActivity.mLastCursorID = 0;
        SDLActivity.mSDLThread = null;
        SDLActivity.mExitCalledFromJava = false;
        SDLActivity.mIsResumedCalled = false;
        SDLActivity.mHasFocus = true;
        SDLActivity.mNextNativeState = NativeState.INIT;
        SDLActivity.mCurrentNativeState = NativeState.INIT;
    }

    public static boolean isAndroidTV() {
        if(((UiModeManager)SDLActivity.getContext().getSystemService("uimode")).getCurrentModeType() == 4) {
            return true;
        }
        String s = Build.MANUFACTURER;
        if(s.equals("MINIX") && Build.MODEL.equals("NEO-U1")) {
            return true;
        }
        return !s.equals("Amlogic") || !Build.MODEL.equals("X96-W") ? s.equals("Amlogic") && Build.MODEL.startsWith("TV") : true;
    }

    public static boolean isChromebook() {
        return SDLActivity.getContext() == null ? false : SDLActivity.getContext().getPackageManager().hasSystemFeature("org.chromium.arc.device_management");
    }

    public static boolean isDeXMode() {
        if(Build.VERSION.SDK_INT < 24) {
            return false;
        }
        try {
            Configuration configuration0 = SDLActivity.getContext().getResources().getConfiguration();
            Class class0 = configuration0.getClass();
            if(class0.getField("SEM_DESKTOP_MODE_ENABLED").getInt(class0) == class0.getField("semDesktopModeEnabled").getInt(configuration0)) {
                return true;
            }
        }
        catch(Exception unused_ex) {
        }
        return false;
    }

    public static boolean isScreenKeyboardShown() {
        if(SDLActivity.mTextEdit == null) {
            return false;
        }
        return SDLActivity.mScreenKeyboardShown ? ((InputMethodManager)SDL.getContext().getSystemService("input_method")).isAcceptingText() : false;
    }

    public static boolean isTablet() {
        return SDLActivity.getDiagonal() >= 7.0;
    }

    // 去混淆评级： 低(30)
    public static boolean isTextInputEvent(KeyEvent keyEvent0) {
        return keyEvent0.isCtrlPressed() ? false : keyEvent0.isPrintingKey() || keyEvent0.getKeyCode() == 62;
    }

    public void loadLibraries() {
        String[] arr_s = this.getLibraries();
        for(int v = 0; v < arr_s.length; ++v) {
            SDL.loadLibrary(arr_s[v]);
        }
    }

    public static void manualBackButton() {
        SDLActivity.mSingleton.pressBackButton();
    }

    // 检测为 Lambda 实现
    protected void messageboxCreateAndShow(Bundle bundle0) [...]

    public int messageboxShowMessageBox(int v, String s, String s1, int[] arr_v, int[] arr_v1, String[] arr_s, int[] arr_v2) {
        this.messageboxSelection[0] = -1;
        if(arr_v.length != arr_v1.length && arr_v1.length != arr_s.length) {
            return -1;
        }
        Bundle bundle0 = new Bundle();
        bundle0.putInt("flags", v);
        bundle0.putString("title", s);
        bundle0.putString("message", s1);
        bundle0.putIntArray("buttonFlags", arr_v);
        bundle0.putIntArray("buttonIds", arr_v1);
        bundle0.putStringArray("buttonTexts", arr_s);
        bundle0.putIntArray("colors", arr_v2);
        this.runOnUiThread(() -> {
            int v4;
            int v2;
            int v1;
            int[] arr_v = this.val$args.getIntArray("colors");
            if(arr_v == null) {
                v1 = 0;
                v2 = 0;
                v4 = 0;
            }
            else {
                v1 = arr_v[0];
                v2 = arr_v[1];
                int v3 = arr_v[2];
                v4 = arr_v[3];
                int v5 = arr_v[4];
            }
            AlertDialog alertDialog0 = new AlertDialog.Builder(SDLActivity.this).create();
            alertDialog0.setTitle(this.val$args.getString("title"));
            alertDialog0.setCancelable(false);
            alertDialog0.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override  // android.content.DialogInterface$OnDismissListener
                public void onDismiss(DialogInterface dialogInterface0) {
                    synchronized(SDLActivity.this.messageboxSelection) {
                        SDLActivity.this.messageboxSelection.notify();
                    }
                }
            });
            TextView textView0 = new TextView(SDLActivity.this);
            textView0.setGravity(17);
            textView0.setText(this.val$args.getString("message"));
            if(v2 != 0) {
                textView0.setTextColor(v2);
            }
            int[] arr_v1 = this.val$args.getIntArray("buttonFlags");
            int[] arr_v2 = this.val$args.getIntArray("buttonIds");
            String[] arr_s = this.val$args.getStringArray("buttonTexts");
            SparseArray sparseArray0 = new SparseArray();
            LinearLayout linearLayout0 = new LinearLayout(SDLActivity.this);
            linearLayout0.setOrientation(0);
            linearLayout0.setGravity(17);
            for(int v = 0; v < arr_s.length; ++v) {
                Button button0 = new Button(SDLActivity.this);
                button0.setOnClickListener(new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        SDLActivity.this.messageboxSelection[0] = arr_v2[v];
                        alertDialog0.dismiss();
                    }
                });
                int v6 = arr_v1[v];
                if(v6 != 0) {
                    if((v6 & 1) != 0) {
                        sparseArray0.put(66, button0);
                    }
                    if((arr_v1[v] & 2) != 0) {
                        sparseArray0.put(0x6F, button0);
                    }
                }
                button0.setText(arr_s[v]);
                if(v2 != 0) {
                    button0.setTextColor(v2);
                }
                if(v4 != 0) {
                    Drawable drawable0 = button0.getBackground();
                    if(drawable0 == null) {
                        button0.setBackgroundColor(v4);
                    }
                    else {
                        drawable0.setColorFilter(v4, PorterDuff.Mode.MULTIPLY);
                    }
                }
                linearLayout0.addView(button0);
            }
            LinearLayout linearLayout1 = new LinearLayout(SDLActivity.this);
            linearLayout1.setOrientation(1);
            linearLayout1.addView(textView0);
            linearLayout1.addView(linearLayout0);
            if(v1 != 0) {
                linearLayout1.setBackgroundColor(v1);
            }
            alertDialog0.setView(linearLayout1);
            alertDialog0.setOnKeyListener(new DialogInterface.OnKeyListener() {
                @Override  // android.content.DialogInterface$OnKeyListener
                public boolean onKey(DialogInterface dialogInterface0, int v, KeyEvent keyEvent0) {
                    Button button0 = (Button)sparseArray0.get(v);
                    if(button0 != null) {
                        if(keyEvent0.getAction() == 1) {
                            button0.performClick();
                        }
                        return true;
                    }
                    return false;
                }
            });
            alertDialog0.show();
        });
        synchronized(this.messageboxSelection) {
            try {
                this.messageboxSelection.wait();
            }
            catch(InterruptedException interruptedException0) {
                interruptedException0.printStackTrace();
                return -1;
            }
        }
        return this.messageboxSelection[0];

        class org.libsdl.app.SDLActivity.3 implements Runnable {
            org.libsdl.app.SDLActivity.3(Bundle bundle0) {
            }

            @Override
            public void run() {
                SDLActivity.this.messageboxCreateAndShow(this.val$args);
            }
        }

    }

    public static void minimizeWindow() {
        if(SDLActivity.mSingleton == null) {
            return;
        }
        Intent intent0 = new Intent("android.intent.action.MAIN");
        intent0.addCategory("android.intent.category.HOME");
        intent0.setFlags(0x10000000);
        SDLActivity.mSingleton.startActivity(intent0);
    }

    public static native void nativeAddTouch(int arg0, String arg1) {
    }

    public static native void nativeFocusChanged(boolean arg0) {
    }

    public static native String nativeGetHint(String arg0) {
    }

    public static native boolean nativeGetHintBoolean(String arg0, boolean arg1) {
    }

    public static native String nativeGetVersion() {
    }

    public static native void nativeLowMemory() {
    }

    public static native void nativePause() {
    }

    public static native void nativePermissionResult(int arg0, boolean arg1) {
    }

    public static native void nativeQuit() {
    }

    public static native void nativeResume() {
    }

    public static native int nativeRunMain(String arg0, String arg1, Object arg2) {
    }

    public static native void nativeSendQuit() {
    }

    public static native void nativeSetScreenResolution(int arg0, int arg1, int arg2, int arg3, float arg4) {
    }

    public static native void nativeSetenv(String arg0, String arg1) {
    }

    public static native int nativeSetupJNI() {
    }

    @Override  // android.app.Activity
    public void onBackPressed() {
        if(SDLActivity.nativeGetHintBoolean("SDL_ANDROID_TRAP_BACK_BUTTON", false)) {
            return;
        }
        if(!this.isFinishing()) {
            super.onBackPressed();
        }
    }

    @Override  // android.app.Activity
    public void onConfigurationChanged(Configuration configuration0) {
        Log.v("SDL", "onConfigurationChanged()");
        super.onConfigurationChanged(configuration0);
        if(SDLActivity.mBrokenLibraries) {
            return;
        }
        if(SDLActivity.mCurrentLocale == null || !SDLActivity.mCurrentLocale.equals(configuration0.locale)) {
            SDLActivity.mCurrentLocale = configuration0.locale;
            SDLActivity.onNativeLocaleChanged();
        }
    }

    @Override  // android.app.Activity
    protected void onCreate(Bundle bundle0) {
        String s;
        Log.v("SDL", "Device: " + Build.DEVICE);
        Log.v("SDL", "Model: " + Build.MODEL);
        Log.v("SDL", "onCreate()");
        super.onCreate(bundle0);
        try {
            Thread.currentThread().setName("SDLActivity");
        }
        catch(Exception exception0) {
            Log.v("SDL", "modify thread properties failed " + exception0.toString());
        }
        try {
            this.loadLibraries();
            SDLActivity.mBrokenLibraries = false;
            s = "";
        }
        catch(UnsatisfiedLinkError | Exception unsatisfiedLinkError0) {
            System.err.println(unsatisfiedLinkError0.getMessage());
            SDLActivity.mBrokenLibraries = true;
            s = unsatisfiedLinkError0.getMessage();
        }
        if(!SDLActivity.mBrokenLibraries) {
            String s1 = SDLActivity.nativeGetVersion();
            if(!s1.equals("2.28.5")) {
                SDLActivity.mBrokenLibraries = true;
                s = "SDL C/Java version mismatch (expected 2.28.5, got " + s1 + ")";
            }
        }
        if(SDLActivity.mBrokenLibraries) {
            SDLActivity.mSingleton = this;
            AlertDialog.Builder alertDialog$Builder0 = new AlertDialog.Builder(this);
            alertDialog$Builder0.setMessage("An error occurred while trying to start the application. Please try again and/or reinstall.\n\nError: " + s);
            alertDialog$Builder0.setTitle("SDL Error");
            alertDialog$Builder0.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                @Override  // android.content.DialogInterface$OnClickListener
                public void onClick(DialogInterface dialogInterface0, int v) {
                    SDLActivity.mSingleton.finish();
                }
            });
            alertDialog$Builder0.setCancelable(false);
            alertDialog$Builder0.create().show();
            return;
        }
        this.startNative();
    }

    @Override  // android.app.Activity
    protected void onDestroy() {
        Log.v("SDL", "onDestroy()");
        HIDDeviceManager hIDDeviceManager0 = SDLActivity.mHIDDeviceManager;
        if(hIDDeviceManager0 != null) {
            HIDDeviceManager.release(hIDDeviceManager0);
            SDLActivity.mHIDDeviceManager = null;
        }
        SDLAudioManager.release(this);
        if(SDLActivity.mBrokenLibraries) {
            super.onDestroy();
            return;
        }
        this.appQuitFinish();
        super.onDestroy();
    }

    @Override  // android.app.Activity
    public void onLowMemory() {
        Log.v("SDL", "onLowMemory()");
        super.onLowMemory();
        if(SDLActivity.mBrokenLibraries) {
            return;
        }
        SDLActivity.nativeLowMemory();
    }

    public static native void onNativeAccel(float arg0, float arg1, float arg2) {
    }

    public static native void onNativeClipboardChanged() {
    }

    public static native void onNativeDropFile(String arg0) {
    }

    public static native void onNativeKeyDown(int arg0) {
    }

    public static native void onNativeKeyUp(int arg0) {
    }

    public static native void onNativeKeyboardFocusLost() {
    }

    public static native void onNativeLocaleChanged() {
    }

    public static native void onNativeMouse(int arg0, int arg1, float arg2, float arg3, boolean arg4) {
    }

    public static native void onNativeOrientationChanged(int arg0) {
    }

    public static native void onNativeResize() {
    }

    public static native boolean onNativeSoftReturnKey() {
    }

    public static native void onNativeSurfaceChanged() {
    }

    public static native void onNativeSurfaceCreated() {
    }

    public static native void onNativeSurfaceDestroyed() {
    }

    public static native void onNativeTouch(int arg0, int arg1, int arg2, float arg3, float arg4, float arg5) {
    }

    @Override  // android.app.Activity
    protected void onPause() {
        Log.v("SDL", "onPause()");
        super.onPause();
        HIDDeviceManager hIDDeviceManager0 = SDLActivity.mHIDDeviceManager;
        if(hIDDeviceManager0 != null) {
            hIDDeviceManager0.setFrozen(true);
        }
        if(!SDLActivity.mHasMultiWindow) {
            this.pauseNativeThread();
        }
    }

    @Override  // android.app.Activity
    public void onRequestPermissionsResult(int v, String[] arr_s, int[] arr_v) {
        SDLActivity.nativePermissionResult(v, arr_v.length > 0 && arr_v[0] == 0);
    }

    @Override  // android.app.Activity
    protected void onResume() {
        Log.v("SDL", "onResume()");
        super.onResume();
        HIDDeviceManager hIDDeviceManager0 = SDLActivity.mHIDDeviceManager;
        if(hIDDeviceManager0 != null) {
            hIDDeviceManager0.setFrozen(false);
        }
        if(!SDLActivity.mHasMultiWindow) {
            this.resumeNativeThread();
        }
    }

    @Override  // android.app.Activity
    protected void onStart() {
        Log.v("SDL", "onStart()");
        super.onStart();
        if(SDLActivity.mHasMultiWindow) {
            this.resumeNativeThread();
        }
    }

    @Override  // android.app.Activity
    protected void onStop() {
        Log.v("SDL", "onStop()");
        super.onStop();
        if(SDLActivity.mHasMultiWindow) {
            this.pauseNativeThread();
        }
    }

    @Override  // android.view.View$OnSystemUiVisibilityChangeListener
    public void onSystemUiVisibilityChange(int v) {
        if(SDLActivity.mFullscreenModeActive && ((v & 4) == 0 || (v & 2) == 0)) {
            Handler handler0 = this.getWindow().getDecorView().getHandler();
            if(handler0 != null) {
                handler0.removeCallbacks(this.rehideSystemUi);
                handler0.postDelayed(this.rehideSystemUi, 2000L);
            }
        }
    }

    protected boolean onUnhandledMessage(int v, Object object0) {
        return false;
    }

    @Override  // android.app.Activity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        Log.v("SDL", "onWindowFocusChanged(): " + z);
        if(SDLActivity.mBrokenLibraries) {
            return;
        }
        SDLActivity.mHasFocus = z;
        if(z) {
            SDLActivity.mNextNativeState = NativeState.RESUMED;
            SDLActivity.getMotionListener().reclaimRelativeMouseModeIfNeeded();
            SDLActivity.handleNativeState();
            SDLActivity.nativeFocusChanged(true);
            return;
        }
        SDLActivity.nativeFocusChanged(false);
        if(!SDLActivity.mHasMultiWindow) {
            SDLActivity.mNextNativeState = NativeState.PAUSED;
            SDLActivity.handleNativeState();
        }
    }

    public static int openURL(String s) {
        try {
            Intent intent0 = new Intent("android.intent.action.VIEW");
            intent0.setData(Uri.parse(s));
            intent0.addFlags(0x48080000);
            SDLActivity.mSingleton.startActivity(intent0);
            return 0;
        }
        catch(Exception unused_ex) {
            return -1;
        }
    }

    protected void pauseNativeThread() {
        SDLActivity.mNextNativeState = NativeState.PAUSED;
        SDLActivity.mIsResumedCalled = false;
        if(SDLActivity.mBrokenLibraries) {
            return;
        }
        SDLActivity.handleNativeState();
    }

    public void pressBackButton() {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(!SDLActivity.this.isFinishing()) {
                    SDLActivity.this.superOnBackPressed();
                }
            }
        });
    }

    public static void requestPermission(String s, int v) {
        Activity activity0 = (Activity)SDLActivity.getContext();
        if(activity0.checkSelfPermission(s) != 0) {
            activity0.requestPermissions(new String[]{s}, v);
            return;
        }
        SDLActivity.nativePermissionResult(v, true);
    }

    public void resetNative() {
        Log.v("SDL", "resetNative()");
        SDLActivity.mExitCalledFromJava = true;
        this.appQuitFinish();
    }

    protected void resumeNativeThread() {
        SDLActivity.mNextNativeState = NativeState.RESUMED;
        SDLActivity.mIsResumedCalled = true;
        if(SDLActivity.mBrokenLibraries) {
            return;
        }
        SDLActivity.handleNativeState();
    }

    boolean sendCommand(int v, Object object0) {
        int v1 = 0;
        Message message0 = this.commandHandler.obtainMessage();
        message0.arg1 = v;
        message0.obj = object0;
        boolean z = this.commandHandler.sendMessage(message0);
        if(v == 2) {
            if(object0 instanceof Integer) {
                Display display0 = ((WindowManager)this.getSystemService("window")).getDefaultDisplay();
                DisplayMetrics displayMetrics0 = new DisplayMetrics();
                display0.getRealMetrics(displayMetrics0);
                if(displayMetrics0.widthPixels == SDLActivity.mSurface.getWidth() && displayMetrics0.heightPixels == SDLActivity.mSurface.getHeight()) {
                    v1 = 1;
                }
                if(((int)(((Integer)object0))) == 1) {
                    v1 ^= 1;
                }
            }
            if(v1 != 0 && SDLActivity.getContext() != null) {
                synchronized(SDLActivity.getContext()) {
                    try {
                        SDLActivity.getContext().wait(500L);
                    }
                    catch(InterruptedException interruptedException0) {
                        interruptedException0.printStackTrace();
                    }
                }
            }
        }
        return z;
    }

    public static boolean sendMessage(int v, int v1) {
        return SDLActivity.mSingleton == null ? false : SDLActivity.mSingleton.sendCommand(v, v1);
    }

    public static boolean setActivityTitle(String s) {
        return SDLActivity.mSingleton.sendCommand(1, s);
    }

    public static boolean setCustomCursor(int v) {
        if(Build.VERSION.SDK_INT >= 24) {
            try {
                SDLActivity.mSurface.setPointerIcon(a.a(SDLActivity.mCursors.get(v)));
                return true;
            }
            catch(Exception unused_ex) {
            }
        }
        return false;
    }

    public static void setOrientation(int v, int v1, boolean z, String s) {
        SDLActivity sDLActivity0 = SDLActivity.mSingleton;
        if(sDLActivity0 != null) {
            sDLActivity0.setOrientationBis(v, v1, z, s);
        }
    }

    public void setOrientationBis(int v, int v1, boolean z, String s) {
        int v4;
        int v2;
        boolean z1 = false;
        if(s.contains("LandscapeRight") && s.contains("LandscapeLeft")) {
            v2 = 6;
        }
        else if(s.contains("LandscapeLeft")) {
            v2 = 0;
        }
        else {
            v2 = s.contains("LandscapeRight") ? 8 : -1;
        }
        boolean z2 = s.contains("Portrait ") || s.endsWith("Portrait");
        int v3 = 7;
        if(z2 && s.contains("PortraitUpsideDown")) {
            v4 = 7;
        }
        else if(z2) {
            v4 = 1;
        }
        else {
            v4 = s.contains("PortraitUpsideDown") ? 9 : -1;
        }
        boolean z3 = v2 != -1;
        if(v4 != -1) {
            z1 = true;
        }
        int v5 = 10;
        if(z1 || z3) {
            if(!z) {
                if(!(!z1 || !z3 ? z3 : v > v1)) {
                    v2 = v4;
                }
                v5 = v2;
            }
            else if(!z1 || !z3) {
                if(!z3) {
                    v2 = v4;
                }
                v5 = v2;
            }
        }
        else if(!z) {
            if(v > v1) {
                v3 = 6;
            }
            v5 = v3;
        }
        Log.v("SDL", "setOrientation() requestedOrientation=" + v5 + " width=" + v + " height=" + v1 + " resizable=" + z + " hint=" + s);
        SDLActivity.mSingleton.setRequestedOrientation(6);
    }

    // 去混淆评级： 低(20)
    public static boolean setRelativeMouseEnabled(boolean z) {
        return !z || SDLActivity.supportsRelativeMouse() ? SDLActivity.getMotionListener().setRelativeMouseEnabled(z) : false;
    }

    public static boolean setSystemCursor(int v) {
        int v1 = 1004;
        switch(v) {
            case 0: {
                v1 = 1000;
                break;
            }
            case 1: {
                v1 = 0x3F0;
                break;
            }
            case 3: {
                v1 = 1007;
                break;
            }
            case 2: 
            case 4: {
                break;
            }
            case 5: {
                v1 = 0x3F9;
                break;
            }
            case 6: {
                v1 = 0x3F8;
                break;
            }
            case 7: {
                v1 = 0x3F6;
                break;
            }
            case 8: {
                v1 = 0x3F7;
                break;
            }
            case 9: {
                v1 = 1020;
                break;
            }
            case 10: {
                v1 = 0x3F4;
                break;
            }
            case 11: {
                v1 = 1002;
                break;
            }
            default: {
                v1 = 0;
            }
        }
        if(Build.VERSION.SDK_INT >= 24) {
            try {
                SDLActivity.mSurface.setPointerIcon(PointerIcon.getSystemIcon(SDL.getContext(), v1));
                return true;
            }
            catch(Exception unused_ex) {
                return false;
            }
        }
        return true;
    }

    public static void setWindowStyle(boolean z) {
        SDLActivity.mSingleton.sendCommand(2, ((int)z));
    }

    public static boolean shouldMinimizeOnFocusLoss() {
        return false;
    }

    public static boolean showTextInput(int v, int v1, int v2, int v3) {
        return SDLActivity.mSingleton.commandHandler.post(new ShowTextInputTask(v, v1, v2, v3));
    }

    public static int showToast(String s, int v, int v1, int v2, int v3) {
        class OneShotTask implements Runnable {
            int mDuration;
            int mGravity;
            String mMessage;
            int mXOffset;
            int mYOffset;

            OneShotTask(String s, int v, int v1, int v2, int v3) {
                this.mDuration = v;
                this.mGravity = v1;
                this.mXOffset = v2;
                this.mYOffset = v3;
            }

            @Override
            public void run() {
                try {
                    Toast toast0 = Toast.makeText(SDLActivity.mSingleton, this.mMessage, this.mDuration);
                    int v = this.mGravity;
                    if(v >= 0) {
                        toast0.setGravity(v, this.mXOffset, this.mYOffset);
                    }
                    toast0.show();
                }
                catch(Exception exception0) {
                    Log.e("SDL", exception0.getMessage());
                }
            }
        }

        SDLActivity sDLActivity0 = SDLActivity.mSingleton;
        if(sDLActivity0 == null) {
            return -1;
        }
        try {
            sDLActivity0.runOnUiThread(new OneShotTask(s, v, v1, v2, v3));
            return 0;
        }
        catch(Exception unused_ex) {
            return -1;
        }
    }

    public void startNative() {
        boolean z = SDLActivity.mSDLThread != null;
        SDL.setupJNI();
        SDL.initialize();
        SDLActivity.mSingleton = this;
        SDL.setContext(this);
        SDLActivity.mClipboardHandler = new SDLClipboardHandler();
        SDLActivity.mHIDDeviceManager = HIDDeviceManager.acquire(this);
        SDLActivity.mSurface = this.createSDLSurface(this);
        RelativeLayout relativeLayout0 = new RelativeLayout(this);
        SDLActivity.mLayout = relativeLayout0;
        relativeLayout0.addView(SDLActivity.mSurface);
        int v = SDLActivity.getCurrentOrientation();
        SDLActivity.mCurrentOrientation = v;
        SDLActivity.onNativeOrientationChanged(v);
        try {
            SDLActivity.mCurrentLocale = Build.VERSION.SDK_INT >= 24 ? SDLActivity.getContext().getResources().getConfiguration().getLocales().get(0) : SDLActivity.getContext().getResources().getConfiguration().locale;
        }
        catch(Exception unused_ex) {
        }
        this.setContentView(SDLActivity.mLayout);
        SDLActivity.setWindowStyle(false);
        this.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(this);
        Intent intent0 = this.getIntent();
        if(intent0 != null && intent0.getData() != null) {
            String s = intent0.getData().getPath();
            if(s != null) {
                Log.v("SDL", "Got filename: " + s);
                SDLActivity.onNativeDropFile(s);
            }
        }
        if(z) {
            this.resumeNativeThread();
        }
    }

    public void superOnBackPressed() {
        super.onBackPressed();
    }

    public static boolean supportsRelativeMouse() {
        return Build.VERSION.SDK_INT >= 27 || !SDLActivity.isDeXMode() ? SDLActivity.getMotionListener().supportsRelativeMouse() : false;
    }
}

