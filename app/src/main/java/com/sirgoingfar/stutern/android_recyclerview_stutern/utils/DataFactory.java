package com.sirgoingfar.stutern.android_recyclerview_stutern.utils;

import com.sirgoingfar.stutern.android_recyclerview_stutern.models.Chat;
import com.sirgoingfar.stutern.android_recyclerview_stutern.models.MessageType;
import com.sirgoingfar.stutern.android_recyclerview_stutern.models.Status;
import com.sirgoingfar.stutern.android_recyclerview_stutern.models.StatusContent;

import java.util.ArrayList;
import java.util.List;

public class DataFactory {

    public static List<Chat> getChatListData() {

        ArrayList<Chat> chatArrayList = new ArrayList<>();

        chatArrayList.add(
                new Chat(
                        "Ope Olatoye",
                        "https://media-exp1.licdn.com/dms/image/C4D03AQHRaP9kuyx_Ng/profile-displayphoto-shrink_800_800/0?e=1586995200&v=beta&t=PglTyWCrTJTSBjQoF16cr7ngXLrIUbYDgmGv_b2D1Cs",
                        "Ope Olatoye: Hi Akintunde! Hope you're ready for us today.",
                        2,
                        "12:45 PM",
                        MessageType.TEXT,
                        false,
                        false
                )
        );

        chatArrayList.add(
                new Chat(
                        "Whitmans Chat",
                        "https://unsplash.com/photos/TXRiNssV1Jc/download?force=true",
                        "Jessica: Yeah... I think it's a good idea Bright.",
                        4,
                        "12:03 PM",
                        MessageType.TEXT,
                        false,
                        true
                )
        );

        chatArrayList.add(
                new Chat(
                        "Princess",
                        null,
                        "Image",
                        4,
                        "11:03 AM",
                        MessageType.IMAGE,
                        false,
                        false
                )
        );

        chatArrayList.add(
                new Chat(
                        "Stutern SGA 0.7 (Android)",
                        null,
                        "Frank: Fam! The lecture on RecyclerView has started.",
                        4,
                        "3:02 AM",
                        MessageType.TEXT,
                        false,
                        true
                )
        );

        chatArrayList.add(
                new Chat(
                        "+2349078343423",
                        null,
                        "00:34",
                        3,
                        "12:35 AM",
                        MessageType.VIDEO,
                        true,
                        false
                )
        );

        chatArrayList.add(
                new Chat(
                        "Udacity Scholarship Page",
                        null,
                        "Image",
                        9,
                        "12:30 AM",
                        MessageType.IMAGE,
                        true,
                        true
                )
        );

        chatArrayList.add(
                new Chat(
                        "Auwal MS",
                        null,
                        "Cavdy needs to take us on a React tutorial today.",
                        3,
                        "12:20 AM",
                        MessageType.TEXT,
                        true,
                        false
                )
        );

        chatArrayList.add(
                new Chat(
                        "Stewart Family",
                        null,
                        "You: Great! Thanks.",
                        2,
                        "11:39 AM",
                        MessageType.TEXT,
                        false,
                        true
                )
        );

        chatArrayList.add(
                new Chat(
                        "Alice Whitman",
                        null,
                        "Image",
                        0,
                        "YESTERDAY",
                        MessageType.IMAGE,
                        true,
                        false
                )
        );

        chatArrayList.add(
                new Chat(
                        "Jack Whitman",
                        null,
                        "0:07",
                        0,
                        "YESTERDAY",
                        MessageType.AUDIO,
                        true,
                        false
                )
        );

        chatArrayList.add(
                new Chat(
                        "Lunch Party",
                        null,
                        "You: Sounds good!",
                        0,
                        "FRIDAY",
                        MessageType.TEXT,
                        true,
                        true
                )
        );

        chatArrayList.add(
                new Chat(
                        "Judith",
                        null,
                        "23:45",
                        0,
                        "THURSDAY",
                        MessageType.VIDEO,
                        true,
                        false
                )
        );

        chatArrayList.add(
                new Chat(
                        "Gbenga",
                        null,
                        "3:05",
                        3,
                        "WEDNESDAY",
                        MessageType.VIDEO,
                        true,
                        false
                )
        );

        return chatArrayList;
    }

    public static Chat getNewChat() {
        return new Chat(
                "Just Added",
                "null",
                "You: I just added this child view now",
                2,
                "12:00 PM",
                MessageType.TEXT,
                false,
                false
        );
    }

    public static List<Status> getUserStatusList() {
        List<Status> userStatusList = new ArrayList<>();

        userStatusList.add(new Status(
                "My status",
                "Yesterday, 7:45 PM",
                false, true,
                new ArrayList<StatusContent>()
        ));

        return userStatusList;
    }

    public static List<Status> getRecentStatusList() {
        List<Status> recentStatusList = new ArrayList<>();

        recentStatusList.add(new Status(
                "Dark Lord",
                "Just now",
                false, true,
                new ArrayList<StatusContent>()
        ));

        recentStatusList.add(new Status(
                "Auwal MS",
                "Just now",
                false, true,
                new ArrayList<StatusContent>()
        ));

        recentStatusList.add(new Status(
                "Mesh",
                "5 minutes ago",
                false, true,
                new ArrayList<StatusContent>()
        ));

        recentStatusList.add(new Status(
                "Khalid",
                "10 minutes ago",
                false, true,
                new ArrayList<StatusContent>()
        ));

        recentStatusList.add(new Status(
                "C. Ronaldo",
                "Today, 7:45 PM",
                false, true,
                new ArrayList<StatusContent>()
        ));

        recentStatusList.add(new Status(
                "Lionel Messi",
                "Today, 7:40 PM",
                false, true,
                new ArrayList<StatusContent>()
        ));

        return recentStatusList;
    }

    public static List<Status> getViewedStatusList() {
        List<Status> viewedStatusList = new ArrayList<>();

        viewedStatusList.add(new Status(
                "NezSpencer",
                "Today, 6:40 AM",
                false, true,
                new ArrayList<StatusContent>()
        ));

        viewedStatusList.add(new Status(
                "Andre",
                "Today, 6:50 AM",
                false, true,
                new ArrayList<StatusContent>()
        ));

        viewedStatusList.add(new Status(
                "SirGoingFar",
                "Yesterday, 3:41 AM",
                false, true,
                new ArrayList<StatusContent>()
        ));

        return viewedStatusList;
    }

    public static List<Status> getMutedStatusList() {
        List<Status> mutedStatusList = new ArrayList<>();

        mutedStatusList.add(new Status(
                "Nifemi",
                "Today, 6:40 AM",
                false, true,
                new ArrayList<StatusContent>()
        ));

        mutedStatusList.add(new Status(
                "Deola",
                "Yesterday, 6:15 AM",
                false, true,
                new ArrayList<StatusContent>()
        ));

        return mutedStatusList;
    }
}
