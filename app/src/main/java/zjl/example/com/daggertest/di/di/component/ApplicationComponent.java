package zjl.example.com.daggertest.di.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import zjl.example.com.daggertest.data.source.DataManager;
import zjl.example.com.daggertest.data.source.local.DatabaseHelper;
import zjl.example.com.daggertest.di.di.module.ApplicationModule;


@Singleton
@Component(modules = ApplicationModule.class)//使用是在被依赖的ActivityComponent和FragmentComponent中。参考全局单例使用 https://www.jianshu.com/p/2cd491f0da01
public interface ApplicationComponent {
    Application application();
    DataManager dataManager();
    DatabaseHelper databaseHelper();
}
