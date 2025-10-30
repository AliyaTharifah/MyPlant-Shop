package lat.pam.plantshop

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupBottomNavigation()
        setupRecyclerView()
    }

    private fun setupBottomNavigation() {
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Home Terpilih", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_order -> {
                    Toast.makeText(this, "Order Terpilih (Keranjang)", Toast.LENGTH_SHORT).show()
                    // TODO: Arahkan ke Order/Cart Activity
                    true
                }
                R.id.nav_profile -> {
                    Toast.makeText(this, "Profile Terpilih", Toast.LENGTH_SHORT).show()
                    // TODO: Arahkan ke Profile Activity
                    true
                }
                else -> false
            }
        }
        // Atur Home sebagai item yang dipilih saat awal
        bottomNavigationView.selectedItemId = R.id.nav_home
    }

    private fun setupRecyclerView() {
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view_menu)

        // 1. Dapatkan data menu
        val menuList = getPlantMenuData()

        // 2. Buat dan set Adapter
        val adapter = PlantMenuAdapter(menuList)
        recyclerView.adapter = adapter

        // 3. Set Layout Manager (sudah didefinisikan di XML, tapi bisa diulang di sini jika perlu)
        // recyclerView.layoutManager = LinearLayoutManager(this)
    }

    // Data Menu Tanaman (Minimal 10)
    fun getPlantMenuData(): List<PlantMenu> {
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
