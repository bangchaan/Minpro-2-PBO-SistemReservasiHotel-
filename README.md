# DOKUMENTASI MINI PROJECT 2

---

## SISTEM RESERVASI HOTEL

**Nama:** Aulia Aisyah Al Humaira
**NIM:** 2509116029

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

- Membantu mengelola data reservasi hotel secara terstruktur.
- Memudahkan proses tambah, tampil, update, dan hapus data reservasi.
- Memudahkan tracking status tamu melalui proses check-in dan check-out
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

<img width="380" height="273" alt="image" src="https://github.com/user-attachments/assets/52b89b24-3bd3-4255-b98a-5b856691de1c" />


Gambar di atas menampilkan Menu Utama dari program Sistem Tracking Reservasi Hotel. Menu ini menjadi tampilan awal yang digunakan sebagai pusat navigasi bagi pengguna dalam mengelola data reservasi hotel. Terdapat beberapa pilihan menu, yaitu Tambah Reservasi untuk menambahkan data reservasi baru, Tampilkan Semua Reservasi untuk melihat seluruh data reservasi yang telah tersimpan, Check-In Tamu dan Check-Out Tamu untuk mengubah status reservasi, Update Jumlah Malam untuk memperbarui lama menginap, Hapus Reservasi untuk menghapus data reservasi, serta Keluar untuk mengakhiri program.

Pengguna dapat memilih menu sesuai dengan kebutuhan pengelolaan reservasi melalui pilihan nomor yang tersedia. Dengan adanya Menu Utama ini, proses pengelolaan dan tracking data reservasi hotel dapat dilakukan secara lebih terstruktur dan mudah digunakan.

---

## 2.2 Menu Tambah Reservasi

<img width="557" height="150" alt="image" src="https://github.com/user-attachments/assets/ca92f490-3e1e-423d-85d6-d846f6a43589" />

Gambar di atas menampilkan Menu Tambah Reservasi pada program Sistem Tracking Reservasi Hotel. Menu ini digunakan untuk menambahkan data reservasi baru ke dalam sistem. Pengguna dapat memilih jenis reservasi yang ingin dibuat, yaitu Reservasi Standard atau Reservasi VIP.

Reservasi Standard memiliki harga Rp300.000 per malam dengan ketentuan denda pembatalan sebesar 20%, sedangkan Reservasi VIP memiliki harga Rp750.000 per malam dengan tambahan layanan sebesar Rp100.000. Setelah memilih jenis reservasi, pengguna akan melanjutkan proses dengan memasukkan data yang diperlukan sesuai dengan jenis reservasi yang dipilih.

Dengan adanya menu ini, pengguna dapat menentukan jenis reservasi sesuai kebutuhan sebelum memasukkan data tamu dan informasi reservasi.

### 2.2.1 Tambah Reservasi Standard

<img width="541" height="173" alt="image" src="https://github.com/user-attachments/assets/d476d9e4-466f-43d1-952e-51b6368ba481" />


Gambar di atas menampilkan proses penambahan Reservasi Standard pada program Sistem Tracking Reservasi Hotel. Pengguna memilih tipe reservasi Standard, kemudian memasukkan nama tamu dan jumlah malam menginap.

Reservasi Standard memiliki atribut khusus `dendaPembatalanPersen` yang digunakan untuk menentukan persentase denda apabila reservasi dibatalkan sebelum proses check-out. Nilai denda yang digunakan dalam program adalah 20%.

Pada contoh tersebut, tamu melakukan reservasi Standard selama 2 malam. Setelah data berhasil dimasukkan, sistem memberikan ID reservasi secara otomatis.

---

## 2.2.2 Tambah Reservasi VIP

<img width="555" height="277" alt="image" src="https://github.com/user-attachments/assets/69657d4a-a4cf-42d1-af1f-79ca5f8d01f6" />

