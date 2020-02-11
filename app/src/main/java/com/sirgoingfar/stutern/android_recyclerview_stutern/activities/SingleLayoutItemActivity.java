package com.sirgoingfar.stutern.android_recyclerview_stutern.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.sirgoingfar.stutern.android_recyclerview_stutern.R;
import com.sirgoingfar.stutern.android_recyclerview_stutern.adapters.ChatAdapter;
import com.sirgoingfar.stutern.android_recyclerview_stutern.interfaces.OnChatItemClickListener;
import com.sirgoingfar.stutern.android_recyclerview_stutern.models.Chat;
import com.sirgoingfar.stutern.android_recyclerview_stutern.utils.DataFactory;

public class SingleLayoutItemActivity extends AppCompatActivity implements OnChatItemClickListener {

    private ChatAdapter chatAdapter = new ChatAdapter(this);
    private RecyclerView chatRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_layout_item);
        setupRecyclerView();
        setupFabs();
    }

    private void setupRecyclerView() {
        chatRecyclerView = findViewById(R.id.rv_chat);
        chatRecyclerView.setHasFixedSize(true);
        /*chatRecyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        );*/
        chatRecyclerView.setAdapter(chatAdapter);
        chatAdapter.refreshChatList(DataFactory.getChatListData());

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(final RecyclerView.ViewHolder viewHolder, int direction) {

                int chatPosition = viewHolder.getAdapterPosition();

                //Here is the Chat object bound to the swiped child view
                Chat chat = chatAdapter.getChatAt(chatPosition);

                //Perform your action - Here, I'm showing the Toast of the Contact Name
                String toastMsg = chat.getContactName().concat(chat.isGroup() ? " group" : "").concat(" has been removed");
                toastMsg(toastMsg);

                //Notify the Adapter that a view has been removed
                chatAdapter.removeChatAt(chatPosition);
            }
        }).attachToRecyclerView(chatRecyclerView);
    }

    private void setupFabs() {

        final int position = 2;

        //FAB: Add
        findViewById(R.id.fab_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Insert a new chat
                chatAdapter.insertNewChatAt(position, DataFactory.getNewChat());

                //Scroll the RecyclerView to the Position
                chatRecyclerView.scrollToPosition(position);
            }
        });


        //FAB: Remove
        findViewById(R.id.fab_remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Remove the child at position
                chatAdapter.removeChatAt(position);
            }
        });

        //FAB: Move up
        findViewById(R.id.fab_move_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Move Chat to Top
                chatAdapter.moveChatTo(position, 0);
                chatRecyclerView.scrollToPosition(0);
            }
        });

        //FAB: Move down
        findViewById(R.id.fab_move_down).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatAdapter.moveChatTo(0, 1);
                chatRecyclerView.scrollToPosition(1);
            }
        });
    }

    @Override
    public void onClick(int position, Chat chat) {
        toastMsg("Item #".concat(String.valueOf(position)).concat(" with name \"").concat(chat.getContactName()).concat("\" was clicked"));

        //Mark Chat as READ
        chatAdapter.markChatAsRead(position);
    }

    private void toastMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

}
