package developer.osmanforhad.androidauth;

import android.content.Context;
import android.content.SharedPreferences;

public class LocalStorage {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;
    String token;

    public LocalStorage(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("STORAGE_LOGIN_API",context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public String getToken() {
        token = sharedPreferences.getString("TOKEN", "");
        return token;
    }

    public void setToken(String token) {
        editor.putString("TOKEN", token);
        editor.commit();
        this.token = token;
    }
}
