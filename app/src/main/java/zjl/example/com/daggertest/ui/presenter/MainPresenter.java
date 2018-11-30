package zjl.example.com.daggertest.ui.presenter;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import zjl.example.com.daggertest.base.BasePresenter;
import zjl.example.com.daggertest.data.bean.BaseResponse;
import zjl.example.com.daggertest.data.source.DataManager;
import zjl.example.com.daggertest.ui.contract.MainContract;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private DataManager dataManager;//这个就相当于是一个总的module类了
    private CompositeDisposable disposable = new CompositeDisposable();

    //1.这里需要使用inject注解来声明这个MainPresenter是需要实例化的，当用到这个MainPresenter的时候，使用被inject注解的构造函数来实例化这个就可以获取到了（来替换provider注解的作用）。
    //2.在@Inject注解的变量或者有参构造方法的参数没有值提供方的情况下，其值会为null，大家需要注意这个问题。
    @Inject
    public MainPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getData() {
        //第一种（完整）
//        Observable<BaseResponse> observable = dataManager.getData();
//        observable.observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribeWith(new Observer<BaseResponse>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(BaseResponse baseResponse) {
//                getView().returnData(baseResponse);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                getView().showError(e.getMessage());
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });

        //第二种（整洁清爽）
        dataManager.getData()
                .subscribeWith(new Observer<BaseResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResponse baseResponse) {
                        getView().returnData(baseResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().showError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
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
