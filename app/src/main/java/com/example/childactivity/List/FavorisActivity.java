package com.example.childactivity.List;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.childactivity.R;

import java.util.ArrayList;
import java.util.List;

public class FavorisActivity extends AppCompatActivity {
    TextView textview;
    ImageButton imagebutton;
    ListView list;
    TextView text;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoris);
        textview=findViewById(R.id.textView);
        imagebutton=findViewById(R.id.ib_histoire);
        list=findViewById(R.id.lv_favoris);
        text=findViewById(R.id.titre_histoire);

        List<String> list_msg=new ArrayList<>();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list_msg);

        textview.setText("Aucune histoire à afficher");

        imagebutton.setOnClickListener(view -> {
            String msg = text.getText().toString();
            list_msg.add(msg);
            arrayAdapter.notifyDataSetChanged();
            text.setText("");
            textview.setText("");

        });
    }
}