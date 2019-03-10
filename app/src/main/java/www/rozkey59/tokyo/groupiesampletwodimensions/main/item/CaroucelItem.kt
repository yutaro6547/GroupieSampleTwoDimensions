package www.rozkey59.tokyo.groupiesampletwodimensions.main.item

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import com.xwray.groupie.databinding.BindableItem
import www.rozkey59.tokyo.groupiesampletwodimensions.R
import www.rozkey59.tokyo.groupiesampletwodimensions.infra.data.IchibaListResponse
import www.rozkey59.tokyo.groupiesampletwodimensions.databinding.ItemCarouselBinding


class CaroucelItem(
    private val response: IchibaListResponse,
    private val itemPosition: Int
): BindableItem<ItemCarouselBinding>() {

    override fun isSameAs(other: Item<*>?): Boolean {
        return if (other != null && other is CaroucelItem) {
            other.response.Items[itemPosition].itemPrice == response.Items[itemPosition].itemPrice
        } else {
            false
        }
    }

    override fun equals(other: Any?): Boolean {
        return if (other != null && other is CaroucelItem) {
            other.response.Items[itemPosition] == response.Items[itemPosition]
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        return response.hashCode()
    }


    override fun getLayout(): Int {
        return R.layout.item_carousel
    }

    override fun bind(binding: ItemCarouselBinding, position: Int) {
        binding.recyclerView.layoutManager = LinearLayoutManager(binding.root.context, RecyclerView.HORIZONTAL, false)
        binding.recyclerView.adapter = GroupAdapter<ViewHolder>().apply {
            add(CellItem(response, itemPosition))
        }
    }

}
