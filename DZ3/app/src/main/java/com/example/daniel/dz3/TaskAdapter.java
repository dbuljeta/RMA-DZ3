package com.example.daniel.dz3;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by daniel on 10.4.2017..
 */

class TaskAdapter extends BaseAdapter {
    private ArrayList<Task> Tasks;

    public TaskAdapter(ArrayList<Task> tasks) {
        Tasks = tasks;
    }

    @Override
    public int getCount() {
        return Tasks.size();
    }

    @Override
    public Object getItem(int position) {
        return Tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder taskViewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item_zadatak, parent, false);
            taskViewHolder = new ViewHolder(convertView);
            convertView.setTag(taskViewHolder);
        } else {
            taskViewHolder = (ViewHolder) convertView.getTag();
        }
        Task task = this.Tasks.get(position);
        taskViewHolder.tvNaslovZadatka.setText(task.getNaslov());
        taskViewHolder.tvTekstZadatka.setText(task.getOpisZadatka());
        if (task.getPrioritet().equals("High"))
            taskViewHolder.ivPrioritet.setBackgroundColor(Color.RED);
        if (task.getPrioritet().equals("Medium"))
            taskViewHolder.ivPrioritet.setBackgroundColor(Color.YELLOW);
        if (task.getPrioritet().equals("Low"))
            taskViewHolder.ivPrioritet.setBackgroundColor(Color.GREEN);

        return convertView;
    }


    public void brisiZadatak(int position) {
        this.Tasks.remove(position);
        this.notifyDataSetChanged();
    }

    public static class ViewHolder {
        public TextView tvNaslovZadatka, tvTekstZadatka;
        public ImageView ivPrioritet;

        public ViewHolder(View taskView) {
            tvNaslovZadatka = (TextView) taskView.findViewById(R.id.tvNaslov);
            tvTekstZadatka = (TextView) taskView.findViewById(R.id.tvTekstZadatka);
            ivPrioritet = (ImageView) taskView.findViewById(R.id.ivPrioritet);
        }
    }
}

