package lat.pam.plantshop

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        // Ambil pesan konfirmasi yang sudah ada di layout
        val messageTextView: TextView = findViewById(R.id.text_confirmation_message)

        // Ambil data alamat dari intent
        val address = intent.getStringExtra("ORDER_ADDRESS") ?: "Alamat tidak tersedia."

        // Modifikasi pesan: Tambahkan alamat pengiriman ke pesan terima kasih
        val originalMessage = getString(R.string.confirmation_message)
        messageTextView.text = "$originalMessage\n\nPesanan akan dikirim ke:\n\n$address"
    }

    // Fungsi yang dipanggil saat tombol "Kembali ke Beranda" diklik
    fun backToHome(view: View) {
        val intent = Intent(this, HomeActivity::class.java)

        // Membersihkan Activity Stack
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)

        startActivity(intent)
        finish()
    }
}