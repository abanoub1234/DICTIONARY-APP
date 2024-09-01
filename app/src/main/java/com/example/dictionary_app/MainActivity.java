package com.example.dictionary_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dictionary_app.Adapters.MeaningsAdapter;
import com.example.dictionary_app.Adapters.PhoneticsAdapter;
import com.example.dictionary_app.Models.APIResponse;

public class MainActivity extends AppCompatActivity
{

    SearchView search_view;
    TextView txt_word;
    RecyclerView recycler_phonetics , recycler_Meanings;
    ProgressDialog dialog;
    PhoneticsAdapter phoneticsAdapter;
    MeaningsAdapter meaningsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_view = findViewById(R.id.search_view);
        txt_word = findViewById(R.id.txt_word);
        recycler_phonetics = findViewById(R.id.recycler_phonetics);
        recycler_Meanings = findViewById(R.id.recycler_Meanings);
        dialog = new ProgressDialog(this);


        dialog.setTitle("Loading...");
        dialog.show();
        RequestManager manager = new RequestManager(MainActivity.this);
        manager.getWordMeaning(listener , "hello");



        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String query)
            {
                dialog.setTitle("Fetching response for " + query);
                dialog.show();

                RequestManager manager = new RequestManager(MainActivity.this);
                manager.getWordMeaning(listener , query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                return false;
            }
        });

    }


    private final OnFetchDataListener listener= new OnFetchDataListener()
    {
        @Override
        public void OnFetchData(APIResponse apiResponse, String message)
        {
            dialog.dismiss();

            if(apiResponse == null)
            {
                Toast.makeText(MainActivity.this, "No data found!!", Toast.LENGTH_SHORT).show();
            }
            showData(apiResponse);
        }

        @Override
        public void OnError(String message)
        {
           dialog.dismiss();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showData(APIResponse apiResponse)
    {
        txt_word.setText("Word: " + apiResponse.getWord());


        recycler_phonetics.setHasFixedSize(true);
        recycler_phonetics.setLayoutManager(new GridLayoutManager(this,1));
        phoneticsAdapter = new PhoneticsAdapter(this, apiResponse.getPhonetics());
        recycler_phonetics.setAdapter(phoneticsAdapter);

        recycler_Meanings.setHasFixedSize(true);
        recycler_Meanings.setLayoutManager(new GridLayoutManager(this , 1));
        meaningsAdapter = new MeaningsAdapter(this , apiResponse.getMeanings());
        recycler_Meanings.setAdapter(meaningsAdapter);
    }


}