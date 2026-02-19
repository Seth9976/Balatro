package r3;

import d3.e;

final class k extends RuntimeException {
    private final e e;

    public k(e e0) {
        this.e = e0;
    }

    @Override
    public Throwable fillInStackTrace() {
        this.setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override
    public String getLocalizedMessage() {
        return this.e.toString();
    }
}

