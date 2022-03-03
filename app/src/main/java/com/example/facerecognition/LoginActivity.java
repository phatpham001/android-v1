package com.example.facerecognition;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import com.example.facerecognition.API.ApiAccount;
import com.example.facerecognition.Models.AccountModel;

import org.json.JSONArray;

import java.util.Currency;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText edt_username, edt_password;
    private Button btn_dangnhap;
    AccountModel accountModel = new AccountModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AnhXa();
        btn_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCallApi();
            }

        });
    }

    private void clickCallApi() {
        if (!isOnline()) {
            Toast.makeText(LoginActivity.this, "Yêu cầu kết nối mạng", Toast.LENGTH_SHORT).show();
        } else {
            ApiAccount.apiAccount.accountModelCall1(
                    edt_username.getText().toString().trim(),
                    edt_password.getText().toString().trim())
                    .enqueue(new Callback<List<AccountModel>>() {
                        @Override
                        public void onResponse(Call<List<AccountModel>> call, Response<List<AccountModel>> response) {
                           //Login thành công -->Call api thành công
                            List<AccountModel> listAccountModel = response.body();
                            AccountModel accountModel = listAccountModel.get(0);
                            Toast.makeText(LoginActivity.this, accountModel.getUsername() + "Login thanh cong", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<List<AccountModel>> call, Throwable t) {
                            //Login không thành công -->Call api không thành công
                            Toast.makeText(LoginActivity.this, "Tài khoản hoặc mật khẩu đã bị sai", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

    private Boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni != null && ni.isConnected()) {
            return true;
        }
        return false;
    }

    private void AnhXa() {
        edt_password = (EditText) findViewById(R.id.ed_login_password);
        edt_username = (EditText) findViewById(R.id.ed_login_username);
        btn_dangnhap = (Button) findViewById(R.id.btn_login);
    }
}