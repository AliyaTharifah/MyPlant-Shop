package lat.pam.plantshop // PASTIKAN NAMA PACKAGE INI BENAR

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.Locale

// Pastikan class ini meng-extends RecyclerView.Adapter
class PlantMenuAdapter(private val menuList: List<PlantMenu>) :
    RecyclerView.Adapter<PlantMenuAdapter.MenuViewHolder>() {

    // Class ViewHolder yang memegang referensi ke View (item_menu_tanaman.xml)
    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.text_plant_name)
        val description: TextView = itemView.findViewById(R.id.text_plant_description)
        val price: TextView = itemView.findViewById(R.id.text_plant_price)
        val image: ImageView = itemView.findViewById(R.id.image_plant)
        val orderButton: Button = itemView.findViewById(R.id.button_order)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu_tanaman, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val currentItem = menuList[position]

        // --- FINAL FIX FORMAT HARGA RUPIAH ---
        val priceInLong = currentItem.price.toLong()
        val format: NumberFormat = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
        format.maximumFractionDigits = 0

        var formattedPrice = format.format(priceInLong)

        // Koreksi string Rupiah (misal: IDR 95.000 -> Rp 95.000)
        formattedPrice = formattedPrice.replace("IDR", "Rp").replace("Rp", "Rp ").trim()
        // --- AKHIR FIX ---


        holder.name.text = currentItem.name
        holder.description.text = currentItem.description
        holder.price.text = formattedPrice
        holder.image.setImageResource(currentItem.imageResId)

        // LOGIC: Mengirim ID Tanaman ke DetailActivity
        holder.orderButton.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_PLANT_ID, currentItem.id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = menuList.size
}