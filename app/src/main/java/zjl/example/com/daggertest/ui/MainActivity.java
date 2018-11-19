package zjl.example.com.daggertest.ui;

import android.content.Intent;
import android.util.Log;

import zjl.example.com.daggertest.R;
import zjl.example.com.daggertest.base.BaseDaggerMVPActivity;
import zjl.example.com.daggertest.base.test.MVPActivity;
import zjl.example.com.daggertest.base.test.MVPContract;
import zjl.example.com.daggertest.base.test.MVPPresenter;
import zjl.example.com.daggertest.data.source.DataManager;
import zjl.example.com.daggertest.sampleDaggerTest.MainActivityTest;
import zjl.example.com.daggertest.ui.contract.MainContract;
import zjl.example.com.daggertest.ui.presenter.MainPresenter;


public class MainActivity extends BaseDaggerMVPActivity<MainPresenter> implements MainContract.View {

    private DataManager dataManager;

    @Override
    protected int getLayoutId() {
        return R.layout.act_main;
    }

    @Override
    protected void initPresenter() {
        // 依赖注入（也要注意顺序，先依赖才能获取对象）
        activityComponent.inject(this);
        // presenter 关联 view
        if (presenter == null) {
            return;
        }
        presenter.attachView(this);
    }

    @Override
    protected void initView() {
        initListener();
        presenter.getData();
    }

    private void initListener() {
        findViewById(R.id.turnMVP).setOnClickListener(v -> {
            Intent intent = new Intent(this, MVPActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.turnDaggerTest).setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivityTest.class);
            startActivity(intent);
        });
    }

    @Override
    public void returnData(String data) {
        Log.e("DaggerWithMvp", data);
    }
}
