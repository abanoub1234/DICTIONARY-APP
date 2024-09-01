package com.example.dictionary_app.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary_app.R;

import org.jetbrains.annotations.NotNull;

public class DefinitionViewHolder extends RecyclerView.ViewHolder
{
    public TextView txt_definition , txt_example , txt_synonyms , txt_antonyms;


    public DefinitionViewHolder(@NonNull @NotNull View itemView)
    {
        super(itemView);

        txt_definition = itemView.findViewById(R.id.txt_definition);
        txt_example = itemView.findViewById(R.id.txt_example);
        txt_synonyms = itemView.findViewById(R.id.txt_synonyms);
        txt_antonyms = itemView.findViewById(R.id.txt_antonyms);

    }
}
