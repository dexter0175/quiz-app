package com.bsuir.quiz_app.UI.Fragments;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bsuir.quiz_app.GameActivity;
import com.bsuir.quiz_app.Model.Question;
import com.bsuir.quiz_app.R;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class QuestionFragment extends Fragment implements View.OnClickListener {
    private TextView tvQuestion;
    private ViewGroup answer_btns;

    public  QuestionFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setRetainInstance(true);
        View view = inflater.inflate(R.layout.fragment_question,container, false);
        tvQuestion = view.findViewById(R.id.tvQuestion);

        final Question question = getArguments().getParcelable("question");

        tvQuestion.setText(Html.fromHtml(question.getQuestion()).toString());
        LinearLayout cardView = view.findViewById(R.id.question_container);

        if(question.getType().equals("boolean")) {
            cardView.addView(inflater.inflate(R.layout.fragment_question_boolean, cardView, false));
            Button btn_1 = view.findViewById(R.id.btn_answer_true);
            Button btn_2 = view.findViewById(R.id.btn_answer_false);
            this.answer_btns = view.findViewById(R.id.answers);
            if((new Random()).nextBoolean() ){
                btn_1.setText(question.getCorrect_answer());
                btn_1.setTag("correct");
                btn_2.setText(question.getIncorrect_answers()[0]);
            } else
            {
                btn_2.setText(question.getCorrect_answer());
                btn_2.setTag("correct");
                btn_1.setText(question.getIncorrect_answers()[0]);
            }
            btn_1.setOnClickListener(this);
            btn_2.setOnClickListener(this);
        } else {
            cardView.addView(inflater.inflate(R.layout.fragment_question_multiple, cardView, false));
            this.answer_btns = view.findViewById(R.id.answers);
            int random =  (new Random()).nextInt(4);
            LinkedList<String> incorrects = new LinkedList<>(Arrays.asList(question.getIncorrect_answers()));


            for (int i = 0; i < answer_btns.getChildCount(); i++) {

                View child = answer_btns.getChildAt(i);
                if(child instanceof Button)
                {
                    Button button = (Button) child;
                    if(i == random){
                        button.setText(question.getCorrect_answer());
                        button.setTag("correct");

                    } else {
                        button.setText(incorrects.pop());
                    }

                    button.setOnClickListener(this);

                }

            }
        }

        return view;
    }


    @Override
    public void onClick(View v) {


        for (int i = 0; i < answer_btns.getChildCount(); i++) {
            View child =  answer_btns.getChildAt(i);
            if(child instanceof Button)
            {
                Button btn = (Button) child;
                btn.setEnabled(false);
                if(btn.getId()!= v.getId()) {
                    btn.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    btn.setTextColor(getResources().getColor(R.color.colorText));
                }

            }

        }

        ((GameActivity)getActivity() ).onAnswer(v);

            }

}
