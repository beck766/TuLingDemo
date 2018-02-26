package com.beck.tuling.model.http.service;


import com.beck.tuling.model.http.entity.TuLingRequest;
import com.beck.tuling.model.http.entity.TuLingResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * Created by beck on 2018/1/22.
 * TuLingService
 */

public interface TuLingService {

    @POST("openapi/api")
    Observable<TuLingResponse> getResponse(@Body TuLingRequest tuLingRequest);
}
