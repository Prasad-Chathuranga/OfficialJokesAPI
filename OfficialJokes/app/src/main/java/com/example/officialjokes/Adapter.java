package com.example.officialjokes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;
    List<Joke> jokeList;

    public Adapter(Context context, List<Joke> jokes)
    {
        this.inflater = LayoutInflater.from(context);
        this.jokeList = jokes;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.cardview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {


        holder.joke_id.setText(jokeList.get(position).getId());
        holder.joke_setup.setText(jokeList.get(position).getSetup());
        holder.joke_punchline.setText(jokeList.get(position).getPunchline());
        holder.joke_type.setText(jokeList.get(position).getType());
    }

    @Override
    public int getItemCount() {
        return jokeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView joke_id,joke_setup,joke_punchline,joke_type;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            joke_id = itemView.findViewById(R.id.id);
            joke_punchline = itemView.findViewById(R.id.punchline);
            joke_setup = itemView.findViewById(R.id.setup);
            joke_type = itemView.findViewById(R.id.type);

        }
    }
}
