package org.aplas.introsliderandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PokeDescription extends AppCompatActivity {

    ImageView imageDesc;
    TextView poketitle, pokedesc;

    String data1, data2;
    int myImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_description);

        imageDesc = findViewById(R.id.imageDesc);
        poketitle = findViewById(R.id.PokeTitleDesc);
        pokedesc = findViewById(R.id.PokeDescDesc);

        GetData();
        SetData();
    }

    private void GetData(){
        if(getIntent().hasExtra("data1") && getIntent().hasExtra("data2")
                && getIntent().hasExtra("myImage")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            myImage = getIntent().getIntExtra("myImage", 1);
        } else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    private void SetData(){
        poketitle.setText(data1);
        pokedesc.setText(data2);
        imageDesc.setImageResource(myImage);
    }
}