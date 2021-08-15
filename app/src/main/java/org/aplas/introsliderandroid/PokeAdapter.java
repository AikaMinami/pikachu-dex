package org.aplas.introsliderandroid;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

public class PokeAdapter extends RecyclerView.Adapter<PokeAdapter.MyViewHolder> {

    String data1[], data2[];
    int images[];
    Context context;

    public PokeAdapter(Context ct, String pokeName[], String pokeDesc[], int img[]){
        context = ct;
        data1 = pokeName;
        data2 = pokeDesc;
        images = img;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PokeAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.myText1.setText(data1[i]);
        myViewHolder.myText2.setText(data2[i]);
        myViewHolder.myImage.setImageResource(images[i]);

        myViewHolder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PokeDescription.class);
                intent.putExtra("data1", data1[i]);
                intent.putExtra("data2", data2[i]);
                intent.putExtra("myImage", images[i]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView myText1, myText2;
        ImageView myImage;
        ConstraintLayout mainLayout;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.pokemon_name_txt);
            myText2 = itemView.findViewById(R.id.pokemon_desc_txt);
            myImage = itemView.findViewById(R.id.myImage);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
