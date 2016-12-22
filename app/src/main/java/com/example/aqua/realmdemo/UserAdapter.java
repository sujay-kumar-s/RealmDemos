package com.example.aqua.realmdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.RealmResults;


/**
 * Created by aqua on 12/21/2016.
 */

public class UserAdapter extends RecyclerView.Adapter {
    Context ctx;
    RealmResults results;
    UserAdapter(Context ctx, RealmResults results)
    {
        this.ctx=ctx;
        this.results=results;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(ctx).inflate(R.layout.row, null, false);
        RowHolder rowHolder = new RowHolder(v);


        return rowHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RowHolder rowHolder=(RowHolder)holder;
       // String poster_url=results.get(position).getPoster();
      //  Picasso.with(ctx).load(poster_url).resize(300,300).into(rowHolder.posteriv);
        User user=(User)results.get(position);
        rowHolder.usernametv.setText(user.getName());
        //rowHolder.yeartv.setText(list1.get(position).getYear());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }




    class RowHolder extends RecyclerView.ViewHolder {
        ImageView posteriv;
        TextView usernametv;
       // TextView yeartv;

        public RowHolder(View itemView) {
            super(itemView);
            posteriv = (ImageView) itemView.findViewById(R.id.posteriv);
            usernametv = (TextView) itemView.findViewById(R.id.usernametv);
           // yeartv = (TextView) itemView.findViewById(R.id.yeartv);

        }
    }
}
