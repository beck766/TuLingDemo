package com.beck.tuling.model.repository;

import com.beck.tuling.model.http.entity.TuLingRequest;

/**
 * Created by beck on 2018/1/22.
 * RequestRepository
 */

public class RequestRepository {
    public static TuLingRequest setTuLingRequest(String query) {
        TuLingRequest tuLingRequest = new TuLingRequest();
        tuLingRequest.setKey("244724a752994bddbb1aa9d810b1db04");
        tuLingRequest.setInfo(query);
        tuLingRequest.setLoc("深圳");
        tuLingRequest.setUserid("15013809484");
        return tuLingRequest;
    }
}
