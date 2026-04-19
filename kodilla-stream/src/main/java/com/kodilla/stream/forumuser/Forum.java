package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> theForumUserList = new ArrayList<>();

    public Forum() {

        theForumUserList.add(new ForumUser(1, "username1", 'M',
                LocalDate.of(2001,1,8), 0));
        theForumUserList.add(new ForumUser(2, "username2", 'M',
                LocalDate.of(2002,2,9), 11));
        theForumUserList.add(new ForumUser(3, "username3", 'F',
                LocalDate.of(2003,3,10), 12));
        theForumUserList.add(new ForumUser(4, "username4", 'F',
                LocalDate.of(2004,4,11), 13));
        theForumUserList.add(new ForumUser(5, "username5", 'M',
                LocalDate.of(2011,5,12), 14));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(theForumUserList);
    }
}
