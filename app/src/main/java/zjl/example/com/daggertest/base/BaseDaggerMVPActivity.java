package zjl.example.com.daggertest.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

import zjl.example.com.daggertest.app.AppApplication;
import zjl.example.com.daggertest.di.di.component.ActivityComponent;
import zjl.example.com.daggertest.di.di.component.DaggerActivityComponent;

/**
 * Created by Administrator on 2018/11/9 0009.
 */

public abstract class BaseDaggerMVPActivity<P extends BaseContract.Presenter> extends AppCompatActivity implements BaseContract.View{

    @Inject
    protected P presenter;
    public ActivityComponent activityComponent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        //要注意先后的顺序（先添加依赖才能调用对象）
        //当Dagger处理器生成组件时，它只需要明确需要的模块和组件依赖项实例来提供绑定请求。
        //如果组件中使用的所有模块方法都是静态的，则Dagger根本不需要该模块的实例。Dagger可以在没有模块的情况下直接调用静态方法。
        //如果模块没有为Component提供绑定，则构造图形不需要该模块的实例。  https://google.github.io/dagger/unused-modules
        activityComponent = DaggerActivityComponent.builder()
//                .applicationComponent(AppApplication.getApplicationComponent())
                .applicationComponent(((AppApplication) getApplication()).getApplicationComponent())//我们必须把所有的依赖的传进去（components和modules）,除非上面的情况。这里好像是使用了dependencies才一定要加的
                .build();//具体的注入在具体的activity实现
        initPresenter();

        initView();
    }

    protected abstract int getLayoutId();

    protected abstract void initPresenter();//MVP模式的时候需要在这个抽象实现里获取view -> presenter.attachView(this);

    protected abstract void initView();

    @Override
    public void showLoading(String title) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void showError(String message) {
        Log.e("BaseMVPActivity----", message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            Log.e("BaseMVPActivity----", "presenter解除关联View");
            presenter.detachView();
        }
    }
}
