package t;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.e.e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

final class d implements InputFilter {
    static class a extends e {
        private final Reference a;
        private final Reference b;

        a(TextView textView0, d d0) {
            this.a = new WeakReference(textView0);
            this.b = new WeakReference(d0);
        }

        @Override  // androidx.emoji2.text.e$e
        public void b() {
            super.b();
            TextView textView0 = (TextView)this.a.get();
            if(!this.c(textView0, ((InputFilter)this.b.get()))) {
                return;
            }
            if(textView0.isAttachedToWindow()) {
                CharSequence charSequence0 = textView0.getText();
                CharSequence charSequence1 = androidx.emoji2.text.e.b().o(charSequence0);
                if(charSequence0 == charSequence1) {
                    return;
                }
                int v = Selection.getSelectionStart(charSequence1);
                int v1 = Selection.getSelectionEnd(charSequence1);
                textView0.setText(charSequence1);
                if(charSequence1 instanceof Spannable) {
                    d.b(((Spannable)charSequence1), v, v1);
                }
            }
        }

        private boolean c(TextView textView0, InputFilter inputFilter0) {
            if(inputFilter0 != null && textView0 != null) {
                InputFilter[] arr_inputFilter = textView0.getFilters();
                if(arr_inputFilter == null) {
                    return false;
                }
                for(int v = 0; v < arr_inputFilter.length; ++v) {
                    if(arr_inputFilter[v] == inputFilter0) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private final TextView a;
    private e b;

    d(TextView textView0) {
        this.a = textView0;
    }

    private e a() {
        if(this.b == null) {
            this.b = new a(this.a, this);
        }
        return this.b;
    }

    static void b(Spannable spannable0, int v, int v1) {
        if(v >= 0 && v1 >= 0) {
            Selection.setSelection(spannable0, v, v1);
            return;
        }
        if(v >= 0) {
            Selection.setSelection(spannable0, v);
            return;
        }
        if(v1 >= 0) {
            Selection.setSelection(spannable0, v1);
        }
    }

    @Override  // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence0, int v, int v1, Spanned spanned0, int v2, int v3) {
        if(this.a.isInEditMode()) {
            return charSequence0;
        }
        boolean z = true;
        switch(androidx.emoji2.text.e.b().d()) {
            case 1: {
                if(v3 == 0 && v2 == 0 && spanned0.length() == 0 && charSequence0 == this.a.getText()) {
                    z = false;
                }
                if(z && charSequence0 != null) {
                    if(v != 0 || v1 != charSequence0.length()) {
                        charSequence0 = charSequence0.subSequence(v, v1);
                    }
                    return androidx.emoji2.text.e.b().p(charSequence0, 0, charSequence0.length());
                }
                return charSequence0;
            }
            case 0: 
            case 3: {
                androidx.emoji2.text.e.b().s(this.a());
                return charSequence0;
            }
            default: {
                return charSequence0;
            }
        }
    }
}

