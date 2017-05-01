package com.simple;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    private Button btn_pass_reset;
    private PasswordView passwordview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_pass_reset = (Button) findViewById(R.id.btn_pass_reset);
        passwordview = (PasswordView) findViewById(R.id.passwordview);
        btn_pass_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordview.setEmpeyText();
            }
        });
    }
}
