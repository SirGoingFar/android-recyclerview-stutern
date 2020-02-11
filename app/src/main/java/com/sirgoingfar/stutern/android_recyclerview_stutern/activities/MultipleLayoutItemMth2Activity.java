package com.sirgoingfar.stutern.android_recyclerview_stutern.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.sirgoingfar.stutern.android_recyclerview_stutern.R;
import com.sirgoingfar.stutern.android_recyclerview_stutern.adapters.StatusAdapterV2;
import com.sirgoingfar.stutern.android_recyclerview_stutern.models.Status;
import com.sirgoingfar.stutern.android_recyclerview_stutern.utils.DataFactory;

import java.util.List;

public class MultipleLayoutItemMth2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_layout_item_mth2);

        setupViews();
    }

    private void setupViews() {
        //Set up User Status
        Status userStatus = DataFactory.getUserStatusList().get(0);

        //Recent Updates
        List<Status> recentUpdates = DataFactory.getRecentStatusList();
        StatusAdapterV2 recentUpdateAdapter = new StatusAdapterV2(recentUpdates);
        RecyclerView recentRv = findViewById(R.id.rv_recent);
        recentRv.setAdapter(recentUpdateAdapter);


        //Viewed Updates
        List<Status> viewedUpdates = DataFactory.getViewedStatusList();
        StatusAdapterV2 viewedUpdateAdapter = new StatusAdapterV2(viewedUpdates);
        RecyclerView viewedRv = findViewById(R.id.rv_viewed);
        viewedRv.setAdapter(viewedUpdateAdapter);

        //Muted Updates
        List<Status> mutedUpdates = DataFactory.getMutedStatusList();
        StatusAdapterV2 mutedUpdateAdapter = new StatusAdapterV2(mutedUpdates);
        RecyclerView mutedRv = findViewById(R.id.rv_muted);
        mutedRv.setAdapter(mutedUpdateAdapter);
    }
}
