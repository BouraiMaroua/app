package com.example.childactivity.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.childactivity.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListActivity extends AppCompatActivity {
    Toolbar toolbar;
    ListView listview;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        if (item.getItemId() == R.id.favoris) {
            goToListFavoris();
        }
        return super.onOptionsItemSelected(item);

    }

    private void goToListFavoris() {
        Intent i = new Intent(this,FavorisActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        listview = findViewById(R.id.lv_histoire);
        String [] titres ={"Le petit chaperon rouge","Boucle d'or et les 3 ours","Cendrillon","La légende de Saint Nicolas"};
        int[] images ={R.drawable.capt0,R.drawable.captr1,R.drawable.capt2,R.drawable.capt3} ;

        List<Map<String,String>> mapList = new ArrayList<>();
        for(int i =0;i< titres.length;i++){
            HashMap <String,String> map= new HashMap<>();
            map.put("titre",titres[i]);
            map.put("image",images[i]+"");
            mapList.add(map);


            String []from={"titres","images"};


            int[]to={R.id.titre_histoire,R.id.img_histoire};

            SimpleAdapter simpleAdapter= new SimpleAdapter(this,mapList,R.layout.histoire_item,from,to);
            listview.setAdapter(simpleAdapter);

        }
    }
}