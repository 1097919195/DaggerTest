package zjl.example.com.daggertest.data.source.remote;

import io.reactivex.Observable;
import retrofit2.http.GET;
import zjl.example.com.daggertest.data.bean.BaseResponse;

public interface ApiService {
    @GET("hotkey/json")
    Observable<BaseResponse> getData();
}
