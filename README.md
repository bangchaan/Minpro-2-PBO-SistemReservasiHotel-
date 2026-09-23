# DOKUMENTASI MINI PROJECT 2

---

## SISTEM TRACKING RESERVASI HOTEL

**Nama:** Aulia  
**NIM:** [Isi NIM]

---

# BAB I PENDAHULUAN

## 1.1 Deskripsi Singkat

### Deskripsi Program

Sistem Tracking Reservasi Hotel merupakan program yang dirancang untuk membantu proses pengelolaan dan pemantauan data reservasi hotel secara sederhana dan terstruktur. Program ini berbasis Java dan menggunakan konsep Pemrograman Berorientasi Objek (PBO).

Program memungkinkan pengguna untuk mengelola data reservasi melalui beberapa fitur, seperti menambahkan reservasi, menampilkan data reservasi, melakukan check-in, melakukan check-out, memperbarui jumlah malam, dan menghapus reservasi.

Setiap data reservasi memiliki informasi seperti ID reservasi, nama tamu, jumlah malam, harga per malam, dan status reservasi. Status reservasi dapat berubah sesuai proses yang dilakukan, yaitu dari **Menunggu**, kemudian **Check-In**, dan setelah tamu selesai menginap menjadi **Check-Out**.

Program memiliki dua jenis reservasi, yaitu **Reservasi Standard** dan **Reservasi VIP**. Reservasi Standard memiliki kebijakan denda pembatalan sebesar 20%, sedangkan Reservasi VIP memiliki pilihan jenis penyambutan yang dapat memengaruhi biaya reservasi.

Dalam pembuatannya, program menerapkan beberapa konsep Pemrograman Berorientasi Objek (PBO), yaitu **encapsulation, inheritance, polymorphism, dan constructor**. Program juga menggunakan pola **Model-View-Controller (MVC)** untuk memisahkan bagian data, tampilan, dan proses pengendalian program.

---

## 1.2 Tujuan

Sistem Tracking Reservasi Hotel dirancang dengan tujuan sebagai berikut:

- Membantu mengelola data reservasi hotel secara lebih terstruktur.
- Memudahkan pengguna dalam menambahkan dan menampilkan data reservasi.
- Memudahkan proses tracking status tamu melalui fitur check-in dan check-out.
- Memungkinkan pengguna memperbarui jumlah malam pada reservasi.
- Memudahkan pengguna menghapus data reservasi yang sudah tidak diperlukan.
- Menerapkan konsep Pemrograman Berorientasi Objek dalam program Java.
- Menerapkan konsep MVC agar struktur program lebih terorganisir.

---

## 1.3 Alur Singkat

Alur program dimulai dengan menampilkan menu utama **Tracking Reservasi Hotel**. Pengguna dapat memilih menu sesuai dengan kebutuhan, yaitu menambah reservasi, menampilkan semua reservasi, melakukan check-in, melakukan check-out, memperbarui jumlah malam, menghapus reservasi, atau keluar dari program.

Pada saat menambahkan reservasi, pengguna terlebih dahulu memilih jenis reservasi, yaitu Standard atau VIP. Setelah itu pengguna memasukkan nama tamu dan jumlah malam.

Jika pengguna memilih reservasi Standard, sistem akan membuat data reservasi Standard dengan harga Rp300.000 per malam dan memiliki ketentuan denda pembatalan sebesar 20%.

Jika pengguna memilih reservasi VIP, pengguna dapat memilih jenis penyambutan. Jenis penyambutan tersebut terdiri dari Reguler, Executive Lounge, dan Airport Pickup + Lounge. Setiap jenis penyambutan memiliki biaya tambahan yang berbeda.

Setelah data berhasil dibuat, reservasi akan masuk ke dalam daftar reservasi dengan status **Menunggu**. Pengguna dapat melakukan check-in sehingga status berubah menjadi **Check-In**, kemudian melakukan check-out sehingga status berubah menjadi **Check-Out**.

