package com.example.self;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.self.UsersClasses.DiaryHelper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.MyViewHolder> {
 Context context;
    ArrayList<DiaryHelper>notesList;
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    public DiaryAdapter(Context context, ArrayList<DiaryHelper> notesList) {
        this.context = context;
        this.notesList = notesList;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
  DiaryHelper diaryHelper=notesList.get(position);
  holder.output.setText(diaryHelper.getNote());
  holder.timeOutput.setText(diaryHelper.getDate());
  holder.options.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          PopupMenu popupMenu=new PopupMenu(context,holder.options);
          popupMenu.inflate(R.menu.option_menu);
          popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
              @Override
              public boolean onMenuItemClick(MenuItem item) {
                  switch (item.getItemId()){
                      case R.id.option_edit:
                          Intent intent=new Intent(context,editNote.class);
                         intent.putExtra("EDIT", diaryHelper.getKey());
                         context.startActivity(intent);
                          break;
                      case R.id.option_delete:
                          FirebaseDatabase.getInstance().getReference("Diary").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(diaryHelper.getKey()).removeValue()
                                  .addOnCompleteListener(new OnCompleteListener<Void>() {
                              @Override
                              public void onComplete(@NonNull Task<Void> task) {
                                  if(task.isSuccessful()){
                                      Toast.makeText(context, "Thought deleted Successfully", Toast.LENGTH_SHORT).show();
                                    notifyItemRemoved(position);
                                   context.startActivity(new Intent(context,AnonymousCorner.class));

                                  }
                                  else
                                      Toast.makeText(context, "Some Error occoured", Toast.LENGTH_SHORT).show();
                              }
                          });
                          break;
                  }
                  return true;
              }
          });
          popupMenu.show();
      }
  });

    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView output,timeOutput,options;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            output=itemView.findViewById(R.id.output);
            timeOutput=itemView.findViewById(R.id.timeoutput);
            options=itemView.findViewById(R.id.options);
        }
    }
}
