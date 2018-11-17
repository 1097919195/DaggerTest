package zjl.example.com.daggertest.di.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import zjl.example.com.daggertest.data.source.DataManager;
import zjl.example.com.daggertest.data.source.local.DatabaseHelper;
import zjl.example.com.daggertest.di.di.module.ApplicationModule;


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Application application();
    DataManager dataManager();
    DatabaseHelper databaseHelper();
}