Program akan terus berjalan sampai pengguna memilih menu **Keluar**.

---

# BAB II ALUR PROGRAM

## 2.1 Menu Utama

Menu utama digunakan sebagai pusat navigasi pengguna dalam mengelola data reservasi hotel.

Pilihan menu yang tersedia adalah:

1. Tambah Reservasi
2. Tampilkan Semua Reservasi
3. Check-In Tamu
4. Check-Out Tamu
5. Update Jumlah Malam
6. Hapus Reservasi
0. Keluar

Pengguna dapat memilih menu berdasarkan proses yang ingin dilakukan. Setiap pilihan akan menjalankan proses yang sesuai melalui `ReservasiController`.

### Tampilan Menu Utama

```text
==============================
   TRACKING RESERVASI HOTEL
==============================
1. Tambah Reservasi
2. Tampilkan Semua Reservasi
3. Check-In Tamu
4. Check-Out Tamu
5. Update Jumlah Malam
6. Hapus Reservasi
0. Keluar
```

---

## 2.2 Menu Tambah Reservasi

Menu Tambah Reservasi digunakan untuk memasukkan data reservasi baru ke dalam sistem.

Pengguna dapat memilih dua jenis reservasi:

```text
--- TAMBAH RESERVASI ---
1. Standard (Rp300.000/malam, denda pembatalan 20%)
2. VIP (Rp750.000/malam + layanan Rp100.000)
```

Setelah memilih jenis reservasi, pengguna memasukkan nama tamu dan jumlah malam.

### 2.2.1 Tambah Reservasi Standard

Pada reservasi Standard, sistem menetapkan harga kamar sebesar **Rp300.000 per malam**.

Reservasi Standard memiliki atribut khusus berupa **denda pembatalan sebesar 20%**. Denda tersebut digunakan ketika reservasi dihapus sebelum status Check-Out.

Contoh data:

```text
--- TAMBAH RESERVASI ---
1. Standard (Rp300.000/malam, denda pembatalan 20%)
2. VIP (Rp750.000/malam + layanan Rp100.000)

Pilih tipe (1-2): 1
Nama tamu: Budi Santoso
Jumlah malam (1-30): 2

>> Berhasil! ID reservasi: 4
```

Data reservasi Standard kemudian disimpan ke dalam `ArrayList<Reservasi>`.

---

## 2.2.2 Tambah Reservasi VIP

Pada reservasi VIP, sistem menetapkan harga kamar sebesar **Rp750.000 per malam**.

Reservasi VIP memiliki pilihan jenis penyambutan yang dapat memengaruhi biaya reservasi.

Pilihan penyambutan yang tersedia:

```text
Pilih jenis penyambutan:
1. Reguler (tanpa tambahan biaya)
2. Executive Lounge (+Rp100.000)
3. Airport Pickup + Lounge (+Rp200.000)
```

Jenis penyambutan digunakan untuk menentukan layanan tambahan dan biaya yang akan ditambahkan ke total biaya reservasi VIP.

Contoh:

```text
--- TAMBAH RESERVASI ---
1. Standard (Rp300.000/malam, denda pembatalan 20%)
2. VIP (Rp750.000/malam + layanan Rp100.000)

Pilih tipe (1-2): 2
Nama tamu: Siti Aminah
Jumlah malam (1-30): 3

Pilih jenis penyambutan:
1. Reguler (tanpa tambahan biaya)
2. Executive Lounge (+Rp100.000)
3. Airport Pickup + Lounge (+Rp200.000)

Pilih (1-3): 2

>> Berhasil! ID reservasi: 5
```

---

## 2.3 Menu Tampilkan Reservasi

Menu Tampilkan Reservasi digunakan untuk melihat seluruh data reservasi yang tersimpan di dalam sistem.

Informasi yang ditampilkan meliputi:

- ID reservasi
- Nama tamu
- Tipe reservasi
- Jumlah malam
- Status
- Total biaya
- Detail tambahan

