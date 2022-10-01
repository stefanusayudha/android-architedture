# Welcome to My Architecture Design!

Seberapa rumit seharusnya arsitektur dari sebuah software? 
Bisakah ini menjadi lebih mudah? 
Dependensi berputar, tidak memungkinkan untuk dilakukan.
Runtime yang kacau dan tidak bisa di prediksi. 
Dimana kita bisa menghentikan sumbu yang terbakar
sebelum meledak?

Orang mengatakan, tidak ada arsitektur yang sempurna. Saya cukup setuju, tetapi apa definisi
sempurna itu? Apakah **Standar Minimal** dari sebuah arsitektur yang baik itu.

Untuk mengukur seberapa baik sebuah arsitektur, kita membutuhkan base line (Standar minimum) dan sebuah alat untuk mengukur. 
Baseline tersebut adalah prinsib-prinsib dan alat tersebut adalah **Alur dependensi** dan **Alur kerja**.
Ya, arsitektur adalah tentang Flow Dependensi dan Flow Runtime. Hal-hal selain itu adalah preferensi saja.

Disini kita akan "**Back to Basic**" dengan konsern sepenuhnya pada **Flow dependensi** dan **Flow runtime**.

Saya memiliki prinsib sederhana; "Jika
rumit berarti salah". Jadi kita
akan membuatnya sedikit lebih mudah dengan menghadirkan sebuah module baru pada gradle project ,
yaitu : **Provider** dan **Igniter**

Ide utama dari proyek ini adalah:
1. Menghilangkan Horizontal dependency sepenuhnya, dengan memunculkan module baru yakni **Provider** dan **Igniter**.
2. Menghilangkan state dari data layer, dengan memaksimalkan functional pattern pada data layer.

# Project Arsitektur

Projek arsitektur mencakup keseluruhan arsitektur dari gradle project kita. Tidak segala hal bisa
kita lakukan dengan gradle project akan tetapi **Pengecualian adalah hal yang buruk** jika kita
tidak membatasinya. Jadi kita akan membatasi pengecualian tersebut hanya 2 hal.

1. App Module adalah bagian dari Igniter. Sehingga App Module dapat berperilaku seperti Igniter
   module, akan tetapi tidak boleh memprovide Module apapun sebagaimana module Igniter.
2. Straight dependensi ke Core Module.

**Circular dependensi** terjadi dikarenakan kita mengizinkan "**Horizontal Dependency**". Jadi kita tidak akan mengijinkan adanya Horizontal dependensi pada module ini.

1. Sebuah module tidak boleh depend ke module lain kecuali Provider.
2. Sebuah module, tidak perlu mengetahui keberadaan Module Lain, selain keberadaan module Provider.

## Provider

Sebagai mana namanya, Provider bertugas untuk memprovide module berdasarkan kontrak module pada
Provider. Sebagai contoh, module tersebut bisa sebuah **API**, **Aktivitas**, **Widget** dan lain
sebagainya.

### Runtime Flow

```mermaid
graph LR
A[Module 1] -- payload --> B((Provider)) -- payload --> C[Module 2]
```

Setiap module bisa memanggil module lain melalui kontrak yang sudah dideklarasikan di dalam
Provider. Selanjutnya, **Igniter** akan memprovide module berdasarkan kontrak yang di inginkan,
dan **Module 1** tidak perlu tau dari mana dia mendapatkan **Module 2** tersebut. Tentusaja sebuah
module harus memprovide atau meng-injeksikan module tersebut ke **Igniter** sebelumnya, untuk
kemudian module tersebut dapat ditemukan oleh **Provider**.

### Dependency Flow

```mermaid
graph LR
A[Module 1] --> B((Provider))
C[Module 2] --> B
D[Module 3] --> B
B --> E{{Core}}
```

Seluruh module (yang masuk dalam kategori runtime module) hanya depend ke 1 Module, yakni Provider
Module. Sementara Provider Module depend ke **Core Module**. Dalam arsitektur ini **Core Module**
adalah sebuah pengecualian, dikarenakan Core Module memiliki sangat banyak komponent dan kebanyakan
berukuran sangat kecil. Oleh Karena itu, akan jauh lebih mudah jika semua module yang membutuhkan
core **"Straight Depend" ke Module Core**, dan semua module tetap harus **mengakses Core Module
melalui Provider**.

## Igniter

Sebagaimana namanya, Igniter adalah sebuah module yang bertugas untuk menjadi sumbu api. Igniter
perlu depend ke semua module, dan **meng-interaksikan** Module-module, API, Widget dll, yang diprovide
setiap Module.

**Application** perlu **diprovide oleh Igniter**. Dan Igniter perlu menghubungkan seluruh Module ke satu sumbu api pada
Application class.

## Overview arsitektur

Anda bisa melihat overview arsitektur pada file arsitektur-overview.pdf

# Internal Module Arsitektur

Kita mengenal MVVM , Clean Architectur, tapi apakah aplikasi front-end perlu se rumit itu? Menurut
saya, Tidak.

Sebagai front-end developer, saya tidak pernah menemukan kemungkinan yang begitu rumit.

Aplikasi front-end hanya terdiri dari 2 hal yakni **UI** dan **Data**. Seberapa rumitkah itu.

## UI

UI adalah module level tinggi, penuh dengan side-effect, lifecycle, configuration changes dan lain
sebagainya. Module ini memang cukup rumit, oleh karena itu, prinsib SOLID dan Dependency injection
akan sangat membantu kita. Tidak ada hal yang istimewa yang perlu saya sampaikan, gunakan ViewModel
dan Injector seperti Koin atau Dagger.

## Data

Disini bagian menariknya. Data layer tidak memerlukan side-effect, tidak perlu memperdulikan
lifecycle dan configuration changes (rotasi, dark mode, dll). Module ini sangat sederhana, jadi
kenapa kita tidak membuatnya menjadi sederhana?

Dalam contoh dalam project ini. Data module tidak perlu mematuhi SOLID principle. Akan tetapi kita
akan memaksimalkan **Functional Pattern** sebisa mungkin. Saya masih menemukan beberapa kesulitan
dalam hal support teknologi, dan dokumentasi, akan tetapi, lihat seberapa sederhana itu.

1. Data module, tidak boleh memiliki state, dia hanya peduli dengan apa data yang diminta, dan
   memberikannya atau memberikan Error / Exception / Either.left apapun yang kalian gunakan.
2. Data module hanya memprovide data dari Source, memberikan data atau Error jika data tidak
   ditemukan. Sedangkan bagaimana source berperilaku bukanlah konsern dari Data module.
3. Repository API -> Source. Tidak rumit bukan. Dengan monoid chain hal ini dapat menjadi sangat
   sederhana, hanya memerlukan 2 step saja.
