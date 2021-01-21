package com.parakram.recycleviewactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.bumptech.glide.Glide
import com.parakram.recycleviewactivity.model.Actor
import de.hdodenhof.circleimageview.CircleImageView

class ActorDetails : AppCompatActivity() {
    private lateinit var imgProfile : CircleImageView
    private lateinit var tvName : TextView
    private lateinit var tvAddress : TextView
    private lateinit var tvSalary : TextView
    private lateinit var tvActorId : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actor_details)

        imgProfile = findViewById(R.id.imgProfile)
        tvActorId = findViewById(R.id.tvActorId)
        tvName = findViewById(R.id.tvName)
        tvAddress = findViewById(R.id.tvAddress)
        tvSalary = findViewById(R.id.tvSalary)

        val intent = intent.getParcelableExtra<Actor>("actor")
        if (intent != null){
            val actorID = intent.actorId
            val actorName = intent.actorName
            val actorAddress = intent.actorAddress
            val actorSalaey = intent.actorSalary
            val actorImage = intent.actorImage

            tvActorId.text = actorID.toString()
            tvName.text = actorName
            tvAddress.text = actorAddress
            tvSalary.text = actorSalaey.toString()

            Glide.with(this@ActorDetails)
                .load(actorImage)
                .into(imgProfile)
        }
    }
}