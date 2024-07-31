package com.example.lobstersale

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lobstersale.adapters.MessageAdapter
import com.example.lobstersale.models.Message

class ChatActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var messageAdapter: MessageAdapter
    private lateinit var messageList: MutableList<Message>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val productName = intent.getStringExtra("product_name")
        findViewById<TextView>(R.id.chat_with).text = "Pesan $productName"

        messageList = mutableListOf()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        messageAdapter = MessageAdapter(messageList)
        recyclerView.adapter = messageAdapter

        val sendButton: Button = findViewById(R.id.send_button)
        val messageInput: EditText = findViewById(R.id.message_input)

        sendButton.setOnClickListener {
            val messageText = messageInput.text.toString()
            if (messageText.isNotBlank()) {
                val message = Message(messageText, "Saya")
                messageList.add(message)
                messageAdapter.notifyItemInserted(messageList.size - 1)
                messageInput.text.clear()
                recyclerView.scrollToPosition(messageList.size - 1)
            }
        }
    }
}
