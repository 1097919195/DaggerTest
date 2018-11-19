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
        activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((AppApplication) getApplication()).getApplicationComponent())
                .build();
        initPresenter();//

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
