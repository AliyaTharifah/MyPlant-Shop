package lat.pam.plantshop // Pastikan package name Anda benar

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import java.util.Locale

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PLANT_ID = "extra_plant_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // 1. Ambil ID Tanaman
        val plantId = intent.getIntExtra(EXTRA_PLANT_ID, 0)
        val selectedPlant = getPlantMenuData().find { it.id == plantId } // <-- PANGGILAN INI AKAN BERHASIL

        // 2. Ambil referensi tombol
        val buttonCart: Button = findViewById(R.id.button_add_to_cart)

        // 3. Pasang Listener ke tombol
        buttonCart.setOnClickListener {
            if (selectedPlant == null) {
                Toast.makeText(this, "Kesalahan: Data tanaman tidak ditemukan.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, CheckoutActivity::class.java)
                intent.putExtra(EXTRA_PLANT_ID, plantId)
                startActivity(intent)
            }
        }

        // 4. Tampilkan Detail
        if (selectedPlant != null) {
            val detailName: TextView = findViewById(R.id.detail_plant_name)
            val detailPrice: TextView = findViewById(R.id.detail_plant_price)
            val detailDescription: TextView = findViewById(R.id.detail_plant_description)
            val detailImage: ImageView = findViewById(R.id.detail_plant_image)

            detailName.text = selectedPlant.name
            detailDescription.text = selectedPlant.description
            detailImage.setImageResource(selectedPlant.imageResId)

            // Formatting Harga
            val format = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
            format.maximumFractionDigits = 0
            val priceInLong = selectedPlant.price.toLong()
            var formattedPrice = format.format(priceInLong)
            formattedPrice = formattedPrice.replace("IDR", "Rp").replace("Rp", "Rp ").trim()
            detailPrice.text = formattedPrice

        } else {
            Toast.makeText(this, "Error: Tanaman tidak ditemukan. Kembali ke Home.", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    /**
     * FUNGSI getPlantMenuData HARUS BERADA DI DALAM CLASS INI.
     */
    private fun getPlantMenuData(): List<PlantMenu> {
        // PASTIKAN SEMUA RESOURCE ID GAMBAR R.drawable.xxx SUDAH BENAR
        return listOf(
            PlantMenu(1, "Monstera Deliciosa", "Tanaman hias dengan daun bolong yang eksotis.", 95000.0, R.drawable.ic_monstera),
            PlantMenu(2, "Calathea Ornata", "Daun bergaris pink yang indah, butuh kelembapan tinggi.", 75000.0, R.drawable.ic_calathea),
            PlantMenu(3, "Sansevieria Trifasciata", "Lidah mertua, penyerap polusi udara yang tangguh.", 45000.0, R.drawable.ic_sansevieria),
            PlantMenu(4, "Kaktus Mini", "Kaktus berbagai jenis dalam pot keramik kecil.", 25000.0, R.drawable.ic_kaktus),
            PlantMenu(5, "Aglonema Red Anjamani", "Ratu tanaman daun dengan warna merah menyala.", 120000.0, R.drawable.ic_aglonema),
            PlantMenu(6, "Sirih Gading (Pothos)", "Tanaman merambat yang mudah dirawat, cocok untuk indoor.", 30000.0, R.drawable.ic_sirihgading),
            PlantMenu(7, "Pilea Peperomioides", "Tanaman koin Cina, lucu dan unik bentuknya.", 85000.0, R.drawable.ic_pilea),
            PlantMenu(8, "Media Tanam Organik", "Campuran sekam bakar, cocopeat, dan kompos.", 15000.0, R.drawable.ic_mediatanamorganik),
            PlantMenu(9, "Pupuk Cair All-in-One", "Nutrisi lengkap untuk pertumbuhan daun dan akar.", 40000.0, R.drawable.ic_pupukcair),
            PlantMenu(10, "Pot Keramik Estetik", "Pot handmade berukuran medium dengan desain minimalis.", 55000.0, R.drawable.ic_potkeramik)
        )
    }
}