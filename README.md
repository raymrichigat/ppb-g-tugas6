# **PPB G Tugas 6: Currency Converter Calculator App**
| Nama         | NRP           |
| :--------: | :------------: |
| Genta Putra Prayoga |5025221040 |

Aplikasi Currency Converter adalah aplikasi Android sederhana yang memungkinkan pengguna mengkonversi nilai mata uang antara Rupiah Indonesia (IDR), Dollar Amerika (USD), Euro (EUR), dan Yen Jepang (JPY) dengan antarmuka yang modern menggunakan Jetpack Compose.

## Fitur

- Konversi mata uang secara real-time
- Dukungan untuk beberapa mata uang (IDR, USD, EUR, JPY)
- Antarmuka pengguna modern dengan Material 3
- Tampilan hasil dengan format dan simbol mata uang yang tepat
- Validasi input untuk menghindari kesalahan konversi

## Screenshot

![Tampilan Mobile](https://github.com/user-attachments/assets/a846b7f1-61f7-4be6-9bf6-c6a56585dd6f)


## Teknologi yang Digunakan

- Kotlin
- Jetpack Compose
- Material 3
- Compose Navigation

## Persyaratan

- Android Studio Arctic Fox (2020.3.1) atau lebih baru
- Kotlin 1.5.0 atau lebih baru
- Android SDK minimal API level 21 (Android 5.0 Lollipop)
- Gradle version 7.0 atau lebih baru

## Cara Menginstal

1. Clone repositori ini: 
```bash
git clone https://github.com/raymrichigat/ppb-g-tugas6.git
```

2. Buka project menggunakan Android Studio

3. Sync Gradle dan jalankan aplikasi

## Struktur Proyek
```
app/
├── src/
│   ├── main/
│   │   ├── java/com/example/currencyconverter/
│   │   │   ├── MainActivity.kt                  # Entry point dan UI utama aplikasi
│   │   │   └── ui/theme/                        # Tema dan styling aplikasi
│   │   │       ├── Color.kt
│   │   │       ├── Theme.kt
│   │   │       └── Type.kt
│   │   ├── res/                                 # Resource aplikasi
│   │   └── AndroidManifest.xml                  # Konfigurasi aplikasi
├── build.gradle                                 # Konfigurasi build project
└── proguard-rules.pro                           # Aturan ProGuard
```

## Panduan Penggunaan

1. Masukkan jumlah uang yang ingin dikonversi di kolom "Enter amount"
2. Pilih jenis konversi dari dropdown "Conversion Type" (misalnya "IDR to USD")
3. Klik tombol "Convert" untuk melihat hasil
4. Hasil konversi akan ditampilkan dengan simbol mata uang yang sesuai

## Kurs Mata Uang

Aplikasi ini menggunakan kurs mata uang hardcoded sebagai berikut:
- 1 IDR = 0.000059 USD
- 1 USD = 16,832 IDR
- 1 IDR = 0.000052 EUR
- 1 EUR = 19,124.12 IDR
- 1 IDR = 0.0085 JPY
- 1 JPY = 117.86 IDR

*Catatan: Dalam aplikasi produksi sebenarnya, nilai kurs sebaiknya diambil dari API untuk mendapatkan nilai terkini.*

## Pengembangan Lebih Lanjut

Beberapa ide untuk pengembangan lebih lanjut:
- Integrasi dengan API kurs mata uang untuk mendapatkan nilai terkini
- Menambahkan lebih banyak mata uang
- Implementasi fitur riwayat konversi
- Menambahkan mode offline dengan penyimpanan data lokal
- Menambahkan widget home screen
