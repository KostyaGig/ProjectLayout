package com.kostya_ubutnu.citylayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kostya_ubutnu.citylayout.models.Model;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Model> list;

    public Adapter(List<Model> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView text,data,time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.main_tv);
            data = itemView.findViewById(R.id.data_tv);
            time = itemView.findViewById(R.id.time_tv);
        }

        void bind(Model currentModel){
            image.setImageResource(currentModel.getImage());
            text.setText(currentModel.getText());
            time.setText(currentModel.getTime());
            data.setText(currentModel.getData());
        }
    }


}
