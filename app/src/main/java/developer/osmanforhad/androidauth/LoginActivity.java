package developer.osmanforhad.androidauth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText etEmail, etPassword;
    Button btnLogin, btnRegister;
    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //__Set Screen Title__//
        getSupportActionBar().setTitle("User Login");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //__connect with xml id__//
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        //__Handle Onclick Event by Login Button__//
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLogin(); //Calling the method
            }
        });

        //__Handle Onclick Event by Register Button__//
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    //__Method for Login Functionality__//
    private void checkLogin() {
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();
        if(email.isEmpty() || password.isEmpty()){
            alertFail("Email and Password is required."); //Calling the method and pass a string message
        }
        else {
            sendLogin();//Calling the Method
        }
    }

    //Method for Redirect to Login Screen__//
    private void sendLogin() {
        Toast.makeText(this, "Sending", Toast.LENGTH_SHORT).show();
    }

    //__Method for Fail Alert__//
    private void alertFail(String s) {
        new AlertDialog.Builder(this).setTitle("Failed").setIcon(R.drawable.ic_warning).setMessage(s)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }

}