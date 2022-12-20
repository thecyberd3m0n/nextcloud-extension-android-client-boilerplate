package org.nextcloud.ncextension;

import androidx.appcompat.app.AppCompatActivity;
import org.nextcloud.ncextension.databinding.ActivityMainBinding;
import org.nextcloud.ncextension.helper.ThemeChooser;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    public static final int RESULT_LOGIN = 16000;
    @Inject
    protected SharedPreferences mPrefs;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((NextcloudExtensionApplication) getApplication()).getAppComponent().injectActivity(this);

        ThemeChooser.chooseTheme(this);

        super.onCreate(savedInstanceState);

        ThemeChooser.afterOnCreate(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(R.layout.activity_main);
        // Init config --> if nothing is configured start the login dialog.
        if (!isUserLoggedIn()) {
            startLoginActivity();
        }

    }

    public void startLoginActivity() {
        Intent loginIntent = new Intent(this, LoginDialogActivity.class);
        startActivityForResult(loginIntent, RESULT_LOGIN);
    }

    private boolean isUserLoggedIn() {
        return (mPrefs.getString(SettingsActivity.EDT_OWNCLOUDROOTPATH_STRING, null) != null);
    }
}
