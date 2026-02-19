package v2;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import p2.f;

public class a implements Closeable {
    class v2.a.a extends f {
        v2.a.a() {
            super();
        }

        @Override  // p2.f
        public void a(a a0) {
            int v;
            switch((a0.l == 0 ? a0.e() : a0.l)) {
                case 12: {
                    v = 8;
                    break;
                }
                case 13: {
                    v = 9;
                    break;
                }
                case 14: {
                    v = 10;
                    break;
                }
                default: {
                    throw new IllegalStateException("Expected a name but was " + a0.E() + a0.p());
                }
            }
            a0.l = v;
        }
    }

    private final Reader e;
    private boolean f;
    private final char[] g;
    private int h;
    private int i;
    private int j;
    private int k;
    int l;
    private long m;
    private int n;
    private String o;
    private int[] p;
    private int q;
    private String[] r;
    private int[] s;

    static {
        f.a = new v2.a.a();
    }

    public a(Reader reader0) {
        this.f = false;
        this.g = new char[0x400];
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        int[] arr_v = new int[0x20];
        this.p = arr_v;
        this.q = 1;
        arr_v[0] = 6;
        this.r = new String[0x20];
        this.s = new int[0x20];
        Objects.requireNonNull(reader0, "in == null");
        this.e = reader0;
    }

    private String A(char c) {
        char[] arr_c = this.g;
        StringBuilder stringBuilder0 = null;
    alab1:
        while(true) {
            int v = this.h;
            int v1 = this.i;
            int v2 = v;
            while(v < v1) {
                int v3 = arr_c[v];
                if(v3 == c) {
                    this.h = v + 1;
                    int v4 = v + 1 - v2 - 1;
                    if(stringBuilder0 == null) {
                        return new String(arr_c, v2, v4);
                    }
                    stringBuilder0.append(arr_c, v2, v4);
                    return stringBuilder0.toString();
                }
                switch(v3) {
                    case 10: {
                        ++this.j;
                        this.k = v + 1;
                        ++v;
                        continue;
                    }
                    case 92: {
                        break;
                    }
                    default: {
                        ++v;
                        continue;
                    }
                }
                this.h = v + 1;
                int v5 = v + 1 - v2 - 1;
                if(stringBuilder0 == null) {
                    stringBuilder0 = new StringBuilder(Math.max((v5 + 1) * 2, 16));
                }
                stringBuilder0.append(arr_c, v2, v5);
                stringBuilder0.append(this.J());
                continue alab1;
            }
            if(stringBuilder0 == null) {
                stringBuilder0 = new StringBuilder(Math.max((v - v2) * 2, 16));
            }
            stringBuilder0.append(arr_c, v2, v - v2);
            this.h = v;
            if(!this.h(1)) {
                break;
            }
        }
        throw this.R("Unterminated string");
    }

    public String B() {
        String s;
    alab1:
        switch(this.l) {
            case 0: {
                switch(this.e()) {
                    case 8: {
                        s = this.A('\'');
                        break alab1;
                    }
                    case 9: {
                        s = this.A('\"');
                        break alab1;
                    }
                    case 10: {
                        s = this.D();
                        break alab1;
                    }
                    case 11: {
                        s = this.o;
                        this.o = null;
                        break alab1;
                    }
                    case 15: {
                        s = Long.toString(this.m);
                        break alab1;
                    }
                    case 16: {
                        s = new String(this.g, this.h, this.n);
                        this.h += this.n;
                        break alab1;
                    }
                    default: {
                        throw new IllegalStateException("Expected a string but was " + this.E() + this.p());
                    }
                }
            }
            case 8: {
                s = this.A('\'');
                break;
            }
            case 9: {
                s = this.A('\"');
                break;
            }
            case 10: {
                s = this.D();
                break;
            }
            case 11: {
                s = this.o;
                this.o = null;
                break;
            }
            case 15: {
                s = Long.toString(this.m);
                break;
            }
            case 16: {
                s = new String(this.g, this.h, this.n);
                this.h += this.n;
                break;
            }
            default: {
                throw new IllegalStateException("Expected a string but was " + this.E() + this.p());
            }
        }
        this.l = 0;
        int v = this.q - 1;
        ++this.s[v];
        return s;
    }

