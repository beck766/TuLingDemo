package com.beck.tuling.presenter;

import android.content.Context;

import com.beck.tuling.contract.ChatContract;
import com.beck.tuling.model.http.entity.TuLingRequest;
import com.beck.tuling.model.http.entity.TuLingResponse;
import com.beck.tuling.model.http.service.TuLingService;
import com.beck.tuling.model.repository.RequestRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by beck on 2018/1/22.
 * ChatPresenter
 */

public class ChatPresenter implements ChatContract.Presenter {

    private static final String TAG = ChatPresenter.class.getSimpleName();
    private ChatContract.View view;
    private Retrofit retrofit;
    private String query;
    private List<TuLingResponse> tuLingResponseList;

    public ChatPresenter(Context context, ChatContract.View view) {
        this.view = view;
        view.setPresenter(this);
        tuLingResponseList=new ArrayList<>();
    }

    @Override
    public void subscribe() {
        initRetrofit();
        loadMessage();
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://www.tuling123.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    @Override
    public void unSubscribe() {

    }

    @Override
    public void setData(List<TuLingResponse> tuLingResponseList) {
        this.tuLingResponseList=tuLingResponseList;
    }

    @Override
    public void input(String query) {
        this.query = query;
        loadMessage();
    }

    @Override
    public void loadMessage() {
        TuLingRequest tuLingRequest = RequestRepository.setTuLingRequest(query);
        TuLingService tuLingService = retrofit.create(TuLingService.class);

        tuLingService.getResponse(tuLingRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<TuLingResponse>() {
                    @Override
                    public void onNext(TuLingResponse tuLingResponse) {
                        tuLingResponse.setDate(new Date());
                        tuLingResponse.setType(TuLingResponse.Type.OUTCOMING);
                        tuLingResponseList.add(tuLingResponse);
                        view.displayMessage(tuLingResponseList);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
