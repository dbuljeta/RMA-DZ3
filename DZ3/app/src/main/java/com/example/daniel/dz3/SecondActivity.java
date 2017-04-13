package com.example.daniel.dz3;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SecondActivity extends Activity implements View.OnClickListener {
Spinner spPrioritet;
    EditText etTaskTitle,etTaskDescritpion;
    Button bAddTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setUpUI();
    }

    private void setUpUI() {
        spPrioritet= (Spinner) findViewById(R.id.spinner1);
        etTaskTitle= (EditText) findViewById(R.id.etTaskTitle);
        etTaskDescritpion= (EditText) findViewById(R.id.etTaskDescription);
        bAddTask= (Button) findViewById(R.id.bAddTask);
        bAddTask.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String NewTaskTitle,NewTaskDescription,NewTaskPrioritet;

        NewTaskTitle=etTaskTitle.getText().toString();
        NewTaskDescription=etTaskDescritpion.getText().toString();
        NewTaskPrioritet=spPrioritet.getSelectedItem().toString();
        if (NewTaskTitle.isEmpty() || NewTaskDescription.isEmpty()){
            Toast.makeText(getApplicationContext(), "Unesi podatke", Toast.LENGTH_SHORT).show();
        }
        else{
            Task task=new Task(NewTaskTitle,NewTaskDescription,NewTaskPrioritet);
            TaskDBHelper.getInstance(getApplicationContext()).insertTask(task);
            Intent intent = new Intent();
            intent.putExtra(MainActivity.KEY_NASLOV, NewTaskTitle);
            intent.putExtra(MainActivity.KEY_OPIS, NewTaskDescription);
            intent.putExtra(MainActivity.KEY_PRIORITET, NewTaskPrioritet);
            this.setResult(RESULT_OK, intent);
            Intent startAgain=new Intent();
            startAgain.setClass(getApplicationContext(),MainActivity.class);
            this.startActivity(startAgain);
            this.finish();
        }

    }
}
