package com.example.dictionary_app.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary_app.R;

import org.jetbrains.annotations.NotNull;

public class MeaningViewHolder extends RecyclerView.ViewHolder
{
    public TextView txt_PartsOfSpeech;
    public RecyclerView recycler_definitions;


    public MeaningViewHolder(@NonNull @NotNull View itemView)
    {
        super(itemView);

        txt_PartsOfSpeech  = itemView.findViewById(R.id.txt_PartsOfSpeech);
        recycler_definitions  = itemView.findViewById(R.id.recycler_definitions);

    }
}
