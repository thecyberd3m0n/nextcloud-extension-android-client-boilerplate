package org.nextcloud.ncextension;

import android.app.Application;

import org.nextcloud.ncextension.di.ApiModule;
import org.nextcloud.ncextension.di.AppComponent;
import org.nextcloud.ncextension.di.DaggerAppComponent;

public class NextcloudExtensionApplication extends Application {
    protected AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initDaggerAppComponent();
    }

    public void initDaggerAppComponent() {
        // Dagger%COMPONENT_NAME%

        mAppComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule(this))
                .build();

        // If a Dagger 2 component does not have any constructor arguments for any of its modules,
        // then we can use .create() as a shortcut instead:
        //mAppComponent = DaggerAppComponent.create();
    }
    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
