package zjl.example.com.daggertest.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import zjl.example.com.daggertest.di.di.component.ApplicationComponent;
import zjl.example.com.daggertest.di.di.component.DaggerApplicationComponent;
import zjl.example.com.daggertest.di.di.module.ApplicationModule;

public class AppApplication extends Application {

    private static AppApplication Application;
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Application = this;

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static Context getAppContext() {
        return Application;
    }

    public static Resources getAppResources() {
        return Application.getResources();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
