package com.example.gad.demo.model;

import android.util.LayoutDirection;

import com.example.gad.demo.R;

public class ChatMessage
{
    private String mMessage;
    private MessageSource mSource;
    private int mAvatar;
    private String mBackgroundColor;
    private int mDirection;

    public ChatMessage(MessageSource source, String message) {
        mMessage            = message;
        mSource             = source;
        mAvatar             = (mSource == MessageSource.PERSON_A) ? R.drawable.ic_person_a : R.drawable.ic_person_b;
        mBackgroundColor    = (mSource == MessageSource.PERSON_A) ? "#AADDFF" : "#EEEEEE";
        mDirection          = (mSource == MessageSource.PERSON_A) ? LayoutDirection.LTR : LayoutDirection.RTL;
    }

    public String           getMessage()            { return mMessage; }
    public MessageSource    getSource()             { return mSource;  }
    public int              getAvatar()             { return mAvatar;  }
    public String           getBackgroundColor()    { return mBackgroundColor;  }
    public int              getDirection()          { return mDirection;  }
}
