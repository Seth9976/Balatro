package m2;

public @interface d {
    public static enum a {
        DEFAULT,
        SIGNED,
        FIXED;

    }

    a intEncoding() default a.e;

    int tag();
}

