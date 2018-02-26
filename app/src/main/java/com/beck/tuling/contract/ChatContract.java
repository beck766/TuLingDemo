package com.beck.tuling.contract;

import com.beck.tuling.model.http.entity.TuLingResponse;
import com.beck.tuling.presenter.BasePresenter;
import com.beck.tuling.view.widget.BaseView;

import java.util.List;

/**
 * Created by beck on 2018/1/22.
 * ChatContract
 */

public interface ChatContract {
    interface View extends BaseView<Presenter> {
        void displayMessage(List<TuLingResponse> tuLingResponses);
    }

    interface Presenter extends BasePresenter {
        void setData(List<TuLingResponse> tuLingResponse);

        void input(String query);
        void loadMessage();
    }
}
