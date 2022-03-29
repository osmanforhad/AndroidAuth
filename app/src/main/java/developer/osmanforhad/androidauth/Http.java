package developer.osmanforhad.androidauth;

import android.content.Context;

import java.util.Locale;

public class Http {
    Context context;
    private String url, method="GET", data=null, response=null;
    private Integer statusCode = 0;
    private Boolean token = false;
    private LocalStorage localStorage;

    public Http(Context context, String url) {
        this.context = context;
        this.url = url;
        localStorage = new LocalStorage(context);
    }

    public void setMethod(String method) {
        this.method = method.toUpperCase();
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setToken(Boolean token) {
        this.token = token;
    }

    public String getResponse() {
        return response;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void send(){
        
    }

}
