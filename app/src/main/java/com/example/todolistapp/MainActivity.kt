package com.example.todolistapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val todoList = mutableListOf<String>()
    private lateinit var adapter: TodoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextTask: EditText = findViewById(R.id.editTextTask)
        val buttonAddTask: Button = findViewById(R.id.buttonAddTask)
        val buttonViewTasks: Button = findViewById(R.id.buttonViewTasks)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewTasks)

        adapter = TodoListAdapter(todoList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        buttonAddTask.setOnClickListener {
            val task = editTextTask.text.toString()

            if (task.isEmpty()) {
                editTextTask.error = "Please enter a task"
                return@setOnClickListener
            }

            todoList.add(task)
            editTextTask.text.clear()
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "$task added to the list", Toast.LENGTH_SHORT).show()
        }

        buttonViewTasks.setOnClickListener {
            val intent = Intent(this, DisplayTasksActivity::class.java).apply {
                putStringArrayListExtra("TODO_LIST", ArrayList(todoList))
            }
            startActivity(intent)
        }
    }
}
