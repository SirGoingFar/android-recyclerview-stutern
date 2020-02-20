package com.sirgoingfar.stutern.android_recyclerview_stutern.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
        List<Status> userStatuses = DataFactory.getUserStatusList();

        //Recent Updates
        View header1 = findViewById(R.id.divider_1);
        ((TextView) header1.findViewById(R.id.tv_header_label)).setText(getString(R.string.text_recent_updates));
        List<Status> recentUpdates = DataFactory.getRecentStatusList();
        StatusAdapterV2 recentUpdateAdapter = new StatusAdapterV2(recentUpdates);
        RecyclerView recentRv = findViewById(R.id.rv_recent);
        recentRv.setAdapter(recentUpdateAdapter);


        //Viewed Updates
        View header2 = findViewById(R.id.divider_2);
        ((TextView) header2.findViewById(R.id.tv_header_label)).setText(getString(R.string.text_viewed_updates));
        List<Status> viewedUpdates = DataFactory.getViewedStatusList();
        StatusAdapterV2 viewedUpdateAdapter = new StatusAdapterV2(viewedUpdates);
        RecyclerView viewedRv = findViewById(R.id.rv_viewed);
        viewedRv.setAdapter(viewedUpdateAdapter);

        //Muted Updates
        View header3 = findViewById(R.id.divider_3);
        ((TextView) header3.findViewById(R.id.tv_header_label)).setText(getString(R.string.text_muted_updates));
        header3.findViewById(R.id.iv_collapse).setVisibility(View.VISIBLE);
        List<Status> mutedUpdates = DataFactory.getMutedStatusList();
        StatusAdapterV2 mutedUpdateAdapter = new StatusAdapterV2(mutedUpdates);
        RecyclerView mutedRv = findViewById(R.id.rv_muted);
        mutedRv.setAdapter(mutedUpdateAdapter);
    }
}