Contoh tampilan:

```text
--- DAFTAR RESERVASI ---

ID   | Nama Tamu       | Tipe     | Malam | Status    | Total Biaya | Detail
--------------------------------------------------------------------------------
1    | Budi Santoso    | Standard | 2     | Menunggu  | Rp600000    | -
2    | Siti Aminah     | VIP      | 3     | Check-In  | Rp2350000   | Penyambutan: Executive Lounge (+Rp100,000)
3    | Andi Wijaya     | Standard | 1     | Check-Out | Rp300000    | -
```

Data ditampilkan berdasarkan isi `ArrayList<Reservasi>` yang dikelola oleh `ReservasiController`.

---

## 2.4 Menu Check-In

Menu Check-In digunakan untuk mengubah status reservasi dari **Menunggu** menjadi **Check-In**.

Pengguna memasukkan ID reservasi yang ingin dilakukan check-in.

Contoh:

```text
--- CHECK-IN TAMU ---
ID reservasi: 1

>> Check-in berhasil.
```

Jika status reservasi bukan Menunggu atau ID tidak ditemukan, sistem akan menampilkan pesan kegagalan.

Fitur ini digunakan untuk membantu proses tracking kedatangan tamu.

---

## 2.5 Menu Check-Out

Menu Check-Out digunakan untuk mengubah status reservasi dari **Check-In** menjadi **Check-Out**.

Pengguna memasukkan ID reservasi yang ingin dilakukan check-out.

Contoh:

```text
--- CHECK-OUT TAMU ---
ID reservasi: 1

>> Check-out berhasil.
```

Check-out hanya dapat dilakukan jika tamu sebelumnya sudah melakukan check-in.

Dengan demikian, alur status reservasi adalah:

```text
Menunggu
   ↓
Check-In
   ↓
Check-Out
```

---

## 2.6 Menu Update

Menu Update digunakan untuk memperbarui jumlah malam pada suatu reservasi.

Pengguna memasukkan ID reservasi, kemudian memasukkan jumlah malam yang baru.

Contoh:

```text
--- UPDATE JUMLAH MALAM ---
ID reservasi: 1
Jumlah malam baru (1-30): 4

>> Data berhasil diperbarui.
```

Reservasi yang sudah berstatus Check-Out tidak dapat diperbarui karena proses menginapnya sudah selesai.

---

## 2.7 Menu Hapus

Menu Hapus digunakan untuk menghapus data reservasi dari sistem.

Pengguna memasukkan ID reservasi yang ingin dihapus.

Pada reservasi Standard, jika reservasi dihapus sebelum Check-Out, sistem akan menghitung denda pembatalan sebesar 20% dari total biaya reservasi.

Contoh:

```text
--- HAPUS RESERVASI ---
ID reservasi: 1

>> Dibatalkan sebelum selesai, kena denda pembatalan: Rp120,000
>> Reservasi dihapus.
```

Jika reservasi sudah berstatus Check-Out, denda pembatalan tidak dikenakan.

---

## 2.8 Menu Keluar

Menu Keluar digunakan untuk menghentikan program.

Ketika pengguna memilih menu 0, program akan berhenti dan menampilkan pesan:

```text
Terima kasih!
```

---

# BAB III PENERAPAN KONSEP PBO

## 3.1 MVC (Model View Controller)

Program Sistem Tracking Reservasi Hotel menggunakan pola **Model-View-Controller (MVC)** untuk memisahkan data, tampilan, dan proses pengendalian program.

Struktur package yang digunakan:

```text
Source Packages
│
├── com.mycompany.reservasihotel
│   └── SistemReservasiHotel.java
│
├── controller
│   └── ReservasiController.java
│
├── model
│   ├── Reservasi.java
│   ├── ReservasiStandard.java
│   └── ReservasiVIP.java
│
└── view
    └── ReservasiView.java
```

### 1. Package Model

