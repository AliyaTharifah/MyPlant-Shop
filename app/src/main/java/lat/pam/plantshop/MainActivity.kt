// Di dalam MainActivity.kt
package lat.pam.plantshop

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Intro Screen
    }

    // Fungsi yang dipanggil saat tombol "Start now" diklik
    fun openAuthOptions(view: View) {
        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
    }
}
// Hapus fungsi openHomeActivity dan openRegisterActivity dari sini!