package s;

public abstract class d {
    private static d a;

    public static d a() {
        if(d.a == null) {
            d.a = new e();
        }
        return d.a;
    }
}

