package org.libsdl.app;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View.OnKeyListener;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

class DummyEdit extends View implements View.OnKeyListener {
    InputConnection ic;

    public DummyEdit(Context context0) {
        super(context0);
        this.setFocusableInTouchMode(true);
        this.setFocusable(true);
        this.setOnKeyListener(this);
    }

    @Override  // android.view.View
    public boolean onCheckIsTextEditor() {
        return true;
    }

    @Override  // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo0) {
        InputConnection inputConnection0 = new SDLInputConnection(this, true);
        this.ic = inputConnection0;
        editorInfo0.inputType = 0x20001;
        editorInfo0.imeOptions = 0x12000000;
        return inputConnection0;
    }

    @Override  // android.view.View$OnKeyListener
    public boolean onKey(View view0, int v, KeyEvent keyEvent0) {
        return SDLActivity.handleKeyEvent(view0, v, keyEvent0, this.ic);
    }

    @Override  // android.view.View
    public boolean onKeyPreIme(int v, KeyEvent keyEvent0) {
        if(keyEvent0.getAction() == 1 && v == 4 && (SDLActivity.mTextEdit != null && SDLActivity.mTextEdit.getVisibility() == 0)) {
            SDLActivity.onNativeKeyboardFocusLost();
        }
        return super.onKeyPreIme(v, keyEvent0);
    }
}

