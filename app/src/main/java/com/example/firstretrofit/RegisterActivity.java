package com.example.firstretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {
    private EditText name;
    private EditText email;
    private EditText password;
    private Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.editTextName);
        email=findViewById(R.id.editTextEmail);
        password=findViewById(R.id.editTextPassword);
        Login=findViewById(R.id.buttonLogin);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog=new ProgressDialog(RegisterActivity.this);
                progressDialog.setMessage("Sign up...");
                progressDialog.show();
                Retrofit retrofit=new Retrofit.Builder().baseUrl(APIUrl.BASE_URL).
                        addConverterFactory(GsonConverterFactory.create()).build();
                APIService service=retrofit.create(APIService.class);
                Call<Result> call=service.createUser(
                        name.getText().toString(),
                        email.getText().toString(),
                        password.getText().toString()
                );
                call.enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(),"User is register",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}