package zjl.example.com.daggertest.base;

//这里后面需要使用V，所以需要声明泛型的继承类
public abstract class BasePresenter<V extends BaseContract.View> implements BaseContract.Presenter<V> {

    private V view;

    public BasePresenter() {
    }

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    public boolean isViewAttached() {
        return view != null;
    }

    public V getView() {
        return view;
    }
}
