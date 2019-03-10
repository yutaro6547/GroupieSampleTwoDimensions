package www.rozkey59.tokyo.groupiesampletwodimensions.main.item

import android.support.v7.widget.GridLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import com.xwray.groupie.databinding.BindableItem
import www.rozkey59.tokyo.groupiesampletwodimensions.R
import www.rozkey59.tokyo.groupiesampletwodimensions.databinding.ItemGridBinding
import www.rozkey59.tokyo.groupiesampletwodimensions.infra.data.IchibaListResponse


class GridItem(
    private val response: IchibaListResponse,
    private val itemPosition: Int
): BindableItem<ItemGridBinding>() {

    override fun isSameAs(other: Item<*>?): Boolean {
        return if (other != null && other is GridItem) {
            other.response.Items[itemPosition].itemPrice == response.Items[itemPosition].itemPrice
        } else {
            false
        }
    }

    override fun equals(other: Any?): Boolean {
        return if (other != null && other is GridItem) {
            other.response.Items[itemPosition].itemPrice == response.Items[itemPosition].itemPrice
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        return response.hashCode()
    }

    override fun getLayout(): Int {
        return R.layout.item_grid
    }

    override fun bind(binding: ItemGridBinding, position: Int) {
        binding.recyclerView.layoutManager = GridLayoutManager(binding.root.context, 2)
        binding.recyclerView.adapter = GroupAdapter<ViewHolder>().apply {
            add(CellItem(response, itemPosition))
        }
    }
}
