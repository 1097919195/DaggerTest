package zjl.example.com.daggertest.data.source;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;


import io.reactivex.Observable;
import zjl.example.com.daggertest.data.bean.BaseResponse;
import zjl.example.com.daggertest.data.source.local.DatabaseHelper;
import zjl.example.com.daggertest.data.source.remote.ApiService;
import zjl.example.com.daggertest.utils.RxSchedulers;


@Singleton
public class DataManager {
    private ApiService apiService;
    private DatabaseHelper databaseHelper;

    @Inject
    public DataManager(ApiService apiService, DatabaseHelper databaseHelper) {
        this.apiService = apiService;
        this.databaseHelper = databaseHelper;
    }

    public Observable<BaseResponse> getData() {
        return apiService.getData()
                .compose(RxSchedulers.io_main());//自己封装了一下
    }
}