    private String D() {
        String s;
        StringBuilder stringBuilder0 = null;
        int v = 0;
        do {
            int v1 = 0;
        alab1:
            while(true) {
                int v2 = this.h;
                if(v2 + v1 < this.i) {
                    switch(this.g[v2 + v1]) {
                        case 35: 
                        case 0x2F: 
                        case 59: 
                        case 61: 
                        case 92: {
                            this.c();
                            break alab1;
                        }
                        case 9: 
                        case 10: 
                        case 12: 
                        case 13: 
                        case 0x20: 
                        case 44: 
                        case 58: 
                        case 91: 
                        case 93: 
                        case 0x7B: 
                        case 0x7D: {
                            break alab1;
                        }
                        default: {
                            ++v1;
                            continue;
                        }
                    }
                }
                if(v1 >= this.g.length) {
                    goto label_14;
                }
                if(!this.h(v1 + 1)) {
                    break;
                }
            }
            v = v1;
            break;
        label_14:
            if(stringBuilder0 == null) {
                stringBuilder0 = new StringBuilder(Math.max(v1, 16));
            }
            stringBuilder0.append(this.g, this.h, v1);
            this.h += v1;
        }
        while(this.h(1));
        if(stringBuilder0 == null) {
            s = new String(this.g, this.h, v);
        }
        else {
            stringBuilder0.append(this.g, this.h, v);
            s = stringBuilder0.toString();
        }
        this.h += v;
        return s;
    }

