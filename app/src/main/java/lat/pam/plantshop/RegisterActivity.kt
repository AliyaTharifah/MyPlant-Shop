package lat.pam.plantshop

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    // Dipanggil saat tombol Register diklik
    fun registerUser(view: View) {
        // Logika validasi dan pendaftaran di sini
        Toast.makeText(this, "Pendaftaran Berhasil! Silakan Login", Toast.LENGTH_LONG).show()

        // GANTI TUJUAN DARI MainActivity ke AuthActivity
        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
        finish()
    }

    // Dipanggil saat link Login diklik
    fun openLoginActivity(view: View) {
        // GANTI TUJUAN DARI MainActivity ke AuthActivity
        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
        finish()
    }
}