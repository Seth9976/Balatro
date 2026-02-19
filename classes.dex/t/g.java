package t;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.e.e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

final class g implements TextWatcher {
    static class a extends e {
        private final Reference a;

        a(EditText editText0) {
            this.a = new WeakReference(editText0);
        }

        @Override  // androidx.emoji2.text.e$e
        public void b() {
            super.b();
            g.b(((EditText)this.a.get()), 1);
        }
    }

    private final EditText a;
    private final boolean b;
    private e c;
    private int d;
    private int e;
    private boolean f;

    g(EditText editText0, boolean z) {
        this.d = 0x7FFFFFFF;
        this.e = 0;
        this.a = editText0;
        this.b = z;
        this.f = true;
    }

    private e a() {
        if(this.c == null) {
            this.c = new a(this.a);
        }
        return this.c;
    }

    @Override  // android.text.TextWatcher
    public void afterTextChanged(Editable editable0) {
    }

    static void b(EditText editText0, int v) {
        if(v == 1 && editText0 != null && editText0.isAttachedToWindow()) {
            Editable editable0 = editText0.getEditableText();
            int v1 = Selection.getSelectionStart(editable0);
            int v2 = Selection.getSelectionEnd(editable0);
            androidx.emoji2.text.e.b().o(editable0);
            d.b(editable0, v1, v2);
        }
    }

    @Override  // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }

    public void c(boolean z) {
        if(this.f != z) {
            if(this.c != null) {
                androidx.emoji2.text.e.b().t(this.c);
            }
            this.f = z;
            if(z) {
                int v = androidx.emoji2.text.e.b().d();
                g.b(this.a, v);
            }
        }
    }

    // 去混淆评级： 中等(50)
    private boolean d() {
        return !this.f || !this.b;
    }

    @Override  // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        if(!this.a.isInEditMode() && !this.d() && v1 <= v2 && charSequence0 instanceof Spannable) {
            switch(androidx.emoji2.text.e.b().d()) {
                case 1: {
                    androidx.emoji2.text.e.b().r(((Spannable)charSequence0), v, v + v2, this.d, this.e);
                    return;
                }
                case 0: 
                case 3: {
                    androidx.emoji2.text.e.b().s(this.a());
                    break;
                }
            }
        }
    }
}

