package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapp.entity.Question;

//AppCompatActivity为安卓旧版本系统提供兼容支持
public class QuizActivity extends AppCompatActivity {
    // 变量名称应有m前缀，命名约定
    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPrevButton;
    private TextView mQuestionTextView;
    private static final String TAG = "QuizActivity";
    /**
     * 定义数组
     */
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_oceans,true),
            new Question(R.string.question_mideast,false),
            new Question(R.string.question_africa,false),
            new Question(R.string.question_americas,true),
            new Question(R.string.question_asia,true)
    };
    private Integer mCurrentIndex = 0;
    // 更新问题的方法，更新下标
    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getmTextResId();
        mQuestionTextView.setText(question);
    }
    // 检查问题回答是否正确
    private void checkAnswer(boolean answer){
        // 拿到当前展示的问题的答案
        boolean answerTrue = mQuestionBank[mCurrentIndex].getmAnswerTrue();
        // 定义提示框文字id
        int messageId = 0;
        if (answer == answerTrue) {
            messageId = R.string.correct_toast;
        }else {
            messageId = R.string.incorrect_toast;
        }
        // 这里可以用this，因为不是匿名内部类
        Toast.makeText(this,messageId,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate(Bundle called)");
        setContentView(R.layout.activity_quiz);
        // 拿到TextView这个组件
        mQuestionTextView = findViewById(R.id.question_text_view);
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
        // 取值，数组下标取值
        int question = mQuestionBank[mCurrentIndex].getmTextResId();
        mQuestionTextView.setText(question);
        // 取出上一页这个按钮
        mPrevButton = findViewById(R.id.preview_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mCurrentIndex){
                    case 0:
                        Toast.makeText(QuizActivity.this,R.string.warning,Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        mCurrentIndex = 0;
                        break;
                    default:
                        mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                }
                updateQuestion();
            }
        });
        // 拿到mNextButton
        mNextButton = findViewById(R.id.next_button);
        // 设置监听器
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 这样计算得到当前位置  可以限制当数组下标加到数组的长度时直接回到第1位(下标0)
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
        mTrueButton = findViewById(R.id.true_button);
        // 设置mTrueButton的单击监听器
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 第一个参数，显示提示的窗口的实例，第二个参数显示的内容，第三个参数显示的时间。
                // 第一个参数，不能直接输入this，因为是匿名内部类，this指的是这个监听器
                // 弹出提示框
//                Toast.makeText(QuizActivity.this,R.string.correct_text,Toast.LENGTH_SHORT).show();
                checkAnswer(true);
            }
        });
        mFalseButton = findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//               Toast.makeText(QuizActivity.this,R.string.incorrect_text,Toast.LENGTH_SHORT).show();
                checkAnswer(false);
            }
        });
        updateQuestion();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart(Bundle) called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop(Bundle) called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy(Bundle) called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume(Bundle) called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause(Bundle) called");
    }
}