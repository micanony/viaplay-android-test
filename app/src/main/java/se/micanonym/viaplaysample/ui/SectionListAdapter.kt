package se.micanonym.viaplaysample.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import se.micanonym.viaplaysample.data.models.Section
import se.micanonym.viaplaysample.databinding.ListItemSectionBinding

class SectionListAdapter(private val onSectionClick: (Section) -> Unit) :
    ListAdapter<Section, RecyclerView.ViewHolder>(SectionDiffCallback()) {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val section = getItem(position)
        (holder as SectionViewHolder).bind(section)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        return SectionViewHolder(
            ListItemSectionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class SectionViewHolder(private val binding: ListItemSectionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(section: Section) {
            binding.container.setOnClickListener {
                onSectionClick.invoke(section)
            }
            binding.tvTitle.text = section.title
        }
    }
}

private class SectionDiffCallback : DiffUtil.ItemCallback<Section>() {
    override fun areItemsTheSame(oldItem: Section, newItem: Section) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Section, newItem: Section) =
        oldItem == newItem
}
