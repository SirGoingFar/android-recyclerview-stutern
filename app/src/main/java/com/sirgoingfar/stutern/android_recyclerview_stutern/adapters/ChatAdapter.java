package com.sirgoingfar.stutern.android_recyclerview_stutern.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sirgoingfar.stutern.android_recyclerview_stutern.R;
import com.sirgoingfar.stutern.android_recyclerview_stutern.interfaces.OnChatItemClickListener;
import com.sirgoingfar.stutern.android_recyclerview_stutern.models.Chat;
import com.sirgoingfar.stutern.android_recyclerview_stutern.viewholders.ChatViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatViewHolder> {

    private final OnChatItemClickListener clickListener;

    private List<Chat> chatList;

    public ChatAdapter(OnChatItemClickListener listener) {
        this(listener, new ArrayList<Chat>());
    }

    public ChatAdapter(OnChatItemClickListener listener, List<Chat> chatList) {
        this.clickListener = listener;
        this.chatList = chatList;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_chat_item, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ChatViewHolder holder, int position) {

        final int currentPosition = holder.getAdapterPosition();
        final Chat currentItem = chatList.get(currentPosition);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClick(currentPosition, currentItem);
            }
        });

        holder.bindData(currentItem);
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public void refreshChatList(@NonNull List<Chat> newChatList) {
        if (newChatList.isEmpty())
            return;

        //Add the new set of Chats
        chatList = newChatList;

        //Bring the attention of the Adapter to the items newly added
        // so as to add the new items as child views on the RecyclerView
        notifyDataSetChanged();
    }

    @Override
    public void onViewRecycled(@NonNull ChatViewHolder holder) {
        super.onViewRecycled(holder);
        holder.setAnimation(holder.itemView);
    }

    public void addMoreChat(@NonNull List<Chat> newChatList) {
        if (newChatList.isEmpty())
            return;

        //get the current size of the Chat List
        int initialChatListSize = chatList.size();

        //Add the new set of Chats
        chatList.addAll(new ArrayList<>(newChatList));

        //get the last resulting Chat List index
        int newLastIndex = chatList.size() - 1;

        //Bring the attention of the Adapter to the items newly added
        // so as to add the new items as child views on the RecyclerView
        notifyItemRangeInserted(initialChatListSize, newLastIndex);
    }

    public void insertNewChatAt(int position, @NonNull Chat chat) {

        if (position < 0 || position > chatList.size()) {
            Log.e(getClass().getSimpleName(), chat.toString().concat((" cannot be added to the Chat " +
                    "List because ").concat(String.valueOf(position)).concat(" will make the List " +
                    "item sparse.")));
            return;
        }

        //Add the Chat object to the specified position
        chatList.add(position, chat);

        //Bring the attention of the Adapter to the Chat item added so the object
        // can be added to the RecyclerView as a child view
        notifyItemInserted(position);
    }

    public void removeChatAt(int position) {
        if (position < 0 || (position > chatList.size() - 1)) {
            Log.e(getClass().getSimpleName(), "Chat at position ".concat(String.valueOf(position))
                    .concat(" does not exist."));

            return;
        }

        //Remove the Chat at the specified position
        chatList.remove(position);

        //Bring the attention of the Adapter to the fact that a Chat item has been
        // removed and the corresponding View has to removed accordingly on the RecyclerView
        notifyItemRemoved(position);
    }

    public void moveChatTo(int fromPosition, int toPosition) {

        if (fromPosition < 0 || (fromPosition > chatList.size() - 1)) {
            Log.e(getClass().getSimpleName(), "Chat at position ".concat(String.valueOf(fromPosition))
                    .concat(" does not exist."));

            return;
        }

        //Retrieve the chat object to move
        Chat chatToMove = chatList.get(fromPosition);

        //remove the Chat from the specified position
        removeChatAt(fromPosition);

        //move the Chat to the top position
        insertNewChatAt(toPosition, chatToMove);
    }

    public void markChatAsRead(int position) {

        if (position < 0 || (position > chatList.size() - 1)) {
            Log.e(getClass().getSimpleName(), "Chat at position ".concat(String.valueOf(position))
                    .concat(" does not exist."));

            return;
        }

        //Get the Chat object from the ChatList
        Chat theChat = chatList.get(position);

        //Remove the same chat from the Chat List
        chatList.remove(position);

        //Mark the Chat as READ
        theChat.markAsRead();

        //Update the Chat List with the updated Chat object
        chatList.add(position, theChat);

        //Bring the attention of the Adapter to the fact that a Chat item has been
        // updated and the corresponding View has to change accordingly
        notifyItemChanged(position);
    }

    public Chat getChatAt(int position) {
        if (position < 0 || position > (chatList.size() - 1))
            return null;

        return chatList.get(position);
    }

}
