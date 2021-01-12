package com.example.room_sqlexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText et_todo;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_todo = findViewById(R.id.et_todo);
        resultView = findViewById(R.id.tv_re);

        AppDatabase db = Room.databaseBuilder(this, AppDatabase.class,
                "todo_db").build();

        // TextView 자동 갱신
        db.todoDao().getAll().observe(this, todos -> {
            resultView.setText(db.todoDao().getAll().toString());
            resultView.setText(todos.toString());
        });

        //버튼 클릭시 db에 입력
        /*
        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

         */
        findViewById(R.id.btn_add).setOnClickListener(v -> { //람다식
            //db.todoDao().insert(new todo(et_todo.getText().toString()));

            new InsertAsyncTask(db.todoDao()).execute(new todo(et_todo.getText().toString()));
        });

    }
    //백그라운드
    private  static  class InsertAsyncTask extends AsyncTask<todo, Void ,Void>{
        private  todoDao dao;

        public InsertAsyncTask(com.example.room_sqlexam.todoDao todoDao) {
            this.dao = todoDao;
        }

        @Override
        protected Void doInBackground(todo... todos) {
            dao.insert(todos[0]);
            return null;
        }
    }


}