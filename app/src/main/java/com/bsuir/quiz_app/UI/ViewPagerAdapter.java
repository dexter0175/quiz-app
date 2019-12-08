package com.bsuir.quiz_app.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.bsuir.quiz_app.Model.Question;
import com.bsuir.quiz_app.UI.Fragments.QuestionFragment;

import java.util.ArrayList;


public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final ArrayList<Question> questions;

    public ViewPagerAdapter(FragmentManager fm, ArrayList<Question> questions){
        super (fm);
        this.questions = questions;

    }

    @Override
    public Fragment getItem(int position) {
        QuestionFragment questionFragment = new QuestionFragment();
        Bundle bundle = new Bundle();
        Question question = questions.get(position);
        bundle.putParcelable("question",question);
        questionFragment.setArguments(bundle);
        return questionFragment;
    }

    @Override
    public int getCount() {
        return questions.size();
    }
}
