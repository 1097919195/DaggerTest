package zjl.example.com.daggertest.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import zjl.example.com.daggertest.R;
import zjl.example.com.daggertest.base.test.MVPActivity;
import zjl.example.com.daggertest.sampleDaggerTest.MainActivityTest;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        initListener();

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
}
