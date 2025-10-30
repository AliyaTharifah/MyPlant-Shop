// Di dalam AuthActivity.kt
package lat.pam.plantshop

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth) // Layout Login
    }

    // Logic Login: Dipanggil dari tombol Login di activity_auth.xml
    fun openHomeActivity(view: View) {
        // Logic validasi login akan ada di sini
        Toast.makeText(this, "Login Berhasil! Membuka Halaman Utama...", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    // Logic Register: Dipanggil dari link Daftar di activity_auth.xml
    fun openRegisterActivity(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}