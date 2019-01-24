package zjl.example.com.daggertest.di.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Documented
@Scope
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ActivityScope {//使用scope表示使用的范围，保证ApplicationComponent为单例，参考单利注意事项
}
