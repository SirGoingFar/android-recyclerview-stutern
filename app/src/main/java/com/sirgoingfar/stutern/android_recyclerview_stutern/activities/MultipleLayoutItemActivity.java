package com.sirgoingfar.stutern.android_recyclerview_stutern.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sirgoingfar.stutern.android_recyclerview_stutern.R;
import com.sirgoingfar.stutern.android_recyclerview_stutern.adapters.StatusAdapter;
import com.sirgoingfar.stutern.android_recyclerview_stutern.models.StatusData;

public class MultipleLayoutItemActivity extends AppCompatActivity {

    private StatusAdapter statusAdapter = new StatusAdapter(new StatusData());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_layout_item);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView statusRecyclerView = findViewById(R.id.rv_status);
        statusRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        statusRecyclerView.setHasFixedSize(false);
        statusRecyclerView.setAdapter(statusAdapter);
    }

}
