package zjl.example.com.daggertest.ui.presenter;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import zjl.example.com.daggertest.base.BasePresenter;
import zjl.example.com.daggertest.ui.contract.MainContract;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private CompositeDisposable disposable = new CompositeDisposable();

    //这里需要使用inject注解来声明这个MainPresenter是需要实例化的，当用到这个MainPresenter的时候，使用被inject注解的构造函数来实例化这个就可以获取到了（来替换provider注解的作用）
    @Inject
    public MainPresenter() {
    }

    @Override
    public void getData() {
        getView().returnData("简单的MVP与Dagger2结合回调成功了！");

    }

    //取消订阅及断开了和view的关联操作
    @Override
    public void detachView() {
        super.detachView();
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
