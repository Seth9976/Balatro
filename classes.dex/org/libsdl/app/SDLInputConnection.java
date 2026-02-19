package org.libsdl.app;

import android.os.Build.VERSION;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.EditText;

class SDLInputConnection extends BaseInputConnection {
    protected String mCommittedText;
    protected EditText mEditText;

    public SDLInputConnection(View view0, boolean z) {
        super(view0, z);
        this.mCommittedText = "";
        this.mEditText = new EditText(SDL.getContext());
    }

    @Override  // android.view.inputmethod.BaseInputConnection
    public boolean commitText(CharSequence charSequence0, int v) {
        if(!super.commitText(charSequence0, v)) {
            return false;
        }
        this.updateText();
        return true;
    }

    @Override  // android.view.inputmethod.BaseInputConnection
    public boolean deleteSurroundingText(int v, int v1) {
        if(Build.VERSION.SDK_INT <= 29 && v > 0 && v1 == 0) {
            while(v > 0) {
                SDLInputConnection.nativeGenerateScancodeForUnichar('\b');
                --v;
            }
            return true;
        }
        if(!super.deleteSurroundingText(v, v1)) {
            return false;
        }
        this.updateText();
        return true;
    }

    @Override  // android.view.inputmethod.BaseInputConnection
    public Editable getEditable() {
        return this.mEditText.getEditableText();
    }

    public static native void nativeCommitText(String arg0, int arg1) {
    }

    public static native void nativeGenerateScancodeForUnichar(char arg0) {
    }

    @Override  // android.view.inputmethod.BaseInputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent0) {
        return keyEvent0.getKeyCode() != 66 || !SDLActivity.onNativeSoftReturnKey() ? super.sendKeyEvent(keyEvent0) : true;
    }

    @Override  // android.view.inputmethod.BaseInputConnection
    public boolean setComposingText(CharSequence charSequence0, int v) {
        if(!super.setComposingText(charSequence0, v)) {
            return false;
        }
        this.updateText();
        return true;
    }

    protected void updateText() {
        Editable editable0 = this.getEditable();
        if(editable0 == null) {
            return;
        }
        String s = editable0.toString();
        int v = Math.min(s.length(), this.mCommittedText.length());
        int v1;
        for(v1 = 0; v1 < v; v1 += Character.charCount(v2)) {
            int v2 = this.mCommittedText.codePointAt(v1);
            if(v2 != s.codePointAt(v1)) {
                break;
            }
        }
        for(int v3 = v1; v3 < this.mCommittedText.length(); v3 += Character.charCount(v4)) {
            int v4 = this.mCommittedText.codePointAt(v3);
            SDLInputConnection.nativeGenerateScancodeForUnichar('\b');
        }
        if(v1 < s.length()) {
            String s1 = s.subSequence(v1, s.length()).toString();
            for(int v5 = 0; v5 < s1.length(); v5 += Character.charCount(v6)) {
                int v6 = s1.codePointAt(v5);
                if(v6 == 10 && SDLActivity.onNativeSoftReturnKey()) {
                    return;
                }
                if(v6 < 0x80) {
                    SDLInputConnection.nativeGenerateScancodeForUnichar(((char)v6));
                }
            }
            SDLInputConnection.nativeCommitText(s1, 0);
        }
        this.mCommittedText = s;
    }
}

