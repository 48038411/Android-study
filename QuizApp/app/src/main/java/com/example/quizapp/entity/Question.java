package com.example.quizapp.entity;

public class Question {
    private Integer mTextResId;
    private Boolean mAnswerTrue;

    public Question(Integer mTextResId, Boolean mAnswerTrue) {
        this.mTextResId = mTextResId;
        this.mAnswerTrue = mAnswerTrue;
    }

    public Integer getmTextResId() {
        return mTextResId;
    }

    public void setmTextResId(Integer mTextResId) {
        this.mTextResId = mTextResId;
    }

    public Boolean getmAnswerTrue() {
        return mAnswerTrue;
    }

    public void setmAnswerTrue(Boolean mAnswerTrue) {
        this.mAnswerTrue = mAnswerTrue;
    }
}