Gambar di atas menampilkan proses penambahan Reservasi VIP pada program Sistem Tracking Reservasi Hotel. Pengguna memilih tipe reservasi VIP, kemudian memasukkan nama tamu dan jumlah malam menginap. Setelah itu, pengguna memilih jenis penyambutan yang tersedia, yaitu Reguler, Executive Lounge, atau Airport Pickup + Lounge. 

Pada contoh tersebut, tamu bernama Lia melakukan reservasi selama 10 malam dan memilih jenis penyambutan Executive Lounge. Setelah data berhasil dimasukkan, sistem memberikan ID reservasi secara otomatis, yaitu ID 5.

---

## 2.3 Menu Tampilkan Reservasi

<img width="1171" height="221" alt="Screenshot 2026-09-23 220612" src="https://github.com/user-attachments/assets/a54efbc6-0c3e-469e-bfc2-707bfa4862ef" />


Gambar di atas menampilkan Daftar Reservasi pada program Sistem Tracking Reservasi Hotel. Menu ini digunakan untuk melihat seluruh data reservasi yang telah tersimpan di dalam sistem. Informasi yang ditampilkan meliputi ID reservasi, nama tamu, tipe reservasi, jumlah malam, status, total biaya, dan detail tambahan.

Pada daftar tersebut terdapat reservasi Standard dan VIP dengan status yang berbeda, yaitu Menunggu, Check-In, dan Check-Out. Pada reservasi VIP, bagian detail juga menampilkan jenis penyambutan yang dipilih beserta biaya tambahannya.

Dengan adanya menu ini, pengguna dapat melihat dan memantau data serta status seluruh reservasi yang tersimpan dalam sistem.

---

## 2.4 Menu Check-In

<img width="292" height="82" alt="Screenshot 2026-09-23 220927" src="https://github.com/user-attachments/assets/26ecf010-502e-4969-9a23-efa124020e0f" />


Gambar di atas menampilkan proses Check-In Tamu pada program Sistem Tracking Reservasi Hotel. Pengguna perlu memasukkan ID reservasi yang ingin melakukan check-in. Pada contoh tersebut, pengguna memasukkan ID reservasi 4 dan sistem menampilkan pesan bahwa check-in berhasil.

<img width="685" height="201" alt="Screenshot 2026-09-23 220945" src="https://github.com/user-attachments/assets/4091a965-78c1-4530-be4d-55a66fa5f1b5" />


Setelah proses check-in berhasil, status reservasi dengan ID 4 yang sebelumnya **Menunggu** berubah menjadi **Check-In**. Perubahan status tersebut dapat dilihat pada daftar reservasi setelah proses dilakukan.

Fitur Check-In digunakan untuk mencatat bahwa tamu telah melakukan proses masuk ke hotel sehingga status reservasi dapat diperbarui sesuai dengan kondisi tamu.

---

## 2.5 Menu Check-Out

<img width="293" height="111" alt="image" src="https://github.com/user-attachments/assets/dfe58c77-b35d-4c73-8f88-008a5452f22d" />

Gambar di atas menampilkan proses Check-Out Tamu pada program Sistem Tracking Reservasi Hotel. Pengguna perlu memasukkan ID reservasi yang ingin melakukan check-out. Pada contoh tersebut, pengguna memasukkan ID reservasi 4 dan sistem menampilkan pesan bahwa check-out berhasil.


<img width="1162" height="192" alt="image" src="https://github.com/user-attachments/assets/e5898219-7fc9-4751-9613-245a656f0b63" />

Setelah proses check-out berhasil, status reservasi dengan ID 4 yang sebelumnya **Check-In** berubah menjadi **Check-Out**. Perubahan status tersebut dapat dilihat pada daftar reservasi setelah proses dilakukan.

Fitur Check-Out digunakan untuk mencatat bahwa tamu telah selesai menginap dan keluar dari hotel. Dengan adanya fitur ini, status reservasi dapat diperbarui sesuai dengan kondisi tamu.


