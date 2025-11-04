## 1. Screen 1: Halaman Intro 
Halaman ini berfungsi sebagai Intro Screen atau Splash Screen aplikasi. Tampilan berpusat pada judul aplikasi, "Toko Tanaman Hias," dan tagline singkat. 
Tombol "Start now" di bagian bawah adalah aksi utama yang mengarahkan pengguna ke halaman Otentikasi (Login/Register) untuk memulai.
<img width="738" height="1600" alt="Image" src="https://github.com/user-attachments/assets/5c8489a5-4bbc-47b3-b626-04d96d45a092" />

## 2. Screen 2: Login 
Halaman-halaman ini menangani Otentikasi Pengguna.
Login (AuthActivity): Halaman ini muncul setelah tombol "Start now" diklik. Pengguna memasukkan username dan password untuk memverifikasi akun. 
Setelah login berhasil, aplikasi akan berpindah ke Home Activity.

## 3. Screen 3 : Register
Register (RegisterActivity): Halaman ini memungkinkan pengguna baru untuk membuat akun dengan mengisi nama lengkap, email, dan password. 
Setelah pendaftaran, pengguna akan diarahkan kembali ke halaman Login (AuthActivity) agar dapat langsung masuk.

## 4. Screen 4 : alaman Utama / Menu (HomeActivity)
Ini adalah halaman Beranda aplikasi yang menampilkan semua produk yang tersedia.  
Setiap item menampilkan Foto Produk, Nama Tanaman, deskripsi singkat, dan Harga yang sudah diformat ke Rupiah (Rp X.XXX). 
Tombol Order pada setiap item akan mengarahkan ke halaman Detail (Screen 5).

## 5. Screen 5 : Halaman Detail Produk (DetailActivity)
Setelah item menu diklik, halaman ini akan muncul. Fungsinya adalah menampilkan Detail Lengkap dari tanaman yang dipilih, termasuk gambar besar, nama, harga, dan deskripsi perawatan penuh. 
Tombol aksi utamanya adalah "Pesan Sekarang", yang memicu proses checkout dan mengarahkan pengguna ke halaman Form Pengiriman (Screen 6).

## Screen 6 : 
Form Pengiriman (CheckoutActivity)
Halaman ini adalah Formulir Checkout. Tujuannya adalah untuk mengumpulkan informasi yang dibutuhkan untuk pengiriman, seperti Alamat Lengkap, Nomor HP aktif, dan Catatan Order (jika ada). 
Setelah data diisi dan tombol "Konfirmasi Order" diklik, pengguna akan diarahkan ke halaman Konfirmasi Akhir (Screen 7).

## Screem 7 : Halaman Konfirmasi (ConfirmationActivity)
Ini adalah halaman Ucapan Terima Kasih yang muncul setelah order berhasil dikonfirmasi. Halaman ini menampilkan pesan sukses dan merangkum informasi bahwa pesanan sedang diproses.
Terdapat pula tombol "Kembali ke Beranda" yang mengarahkan pengguna ke Home Screen (Screen 4).
