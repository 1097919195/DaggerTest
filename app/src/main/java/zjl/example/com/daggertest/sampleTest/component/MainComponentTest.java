package zjl.example.com.daggertest.sampleTest.component;

import dagger.Component;
import zjl.example.com.daggertest.ui.MainActivity;
import zjl.example.com.daggertest.sampleTest.module.MainModuleTest;
import zjl.example.com.daggertest.ui.MainActivityTest;

/**
 * Created by Administrator on 2018/11/13 0013.
 */

//第一步 添加@Component
//第二步 添加module
@Component(modules = {MainModuleTest.class})
public interface MainComponentTest {
    //第三步  写一个方法 绑定Activity /Fragment
    void inject(MainActivityTest activity);
}

