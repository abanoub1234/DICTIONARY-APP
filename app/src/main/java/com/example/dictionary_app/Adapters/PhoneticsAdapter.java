package com.example.dictionary_app.Adapters;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary_app.Models.phonetics;
import com.example.dictionary_app.R;
import com.example.dictionary_app.ViewHolders.PhoneticViewHolder;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

public class PhoneticsAdapter extends RecyclerView.Adapter<PhoneticViewHolder>
{
    Context context;
    List<phonetics> phonetics;

    public PhoneticsAdapter(Context context, List<com.example.dictionary_app.Models.phonetics> phonetics) {
        this.context = context;
        this.phonetics = phonetics;
    }

    @NonNull
    @NotNull
    @Override
    public PhoneticViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType)
    {
        return new PhoneticViewHolder(LayoutInflater.from(context).inflate(R.layout.phonetic_list_items, parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PhoneticViewHolder holder, int position)
    {
          holder.txt_phonetic.setText(phonetics.get(position).getText());
          holder.img_btn_audio.setOnClickListener(new View.OnClickListener()
          {
              @Override
              public void onClick(View view)
              {
                  MediaPlayer mediaPlayer = new MediaPlayer();

                  try{
                      mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                      mediaPlayer.setDataSource( phonetics.get(position).getAudio());
                      mediaPlayer.prepare();
                      mediaPlayer.start();
                  }
                  catch (IOException e)
                  {
                      e.printStackTrace();
                      Toast.makeText(context, "Couldn't play audio", Toast.LENGTH_SHORT).show();
                  }
              }
          });
    }

    @Override
    public int getItemCount()
    {
        return phonetics.size();
    }
}
