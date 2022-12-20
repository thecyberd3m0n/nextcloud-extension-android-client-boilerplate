package org.nextcloud.ncextension.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

import com.nextcloud.android.sso.model.ocs.OcsUser;

public interface OcsAPI {
    String mApiEndpoint = "/ocs/v2.php/";

    @GET("cloud/user?format=json")
    Observable<OcsUser> user();
}
