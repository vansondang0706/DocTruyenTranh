package com.example.doctruyentranh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.example.doctruyentranh.adapter.TruyenTranhAdapter;
import com.example.doctruyentranh.interfaces.LayTruyenVe;
import com.example.doctruyentranh.object.TruyenTranh;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LayTruyenVe {
    GridView gdvDSTruyen;
    TruyenTranhAdapter adapter;
    EditText edtTimKem;
    ArrayList<TruyenTranh> truyenTranhArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        anhXa();
        setUp();
        setClick();
    }

    private void init() {
        truyenTranhArrayList = new ArrayList<>();
//        truyenTranhArrayList.add(new TruyenTranh("Cửu Khuyết Phong Hoa", "Chapter 86", "http://st.truyenchon.com/data/comics/187/cuu-khuyet-phong-hoa.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Bởi vì chúng ta đều là những ngôi sao", "Chapter 195", "http://st.truyenchon.com/data/comics/153/boi-vi-chung-ta-deu-la-nhung-ngoi-sao.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Jyaryu Tensei - Tà Long Tái Sinh", "Chapter 28", "http://st.truyenchon.com/data/comics/19/jyaryu-tensei-ta-long-tai-sinh.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Kang Gito", "Chapter 15", "http://st.truyenchon.com/data/comics/182/kang-gito.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Cửu Khuyết Phong Hoa", "Chapter 86", "http://st.truyenchon.com/data/comics/187/cuu-khuyet-phong-hoa.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Bởi vì chúng ta đều là những ngôi sao", "Chapter 195", "http://st.truyenchon.com/data/comics/153/boi-vi-chung-ta-deu-la-nhung-ngoi-sao.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Jyaryu Tensei - Tà Long Tái Sinh", "Chapter 28", "http://st.truyenchon.com/data/comics/19/jyaryu-tensei-ta-long-tai-sinh.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Kang Gito", "Chapter 15", "http://st.truyenchon.com/data/comics/182/kang-gito.jpg"));

        adapter = new TruyenTranhAdapter(this, 0, truyenTranhArrayList);
    }

    ;

    private void anhXa() {
        gdvDSTruyen = findViewById(R.id.gdvDSTruyen);
        edtTimKem = findViewById(R.id.edtTimKiem);
    }

    ;

    private void setUp() {
        gdvDSTruyen.setAdapter(adapter);

    }

    ;

    private void setClick() {
        edtTimKem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = edtTimKem.getText().toString();
                adapter.sortTruyen(s);
            }
        });
        gdvDSTruyen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                TruyenTranh truyenTranh = truyenTranhArrayList.get(i);
                Bundle b = new Bundle();
                b.putSerializable("truyen",truyenTranh);

                Intent intent = new Intent(MainActivity.this,ChapActivity.class);
                intent.putExtra("data",b);
                startActivity(intent);
            }
        });
    }

    @Override
    public void batDau() {
        Toast.makeText(this,"Dang lay Truyen ve",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ketThuc(String data) {
    try {
        JSONArray arr = new JSONArray(data);
        for (int i=0; i <= arr.length(); i++){
            JSONObject o = arr.getJSONObject(i);
        }
    }
    catch (JSONException e ){

    }
    }

    @Override
    public void biLoi() {
        Toast.makeText(this,"Loi ket noi",Toast.LENGTH_SHORT).show();

    }

    ;

}