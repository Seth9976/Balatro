package p2;

import java.io.Writer;
import java.util.Objects;
import n2.g;
import v2.c;

public abstract class m {
    static abstract class a {
    }

    static final class b extends Writer {
        static class p2.m.b.a implements CharSequence {
            private char[] e;
            private String f;

            private p2.m.b.a() {
            }

            p2.m.b.a(a m$a0) {
            }

            void a(char[] arr_c) {
                this.e = arr_c;
                this.f = null;
            }

            @Override
            public char charAt(int v) {
                return this.e[v];
            }

            @Override
            public int length() {
                return this.e.length;
            }

            @Override
            public CharSequence subSequence(int v, int v1) {
                return new String(this.e, v, v1 - v);
            }

            @Override
            public String toString() {
                if(this.f == null) {
                    this.f = new String(this.e);
                }
                return this.f;
            }
        }

        private final Appendable e;
        private final p2.m.b.a f;

        b(Appendable appendable0) {
            this.f = new p2.m.b.a(null);
            this.e = appendable0;
        }

        @Override
        public Writer append(CharSequence charSequence0) {
            this.e.append(charSequence0);
            return this;
        }

        @Override
        public Writer append(CharSequence charSequence0, int v, int v1) {
            this.e.append(charSequence0, v, v1);
            return this;
        }

        @Override
        public Appendable append(CharSequence charSequence0) {
            return this.append(charSequence0);
        }

        @Override
        public Appendable append(CharSequence charSequence0, int v, int v1) {
            return this.append(charSequence0, v, v1);
        }

        @Override
        public void close() {
        }

        @Override
        public void flush() {
        }

        @Override
        public void write(int v) {
            this.e.append(((char)v));
        }

        @Override
        public void write(String s, int v, int v1) {
            Objects.requireNonNull(s);
            this.e.append(s, v, v1 + v);
        }

        @Override
        public void write(char[] arr_c, int v, int v1) {
            this.f.a(arr_c);
            this.e.append(this.f, v, v1 + v);
        }
    }

    public static void a(g g0, c c0) {
        q2.m.V.d(c0, g0);
    }

    public static Writer b(Appendable appendable0) {
        return appendable0 instanceof Writer ? ((Writer)appendable0) : new b(appendable0);
    }
}

