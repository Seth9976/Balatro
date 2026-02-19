package g2;

public final class b extends IllegalStateException {
    private b(String s, Throwable throwable0) {
        super(s, throwable0);
    }

    public static IllegalStateException a(h h0) {
        if(!h0.p()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception exception0 = h0.m();
        if(exception0 != null) {
            return new b("Complete with: failure", exception0);
        }
        if(h0.q()) {
            return new b("Complete with: " + ("result " + h0.n()), null);
        }
        return h0.o() ? new b("Complete with: cancellation", null) : new b("Complete with: unknown issue", null);
    }
}

