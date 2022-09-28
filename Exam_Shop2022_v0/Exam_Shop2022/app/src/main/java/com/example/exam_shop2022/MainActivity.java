package com.example.exam_shop2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView img_product_main;
    EditText edit_count;
    TextView txt_price,txt_delivery,txt_pay;
    CheckBox chk_agree;

    int selected_price=1500,selected_count;
    int val_price,val_delivery,val_pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img_product_main = findViewById(R.id.img_product_main);
        edit_count = findViewById(R.id.edit_count);
        txt_price = findViewById(R.id.txt_price);
        txt_delivery = findViewById(R.id.txt_delivery);
        txt_pay = findViewById(R.id.txt_pay);
        chk_agree = findViewById(R.id.chk_agree);
//진혁아 안녕 하하하하하하하ㅣ하하하하하하하하하하하 라라라라라라라라라라라라라라라라라라라라라라라라라라라라라라라라라라라라라라라
        findViewById(R.id.radio1).setOnClickListener(this);
        findViewById(R.id.radio2).setOnClickListener(this);
        findViewById(R.id.radio3).setOnClickListener(this);
        findViewById(R.id.btn_plus).setOnClickListener(this);
        findViewById(R.id.btn_minus).setOnClickListener(this);
        findViewById(R.id.btn_pay).setOnClickListener(this);
        sumTotal();
    }
    void sumTotal(){
        selected_count= Integer.parseInt(edit_count.getText().toString());
        val_price=selected_price*selected_count;
        if(val_price>=10000)val_delivery=0;
        else val_delivery=2500;
        val_pay=val_price+val_delivery;
        txt_price.setText(val_price+"원");
        txt_delivery.setText(val_delivery+"원");
        txt_pay.setText(val_pay+"원");

    }
    @Override
    public void onClick(View v) {
        int cnt= Integer.parseInt(edit_count.getText().toString());
        switch (v.getId()) {
            case R.id.radio1:
                img_product_main.setImageResource(R.drawable.product1);
                selected_price=1500;
                sumTotal();
                break;
            case R.id.radio2:
                img_product_main.setImageResource(R.drawable.product2);
                selected_price=2000;
                sumTotal();
                break;
            case R.id.radio3:
                img_product_main.setImageResource(R.drawable.product3);
                selected_price=3000;
                sumTotal();
                break;
            case R.id.btn_minus:
                if(cnt>1)edit_count.setText(cnt-1+"");
                else Toast.makeText(this, "주문할 수 있는 최소수량은 1개입니다.", Toast.LENGTH_SHORT).show();
                sumTotal();
                break;
            case R.id.btn_plus:
                edit_count.setText(cnt+1+"");
                sumTotal();
                break;
            case R.id.btn_pay:
                if(chk_agree.isChecked()==false)
                    Toast.makeText(this, "결제 동의 버튼을 체크해주세요", Toast.LENGTH_SHORT).show();
                else{
                    Toast.makeText(this, val_pay+"원을 결제하겠습니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,SubActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }
}