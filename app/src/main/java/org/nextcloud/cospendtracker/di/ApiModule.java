package org.nextcloud.ncextension.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.nextcloud.ncextension.helper.PostDelayHandler;
import org.nextcloud.ncextension.helper.ThemeChooser;
import org.nextcloud.ncextension.ssl.MemorizingTrustManager;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

@Module
public class ApiModule {
    private final Application mApplication;
    public ApiModule(Application application) {
        this.mApplication = application;
    }

    // Dagger will only look for methods annotated with @Provides
    @Provides
    @Singleton
    // Application reference must come from AppModule.class
    SharedPreferences providesSharedPreferences() {
        SharedPreferences mPrefs = mApplication.getSharedPreferences(providesSharedPreferencesFileName(), Context.MODE_PRIVATE);
        ThemeChooser.init(mPrefs);
        return mPrefs;
    }

    // Dagger will only look for methods annotated with @Provides
    @Provides
    @Named("sharedPreferencesFileName")
    public String providesSharedPreferencesFileName() {
        //return PreferenceManager.getDefaultSharedPreferencesName(mApplication);
        return mApplication.getPackageName() + "_preferences";
    }


    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache) {
        // setCache(cache);
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    PostDelayHandler providePostDelayHandler() {
        return new PostDelayHandler(mApplication);
    }

    @Provides
    @Singleton
    MemorizingTrustManager provideMTM() {
        return new MemorizingTrustManager(mApplication);
    }

    @Provides
    @Singleton
    ApiProvider provideAPI(MemorizingTrustManager mtm, SharedPreferences sp) {
        return new ApiProvider(mtm, sp, mApplication);
    }
}
