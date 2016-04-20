package com.example.envy_m6.sayitahminoyunu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText et;
    TextView tvHak, tvSonuc;
    Button btnTahmin, btnYenile;
    int tut, fark, tahmin;
    private static int hak = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText)findViewById(R.id.editText);
        tvHak = (TextView)findViewById(R.id.textView);
        tvSonuc = (TextView)findViewById(R.id.textView2);
        btnTahmin = (Button)findViewById(R.id.buttonTahmin);
        btnYenile = (Button)findViewById(R.id.buttonYenile);

        Random rnd = new Random();
        tut = rnd.nextInt(26);

        btnTahmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gelenVeri;
                gelenVeri = et.getText().toString();
                if (gelenVeri.matches("")){
                    tahmin = 1;
                    Toast.makeText(getApplicationContext(), "Boş bırakılamaz.", Toast.LENGTH_SHORT).show();
                    hak++;
                }else {
                    tahmin = Integer.parseInt(gelenVeri);
                    fark = Math.abs(tut - tahmin);
                }

                hak--;
                tvHak.setText(String.valueOf(hak).toString());
                if (hak>0) {

                    if (fark >= 1 && fark<5) {
                        tvSonuc.setText("ÇOK YAKINSIN!");
                    }
                    if (fark >= 5 && fark<10) {
                        tvSonuc.setText("YAKINSIN!");
                    }
                    if (fark >= 10 && fark<15) {
                        tvSonuc.setText("UZAKSIN!");
                    }
                    if (fark >= 15 && fark<20) {
                        tvSonuc.setText("ÇOK UZAKSIN!");
                    }
                    if (fark >= 20 && fark<=25) {
                        tvSonuc.setText("ABARTMA!!");
                    }
                    if (fark<1 && fark>25){
                        Toast.makeText(getApplicationContext(), "Lütfen 1-25 arası sayı girin", Toast.LENGTH_SHORT).show();
                        hak++;
                    }


                }else {
                    if (fark==0){
                        tvSonuc.setText("Tebrikler! Sayı: " + tut + ".");
                    }else {
                        tvSonuc.setText("Sayı: " + tut + " olacaktı.");
                        tvHak.setText("Hakkınız Bitti!!");
                        btnTahmin.setEnabled(false);
                    }
                }
            }
        });

        btnYenile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hak = 3;
                finish();
                startActivity(getIntent());
            }
        });
    }
}
