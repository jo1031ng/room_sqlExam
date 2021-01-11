package com.example.room_sqlexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText et_todo;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_todo =findViewById(R.id.et_todo);
        resultView =findViewById(R.id.tv_re);

        AppDatabase db = Room.databaseBuilder(this, AppDatabase.class,
                "todo_db").allowMainThreadQueries().build();

        resultView.setText(db.todoDao().getAll().toString());

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.todoDao().insert(new todo(et_todo.getText().toString()));
                resultView.setText(db.todoDao().getAll().toString());
            }
        });


    }
}