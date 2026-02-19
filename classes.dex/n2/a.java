package n2;

import java.lang.reflect.Field;
import java.util.Objects;

public final class a {
    private final Field a;

    public a(Field field0) {
        Objects.requireNonNull(field0);
        this.a = field0;
    }

    @Override
    public String toString() {
        return this.a.toString();
    }
}

