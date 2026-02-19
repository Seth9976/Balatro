package com.google.android.gms.internal.play_billing;

import h.d;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class j1 {
    static c1 a(Class class0) {
        String s;
        Class class1 = j1.class;
        ClassLoader classLoader0 = class1.getClassLoader();
        if(class0.equals(c1.class)) {
            s = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
        }
        else {
            if(!class0.getPackage().equals(class1.getPackage())) {
                throw new IllegalArgumentException(class0.getName());
            }
            s = String.format("%s.BlazeGenerated%sLoader", class0.getPackage().getName(), class0.getSimpleName());
        }
        try {
            Class class2 = Class.forName(s, true, classLoader0);
            try {
                d.a(class2.getConstructor().newInstance());
            }
            catch(NoSuchMethodException noSuchMethodException0) {
                throw new IllegalStateException(noSuchMethodException0);
            }
            catch(InstantiationException instantiationException0) {
                throw new IllegalStateException(instantiationException0);
            }
            catch(IllegalAccessException illegalAccessException0) {
                throw new IllegalStateException(illegalAccessException0);
            }
            catch(InvocationTargetException invocationTargetException0) {
                throw new IllegalStateException(invocationTargetException0);
            }
        }
        catch(ClassNotFoundException unused_ex) {
            Iterator iterator0 = ServiceLoader.load(class1, classLoader0).iterator();
            ArrayList arrayList0 = new ArrayList();
            while(true) {
                if(!iterator0.hasNext()) {
                    switch(arrayList0.size()) {
                        case 0: {
                            return null;
                        }
                        case 1: {
                            return (c1)arrayList0.get(0);
                        }
                        default: {
                            try {
                                return (c1)class0.getMethod("combine", Collection.class).invoke(null, arrayList0);
                            }
                            catch(NoSuchMethodException noSuchMethodException1) {
                                throw new IllegalStateException(noSuchMethodException1);
                            }
                            catch(IllegalAccessException illegalAccessException1) {
                                throw new IllegalStateException(illegalAccessException1);
                            }
                            catch(InvocationTargetException invocationTargetException1) {
                                throw new IllegalStateException(invocationTargetException1);
                            }
                        }
                    }
                }
                try {
                    Object object0 = iterator0.next();
                    d.a(object0);
                    break;
                }
                catch(ServiceConfigurationError serviceConfigurationError0) {
                    Logger.getLogger("com.google.android.gms.internal.play_billing.y0").logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load " + class0.getSimpleName(), serviceConfigurationError0);
                }
            }
            throw null;
        }
        throw null;
    }
}

