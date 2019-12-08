package com.bsuir.quiz_app.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bsuir.quiz_app.Model.Leader;
import com.bsuir.quiz_app.R;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.ViewHolder> {
    Leader[] leaders = {};
    @NonNull
    @Override
    public LeaderboardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardAdapter.ViewHolder vh, int position) {
        Leader leader = leaders[position];
        //TODO not user id but name thus change in api and in class
        vh.username.setText(leader.getUserId());
        vh.place.setText(Integer.toString(position+1) );
        vh.score.setText(Integer.toString(leader.getTotalScore()) );
    }

    public void setItems(Leader[] leaders){
        this.leaders= leaders;
    }

    public void clearItems(){
        this.leaders = new Leader[]{};
    }

    @Override
    public int getItemCount() {
        return  leaders.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView username;
        private final TextView place;
        private final TextView score;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           username =  itemView.findViewById(R.id.username);
           place  = itemView.findViewById(R.id.place);
           score =  itemView.findViewById(R.id.score);

        }
    }
}
