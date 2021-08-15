package org.aplas.introsliderandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class PokeList extends AppCompatActivity {

    RecyclerView recyclerView;
    String pokeName[], pokeDesc[];
    int img[] = {R.drawable.bullbasaur, R.drawable.charmander, R.drawable.dratini, R.drawable.eevee,
            R.drawable.jigglypuff, R.drawable.meowth, R.drawable.pikachu, R.drawable.psyduck, R.drawable.snorlax,
            R.drawable.squirtle};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_list);

        recyclerView = findViewById(R.id.pokeRecyclerView);
        pokeName = getResources().getStringArray(R.array.pokemon);
        pokeDesc = getResources().getStringArray(R.array.description);

        PokeAdapter pokeAdapter = new PokeAdapter(this, pokeName, pokeDesc, img);
        recyclerView.setAdapter(pokeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}