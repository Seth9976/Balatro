package androidx.core.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;

public class CoreComponentFactory extends AppComponentFactory {
    static Object a(Object object0) {
        return object0;
    }

    @Override  // android.app.AppComponentFactory
    public Activity instantiateActivity(ClassLoader classLoader0, String s, Intent intent0) {
        return (Activity)CoreComponentFactory.a(super.instantiateActivity(classLoader0, s, intent0));
    }

    @Override  // android.app.AppComponentFactory
    public Application instantiateApplication(ClassLoader classLoader0, String s) {
        return (Application)CoreComponentFactory.a(super.instantiateApplication(classLoader0, s));
    }

    @Override  // android.app.AppComponentFactory
    public ContentProvider instantiateProvider(ClassLoader classLoader0, String s) {
        return (ContentProvider)CoreComponentFactory.a(super.instantiateProvider(classLoader0, s));
    }

    @Override  // android.app.AppComponentFactory
    public BroadcastReceiver instantiateReceiver(ClassLoader classLoader0, String s, Intent intent0) {
        return (BroadcastReceiver)CoreComponentFactory.a(super.instantiateReceiver(classLoader0, s, intent0));
    }

    @Override  // android.app.AppComponentFactory
    public Service instantiateService(ClassLoader classLoader0, String s, Intent intent0) {
        return (Service)CoreComponentFactory.a(super.instantiateService(classLoader0, s, intent0));
    }
}

