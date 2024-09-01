package com.example.dictionary_app.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary_app.Models.definitions;
import com.example.dictionary_app.R;
import com.example.dictionary_app.ViewHolders.DefinitionViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DefinitionAdapter extends RecyclerView.Adapter<DefinitionViewHolder>
{
    Context context;
    List<definitions> definitions;


    public DefinitionAdapter(Context context, List<com.example.dictionary_app.Models.definitions> definitions) {
        this.context = context;
        this.definitions = definitions;
    }

    @NonNull
    @NotNull
    @Override
    public DefinitionViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType)
    {
        return new DefinitionViewHolder(LayoutInflater.from(context).inflate(R.layout.definitions_list_items , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DefinitionViewHolder holder, int position)
    {
        holder.txt_definition.setText("Definitions: " + definitions.get(position).getDefinition());
        holder.txt_example.setText("Example: " + definitions.get(position).getExample());
        StringBuilder synonyms = new StringBuilder();
        StringBuilder antonyms = new StringBuilder();

        synonyms.append(definitions.get(position).getSynonyms());
        antonyms.append(definitions.get(position).getAntonyms());

        holder.txt_synonyms.setText(synonyms);
        holder.txt_antonyms.setText(antonyms);

        holder.txt_synonyms.setSelected(true);
        holder.txt_antonyms.setSelected(true);
    }

    @Override
    public int getItemCount()
    {
        return definitions.size();
    }
}
