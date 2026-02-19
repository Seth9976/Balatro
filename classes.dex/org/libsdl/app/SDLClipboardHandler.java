package org.libsdl.app;

import android.content.ClipData.Item;
import android.content.ClipData;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.content.ClipboardManager;

class SDLClipboardHandler implements ClipboardManager.OnPrimaryClipChangedListener {
    protected ClipboardManager mClipMgr;

    SDLClipboardHandler() {
        ClipboardManager clipboardManager0 = (ClipboardManager)SDL.getContext().getSystemService("clipboard");
        this.mClipMgr = clipboardManager0;
        clipboardManager0.addPrimaryClipChangedListener(this);
    }

    public String clipboardGetText() {
        ClipData clipData0 = this.mClipMgr.getPrimaryClip();
        if(clipData0 != null) {
            ClipData.Item clipData$Item0 = clipData0.getItemAt(0);
            if(clipData$Item0 != null) {
                CharSequence charSequence0 = clipData$Item0.getText();
                return charSequence0 == null ? null : charSequence0.toString();
            }
        }
        return null;
    }

    public boolean clipboardHasText() {
        return this.mClipMgr.hasPrimaryClip();
    }

    public void clipboardSetText(String s) {
        this.mClipMgr.removePrimaryClipChangedListener(this);
        ClipData clipData0 = ClipData.newPlainText(null, s);
        this.mClipMgr.setPrimaryClip(clipData0);
        this.mClipMgr.addPrimaryClipChangedListener(this);
    }

    @Override  // android.content.ClipboardManager$OnPrimaryClipChangedListener
    public void onPrimaryClipChanged() {
        SDLActivity.onNativeClipboardChanged();
    }
}

