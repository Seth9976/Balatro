package t;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

public final class f {
    static class a extends b {
        private final TextView a;
        private final d b;
        private boolean c;

        a(TextView textView0) {
            this.a = textView0;
            this.c = true;
            this.b = new d(textView0);
        }

        @Override  // t.f$b
        InputFilter[] a(InputFilter[] arr_inputFilter) {
            return this.c ? this.d(arr_inputFilter) : this.f(arr_inputFilter);
        }

        @Override  // t.f$b
        void b(boolean z) {
            if(z) {
                this.j();
            }
        }

        @Override  // t.f$b
        void c(boolean z) {
            this.c = z;
            this.j();
            this.i();
        }

        private InputFilter[] d(InputFilter[] arr_inputFilter) {
            for(int v = 0; v < arr_inputFilter.length; ++v) {
                if(arr_inputFilter[v] == this.b) {
                    return arr_inputFilter;
                }
            }
            InputFilter[] arr_inputFilter1 = new InputFilter[arr_inputFilter.length + 1];
            System.arraycopy(arr_inputFilter, 0, arr_inputFilter1, 0, arr_inputFilter.length);
            arr_inputFilter1[arr_inputFilter.length] = this.b;
            return arr_inputFilter1;
        }

        private SparseArray e(InputFilter[] arr_inputFilter) {
            SparseArray sparseArray0 = new SparseArray(1);
            for(int v = 0; v < arr_inputFilter.length; ++v) {
                InputFilter inputFilter0 = arr_inputFilter[v];
                if(inputFilter0 instanceof d) {
                    sparseArray0.put(v, inputFilter0);
                }
            }
            return sparseArray0;
        }

        private InputFilter[] f(InputFilter[] arr_inputFilter) {
            SparseArray sparseArray0 = this.e(arr_inputFilter);
            if(sparseArray0.size() == 0) {
                return arr_inputFilter;
            }
            InputFilter[] arr_inputFilter1 = new InputFilter[arr_inputFilter.length - sparseArray0.size()];
            int v1 = 0;
            for(int v = 0; v < arr_inputFilter.length; ++v) {
                if(sparseArray0.indexOfKey(v) < 0) {
                    arr_inputFilter1[v1] = arr_inputFilter[v];
                    ++v1;
                }
            }
            return arr_inputFilter1;
        }

        void g(boolean z) {
            this.c = z;
        }

        // 去混淆评级： 低(20)
        private TransformationMethod h(TransformationMethod transformationMethod0) {
            return transformationMethod0 instanceof h ? ((h)transformationMethod0).a() : transformationMethod0;
        }

        private void i() {
            InputFilter[] arr_inputFilter = this.a(this.a.getFilters());
            this.a.setFilters(arr_inputFilter);
        }

        void j() {
            TransformationMethod transformationMethod0 = this.l(this.a.getTransformationMethod());
            this.a.setTransformationMethod(transformationMethod0);
        }

        private TransformationMethod k(TransformationMethod transformationMethod0) {
            if(transformationMethod0 instanceof h) {
                return transformationMethod0;
            }
            return transformationMethod0 instanceof PasswordTransformationMethod ? transformationMethod0 : new h(transformationMethod0);
        }

        // 去混淆评级： 低(20)
        TransformationMethod l(TransformationMethod transformationMethod0) {
            return this.c ? this.k(transformationMethod0) : this.h(transformationMethod0);
        }
    }

    static abstract class b {
        abstract InputFilter[] a(InputFilter[] arg1);

        abstract void b(boolean arg1);

        abstract void c(boolean arg1);
    }

    static class c extends b {
        private final a a;

        c(TextView textView0) {
            this.a = new a(textView0);
        }

        // 去混淆评级： 低(30)
        @Override  // t.f$b
        InputFilter[] a(InputFilter[] arr_inputFilter) {
            return arr_inputFilter;
        }

        // 去混淆评级： 低(30)
        @Override  // t.f$b
        void b(boolean z) {
        }

        @Override  // t.f$b
        void c(boolean z) {
            this.a.g(z);
        }

        // 去混淆评级： 低(20)
        private boolean d() [...] // 潜在的解密器
    }

    private final b a;

    public f(TextView textView0, boolean z) {
        androidx.core.util.c.e(textView0, "textView cannot be null");
        c f$c0 = z ? new a(textView0) : new c(textView0);
        this.a = f$c0;
    }

    public InputFilter[] a(InputFilter[] arr_inputFilter) {
        return this.a.a(arr_inputFilter);
    }

    public void b(boolean z) {
        this.a.b(z);
    }

    public void c(boolean z) {
        this.a.c(z);
    }
}

