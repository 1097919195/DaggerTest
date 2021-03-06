package zjl.example.com.daggertest.base.test;


import zjl.example.com.daggertest.base.BaseContract;
import zjl.example.com.daggertest.base.BasePresenter;

/**
 * Created by Administrator on 2018/11/9 0009.
 */

public interface MVPContract {
    interface View extends BaseContract.View {
        void returnData(String data);
    }


    //第一种接口实现的话 需要XXPresenter后面继承BasePresenter<MVPContract.View> 才能获取view   因为getView方法定义在BasePresenter里面
    interface Presenter extends BaseContract.Presenter<View> {
        void getData();
    }

    //第二种抽象类只要实现MVPContract.basePresenter 就能获取到view （就是新闻APP中使用的MVP模式）
    abstract class basePresenter extends BasePresenter<View> {
        public abstract void getData();
    }

}
