package lat.pam.plantshop

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CheckoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
    }

    fun confirmOrder(view: View) {
        // Gunakan .trim() untuk menghapus spasi di awal dan akhir input
        val address = findViewById<EditText>(R.id.edit_text_address).text.toString().trim()
        val phone = findViewById<EditText>(R.id.edit_text_phone).text.toString().trim()
        val note = findViewById<EditText>(R.id.edit_text_note).text.toString().trim()

        // Cek jika input kosong SETELAH spasi dihapus
        if (address.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, "Alamat dan Nomor HP wajib diisi.", Toast.LENGTH_SHORT).show()
            return // Keluar dari fungsi jika validasi gagal
        }

        // --- Jika Lolos Validasi, PINDAH HALAMAN ---
        Toast.makeText(this, "Order dikonfirmasi. Menuju halaman terima kasih...", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, ConfirmationActivity::class.java)
        intent.putExtra("ORDER_ADDRESS", address)
        intent.putExtra("ORDER_PHONE", phone)

        startActivity(intent)
        finish()
    }
}