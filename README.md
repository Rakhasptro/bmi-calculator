# 🏋️ BMI Calculator

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9+-purple.svg)](https://kotlinlang.org)
[![Compose](https://img.shields.io/badge/Jetpack%20Compose-2025.11-green.svg)](https://developer.android.com/jetpack/compose)
[![Material3](https://img.shields.io/badge/Material%20Design%203-latest-blue.svg)](https://m3.material.io/)
[![License](https://img.shields.io/badge/License-Apache%202.0-orange.svg)](LICENSE)

Modern Android aplikasi untuk menghitung Body Mass Index (BMI) dengan antarmuka yang clean dan intuitif menggunakan Jetpack Compose dan Material Design 3.

![BMI Calculator Screenshot](https://via.placeholder.com/800x400/2563EB/FFFFFF?text=BMI+Calculator+App)

---

## 📋 Daftar Isi

- [Fitur](#-fitur)
- [Teknologi](#-teknologi)
- [Arsitektur](#-arsitektur)
- [Instalasi](#-instalasi)
- [Cara Menggunakan](#-cara-menggunakan)
- [Testing](#-testing)
- [Struktur Project](#-struktur-project)
- [Kategori BMI](#-kategori-bmi)
- [Formula Perhitungan](#-formula-perhitungan)
- [Kontribusi](#-kontribusi)
- [Lisensi](#-lisensi)
- [Kontak](#-kontak)

---

## ✨ Fitur

### 🎯 Core Features

- ✅ **Perhitungan BMI Akurat** - Formula standar WHO untuk Metric dan Imperial
- ✅ **Dual Unit System** - Support Metric (kg, cm) dan Imperial (lb, in)
- ✅ **Kategori BMI** - Underweight, Normal, Overweight, Obese dengan color coding
- ✅ **Healthy Weight Range** - Menampilkan rentang berat ideal berdasarkan tinggi
- ✅ **Input Validation** - Validasi real-time untuk input yang valid
- ✅ **Error Handling** - Error messages yang jelas dan helpful

### 🎨 UI/UX Features

- ✅ **Modern UI** - Jetpack Compose dengan Material Design 3
- ✅ **Smooth Animations** - Spring animations untuk hasil BMI
- ✅ **Clean Design** - Minimalist interface dengan visual hierarchy yang jelas
- ✅ **Material Icons** - Icon yang meaningful untuk setiap elemen
- ✅ **Welcome Screen** - Onboarding screen dengan ilustrasi
- ✅ **Responsive Layout** - Adaptive untuk berbagai ukuran layar
- ✅ **Color-coded Results** - Visual feedback berdasarkan kategori BMI

### 🔧 Technical Features

- ✅ **Jetpack Compose** - 100% Compose UI (no XML layouts)
- ✅ **Material Design 3** - Latest design system
- ✅ **Type Safety** - Kotlin with strong typing
- ✅ **Unit Tested** - 93+ test cases dengan coverage >90%
- ✅ **Edge-to-Edge** - Modern Android edge-to-edge support
- ✅ **No Dependencies** - Pure Android SDK (no third-party libraries)

---

## 🛠 Teknologi

### Core Technologies

| Technology | Version | Purpose |
|------------|---------|---------|
| **Kotlin** | 1.9+ | Programming language |
| **Jetpack Compose** | 2025.11 | Modern UI toolkit |
| **Material Design 3** | Latest | Design system |
| **Android SDK** | Min 24, Target 36 | Android platform |
| **JUnit 4** | 4.13.2 | Unit testing |

### Key Libraries

```kotlin
// Compose BOM
implementation(platform("androidx.compose:compose-bom:2025.11.00"))

// Compose Core
implementation("androidx.compose.ui:ui")
implementation("androidx.compose.material3:material3")
implementation("androidx.compose.material:material-icons-extended")

// Activity Compose
implementation("androidx.activity:activity-compose:1.11.0")

// Core
implementation("androidx.core:core-ktx:1.17.0")
implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.9.4")
```

### Development Tools

- **Gradle** 8.x - Build system
- **Android Studio** Koala+ - IDE
- **Git** - Version control

---

## 🏗 Arsitektur

### Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/example/tiptime/
│   │   │   ├── MainActivity.kt              # Main entry point
│   │   │   ├── WelcomeActivity.kt           # Welcome screen
│   │   │   ├── model/
│   │   │   │   ├── BmiData.kt               # BMI data class
│   │   │   │   ├── BmiCategory.kt           # BMI categories enum
│   │   │   │   └── UnitSystem.kt            # Metric/Imperial enum
│   │   │   ├── ui/
│   │   │   │   ├── BmiCalculatorScreen.kt   # Main calculator UI
│   │   │   │   └── theme/
│   │   │   │       ├── Color.kt             # Color definitions
│   │   │   │       ├── Theme.kt             # App theme
│   │   │   │       └── Type.kt              # Typography
│   │   │   └── utils/
│   │   │       └── BmiCalculator.kt         # BMI calculation logic
│   │   └── res/
│   │       ├── drawable/
│   │       │   └── image_bmi.png            # Welcome illustration
│   │       └── values/
│   │           └── strings.xml              # String resources
│   └── test/
│       └── java/com/example/tiptime/
│           ├── utils/
│           │   └── BmiCalculatorTest.kt     # 43 unit tests
│           └── model/
│               ├── BmiCategoryTest.kt       # 30+ unit tests
│               ├── BmiDataTest.kt           # 10 unit tests
│               └── UnitSystemTest.kt        # 10 unit tests
```

### Design Pattern

- **MVVM-like Structure** - Separation of UI and business logic
- **Single Activity** - Modern Android navigation
- **Stateless Composables** - Unidirectional data flow
- **Utility Classes** - Pure functions for calculations
- **Material Design** - Following Material 3 guidelines

---

## 💿 Instalasi

### Prerequisites

- **Android Studio** Koala (2024.1.1) atau lebih baru
- **JDK** 17 atau lebih baru
- **Android SDK** API 24+ (Android 7.0)
- **Git** untuk clone repository

### Clone & Build

```bash
# 1. Clone repository
git clone https://github.com/Rakhasptro/bmi-calculator.git
cd bmi-calculator

# 2. Open di Android Studio
# File → Open → Pilih folder project

# 3. Sync Gradle
# Android Studio akan otomatis sync dependencies

# 4. Build project
./gradlew build

# Windows:
gradlew.bat build

# 5. Run aplikasi
# Pilih device/emulator → Click Run (▶️)
```

### Install APK

```bash
# Build debug APK
./gradlew assembleDebug

# APK tersedia di:
# app/build/outputs/apk/debug/app-debug.apk

# Install ke device
./gradlew installDebug
```

---

## 📖 Cara Menggunakan

### Langkah Penggunaan

1. **Buka Aplikasi**
   - Lihat welcome screen
   - Tap "Get Started"

2. **Pilih Unit System**
   - **Metric**: kg & cm
   - **Imperial**: lb & in

3. **Input Data**
   - Masukkan **Weight** (berat badan)
   - Masukkan **Height** (tinggi badan)

4. **Hitung BMI**
   - Tap tombol **"Calculate BMI"**
   - Hasil akan muncul dengan animasi

5. **Lihat Hasil**
   - **BMI Value** - Nilai BMI Anda
   - **Category** - Underweight/Normal/Overweight/Obese
   - **Healthy Range** - Rentang berat ideal Anda
   - **BMI Categories** - Info kategori BMI

### Input Validation

| System   | Weight Range | Height Range |
|----------|--------------|--------------|
| Metric   | 1-500 kg     | 50-300 cm    |
| Imperial | 2-1100 lb    | 20-120 in    |

---

## 🧪 Testing

### Unit Tests

Project ini memiliki **93+ unit tests** dengan coverage >90%.

#### Jalankan Test

```bash
# Command Line
./gradlew test

# Windows
gradlew.bat test

# Lihat HTML Report
# app/build/reports/tests/test/index.html
```

#### Test Coverage

| File | Tests | Coverage |
|------|-------|----------|
| `BmiCalculatorTest.kt` | 43 | Perhitungan, validasi, boundary |
| `BmiCategoryTest.kt` | 30+ | Kategori, warna, display |
| `BmiDataTest.kt` | 10 | Data class, equality |
| `UnitSystemTest.kt` | 10 | Enum values |

#### Contoh Test Cases

```kotlin
// Test perhitungan BMI
@Test
fun calculateBmi_metric_normal_returnsCorrectBmi() {
    // 70 kg, 175 cm -> BMI = 22.86 (Normal)
    val result = BmiCalculator.calculateBmi(70.0, 175.0, UnitSystem.METRIC)
    assertEquals(22.86, result.bmi, 0.01)
    assertEquals(BmiCategory.NORMAL, result.category)
}

// Test boundary values
@Test
fun fromBmi_exactNormalLowerBoundary_returnsNormal() {
    // BMI 18.5 (tepat batas bawah normal)
    assertEquals(BmiCategory.NORMAL, BmiCategory.fromBmi(18.5))
}
```

Untuk panduan lengkap, baca: **[TESTING_GUIDE.md](TESTING_GUIDE.md)**

---

## 📊 Kategori BMI

Berdasarkan standar **WHO (World Health Organization)**:

| Kategori | BMI Range | Color | Status |
|----------|-----------|-------|--------|
| **Underweight** | < 18.5 | 🔵 Blue | Berat badan kurang |
| **Normal** | 18.5 - 24.9 | 🟢 Green | Berat badan ideal |
| **Overweight** | 25.0 - 29.9 | 🟠 Orange | Kelebihan berat badan |
| **Obese** | ≥ 30.0 | 🔴 Red | Obesitas |

### Visual Color Coding

```kotlin
val UnderweightColor = Color(0xFF3B82F6)  // Blue
val NormalColor = Color(0xFF10B981)       // Green
val OverweightColor = Color(0xFFF59E0B)   // Orange
val ObeseColor = Color(0xFFEF4444)        // Red
```

---

## 🔬 Formula Perhitungan

### Metric System (kg, cm)

```
BMI = weight (kg) / (height (m))²
```

**Contoh:**
- Weight: 70 kg
- Height: 175 cm = 1.75 m
- BMI = 70 / (1.75)² = 22.86

### Imperial System (lb, in)

```
BMI = (weight (lb) / (height (in))²) × 703
```

**Contoh:**
- Weight: 150 lb
- Height: 67 in
- BMI = (150 / (67)²) × 703 = 23.49

### Healthy Weight Range

```kotlin
// Untuk BMI 18.5 - 24.9
minWeight = 18.5 × (height)²
maxWeight = 24.9 × (height)²
```

---

## 🎨 Theme & Colors

### Color Palette

```kotlin
// Primary Colors
val PrimaryBlue = Color(0xFF2563EB)
val PrimaryBlueDark = Color(0xFF1E40AF)
val BackgroundLight = Color(0xFFF8FAFC)

// Text Colors
val TextPrimary = Color(0xFF1E293B)
val TextSecondary = Color(0xFF64748B)

// BMI Category Colors
val UnderweightColor = Color(0xFF3B82F6)  // Blue
val NormalColor = Color(0xFF10B981)       // Green
val OverweightColor = Color(0xFFF59E0B)   // Orange
val ObeseColor = Color(0xFFEF4444)        // Red
```

### Material Icons

- **FitnessCenter** - App header icon
- **MonitorWeight** - Weight input icon
- **Height** - Height input icon
- **Calculate** - Calculate button icon

---

## 🔧 Configuration

### Build Configuration

```kotlin
android {
    compileSdk = 36
    
    defaultConfig {
        applicationId = "com.example.tiptime"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    
    kotlinOptions {
        jvmTarget = "17"
    }
}
```

### Gradle Version

- **Gradle**: 8.9
- **AGP**: 8.7.3
- **Kotlin**: 2.0.21

---

## 🤝 Kontribusi

Kontribusi sangat diterima! Berikut cara berkontribusi:

### Steps

1. **Fork** repository ini
2. **Create** feature branch (`git checkout -b feature/AmazingFeature`)
3. **Commit** changes (`git commit -m 'Add some AmazingFeature'`)
4. **Push** to branch (`git push origin feature/AmazingFeature`)
5. **Open** Pull Request

### Guidelines

- ✅ Ikuti Kotlin coding conventions
- ✅ Tulis unit tests untuk fitur baru
- ✅ Update dokumentasi jika perlu
- ✅ Pastikan semua tests pass
- ✅ Gunakan commit messages yang jelas

### Bug Reports

Jika menemukan bug, silakan buat issue dengan detail:
- Deskripsi bug
- Steps to reproduce
- Expected vs actual behavior
- Screenshots (jika ada)
- Device & Android version

---

## 📝 Changelog

### Version 1.0.0 (November 2025)

**Initial Release**

✨ **Features:**
- BMI calculation (Metric & Imperial)
- Welcome screen dengan ilustrasi
- Modern Material Design 3 UI
- Input validation
- Healthy weight range
- Animated results
- BMI categories info card

🧪 **Tests:**
- 93+ unit tests
- >90% code coverage
- Boundary value testing
- Edge case handling

🎨 **UI/UX:**
- Clean, modern interface
- Color-coded categories
- Material icons
- Smooth animations
- Responsive layout

---

## 🙏 Acknowledgments

- **Android Team** - Jetpack Compose & Material Design 3
- **WHO** - BMI classification standards
- **Material Design** - Design guidelines & icons
- **Kotlin Team** - Amazing programming language
- **Open Source Community** - Inspiration & support

---

## 📚 Resources

### Documentation

- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Material Design 3](https://m3.material.io/)
- [Kotlin Language](https://kotlinlang.org/docs/home.html)

### Related Projects

- [Android Compose Samples](https://github.com/android/compose-samples)
- [Material 3 Catalog](https://github.com/material-components/material-components-android)

### Learning Resources

- [Android Basics with Compose](https://developer.android.com/courses/android-basics-compose/course)
- [Kotlin Bootcamp](https://developer.android.com/courses/kotlin-bootcamp/overview)

---

## ⭐ Star History

Jika project ini membantu Anda, berikan ⭐ di GitHub!

[![Star History Chart](https://api.star-history.com/svg?repos=username/bmi-calculator&type=Date)](https://star-history.com/#username/bmi-calculator&Date)

---

<div align="center">

**Made with ❤️ using Jetpack Compose**

[⬆ Back to Top](#-bmi-calculator)

</div>

