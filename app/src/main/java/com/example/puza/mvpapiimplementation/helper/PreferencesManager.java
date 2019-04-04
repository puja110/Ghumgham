package com.example.puza.mvpapiimplementation.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesManager {

    private SharedPreferences sharedPreferences;
    private Context context;
    private static final String LOGIN_DETAILS = "login_details";
    private static final String SERVICE_DETAILS = "service_details";
    private static final String SHARED_PREF_PASSENGER = "passenger";
    private static final String KEY_PASSENGER = "from";

    private static final String KEY_ELECTRICITY = "electricity";


    public PreferencesManager(Context context)
    {
        sharedPreferences = context.getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
        this.context = context;
    }

    public void save(String key, String value)
    {
        sharedPreferences.edit().putString(key,value).apply();
    }

    public void setBoolean(String key, Boolean value)
    {
        sharedPreferences.edit().putBoolean(key,value).apply();
    }

    public void setFirstLaunch(String key, Boolean value)
    {
        sharedPreferences.edit().putBoolean(key,value).apply();
    }
    public Boolean getFirstLaunch(String key)
    {
        return sharedPreferences.getBoolean(key,true);
    }

    public String get(String key)
    {
        return sharedPreferences.getString(key,null);
    }

    public Boolean getBoolean(String key)
    {
        return sharedPreferences.getBoolean(key,false);
    }

    public boolean isEmpty(String key)
    {
        return (sharedPreferences.getString(key,null) == null);
    }

    public boolean setLoginDetails (String login_deatils){

        SharedPreferences login = context.getSharedPreferences(LOGIN_DETAILS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editorLogin = login.edit();

        editorLogin.putString(LOGIN_DETAILS, login_deatils);

        editorLogin.apply();

        return true;
    }

    public String getLoginDetails(){
        SharedPreferences login = context.getSharedPreferences(LOGIN_DETAILS, Context.MODE_PRIVATE);
        return login.getString(LOGIN_DETAILS, null);
    }


    public boolean setServiceDetails (String service_details){

        SharedPreferences service = context.getSharedPreferences(SERVICE_DETAILS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editorService = service.edit();

        editorService.putString(SERVICE_DETAILS, service_details);

        editorService.apply();

        return true;
    }

    public String getServiceDetails(){
        SharedPreferences service = context.getSharedPreferences(SERVICE_DETAILS, Context.MODE_PRIVATE);
        return service.getString(SERVICE_DETAILS, null);
    }

    public void clear()
    {
        sharedPreferences.edit().clear().apply();
    }

    public boolean setPassengerDetails(String setPassenger) {

        SharedPreferences sharedPreferencesPM = context.getSharedPreferences(SHARED_PREF_PASSENGER, Context.MODE_PRIVATE);
        SharedPreferences.Editor editorTM = sharedPreferencesPM.edit();

        editorTM.putString(KEY_PASSENGER, setPassenger);

        editorTM.apply();

        return true;
    }

    public String getPassengerDetails() {
        SharedPreferences sharedPreferencesPM = context.getSharedPreferences(SHARED_PREF_PASSENGER, Context.MODE_PRIVATE);
        return sharedPreferencesPM.getString(KEY_PASSENGER, null);

    }

    public boolean setelectricity(String setelectrivity) {

        SharedPreferences sharedPreferencesPM = context.getSharedPreferences(SHARED_PREF_PASSENGER, Context.MODE_PRIVATE);
        SharedPreferences.Editor editorTM = sharedPreferencesPM.edit();

        editorTM.putString(KEY_ELECTRICITY, setelectrivity);

        editorTM.apply();

        return true;
    }

    public String getelectricity() {
        SharedPreferences sharedPreferencesPM = context.getSharedPreferences(SHARED_PREF_PASSENGER, Context.MODE_PRIVATE);
        return sharedPreferencesPM.getString(KEY_ELECTRICITY, null);

    }

}
