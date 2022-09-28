package com.example.mywebview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editUrl;
    WebView webView;
    InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUrl = findViewById(R.id.editUrl);
        webView = findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());

        findViewById(R.id.btnClear).setOnClickListener(this);
        findViewById(R.id.btnGoNaver).setOnClickListener(this);
        findViewById(R.id.btnGoGoogle).setOnClickListener(this);
        findViewById(R.id.btnBack).setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.menu1:

                break;
            case R.id.menu2:

                break;
            case R.id.menu3:
                finish();
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        switch (v.getId()){
            case R.id.btnClear:
                editUrl.setText("");
                break;
            case R.id.btnGoNaver:
                webView.loadUrl("https://search.naver.com/search.naver?query=" + editUrl.getText().toString());
                imm.hideSoftInputFromWindow(editUrl.getWindowToken(), 0);
                break;
            case R.id.btnGoGoogle:
                webView.loadUrl("https://www.google.co.kr/search?q=" + editUrl.getText().toString());
                imm.hideSoftInputFromWindow(editUrl.getWindowToken(), 0);
                break;
            case R.id.btnBack:
                webView.goBack();
                break;

        }
    }
}