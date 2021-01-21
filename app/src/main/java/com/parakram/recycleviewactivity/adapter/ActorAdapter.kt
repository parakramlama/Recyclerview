package com.parakram.recycleviewactivity.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.parakram.recycleviewactivity.ActorDetails
import com.parakram.recycleviewactivity.R
import com.parakram.recycleviewactivity.model.Actor
import de.hdodenhof.circleimageview.CircleImageView


class ActorAdapter(
    val lstActors: ArrayList<Actor>,
    val context: Context
):
RecyclerView.Adapter<ActorAdapter.ActorViewHolder>(){

    class ActorViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val imgProfile: CircleImageView
        val tvName: TextView
        val tvAddress: TextView
        val tvSalary: TextView

        init {
            imgProfile = view.findViewById(R.id.imgProfile)
            tvName = view.findViewById(R.id.tvName)
            tvAddress = view.findViewById(R.id.tvAddress)
            tvSalary = view.findViewById(R.id.tvSalary)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.mero_actor_layout, parent, false)
        return ActorViewHolder(view)
    }


    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        val actor = lstActors[position]
        holder.tvName.text = actor.actorName
        holder.tvAddress.text = actor.actorAddress
        holder.tvSalary.text = actor.actorSalary.toString()

        Glide.with(context)
            .load(actor.actorImage)
            .into(holder.imgProfile)

        holder.imgProfile.setOnClickListener {
            val intent = Intent(context, ActorDetails::class.java)
            intent.putExtra("actor", actor)
            context.startActivity(intent)
        }
    }

    //length kati banaune yesko kaam
    override fun getItemCount(): Int {
        return lstActors.size
    }
}