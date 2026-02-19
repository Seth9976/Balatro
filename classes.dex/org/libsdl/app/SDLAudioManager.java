package org.libsdl.app;

import android.content.Context;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.Log;
import java.util.Arrays;

public class SDLAudioManager {
    private static final int[] NO_DEVICES = null;
    protected static final String TAG = "SDLAudio";
    private static AudioDeviceCallback mAudioDeviceCallback;
    protected static AudioRecord mAudioRecord;
    protected static AudioTrack mAudioTrack;
    protected static Context mContext;

    static {
        SDLAudioManager.NO_DEVICES = new int[0];
    }

    public static native void addAudioDevice(boolean arg0, int arg1) {
    }

    public static void audioClose() {
        AudioTrack audioTrack0 = SDLAudioManager.mAudioTrack;
        if(audioTrack0 != null) {
            audioTrack0.stop();
            SDLAudioManager.mAudioTrack.release();
            SDLAudioManager.mAudioTrack = null;
        }
    }

    public static int[] audioOpen(int v, int v1, int v2, int v3, int v4) {
        return SDLAudioManager.open(false, v, v1, v2, v3, v4);
    }

    public static void audioSetThreadPriority(boolean z, int v) {
        String s;
        Thread thread0;
        try {
            if(z) {
                thread0 = Thread.currentThread();
                s = "SDLAudioC" + v;
            }
            else {
                thread0 = Thread.currentThread();
                s = "SDLAudioP" + v;
            }
            thread0.setName(s);
            Process.setThreadPriority(-16);
        }
        catch(Exception exception0) {
            Log.v("SDLAudio", "modify thread properties failed " + exception0.toString());
        }
    }

    public static void audioWriteByteBuffer(byte[] arr_b) {
        if(SDLAudioManager.mAudioTrack == null) {
            Log.e("SDLAudio", "Attempted to make audio call with uninitialized audio!");
            return;
        }
        int v = 0;
        while(v < arr_b.length) {
            int v1 = SDLAudioManager.mAudioTrack.write(arr_b, v, arr_b.length - v);
            if(v1 > 0) {
                v += v1;
            }
            else if(v1 == 0) {
                try {
                    Thread.sleep(1L);
                }
                catch(InterruptedException unused_ex) {
                }
            }
            else {
                Log.w("SDLAudio", "SDL audio: error return from write(byte)");
                if(true) {
                    break;
                }
            }
        }
    }

    public static void audioWriteFloatBuffer(float[] arr_f) {
        if(SDLAudioManager.mAudioTrack == null) {
            Log.e("SDLAudio", "Attempted to make audio call with uninitialized audio!");
            return;
        }
        int v = 0;
        while(v < arr_f.length) {
            int v1 = SDLAudioManager.mAudioTrack.write(arr_f, v, arr_f.length - v, 0);
            if(v1 > 0) {
                v += v1;
            }
            else if(v1 == 0) {
                try {
                    Thread.sleep(1L);
                }
                catch(InterruptedException unused_ex) {
                }
            }
            else {
                Log.w("SDLAudio", "SDL audio: error return from write(float)");
                if(true) {
                    break;
                }
            }
        }
    }

    public static void audioWriteShortBuffer(short[] arr_v) {
        if(SDLAudioManager.mAudioTrack == null) {
            Log.e("SDLAudio", "Attempted to make audio call with uninitialized audio!");
            return;
        }
        int v = 0;
        while(v < arr_v.length) {
            int v1 = SDLAudioManager.mAudioTrack.write(arr_v, v, arr_v.length - v);
            if(v1 > 0) {
                v += v1;
            }
            else if(v1 == 0) {
                try {
                    Thread.sleep(1L);
                }
                catch(InterruptedException unused_ex) {
                }
            }
            else {
                Log.w("SDLAudio", "SDL audio: error return from write(short)");
                if(true) {
                    break;
                }
            }
        }
    }

    public static void captureClose() {
        AudioRecord audioRecord0 = SDLAudioManager.mAudioRecord;
        if(audioRecord0 != null) {
            audioRecord0.stop();
            SDLAudioManager.mAudioRecord.release();
            SDLAudioManager.mAudioRecord = null;
        }
    }

    public static int[] captureOpen(int v, int v1, int v2, int v3, int v4) {
        return SDLAudioManager.open(true, v, v1, v2, v3, v4);
    }

    public static int captureReadByteBuffer(byte[] arr_b, boolean z) {
        return SDLAudioManager.mAudioRecord.read(arr_b, 0, arr_b.length, !z);
    }

    public static int captureReadFloatBuffer(float[] arr_f, boolean z) {
        return SDLAudioManager.mAudioRecord.read(arr_f, 0, arr_f.length, !z);
    }

    public static int captureReadShortBuffer(short[] arr_v, boolean z) {
        return SDLAudioManager.mAudioRecord.read(arr_v, 0, arr_v.length, !z);
    }

