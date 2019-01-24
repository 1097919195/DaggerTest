package zjl.example.com.daggertest.di.di.component;

import dagger.Component;
import zjl.example.com.daggertest.ui.MainActivity;
import zjl.example.com.daggertest.di.di.module.ActivityModule;
import zjl.example.com.daggertest.di.di.scope.ActivityScope;

@ActivityScope//子类component的Scoped 要小于父类的Scoped，所以添加注解指明范围，参考单利注意事项
@Component(modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}
