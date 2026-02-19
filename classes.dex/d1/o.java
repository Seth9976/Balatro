package d1;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

final class o extends BasePendingResult {
    private final k n;

    public o(f f0, k k0) {
        super(f0);
        this.n = k0;
    }

    @Override  // com.google.android.gms.common.api.internal.BasePendingResult
    protected final k e(Status status0) {
        return this.n;
    }
}

