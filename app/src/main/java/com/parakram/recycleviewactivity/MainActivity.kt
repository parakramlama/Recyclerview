package com.parakram.recycleviewactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.parakram.recycleviewactivity.adapter.ActorAdapter
import com.parakram.recycleviewactivity.model.Actor

class MainActivity : AppCompatActivity() {
    private var lstActors = ArrayList<Actor>()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        loadAdaptors()
        val adapter = ActorAdapter(lstActors, this@MainActivity)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = adapter
    }

    private fun loadAdaptors(){
        lstActors.add(
            Actor(1, "Salman Khan",
            actorImage = "https://static.toiimg.com/thumb/msid-70305128,imgsize-121900,width-800,height-600,resizemode-75/70305128.jpg",
            actorAddress = "Kathmandu", 100000F))

        lstActors.add(
            Actor(1, "Salman Khan",
                actorImage = "https://static.toiimg.com/thumb/msid-70305128,imgsize-121900,width-800,height-600,resizemode-75/70305128.jpg",
                actorAddress = "Kathmandu", 100000F))

        lstActors.add(
            Actor(1, "Salman Khan",
                actorImage = "https://static.toiimg.com/thumb/msid-70305128,imgsize-121900,width-800,height-600,resizemode-75/70305128.jpg",
                actorAddress = "Kathmandu", 100000F))
    }
}