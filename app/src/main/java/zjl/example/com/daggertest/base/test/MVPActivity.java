package zjl.example.com.daggertest.base.test;

import android.view.View;
import android.widget.Toast;

import zjl.example.com.daggertest.R;
import zjl.example.com.daggertest.base.BaseMVPActivity;


/**
 * Created by Administrator on 2018/11/9 0009.
 * MVP单纯的模式测试（没有加入Dagger2）
 */

public class MVPActivity extends BaseMVPActivity<MVPPresenter> implements MVPContract.View {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_mvp;
    }

    //因为在BaseMVPActivity中没有实现presenter类实例化所以需要new，可以模仿新闻APP的实现    （测试MVPPresenter2直接把本类中的MVPPresenter全部替换了就行）
    @Override
    protected void initPresenter() {
        // presenter 关联 view
        if (presenter == null) {
            presenter = new MVPPresenter();
        }
        presenter.attachView(this);
    }

    @Override
    protected void initView() {
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getData();
            }
        });
    }

    @Override
    public void returnData(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }
}
