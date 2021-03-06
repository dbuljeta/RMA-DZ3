package com.example.daniel.dz3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {
    ListView lvTaskList;
    TaskAdapter TaskAdapter;
    Button bDodajZadatak;
    public static final String KEY_NASLOV = "KeyTittle";
    public static final String KEY_OPIS = "KeyDescription";
    public static final String KEY_PRIORITET = "KeyPriority";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        setUpUI();

    }

    private void setUpUI() {
        bDodajZadatak = (Button) findViewById(R.id.bDodajZadatak);
        this.lvTaskList = (ListView) this.findViewById(R.id.lvTaskList);
        this.TaskAdapter = new TaskAdapter(this.loadTasks());
        this.lvTaskList.setAdapter(this.TaskAdapter);
        this.lvTaskList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Task task = (Task) lvTaskList.getItemAtPosition(position);
                TaskAdapter.brisiZadatak(position);
                TaskDBHelper.getInstance(getApplicationContext()).Delete(task);
                return false;
            }
        });
        bDodajZadatak.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), SecondActivity.class);
        this.startActivity(intent);
        this.finish();

    }

    private ArrayList<Task> loadTasks() {
        return TaskDBHelper.getInstance(this).getAllTasks();
    }
}