    protected static String getAudioFormatString(int v) {
        switch(v) {
            case 2: {
                return "16-bit";
            }
            case 3: {
                return "8-bit";
            }
            case 4: {
                return "float";
            }
            default: {
                return Integer.toString(v);
            }
        }
    }

    public static int[] getAudioInputDevices() {
        return Build.VERSION.SDK_INT < 24 ? SDLAudioManager.NO_DEVICES : Arrays.stream(((AudioManager)SDLAudioManager.mContext.getSystemService("audio")).getDevices(1)).mapToInt(new l()).toArray();
    }

    public static int[] getAudioOutputDevices() {
        return Build.VERSION.SDK_INT < 24 ? SDLAudioManager.NO_DEVICES : Arrays.stream(((AudioManager)SDLAudioManager.mContext.getSystemService("audio")).getDevices(2)).mapToInt(new l()).toArray();
    }

    private static AudioDeviceInfo getInputAudioDeviceInfo(int v) {
        return Build.VERSION.SDK_INT < 24 ? null : ((AudioDeviceInfo)Arrays.stream(((AudioManager)SDLAudioManager.mContext.getSystemService("audio")).getDevices(1)).filter((AudioDeviceInfo audioDeviceInfo0) -> audioDeviceInfo0.getId() == v).findFirst().orElse(null));
    }

    private static AudioDeviceInfo getOutputAudioDeviceInfo(int v) {
        return Build.VERSION.SDK_INT < 24 ? null : ((AudioDeviceInfo)Arrays.stream(((AudioManager)SDLAudioManager.mContext.getSystemService("audio")).getDevices(2)).filter((AudioDeviceInfo audioDeviceInfo0) -> audioDeviceInfo0.getId() == v).findFirst().orElse(null));
    }

    public static void initialize() {
        SDLAudioManager.mAudioTrack = null;
        SDLAudioManager.mAudioRecord = null;
        SDLAudioManager.mAudioDeviceCallback = null;
        if(Build.VERSION.SDK_INT >= 24) {
            SDLAudioManager.mAudioDeviceCallback = new AudioDeviceCallback() {
                // 检测为 Lambda 实现
                private static void lambda$onAudioDevicesAdded$0(AudioDeviceInfo audioDeviceInfo0) [...]

                // 检测为 Lambda 实现
                private static void lambda$onAudioDevicesRemoved$1(AudioDeviceInfo audioDeviceInfo0) [...]

                @Override  // android.media.AudioDeviceCallback
                public void onAudioDevicesAdded(AudioDeviceInfo[] arr_audioDeviceInfo) {
                    Arrays.stream(arr_audioDeviceInfo).forEach((AudioDeviceInfo audioDeviceInfo0) -> SDLAudioManager.addAudioDevice(audioDeviceInfo0.isSink(), audioDeviceInfo0.getId()));
                }

                @Override  // android.media.AudioDeviceCallback
                public void onAudioDevicesRemoved(AudioDeviceInfo[] arr_audioDeviceInfo) {
                    Arrays.stream(arr_audioDeviceInfo).forEach((AudioDeviceInfo audioDeviceInfo0) -> SDLAudioManager.removeAudioDevice(audioDeviceInfo0.isSink(), audioDeviceInfo0.getId()));
                }
            };
        }
    }

    // 检测为 Lambda 实现
    private static boolean lambda$getInputAudioDeviceInfo$0(int v, AudioDeviceInfo audioDeviceInfo0) [...]

    // 检测为 Lambda 实现
    private static boolean lambda$getOutputAudioDeviceInfo$1(int v, AudioDeviceInfo audioDeviceInfo0) [...]

    public static native int nativeSetupJNI() {
    }