    public b E() {
        switch((this.l == 0 ? this.e() : this.l)) {
            case 1: {
                return b.g;
            }
            case 2: {
                return b.h;
            }
            case 3: {
                return b.e;
            }
            case 4: {
                return b.f;
            }
            case 5: 
            case 6: {
                return b.l;
            }
            case 7: {
                return b.m;
            }
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                return b.j;
            }
            case 12: 
            case 13: 
            case 14: {
                return b.i;
            }
            case 15: 
            case 16: {
                return b.k;
            }
            case 17: {
                return b.n;
            }
            default: {
                throw new AssertionError();
            }
        }
    }

    private int F() {
        int v;
        String s1;
        String s;
        switch(this.g[this.h]) {
            case 70: 
            case 102: {
                s = "false";
                s1 = "FALSE";
                v = 6;
                break;
            }
            case 78: 
            case 110: {
                s = "null";
                s1 = "NULL";
                v = 7;
                break;
            }
            case 84: 
            case 0x74: {
                s = "true";
                s1 = "TRUE";
                v = 5;
                break;
            }
            default: {
                return 0;
            }
        }
        int v1 = s.length();
        for(int v2 = 1; v2 < v1; ++v2) {
            if(this.h + v2 >= this.i && !this.h(v2 + 1)) {
                return 0;
            }
            int v3 = this.g[this.h + v2];
            if(v3 != s.charAt(v2) && v3 != s1.charAt(v2)) {
                return 0;
            }
        }
        if((this.h + v1 < this.i || this.h(v1 + 1)) && this.n(this.g[this.h + v1])) {
            return 0;
        }
        this.h += v1;
        this.l = v;
        return v;
    }

    private int G() {
        int v9;
        char[] arr_c = this.g;
        int v = this.h;
        int v1 = this.i;
        int v2 = 0;
        int v3 = 0;
        boolean z = false;
        int v4 = 1;
        long v5 = 0L;
        while(true) {
            if(v + v2 == v1) {
                if(v2 == arr_c.length) {
                    return 0;
                }
                if(!this.h(v2 + 1)) {
                    goto label_34;
                }
                v = this.h;
                v1 = this.i;
            }
            int v6 = arr_c[v + v2];
        alab1:
            switch(v6) {
                case 43: {
                    if(v3 != 5) {
                        return 0;
                    }
                    v3 = 6;
                    break;
                }
                case 45: {
                    switch(v3) {
                        case 0: {
                            v3 = 1;
                            z = true;
                            break alab1;
                        }
                        case 5: {
                            v3 = 6;
                            break alab1;
                        }
                        default: {
                            return 0;
                        }
                    }
                }
                case 46: {
                    if(v3 != 2) {
                        return 0;
                    }
                    v3 = 6;
                    break;
                }
                case 69: 
                case 101: {
                    if(v3 != 2 && v3 != 4) {
                        return 0;
                    }
                    v3 = 5;
                    break;
                }
                default: {
                    if(v6 >= 0x30 && v6 <= 57) {
                        if(v3 == 0 || v3 == 1) {
                            v5 = (long)(-(v6 - 0x30));
                            v3 = 2;
                        }
                        else {
                            switch(v3) {
                                case 2: {
                                    if(v5 == 0L) {
                                        return 0;
                                    }
                                    long v7 = 10L * v5 - ((long)(v6 - 0x30));
                                    int v8 = Long.compare(v5, -922337203685477580L);
                                    v4 &= (v8 > 0 || v8 == 0 && v7 < v5 ? 1 : 0);
                                    v5 = v7;
                                    break;
                                }
                                case 5: 
                                case 6: {
                                    v3 = 7;
                                }
                            }
                        }
                        break;
                    }
                    if(!this.n(((char)v6))) {
                    label_34:
                        if(v3 != 2 || v4 == 0 || v5 == 0x8000000000000000L && !z || v5 == 0L && z) {
                            if(v3 != 2 && v3 != 4 && v3 != 7) {
                                return 0;
                            }
                            this.n = v2;
                            v9 = 16;
                        }
                        else {
                            if(!z) {
                                v5 = -v5;
                            }
                            this.m = v5;
                            this.h += v2;
                            v9 = 15;
                        }
                        this.l = v9;
                        return v9;
                    }
                    return 0;
                }
            }
            ++v2;
        }
    }

    private void I(int v) {
        int v1 = this.q;
        int[] arr_v = this.p;
        if(v1 == arr_v.length) {
            this.p = Arrays.copyOf(arr_v, v1 * 2);
            this.s = Arrays.copyOf(this.s, v1 * 2);
            this.r = (String[])Arrays.copyOf(this.r, v1 * 2);
        }
        int v2 = this.q;
        this.q = v2 + 1;
        this.p[v2] = v;
    }

    private char J() {
        int v4;
        int v5;
        if(this.h == this.i && !this.h(1)) {
            throw this.R("Unterminated escape sequence");
        }
        int v = this.h;
        this.h = v + 1;
        char c = this.g[v];
        switch(c) {
            case 10: {
                ++this.j;
                this.k = v + 1;
                break;
            }
            case 34: 
            case 39: 
            case 0x2F: 
            case 92: {
                break;
            }
            case 98: {
                return '\b';
            }
            case 102: {
                return '\f';
            }
            case 110: {
                return '\n';
            }
            case 0x72: {
                return '\r';
            }
            case 0x74: {
                return '\t';
            }
            case 0x75: {
                if(v + 5 > this.i && !this.h(4)) {
                    throw this.R("Unterminated escape sequence");
                }
                int v1 = this.h;
                int v2 = v1 + 4;
                char c1 = '\u0000';
                while(v1 < v2) {
                    int v3 = this.g[v1];
                    if(v3 < 0x30 || v3 > 57) {
                        if(v3 < 97 || v3 > 102) {
                            if(v3 < 65 || v3 > 70) {
                                throw new NumberFormatException("\\u" + new String(this.g, this.h, 4));
                            }
                            v5 = v3 - 65;
                        }
                        else {
                            v5 = v3 - 97;
                        }
                        v4 = v5 + 10;
                    }
                    else {
                        v4 = v3 - 0x30;
                    }
                    c1 = (char)(((char)(c1 << 4)) + v4);
                    ++v1;
                }
                this.h += 4;
                return c1;
            }
            default: {
                throw this.R("Invalid escape sequence");
            }
        }
        return c;
    }

    public final void L(boolean z) {
        this.f = z;
    }

    private void M(char c) {
        char[] arr_c = this.g;
    alab1:
        while(true) {
            int v = this.h;
            int v1 = this.i;
            while(v < v1) {
                int v2 = arr_c[v];
                if(v2 == c) {
                    this.h = v + 1;
                    return;
                }
                switch(v2) {
                    case 10: {
                        ++this.j;
                        this.k = v + 1;
                        ++v;
                        continue;
                    }
                    case 92: {
                        break;
                    }
                    default: {
                        ++v;
                        continue;
                    }
                }
                this.h = v + 1;
                this.J();
                continue alab1;
            }
            this.h = v;
            if(!this.h(1)) {
                break;
            }
        }
        throw this.R("Unterminated string");
    }

    private boolean N(String s) {
        int v = s.length();
    alab1:
        while(true) {
            if(this.h + v > this.i && !this.h(v)) {
                return false;
            }
            int v2 = this.h;
            if(this.g[v2] == 10) {
                ++this.j;
                this.k = v2 + 1;
            }
            else {
                for(int v1 = 0; true; ++v1) {
                    if(v1 >= v) {
                        break alab1;
                    }
                    if(this.g[this.h + v1] != s.charAt(v1)) {
                        break;
                    }
                }
            }
            ++this.h;
        }
        return true;
    }

    private void O() {
        while(this.h < this.i || this.h(1)) {
            int v = this.h;
            int v1 = v + 1;
            this.h = v1;
            int v2 = this.g[v];
            if(v2 == 10) {
                ++this.j;
                this.k = v1;
                return;
            }
            if(v2 == 13) {
                break;
            }
        }
    }

    private void P() {
        int v1;
        do {
            int v = 0;
        alab1:
            while(true) {
                v1 = this.h;
                if(v1 + v >= this.i) {
                    goto label_9;
                }
                switch(this.g[v1 + v]) {
                    case 35: 
                    case 0x2F: 
                    case 59: 
                    case 61: 
                    case 92: {
                        break alab1;
                    }
                    case 9: 
                    case 10: 
                    case 12: 
                    case 13: 
                    case 0x20: 
                    case 44: 
                    case 58: 
                    case 91: 
                    case 93: 
                    case 0x7B: 
                    case 0x7D: {
                        this.h += v;
                        return;
                    }
                    default: {
                        ++v;
                    }
                }
            }
            this.c();
            this.h += v;
            return;
        label_9:
            this.h = v1 + v;
        }
        while(this.h(1));
    }

    public void Q() {
        int v = 0;
        do {
            switch((this.l == 0 ? this.e() : this.l)) {
                case 1: {
                    this.I(3);
                    ++v;
                    break;
                }
                case 2: {
                    if(v == 0) {
                        this.r[this.q - 1] = null;
                    }
                    --this.q;
                    --v;
                    break;
                }
                case 3: {
                    this.I(1);
                    ++v;
                    break;
                }
                case 4: {
                    --this.q;
                    --v;
                    break;
                }
                case 8: {
                    this.M('\'');
                    break;
                }
                case 9: {
                    this.M('\"');
                    break;
                }
                case 10: {
                    this.P();
                    break;
                }
                case 12: {
                    this.M('\'');
                    if(v == 0) {
                        this.r[this.q - 1] = "<skipped>";
                    }
                    break;
                }
                case 13: {
                    this.M('\"');
                    if(v == 0) {
                        this.r[this.q - 1] = "<skipped>";
                    }
                    break;
                }
                case 14: {
                    this.P();
                    if(v == 0) {
                        this.r[this.q - 1] = "<skipped>";
                    }
                    break;
                }
                case 16: {
                    this.h += this.n;
                    break;
                }
                case 17: {
                    return;
                }
            }
            this.l = 0;
        }
        while(v > 0);
        int v1 = this.q - 1;
        ++this.s[v1];
    }

    private IOException R(String s) {
        throw new d(s + this.p());
    }

    public void a() {
        if((this.l == 0 ? this.e() : this.l) != 3) {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + this.E() + this.p());
        }
        this.I(1);
        this.s[this.q - 1] = 0;
        this.l = 0;
    }

    public void b() {
        if((this.l == 0 ? this.e() : this.l) != 1) {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + this.E() + this.p());
        }
        this.I(3);
        this.l = 0;
    }

    private void c() {
        if(!this.f) {
            throw this.R("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    @Override
    public void close() {
        this.l = 0;
        this.p[0] = 8;
        this.q = 1;
        this.e.close();
    }

    private void d() {
        this.w(true);
        int v = this.h - 1;
        this.h = v;
        if(v + 5 > this.i && !this.h(5)) {
            return;
        }
        int v1 = this.h;
        if(this.g[v1] == 41 && this.g[v1 + 1] == 93 && this.g[v1 + 2] == 0x7D && this.g[v1 + 3] == 39 && this.g[v1 + 4] == 10) {
            this.h = v1 + 5;
        }
    }

    int e() {
        int v4;
        int[] arr_v = this.p;
        int v = this.q;
        int v1 = arr_v[v - 1];
        if(v1 == 1) {
            arr_v[v - 1] = 2;
            goto label_37;
        }
        else if(v1 == 2) {
            switch(this.w(true)) {
                case 44: {
                    goto label_37;
                }
                case 59: {
                    this.c();
                    goto label_37;
                }
                case 93: {
                    this.l = 4;
                    return 4;
                }
                default: {
                    throw this.R("Unterminated array");
                }
            }
        }
        else if(v1 == 3 || v1 == 5) {
            arr_v[v - 1] = 4;
            if(v1 == 5) {
                switch(this.w(true)) {
                    case 44: {
                        break;
                    }
                    case 59: {
                        this.c();
                        break;
                    }
                    case 0x7D: {
                        this.l = 2;
                        return 2;
                    }
                    default: {
                        throw this.R("Unterminated object");
                    }
                }
            }
            int v8 = this.w(true);
            switch(v8) {
                case 34: {
                    v4 = 13;
                    break;
                }
                case 39: {
                    this.c();
                    v4 = 12;
                    break;
                }
                default: {
                    if(v8 != 0x7D) {
                        this.c();
                        --this.h;
                        if(!this.n(((char)v8))) {
                            throw this.R("Expected name");
                        }
                        v4 = 14;
                        break;
                    }
                    if(v1 == 5) {
                        throw this.R("Expected name");
                    }
                    this.l = 2;
                    return 2;
                }
            }
        }
        else {
        alab1:
            switch(v1) {
                case 4: {
                    arr_v[v - 1] = 5;
                    int v2 = this.w(true);
                    if(v2 != 58) {
                        if(v2 != 61) {
                            throw this.R("Expected \':\'");
                        }
                        this.c();
                        if(this.h < this.i || this.h(1)) {
                            int v3 = this.h;
                            if(this.g[v3] == 62) {
                                this.h = v3 + 1;
                            }
                        }
                    }
                    goto label_37;
                }
                case 6: {
                    if(this.f) {
                        this.d();
                    }
                    this.p[this.q - 1] = 7;
                    goto label_37;
                }
                case 7: {
                    if(this.w(false) == -1) {
                        v4 = 17;
                    }
                    else {
                        this.c();
                        --this.h;
                    label_37:
                        int v5 = this.w(true);
                        switch(v5) {
                            case 34: {
                                v4 = 9;
                                break alab1;
                            }
                            case 39: {
                                this.c();
                                this.l = 8;
                                return 8;
                            }
                            case 44: 
                            case 59: {
                                break;
                            }
                            case 91: {
                                this.l = 3;
                                return 3;
                            label_45:
                                if(v5 != 0x7B) {
                                    --this.h;
                                    int v6 = this.F();
                                    if(v6 != 0) {
                                        return v6;
                                    }
                                    int v7 = this.G();
                                    if(v7 != 0) {
                                        return v7;
                                    }
                                    if(!this.n(this.g[this.h])) {
                                        throw this.R("Expected value");
                                    }
                                    this.c();
                                    v4 = 10;
                                    break alab1;
                                }
                                this.l = 1;
                                return 1;
                            }
                            case 93: {
                                if(v1 == 1) {
                                    this.l = 4;
                                    return 4;
                                }
                                break;
                            }
                            default: {
                                goto label_45;
                            }
                        }
                        if(v1 != 1 && v1 != 2) {
                            throw this.R("Unexpected value");
                        }
                        this.c();
                        --this.h;
                        this.l = 7;
                        return 7;
                    }
                    break;
                }
                case 8: {
                    throw new IllegalStateException("JsonReader is closed");
                }
                default: {
                    goto label_37;
                }
            }
        }
        this.l = v4;
        return v4;
    }

    public void f() {
        if((this.l == 0 ? this.e() : this.l) != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + this.E() + this.p());
        }
        int v = this.q - 1;
        this.q = v;
        ++this.s[v - 1];
        this.l = 0;
    }

    public void g() {
        if((this.l == 0 ? this.e() : this.l) != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + this.E() + this.p());
        }
        int v = this.q - 1;
        this.q = v;
        this.r[v] = null;
        ++this.s[v - 1];
        this.l = 0;
    }

    private boolean h(int v) {
        char[] arr_c = this.g;
        int v1 = this.h;
        this.k -= v1;
        int v2 = this.i;
        if(v2 == v1) {
            this.i = 0;
        }
        else {
            int v3 = v2 - v1;
            this.i = v3;
            System.arraycopy(arr_c, v1, arr_c, 0, v3);
        }
        this.h = 0;
        int v4;
        while((v4 = this.e.read(arr_c, this.i, arr_c.length - this.i)) != -1) {
            int v5 = this.i + v4;
            this.i = v5;
            if(this.j == 0 && this.k == 0 && v5 > 0 && arr_c[0] == 0xFEFF) {
                ++this.h;
                this.k = 1;
                ++v;
            }
            if(v5 >= v) {
                return true;
            }
        }
        return false;
    }

    public String i() {
        return this.j(false);
    }

    private String j(boolean z) {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append('$');
        for(int v = 0; true; ++v) {
            int v1 = this.q;
            if(v >= v1) {
                break;
            }
            switch(this.p[v]) {
                case 1: 
                case 2: {
                    int v2 = this.s[v];
                    if(z && v2 > 0 && v == v1 - 1) {
                        --v2;
                    }
                    stringBuilder0.append('[');
                    stringBuilder0.append(v2);
                    stringBuilder0.append(']');
                    break;
                }
                case 3: 
                case 4: 
                case 5: {
                    stringBuilder0.append('.');
                    String s = this.r[v];
                    if(s != null) {
                        stringBuilder0.append(s);
                    }
                }
            }
        }
        return stringBuilder0.toString();
    }

    public String k() {
        return this.j(true);
    }

    public boolean l() {
        int v = this.l == 0 ? this.e() : this.l;
        return v != 2 && v != 4 && v != 17;
    }

    public final boolean m() {
        return this.f;
    }

    private boolean n(char c) {
        switch(c) {
            case 35: 
            case 0x2F: 
            case 59: 
            case 61: 
            case 92: {
                this.c();
                break;
            }
            case 9: 
            case 10: 
            case 12: 
            case 13: 
            case 0x20: 
            case 44: 
            case 58: 
            case 91: 
            case 93: 
            case 0x7B: 
            case 0x7D: {
                break;
            }
            default: {
                return true;
            }
        }
        return false;
    }

    String p() {
        return " at line " + (this.j + 1) + " column " + (this.h - this.k + 1) + " path " + this.i();
    }

    public boolean q() {
        switch((this.l == 0 ? this.e() : this.l)) {
            case 5: {
                this.l = 0;
                int v = this.q - 1;
                ++this.s[v];
                return true;
            }
            case 6: {
                this.l = 0;
                int v1 = this.q - 1;
                ++this.s[v1];
                return false;
            }
            default: {
                throw new IllegalStateException("Expected a boolean but was " + this.E() + this.p());
            }
        }
    }

    public double r() {
        int v = this.l == 0 ? this.e() : this.l;
        switch(v) {
            case 8: 
            case 9: {
                this.o = this.A(((char)(v == 8 ? 39 : 34)));
                break;
            }
            case 10: {
                this.o = this.D();
                break;
            }
            case 11: {
                break;
            }
            case 15: {
                this.l = 0;
                int v1 = this.q - 1;
                ++this.s[v1];
                return (double)this.m;
            }
            case 16: {
                this.o = new String(this.g, this.h, this.n);
                this.h += this.n;
                break;
            }
            default: {
                throw new IllegalStateException("Expected a double but was " + this.E() + this.p());
            }
        }
        this.l = 11;
        double f = Double.parseDouble(this.o);
        if(!this.f && (Double.isNaN(f) || Double.isInfinite(f))) {
            throw new d("JSON forbids NaN and infinities: " + f + this.p());
        }
        this.o = null;
        this.l = 0;
        int v2 = this.q - 1;
        ++this.s[v2];
        return f;
    }

    public int t() {
        int v = this.l == 0 ? this.e() : this.l;
        switch(v) {
            case 8: {
            label_12:
                String s = v == 10 ? this.D() : this.A(((char)(v == 8 ? 39 : 34)));
                try {
                    this.o = s;
                    int v3 = Integer.parseInt(this.o);
                    this.l = 0;
                    int v4 = this.q - 1;
                    ++this.s[v4];
                    return v3;
                }
                catch(NumberFormatException unused_ex) {
                    goto label_21;
                }
            }
            case 15: {
                int v1 = (int)this.m;
                if(this.m != ((long)v1)) {
                    throw new NumberFormatException("Expected an int but was " + this.m + this.p());
                }
                this.l = 0;
                int v2 = this.q - 1;
                ++this.s[v2];
                return v1;
            label_10:
                if(v != 9 && v != 10) {
                    throw new IllegalStateException("Expected an int but was " + this.E() + this.p());
                }
                goto label_12;
            }
            case 16: {
                break;
            }
            default: {
                goto label_10;
            }
        }
        this.o = new String(this.g, this.h, this.n);
        this.h += this.n;
    label_21:
        this.l = 11;
        double f = Double.parseDouble(this.o);
        if(((double)(((int)f))) != f) {
            throw new NumberFormatException("Expected an int but was " + this.o + this.p());
        }
        this.o = null;
        this.l = 0;
        int v5 = this.q - 1;
        ++this.s[v5];
        return (int)f;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + this.p();
    }

    public long u() {
        int v = this.l == 0 ? this.e() : this.l;
        switch(v) {
            case 8: {
            label_9:
                String s = v == 10 ? this.D() : this.A(((char)(v == 8 ? 39 : 34)));
                try {
                    this.o = s;
                    long v2 = Long.parseLong(this.o);
                    this.l = 0;
                    int v3 = this.q - 1;
                    ++this.s[v3];
                    return v2;
                }
                catch(NumberFormatException unused_ex) {
                    goto label_18;
                }
            }
            case 15: {
                this.l = 0;
                int v1 = this.q - 1;
                ++this.s[v1];
                return this.m;
            label_7:
                if(v != 9 && v != 10) {
                    throw new IllegalStateException("Expected a long but was " + this.E() + this.p());
                }
                goto label_9;
            }
            case 16: {
                break;
            }
            default: {
                goto label_7;
            }
        }
        this.o = new String(this.g, this.h, this.n);
        this.h += this.n;
    label_18:
        this.l = 11;
        double f = Double.parseDouble(this.o);
        if(((double)(((long)f))) != f) {
            throw new NumberFormatException("Expected a long but was " + this.o + this.p());
        }
        this.o = null;
        this.l = 0;
        int v4 = this.q - 1;
        ++this.s[v4];
        return (long)f;
    }

    public String v() {
        String s;
        switch((this.l == 0 ? this.e() : this.l)) {
            case 12: {
                s = this.A('\'');
                break;
            }
            case 13: {
                s = this.A('\"');
                break;
            }
            case 14: {
                s = this.D();
                break;
            }
            default: {
                throw new IllegalStateException("Expected a name but was " + this.E() + this.p());
            }
        }
        this.l = 0;
        this.r[this.q - 1] = s;
        return s;
    }

    private int w(boolean z) {
        int v3;
        int v;
        char[] arr_c = this.g;
    alab1:
        while(true) {
            v = this.h;
        alab2:
            while(true) {
                int v1 = this.i;
            label_3:
                if(v == v1) {
                    this.h = v;
                    if(!this.h(1)) {
                        if(z) {
                            throw new EOFException("End of input" + this.p());
                        }
                        return -1;
                    }
                    v = this.h;
                    v1 = this.i;
                }
                int v2 = arr_c[v];
                switch(v2) {
                    case 10: {
                        ++this.j;
                        this.k = v + 1;
                        break alab1;
                    }
                    case 9: 
                    case 13: 
                    case 0x20: {
                        break alab1;
                    }
                    case 0x2F: {
                        this.h = v + 1;
                        if(v + 1 == v1) {
                            this.h = v;
                            boolean z1 = this.h(2);
                            ++this.h;
                            if(!z1) {
                                return 0x2F;
                            }
                        }
                        this.c();
                        v3 = this.h;
                        switch(arr_c[v3]) {
                            case 42: {
                                this.h = v3 + 1;
                                if(this.N("*/")) {
                                    break;
                                }
                                break alab2;
                            }
                            case 0x2F: {
                                goto label_37;
                            }
                            default: {
                                return 0x2F;
                            }
                        }
                        v = this.h + 2;
                        break;
                    }
                    default: {
                        this.h = v + 1;
                        if(v2 == 35) {
                            this.c();
                            goto label_38;
                        }
                        return v2;
                    }
                }
            }
            throw this.R("Unterminated comment");
        label_37:
            this.h = v3 + 1;
        label_38:
            this.O();
        }
        ++v;
        goto label_3;
    }

    public void y() {
        if((this.l == 0 ? this.e() : this.l) != 7) {
            throw new IllegalStateException("Expected null but was " + this.E() + this.p());
        }
        this.l = 0;
        int v = this.q - 1;
        ++this.s[v];
    }
}

