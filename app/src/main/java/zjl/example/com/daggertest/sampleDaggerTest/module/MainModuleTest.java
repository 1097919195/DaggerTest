package zjl.example.com.daggertest.sampleDaggerTest.module;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import zjl.example.com.daggertest.sampleDaggerTest.A;
import zjl.example.com.daggertest.sampleDaggerTest.B;

/**
 * Created by Administrator on 2018/11/13 0013.
 */

//第一步 添加@Module 注解
@Module
public class MainModuleTest {
    //第二步 使用Provider 注解 实例化对象
    @Provides
    @Named("dev")
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



