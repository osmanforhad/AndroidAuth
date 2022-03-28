package developer.osmanforhad.androidauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {
    TextView tvName, tvEMail, tvCreated;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //__Set Screen Title__//
        getSupportActionBar().setTitle("User Panel");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        //__Initialize variables and connect and xml id__//
        tvName = findViewById(R.id.tvName);
        tvEMail = findViewById(R.id.tvEmail);
        tvCreated = findViewById(R.id.tvCreated);
        btnLogout = findViewById(R.id.btnLogout);

        getUser();//Calling the method

        //__Setup Onclick event on Logout Button__//
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();//Calling the method
            }
        });

    }

    //__Method for Get User Data__//
    private void getUser() {
        tvName.setText("Name : -");
        tvEMail.setText("Email : -");
        tvCreated.setText("Created At : -");
    }

    //__Method for Logout functionality__//
    private void logout() {
        Intent intent = new Intent(UserActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}