package developer.osmanforhad.androidauth;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    EditText etName, etEmail, etPassword, etConfirmation;
    Button btnRegister;
    String name, email, password, confirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //__Setup Screen Title__//
        getSupportActionBar().setTitle("REGISTER");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //__connect with xml id__//
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmation = findViewById(R.id.etConfirmation);
        btnRegister = findViewById(R.id.btnRegister);

        //__Handle Onclick Event by Register Button__//
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkRegister();//Calling the Method
            }
        });
    }

    //__Method for Registration Functionality__//
    private void checkRegister() {
        name = etName.getText().toString();
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();
        confirmation = etConfirmation.getText().toString();
        if(name.isEmpty() || email.isEmpty() || password.isEmpty()){
            alertFail("Name Email and Password is Required.");//Calling the method
        }
        else if(!password.equals(confirmation)) {
            alertFail("Password and Password Confirmation doesn't match");
        }
        else {
            sendRegister();//Calling the method
        }
    }
    //Method for Redirect to Register Screen__//
    private void sendRegister() {
        alertSuccess("Register Successfully !! Thank You");//Calling the method
    }

    //__Method for Success Alert__//
    private void alertSuccess(String s) {
        new AlertDialog.Builder(this).setTitle("Success").setIcon(R.drawable.ic_check).setMessage(s)
                .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        onBackPressed();
                    }
                }).show();
    }

    //__Method for Fail Alert__//
    private void alertFail(String s) {
        new  AlertDialog.Builder(this).setTitle("Failed").setIcon(R.drawable.ic_warning).setMessage(s)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }
}