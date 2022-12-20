package org.nextcloud.ncextension.di;

import org.nextcloud.ncextension.LoginDialogActivity;
import org.nextcloud.ncextension.MainActivity;
import org.nextcloud.ncextension.SettingsActivity;
import org.nextcloud.ncextension.services.SyncItemStateService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { ApiModule.class })
public interface AppComponent {
    void injectActivity(LoginDialogActivity activity);
    void injectActivity(MainActivity activity);
    void injectService(SyncItemStateService service);
}