Package `model` berisi class yang merepresentasikan data dan aturan dari reservasi.

Class yang terdapat pada package model adalah:

- `Reservasi`
- `ReservasiStandard`
- `ReservasiVIP`

Class `Reservasi` menjadi superclass yang menyimpan data umum reservasi. Sedangkan `ReservasiStandard` dan `ReservasiVIP` merupakan subclass yang memiliki karakteristik masing-masing.

### 2. Package View

Package `view` berisi class `ReservasiView`.

Class ini digunakan untuk menampilkan menu, daftar reservasi, dan pesan kepada pengguna.

View bertugas menangani bagian tampilan program.

### 3. Package Controller

Package `controller` berisi class `ReservasiController`.

Class ini menjadi penghubung antara Model dan View serta mengatur proses program seperti menambah, menampilkan, memperbarui, menghapus, check-in, dan check-out reservasi.

---

## 3.2 Inheritance

Inheritance digunakan untuk membuat hubungan antara superclass dan subclass.

Pada program ini:

```text
              Reservasi
                  │
          ┌───────┴────────┐
          ↓                ↓
 ReservasiStandard     ReservasiVIP
```

Class `Reservasi` menjadi superclass, sedangkan `ReservasiStandard` dan `ReservasiVIP` menjadi subclass.

### 1. Reservasi Standard

```java
public class ReservasiStandard extends Reservasi {
```

Class `ReservasiStandard` mewarisi atribut dan method dari class `Reservasi`.

Reservasi Standard memiliki karakteristik khusus berupa kebijakan **denda pembatalan 20%**.

```java
private int dendaPembatalanPersen;
```

Atribut tersebut digunakan untuk menentukan jumlah denda ketika reservasi Standard dibatalkan sebelum selesai.

### 2. Reservasi VIP

```java
public class ReservasiVIP extends Reservasi {
```

Class `ReservasiVIP` juga mewarisi atribut dan method dari class `Reservasi`.

Reservasi VIP memiliki karakteristik khusus berupa **jenis penyambutan**.

Jenis penyambutan yang tersedia adalah:

- Reguler
- Executive Lounge
- Airport Pickup + Lounge

Setiap jenis penyambutan memiliki biaya tambahan yang berbeda.

---

## 3.3 Encapsulation

Encapsulation diterapkan dengan menggunakan access modifier `private` pada atribut class.

Contohnya pada class `Reservasi`:

```java
private final int idReservasi;
private final int hargaPerMalam;
private String namaTamu;
private int jumlahMalam;
private String status;
```

Atribut tersebut tidak dapat diakses secara langsung dari luar class.

Pengambilan data dilakukan melalui getter, sedangkan perubahan data dilakukan melalui setter.

Contoh:

```java
public String getNamaTamu() {
    return namaTamu;
}

public void setNamaTamu(String namaTamu) {
    if (namaTamu == null || namaTamu.trim().isEmpty()) {
        throw new IllegalArgumentException("Nama tamu tidak boleh kosong.");
    }

    this.namaTamu = namaTamu.trim();
}
```

Dengan cara tersebut, data reservasi dapat dikontrol dan divalidasi melalui method yang telah disediakan oleh class.

---

## 3.4 Constructor

Constructor digunakan untuk memberikan nilai awal ketika objek reservasi dibuat.

Pada class `Reservasi` terdapat constructor:

```java
public Reservasi(int idReservasi, String namaTamu,
        int jumlahMalam, int hargaPerMalam) {

    this.idReservasi = idReservasi;
    this.hargaPerMalam = hargaPerMalam;
    setNamaTamu(namaTamu);
    setJumlahMalam(jumlahMalam);
    this.status = MENUNGGU;
}
```

Constructor digunakan untuk menginisialisasi ID reservasi, nama tamu, jumlah malam, harga per malam, dan status awal reservasi.

Pada subclass, constructor menggunakan `super()` untuk memanggil constructor dari superclass.

Contoh:

