package zjl.example.com.daggertest.sampleDaggerTest;

import android.util.Log;

/**
 * Created by Administrator on 2018/11/13 0013.
 */

public class A {
    private B b;
    public A(B b) {
        this.b = b;
    }
    public void eat() {
        Log.e("print====", "succeedEat." + b.someThing());
    }
}