---

## 2.6 Menu Update

<img width="326" height="107" alt="image" src="https://github.com/user-attachments/assets/b3df9b86-ca44-4532-8489-11af040d54c1" />

Gambar di atas menampilkan proses Update Jumlah Malam pada program Sistem Tracking Reservasi Hotel. Pengguna perlu memasukkan ID reservasi yang ingin diperbarui, kemudian memasukkan jumlah malam yang baru. Pada contoh tersebut, pengguna memilih ID reservasi 5 dan mengubah jumlah malam menjadi 13 malam.

<img width="1177" height="210" alt="image" src="https://github.com/user-attachments/assets/87c2f9c8-37e4-4240-b822-36699f5babfe" />

Setelah proses update berhasil, jumlah malam pada reservasi tersebut berubah dari 10 malam menjadi 13 malam. Perubahan tersebut juga memengaruhi total biaya reservasi VIP karena total biaya dihitung berdasarkan jumlah malam dan biaya penyambutan yang dipilih.

Dengan adanya fitur ini, pengguna dapat memperbarui lama menginap pada reservasi yang masih aktif tanpa perlu membuat reservasi baru.

---

## 2.7 Menu Hapus

<img width="672" height="128" alt="image" src="https://github.com/user-attachments/assets/66c031b2-d857-4ac0-a19d-583829d04fb5" />

Gambar di atas menampilkan proses Hapus Reservasi pada program Sistem Tracking Reservasi Hotel. Pengguna perlu memasukkan ID reservasi yang ingin dihapus. Pada contoh tersebut, pengguna memilih ID reservasi 1 yang berstatus Menunggu.

<img width="1178" height="213" alt="Screenshot 2026-09-23 222535" src="https://github.com/user-attachments/assets/092e4d7b-ae5c-4c61-86e7-514e690fe45a" />


Karena reservasi Standard tersebut dibatalkan sebelum proses Check-Out, sistem menghitung denda pembatalan sebesar 20% dari total biaya reservasi. Dengan jumlah biaya Rp600.000, denda yang dikenakan adalah Rp120.000. Setelah proses selesai, data reservasi berhasil dihapus dari daftar reservasi.

Gambar berikutnya menunjukkan bahwa reservasi dengan ID 1 sudah tidak terdapat dalam daftar. Dengan adanya fitur ini, pengguna dapat menghapus data reservasi yang sudah tidak diperlukan sekaligus menerapkan aturan denda pembatalan pada Reservasi Standard.

---

## 2.8 Menu Keluar

Menu Keluar digunakan untuk menghentikan program.


---

# BAB III PENERAPAN KONSEP PBO

## 3.1 MVC (Model View Controller)

<img width="386" height="262" alt="image" src="https://github.com/user-attachments/assets/695422ae-81e5-4a85-ac93-f777569fb416" />


Gambar di atas menampilkan struktur package pada program Sistem Tracking Reservasi Hotel. Program menerapkan pola MVC (Model, View, Controller) untuk memisahkan bagian data, tampilan, dan proses pengendalian program.

Struktur program terdiri dari tiga package utama, yaitu:

1. **Package Model**  
   Package `model` berisi class `Reservasi`, `ReservasiStandard`, dan `ReservasiVIP`. Package ini digunakan untuk menyimpan data serta aturan yang berkaitan dengan reservasi hotel.

2. **Package View**  
   Package `view` berisi class `ReservasiView` yang digunakan untuk menampilkan menu, daftar reservasi, dan pesan kepada pengguna.

3. **Package Controller**  
   Package `controller` berisi class `ReservasiController` yang berfungsi sebagai penghubung antara Model dan View. Controller mengatur proses seperti menambah, menampilkan, memperbarui, menghapus, check-in, dan check-out reservasi.

Selain ketiga package tersebut, terdapat class `SistemReservasiHotel` yang menjadi main classs.

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