```java
public ReservasiStandard(int idReservasi,
        String namaTamu, int jumlahMalam) {

    super(idReservasi, namaTamu, jumlahMalam, 300000);
    setDendaPembatalanPersen(20);
}
```

Dengan penggunaan `super()`, data umum reservasi diinisialisasi oleh class `Reservasi`, sedangkan data khusus Standard diinisialisasi oleh `ReservasiStandard`.

---

## 3.5 Polymorphism

Polymorphism diterapkan dengan menyimpan objek `ReservasiStandard` dan `ReservasiVIP` ke dalam satu `ArrayList` bertipe `Reservasi`.

Contohnya:

```java
private final ArrayList<Reservasi> daftarReservasi = new ArrayList<>();
```

Objek Standard:

```java
Reservasi r = new ReservasiStandard(
        idBerikutnya,
        namaTamu,
        jumlahMalam
);
```

Objek VIP:

```java
Reservasi r = new ReservasiVIP(
        idBerikutnya,
        namaTamu,
        jumlahMalam,
        jenisPenyambutan
);
```

Meskipun keduanya disimpan sebagai tipe `Reservasi`, method yang dioverride pada masing-masing subclass akan menjalankan perilaku sesuai objek sebenarnya.

Contohnya:

```java
r.getTipe();
```

akan menghasilkan:

```text
Standard
```

jika objek merupakan `ReservasiStandard`, dan:

```text
VIP
```

jika objek merupakan `ReservasiVIP`.

Polymorphism juga digunakan pada method `hitungTotalBiaya()` dan `getDetailTambahan()`.

---

## 3.6 Getter dan Setter

Getter dan setter digunakan untuk mengakses dan mengubah atribut yang bersifat `private`.

Contoh getter:

```java
public int getJumlahMalam() {
    return jumlahMalam;
}
```

Contoh setter:

```java
public void setJumlahMalam(int jumlahMalam) {
    if (jumlahMalam < 1 || jumlahMalam > 30) {
        throw new IllegalArgumentException(
                "Jumlah malam harus 1 - 30.");
    }

    this.jumlahMalam = jumlahMalam;
}
```

Setter juga digunakan untuk melakukan validasi agar data yang dimasukkan sesuai dengan aturan program.

---

## 3.7 Validasi Input

Program memiliki validasi input agar program tidak berhenti ketika pengguna memasukkan data yang tidak sesuai.

Validasi angka dilakukan melalui method:

```java
public int inputAngka(String prompt, int min, int max)
```

Jika pengguna memasukkan huruf ketika sistem meminta angka, program akan menampilkan:

```text
>> Input harus berupa angka.
```

Jika angka berada di luar batas yang ditentukan, program akan meminta pengguna memasukkan angka kembali.

Validasi teks juga dilakukan agar input tidak boleh kosong.

Contohnya:

```text
>> Input tidak boleh kosong!
```

Dengan adanya validasi tersebut, pengguna dapat memperbaiki input tanpa harus menjalankan ulang program.

---

# BAB IV KESIMPULAN

Sistem Tracking Reservasi Hotel merupakan program Java yang digunakan untuk mengelola dan memantau data reservasi hotel secara sederhana.

Program menyediakan fitur tambah reservasi, tampilkan reservasi, check-in, check-out, update jumlah malam, dan hapus reservasi. Program juga membedakan reservasi menjadi Standard dan VIP dengan karakteristik dan aturan biaya yang berbeda.

Dalam pembuatannya, program menerapkan konsep Pemrograman Berorientasi Objek seperti **encapsulation, inheritance, polymorphism, constructor, serta getter dan setter**. Selain itu, program menggunakan pola **Model-View-Controller (MVC)** untuk memisahkan bagian model, tampilan, dan proses pengendalian.

Dengan penerapan konsep tersebut, program menjadi lebih terstruktur dan setiap class memiliki fungsi yang lebih jelas dalam pengelolaan sistem reservasi hotel.
