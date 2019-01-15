package zjl.example.com.daggertest.base;

public interface BaseContract {
    interface View {
        void showLoading(String title);
        boolean isNetworkConnected();
        void showError(String message);
    }

    //给BasePresenter使用的（统一声明关联和分离的行为）
    interface Presenter<V extends BaseContract.View> {
        void attachView(V view);
        void detachView();
    }
}
