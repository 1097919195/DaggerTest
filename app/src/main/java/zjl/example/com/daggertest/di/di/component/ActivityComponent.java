package zjl.example.com.daggertest.di.di.component;

import dagger.Component;
import zjl.example.com.daggertest.ui.MainActivity;
import zjl.example.com.daggertest.di.di.module.ActivityModule;
import zjl.example.com.daggertest.di.di.scope.ActivityScope;

@ActivityScope
@Component(modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}
