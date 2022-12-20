package org.nextcloud.ncextension;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {
    public static final String SP_APP_THEME = "sp_app_theme";
    public static final String CB_OLED_MODE = "cb_oled_mode";
    public static final String EDT_OWNCLOUDROOTPATH_STRING = "edt_owncloudRootPath";
    public static final String EDT_USERNAME_STRING = "edt_username";
    public static final String EDT_PASSWORD_STRING = "edt_password";
    public static final String CB_DISABLE_HOSTNAME_VERIFICATION_STRING = "cb_DisableHostnameVerification";
    public static final String SW_USE_SINGLE_SIGN_ON = "sw_use_single_sign_on";
    public static final String SP_MAX_CACHE_SIZE = "sp_max_cache_size";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
}