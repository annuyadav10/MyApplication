package com.example.lenovo.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by logimetrix on 8/7/16.
 */
    public class SharedPrefrences {

    private static SharedPrefrences gardenSharedPrfs;
    private SharedPreferences appSharedPrefs;
    private SharedPreferences.Editor prefsEditor;
    private static final String sharedprfstag="MyApplicarion";

    public SharedPrefrences(Context con) {
        this.appSharedPrefs = con.getSharedPreferences(sharedprfstag, Context.MODE_PRIVATE);
        this.prefsEditor = appSharedPrefs.edit();
    }


    public static SharedPrefrences getsharedprefInstance(Context con) {
        if (gardenSharedPrfs == null)
            gardenSharedPrfs = new SharedPrefrences(con);
        return gardenSharedPrfs;
    }

    public SharedPreferences getAppSharedPrefs() {
        return appSharedPrefs;
    }

    public void setAppSharedPrefs(SharedPreferences appSharedPrefs) {
        this.appSharedPrefs = appSharedPrefs;
    }

    public SharedPreferences.Editor getPrefsEditor() {
        return prefsEditor;
    }

    public void Commit() {
        prefsEditor.commit();
    }

    public void setuserid(String id)
    {
        this.prefsEditor=appSharedPrefs.edit();
        prefsEditor.putString("Userid",id);
        prefsEditor.commit();
    }
    public String getuserid(){
        return appSharedPrefs.getString("Userid","0");
    }
     public void setusername(String name)
     {
       this.prefsEditor=appSharedPrefs.edit();
        prefsEditor.putString("Username",name);
         prefsEditor.commit();
     }
    public String getusername(){
        return appSharedPrefs.getString("Username","0");
    }



    public void setemail(String email)
    {
        this.prefsEditor=appSharedPrefs.edit();
        prefsEditor.putString("Email_id",email);
        prefsEditor.commit();
    }
    public String getemail(){
        return appSharedPrefs.getString("Email_id","0");
    }
    public void setpassword(String pass)
    {
        this.prefsEditor=appSharedPrefs.edit();
        prefsEditor.putString("password",pass);
        prefsEditor.commit();
    }
    public String getpassword(){
        return appSharedPrefs.getString("password","0");
    }

    public void setPhonenumber(String number)
    {
        this.prefsEditor=appSharedPrefs.edit();
        prefsEditor.putString("mob",number);
        prefsEditor.commit();
    }
    public String getmob()
    {
        return appSharedPrefs.getString("mob","");
    }
    public void setCheckStatus(boolean status) {
        this.prefsEditor = appSharedPrefs.edit();
        prefsEditor.putBoolean("Status", status);
        prefsEditor.commit();
    }

    public boolean getcheckStatus() {
        return appSharedPrefs.getBoolean("Status", false);
    }

}
