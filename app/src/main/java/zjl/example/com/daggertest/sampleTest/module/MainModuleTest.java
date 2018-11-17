package zjl.example.com.daggertest.sampleTest.module;

import dagger.Module;
import dagger.Provides;
import zjl.example.com.daggertest.sampleTest.A;
import zjl.example.com.daggertest.sampleTest.B;

/**
 * Created by Administrator on 2018/11/13 0013.
 */

//第一步 添加@Module 注解
@Module
public class MainModuleTest {
    //第二步 使用Provider 注解 实例化对象
    @Provides
    A providerA(B b) {
        return new A(b);
    }

    /***
     * 构造方法需要其他参数时候
     *
     * @return
     */
    @Provides
    B providerB() {
        return new B();
    }
}



