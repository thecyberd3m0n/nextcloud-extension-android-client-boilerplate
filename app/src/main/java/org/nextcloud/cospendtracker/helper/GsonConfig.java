package org.nextcloud.ncextension.helper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.nextcloud.ncextension.api.NextcloudServerDeserializer;
import org.nextcloud.ncextension.model.OcsUser;

import java.lang.reflect.Type;


/**
 * Created by david on 27.06.17.
 */

public class GsonConfig {

    public static Gson GetGson() {
        Type ocsUser = new TypeToken<OcsUser>() {}.getType();

        // Info: RssItems are handled as a stream (to be more memory efficient - see @OwnCloudSyncService and @RssItemObservable)
        return new GsonBuilder()
                .setLenient()
                .registerTypeAdapter(ocsUser,      new NextcloudServerDeserializer<>("ocsUser", OcsUser.class))
                .create();
    }

}