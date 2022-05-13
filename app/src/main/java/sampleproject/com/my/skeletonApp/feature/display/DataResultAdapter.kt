package sampleproject.com.my.skeletonApp.feature.display

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import sampleproject.com.my.skeletonApp.R
import sampleproject.com.my.skeletonApp.databinding.ItemInformationActivityBinding

class DataResultAdapter(statusList: List<DataResultResponse>, private val callbacks: Callbacks? = null) : RecyclerView.Adapter<DataResultAdapter.ViewHolder>() {
    var items = listOf<DataResultResponse>()

    lateinit var mContext: Context

    init {
        items = statusList
    }
    interface Callbacks{
        fun onItemClick(view: View, item: DataResultResponse)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        mContext = parent.context
        val binding: ItemInformationActivityBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.item_information_activity,
            parent,
            false
        )
        return ViewHolder(binding,viewType)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.model = items[position]
        holder.mapTestStatus(items[position],holder)
        holder.binding.cvData.setOnClickListener {
            callbacks?.onItemClick(it,items[position])
        }

    }
    override fun getItemCount(): Int {
        val limit = 20
        return Math.min(items.size,limit)
    }

    inner class ViewHolder(val binding: ItemInformationActivityBinding,viewType: Int) : RecyclerView.ViewHolder(binding.root) {

        fun mapTestStatus(statusModel: DataResultResponse, holder: ViewHolder): DataResultResponse {
            return statusModel
        }

    }
    fun updateData(items:MutableList<DataResultResponse>){
        this.items = items
    }
}


