    protected static int[] open(boolean z, int v, int v1, int v2, int v3, int v4) {
        int[] arr_v1;
        StringBuilder stringBuilder0;
        int v8;
        int v7;
        Log.v("SDLAudio", "Opening " + (z ? "capture" : "playback") + ", requested " + v3 + " frames of " + v2 + " channel " + SDLAudioManager.getAudioFormatString(v1) + " audio at " + v + " Hz");
        int v5 = Build.VERSION.SDK_INT;
        int v6 = v1 != 4 || v5 >= (z ? 23 : 21) ? v1 : 2;
        switch(v6) {
            case 2: {
                v7 = 2;
                break;
            }
            case 3: {
                v7 = 1;
                break;
            }
            default: {
                if(v6 == 4) {
                    v7 = 4;
                }
                else {
                    Log.v("SDLAudio", "Requested format " + v6 + ", getting ENCODING_PCM_16BIT");
                    v6 = 2;
                    v7 = 2;
                }
            }
        }
        if(z) {
            switch(v2) {
                case 1: {
                    v8 = 16;
                    break;
                }
                case 2: {
                    v8 = 12;
                    break;
                }
                default: {
                    stringBuilder0 = new StringBuilder();
                    goto label_24;
                }
            }
        }
        else {
            switch(v2) {
                case 1: {
                    v8 = 4;
                    break;
                }
                case 2: {
                    v8 = 12;
                    break;
                }
                case 3: {
                    v8 = 28;
                    break;
                }
                case 4: {
                    v8 = 204;
                    break;
                }
                case 5: {
                    v8 = 220;
                    break;
                }
                case 6: {
                    v8 = 0xFC;
                    break;
                }
                case 7: {
                    v8 = 0x4FC;
                    break;
                }
                case 8: {
                    v8 = 0x18FC;
                    break;
                }
                default: {
                    stringBuilder0 = new StringBuilder();
                label_24:
                    stringBuilder0.append("Requested ");
                    stringBuilder0.append(v2);
                    stringBuilder0.append(" channels, getting stereo");
                    Log.v("SDLAudio", stringBuilder0.toString());
                    v8 = 12;
                    v2 = 2;
                }
            }
        }
        int v9 = v7 * v2;
        int v10 = Math.max(v3, ((z ? AudioRecord.getMinBufferSize(v, v8, v6) : AudioTrack.getMinBufferSize(v, v8, v6)) + v9 - 1) / v9);
        int[] arr_v = new int[4];
        if(z) {
            if(SDLAudioManager.mAudioRecord == null) {
                arr_v1 = arr_v;
                AudioRecord audioRecord0 = new AudioRecord(0, v, v8, v6, v9 * v10);
                SDLAudioManager.mAudioRecord = audioRecord0;
                if(audioRecord0.getState() != 1) {
                    Log.e("SDLAudio", "Failed during initialization of AudioRecord");
                    SDLAudioManager.mAudioRecord.release();
                    SDLAudioManager.mAudioRecord = null;
                    return null;
                }
                if(v5 >= 24 && v4 != 0) {
                    SDLAudioManager.mAudioRecord.setPreferredDevice(SDLAudioManager.getOutputAudioDeviceInfo(v4));
                }
                SDLAudioManager.mAudioRecord.startRecording();
            }
            else {
                arr_v1 = arr_v;
            }
            arr_v1[0] = SDLAudioManager.mAudioRecord.getSampleRate();
            arr_v1[1] = SDLAudioManager.mAudioRecord.getAudioFormat();
            arr_v1[2] = SDLAudioManager.mAudioRecord.getChannelCount();
        }
        else {
            arr_v1 = arr_v;
            if(SDLAudioManager.mAudioTrack == null) {
                AudioTrack audioTrack0 = new AudioTrack(3, v, v8, v6, v9 * v10, 1);
                SDLAudioManager.mAudioTrack = audioTrack0;
                if(audioTrack0.getState() != 1) {
                    Log.e("SDLAudio", "Failed during initialization of Audio Track");
                    SDLAudioManager.mAudioTrack.release();
                    SDLAudioManager.mAudioTrack = null;
                    return null;
                }
                if(v5 >= 24 && v4 != 0) {
                    SDLAudioManager.mAudioTrack.setPreferredDevice(SDLAudioManager.getInputAudioDeviceInfo(v4));
                }
                SDLAudioManager.mAudioTrack.play();
            }
            arr_v1[0] = SDLAudioManager.mAudioTrack.getSampleRate();
            arr_v1[1] = SDLAudioManager.mAudioTrack.getAudioFormat();
            arr_v1[2] = SDLAudioManager.mAudioTrack.getChannelCount();
        }
        arr_v1[3] = v10;
        Log.v("SDLAudio", "Opening " + (z ? "capture" : "playback") + ", got " + arr_v1[3] + " frames of " + arr_v1[2] + " channel " + SDLAudioManager.getAudioFormatString(arr_v1[1]) + " audio at " + arr_v1[0] + " Hz");
        return arr_v1;
    }

    private static void registerAudioDeviceCallback() {
        if(Build.VERSION.SDK_INT >= 24) {
            ((AudioManager)SDLAudioManager.mContext.getSystemService("audio")).registerAudioDeviceCallback(SDLAudioManager.mAudioDeviceCallback, null);
        }
    }

    public static void release(Context context0) {
        SDLAudioManager.unregisterAudioDeviceCallback(context0);
    }

    public static native void removeAudioDevice(boolean arg0, int arg1) {
    }

    public static void setContext(Context context0) {
        SDLAudioManager.mContext = context0;
        if(context0 != null) {
            SDLAudioManager.registerAudioDeviceCallback();
        }
    }

    private static void unregisterAudioDeviceCallback(Context context0) {
        if(Build.VERSION.SDK_INT >= 24) {
            ((AudioManager)context0.getSystemService("audio")).unregisterAudioDeviceCallback(SDLAudioManager.mAudioDeviceCallback);
        }
    }
}

