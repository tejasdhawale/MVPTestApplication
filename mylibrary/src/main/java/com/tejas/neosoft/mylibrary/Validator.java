package com.tejas.neosoft.mylibrary;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by webwerks1 on 23/1/18.
 */

public class Validator {

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager conMan = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMan.getActiveNetworkInfo() != null && conMan.getActiveNetworkInfo().isConnected())
            return true;
        else
            return false;
    }
    public static boolean validateEmail(String email) {
      if(!email.isEmpty()) {
          if (email.contains("@"))
              return true;
          else
              return false;
      }
      else
      {
          return  false;
      }
    }

}
