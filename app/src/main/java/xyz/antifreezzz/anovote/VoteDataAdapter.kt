package xyz.antifreezzz.anovote

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class VoteDataAdapter(var voteList: List<VotePos>) : RecyclerView.Adapter<VoteDataAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.voteText.text = voteList[position].voteListPos


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.activity_vote, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return voteList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val voteText = itemView.findViewById<TextView>(R.id.voteText)!!

    }

}


