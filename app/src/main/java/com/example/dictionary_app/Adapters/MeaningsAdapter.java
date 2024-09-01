package com.example.dictionary_app.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary_app.Models.meanings;
import com.example.dictionary_app.R;
import com.example.dictionary_app.ViewHolders.MeaningViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MeaningsAdapter extends RecyclerView.Adapter<MeaningViewHolder>
{
    Context context;
    List<meanings> meanings ;

    public MeaningsAdapter(Context context, List<com.example.dictionary_app.Models.meanings> meanings) {
        this.context = context;
        this.meanings = meanings;
    }

    @NonNull
    @NotNull
    @Override
    public MeaningViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType)
    {
        return new MeaningViewHolder(LayoutInflater.from(context).inflate(R.layout.meanings_list_items , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MeaningViewHolder holder, int position)
    {
         holder.txt_PartsOfSpeech.setText("Parts of Speech: " + meanings.get(position).getPartOfSpeech());
         holder.recycler_definitions.setHasFixedSize(true);
         holder.recycler_definitions.setLayoutManager(new GridLayoutManager(context , 1));
         DefinitionAdapter adapter = new DefinitionAdapter(context , meanings.get(position).getDefinitions());
         holder.recycler_definitions.setAdapter(adapter);


    }

    @Override
    public int getItemCount()
    {
        return meanings.size();
    }
}
