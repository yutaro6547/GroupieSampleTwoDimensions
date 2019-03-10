package www.rozkey59.tokyo.groupiesampletwodimensions.main.item

import com.bumptech.glide.Glide
import com.xwray.groupie.Item
import com.xwray.groupie.databinding.BindableItem
import www.rozkey59.tokyo.groupiesampletwodimensions.R
import www.rozkey59.tokyo.groupiesampletwodimensions.databinding.ItemCellBinding
import www.rozkey59.tokyo.groupiesampletwodimensions.infra.data.IchibaListResponse

class CellItem(
    private val response: IchibaListResponse,
    private val itemPosition: Int
): BindableItem<ItemCellBinding>() {

    override fun isSameAs(other: Item<*>?): Boolean {
        return if (other != null && other is CellItem) {
            other.response.Items[itemPosition].itemPrice == response.Items[itemPosition].itemPrice
        } else {
            false
        }
    }

    override fun equals(other: Any?): Boolean {
        return if (other != null && other is CellItem) {
            other.response.Items[itemPosition] == response.Items[itemPosition]
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        return response.hashCode()
    }

    override fun getLayout(): Int {
        return R.layout.item_cell
    }

    override fun bind(binding: ItemCellBinding, position: Int) {
        val images = response.Items[itemPosition].mediumImageUrls
        binding.price.text = response.Items[itemPosition].itemPrice.toString()
        if (images.isNotEmpty()) {
            Glide.with(binding.root).load(images[0]).into(binding.mainImage)
        }
    }
}
