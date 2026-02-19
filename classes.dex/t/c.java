package t;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.emoji2.text.e;

final class c extends InputConnectionWrapper {
    public static class a {
        public boolean a(InputConnection inputConnection0, Editable editable0, int v, int v1, boolean z) {
            return e.e(inputConnection0, editable0, v, v1, z);
        }

        // 去混淆评级： 低(30)
        public void b(EditorInfo editorInfo0) {
        }
    }

    private final TextView a;
    private final a b;

    c(TextView textView0, InputConnection inputConnection0, EditorInfo editorInfo0) {
        this(textView0, inputConnection0, editorInfo0, new a());
    }

    c(TextView textView0, InputConnection inputConnection0, EditorInfo editorInfo0, a c$a0) {
        super(inputConnection0, false);
        this.a = textView0;
        this.b = c$a0;
        c$a0.b(editorInfo0);
    }

    private Editable a() {
        return this.a.getEditableText();
    }

    @Override  // android.view.inputmethod.InputConnectionWrapper
    public boolean deleteSurroundingText(int v, int v1) {
        Editable editable0 = this.a();
        return this.b.a(this, editable0, v, v1, false) || super.deleteSurroundingText(v, v1);
    }

    @Override  // android.view.inputmethod.InputConnectionWrapper
    public boolean deleteSurroundingTextInCodePoints(int v, int v1) {
        Editable editable0 = this.a();
        return this.b.a(this, editable0, v, v1, true) || super.deleteSurroundingTextInCodePoints(v, v1);
    }
}

