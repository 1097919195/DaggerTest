package zjl.example.com.daggertest.sampleDaggerTest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

import zjl.example.com.daggertest.R;
import zjl.example.com.daggertest.sampleDaggerTest.component.DaggerMainComponentTest;

/**
 * 简单的Dagger2测试
 */
public class MainActivityTest extends AppCompatActivity {

    /***
     * 第二步  使用Inject 注解，获取到A 对象的实例
     */
    @Inject
    A a;

    @Inject
    B b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main_test);
        /***
         * 第一步 添加依赖关系
         */
        //第一种方式(简单的注入create()其实就是builder().build())
        DaggerMainComponentTest.create().inject(this);

//        //第二种方式
//        DaggerMainComponentTest.builder().build().inject(this);

        /***
         * 第三步  调用A 对象的方法
         */
        a.eat();
        b.someThing();

        B b1 = new B();
        B b2 = new B();
        Log.e("Tag", b1.toString());
        Log.e("Tag", b2.toString());

//        //直接简单的生成json字符串无需+
//        String objectStr1 = "{\"name\":\"JSON\",\"age\":\"24\",\"address\":\"北京市西城区\"}";
//        //插入简单的json数组
//        List<Integer> id1 = new ArrayList<>();
//        List<Integer> values1 = new ArrayList<>();
//        id1.add(1);
//        values1.add(2);
//        Integer[] id1arr = id1.toArray(new Integer[id1.size()]);
//        Integer[] v1arr = values1.toArray(new Integer[values1.size()]);
//        //因为需要输出对象所以要用+连接
//        String objectStr2 = "{" + "\"id1\":" + Arrays.toString(id1arr) + ",\"values1\":" + Arrays.toString(v1arr) +"}";
//        //可以这么写但是为了格式统一还是向上面这样写
//        String objectStr3 = "{\"id1\":" + Arrays.toString(id1arr) + ",\"values1\":" + Arrays.toString(v1arr) +"}";
//        Log.e("TagJson1", objectStr1);
//        Log.e("TagJson2", objectStr2);
//        Log.e("TagJson3", objectStr3);

    }
}
