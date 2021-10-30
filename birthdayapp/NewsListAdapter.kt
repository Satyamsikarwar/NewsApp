package com.example.birthdayapp
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsListAdapter(private val listner:NewsItemClicked):RecyclerView.Adapter<NewsViewHolder>() {
    private val item: ArrayList<News> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent)
        val holder=NewsViewHolder(view)
        view.setOnClickListener {
            listner.onclick(item[holder.adapterPosition])
        }
        return holder
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.titleView.text=item[position].title
        holder.author.text=item[position].author
        Glide.with(holder.itemView.context).load(item[position].imageUrl).into(holder.image)
    }

    override fun getItemCount(): Int {
       return item.size
    }
    fun updateNews(updateNews:ArrayList<News>){
        item.clear()
        item.addAll(updateNews)
        notifyDataSetChanged()
    }
}
class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
     val titleView:TextView=itemView.findViewById(R.id.title)
     val image: ImageView =itemView.findViewById(R.id.image)
     val author:TextView=itemView.findViewById(R.id.author)
}
interface NewsItemClicked{
    fun onclick(item: News){

    }
}