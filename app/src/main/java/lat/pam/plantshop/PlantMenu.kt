package lat.pam.plantshop

data class PlantMenu(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageResId: Int // Resource ID untuk gambar tanaman
)