package com.example.dictionary_app.ViewHolders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary_app.R;

import org.jetbrains.annotations.NotNull;

public class PhoneticViewHolder extends RecyclerView.ViewHolder
{

    public TextView txt_phonetic;
    public ImageButton img_btn_audio;

    public PhoneticViewHolder(@NonNull @NotNull View itemView)
    {
        super(itemView);
        txt_phonetic = itemView.findViewById(R.id.txt_phonetic);
        img_btn_audio = itemView.findViewById(R.id.img_btn_audio);

    }
}
