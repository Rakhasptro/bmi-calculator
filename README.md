# BMI Calculator

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9+-purple.svg)](https://kotlinlang.org)
[![Compose](https://img.shields.io/badge/Jetpack%20Compose-2025.11-green.svg)](https://developer.android.com/jetpack/compose)
[![Material3](https://img.shields.io/badge/Material%20Design%203-latest-blue.svg)](https://m3.material.io/)
[![License](https://img.shields.io/badge/License-Apache%202.0-orange.svg)](LICENSE)

Modern Android application for calculating Body Mass Index (BMI) with a clean and intuitive interface using Jetpack Compose and Material Design 3.

![BMI Calculator Screenshot](https://via.placeholder.com/800x400/2563EB/FFFFFF?text=BMI+Calculator+App)

---

## Table of Contents

- [Features](#-features)
- [Technologies](#-technologies)
- [Architecture](#-architecture)
- [Installation](#-installation)
- [Usage](#-usage)
- [Testing](#-testing)
- [Project Structure](#-project-structure)
- [BMI Categories](#-bmi-categories)
- [Calculation Formula](#-calculation-formula)
- [Contributing](#-contributing)
- [License](#-license)
- [Contact](#-contact)

---

## ✨ Features

### Core Features

- ✅ **Accurate BMI Calculation** - WHO standard formula for Metric and Imperial
- ✅ **Dual Unit System** - Support for Metric (kg, cm) and Imperial (lb, in)
- ✅ **BMI Categories** - Underweight, Normal, Overweight, Obese with color coding
- ✅ **Healthy Weight Range** - Display ideal weight range based on height
- ✅ **Input Validation** - Real-time validation for valid input
- ✅ **Error Handling** - Clear and helpful error messages

### UI/UX Features

- ✅ **Modern UI** - Jetpack Compose with Material Design 3
- ✅ **Smooth Animations** - Spring animations for BMI results
- ✅ **Clean Design** - Minimalist interface with clear visual hierarchy
- ✅ **Material Icons** - Meaningful icons for each element
- ✅ **Welcome Screen** - Onboarding screen with illustration
- ✅ **Responsive Layout** - Adaptive for various screen sizes
- ✅ **Color-coded Results** - Visual feedback based on BMI category

### Technical Features

- ✅ **Jetpack Compose** - 100% Compose UI (no XML layouts)
- ✅ **Material Design 3** - Latest design system
- ✅ **Type Safety** - Kotlin with strong typing
- ✅ **Unit Tested** - 93+ test cases with >90% coverage
- ✅ **Edge-to-Edge** - Modern Android edge-to-edge support
- ✅ **No Dependencies** - Pure Android SDK (no third-party libraries)

---

## Technologies

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

## Architecture

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

## Installation

### Prerequisites

- **Android Studio** Koala (2024.1.1) or newer
- **JDK** 17 or newer
- **Android SDK** API 24+ (Android 7.0)
- **Git** for cloning repository

### Clone & Build

```bash
# 1. Clone repository
git clone https://github.com/Rakhasptro/bmi-calculator.git
cd bmi-calculator

# 2. Open in Android Studio
# File → Open → Select project folder

# 3. Sync Gradle
# Android Studio will automatically sync dependencies

# 4. Build project
./gradlew build

# Windows:
gradlew.bat build

# 5. Run application
# Select device/emulator → Click Run
```

### Install APK

```bash
# Build debug APK
./gradlew assembleDebug

# APK available at:
# app/build/outputs/apk/debug/app-debug.apk

# Install to device
./gradlew installDebug
```

---

## Usage

### Usage Steps

1. **Open Application**
   - View welcome screen
   - Tap "Get Started"

2. **Select Unit System**
   - **Metric**: kg & cm
   - **Imperial**: lb & in

3. **Input Data**
   - Enter **Weight** (body weight)
   - Enter **Height** (body height)

4. **Calculate BMI**
   - Tap **"Calculate BMI"** button
   - Results will appear with animation

5. **View Results**
   - **BMI Value** - Your BMI value
   - **Category** - Underweight/Normal/Overweight/Obese
   - **Healthy Range** - Your ideal weight range
   - **BMI Categories** - BMI category information

### Input Validation

| System   | Weight Range | Height Range |
|----------|--------------|--------------|
| Metric   | 1-500 kg     | 50-300 cm    |
| Imperial | 2-1100 lb    | 20-120 in    |

---

## Testing

### Unit Tests

This project has **93+ unit tests** with >90% coverage.

#### Run Tests

```bash
# Command Line
./gradlew test

# Windows
gradlew.bat test

# View HTML Report
# app/build/reports/tests/test/index.html
```

#### Test Coverage

| File | Tests | Coverage |
|------|-------|----------|
| `BmiCalculatorTest.kt` | 43 | Calculation, validation, boundary |
| `BmiCategoryTest.kt` | 30+ | Category, color, display |
| `BmiDataTest.kt` | 10 | Data class, equality |
| `UnitSystemTest.kt` | 10 | Enum values |

#### Example Test Cases

```kotlin
// Test BMI calculation
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
    // BMI 18.5 (exact normal lower boundary)
    assertEquals(BmiCategory.NORMAL, BmiCategory.fromBmi(18.5))
}
```

For complete guide, read: **[TESTING_GUIDE.md](TESTING_GUIDE.md)**

---

## BMI Categories

Based on **WHO (World Health Organization)** standards:

| Category | BMI Range | Color | Status |
|----------|-----------|-------|--------|
| **Underweight** | < 18.5 | 🔵 Blue | Underweight |
| **Normal** | 18.5 - 24.9 | 🟢 Green | Ideal weight |
| **Overweight** | 25.0 - 29.9 | 🟠 Orange | Overweight |
| **Obese** | ≥ 30.0 | 🔴 Red | Obese |

### Visual Color Coding

```kotlin
val UnderweightColor = Color(0xFF3B82F6)  // Blue
val NormalColor = Color(0xFF10B981)       // Green
val OverweightColor = Color(0xFFF59E0B)   // Orange
val ObeseColor = Color(0xFFEF4444)        // Red
```

---

## Calculation Formula

### Metric System (kg, cm)

```
BMI = weight (kg) / (height (m))²
```

**Example:**
- Weight: 70 kg
- Height: 175 cm = 1.75 m
- BMI = 70 / (1.75)² = 22.86

### Imperial System (lb, in)

```
BMI = (weight (lb) / (height (in))²) × 703
```

**Example:**
- Weight: 150 lb
- Height: 67 in
- BMI = (150 / (67)²) × 703 = 23.49

### Healthy Weight Range

```kotlin
// For BMI 18.5 - 24.9
minWeight = 18.5 × (height)²
maxWeight = 24.9 × (height)²
```

---

## Theme & Colors

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

## Configuration

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

## Contributing

Contributions are very welcome! Here's how to contribute:

### Steps

1. **Fork** this repository
2. **Create** feature branch (`git checkout -b feature/AmazingFeature`)
3. **Commit** changes (`git commit -m 'Add some AmazingFeature'`)
4. **Push** to branch (`git push origin feature/AmazingFeature`)
5. **Open** Pull Request

### Guidelines

- ✅ Follow Kotlin coding conventions
- ✅ Write unit tests for new features
- ✅ Update documentation if needed
- ✅ Ensure all tests pass
- ✅ Use clear commit messages

### Bug Reports

If you find a bug, please create an issue with details:
- Bug description
- Steps to reproduce
- Expected vs actual behavior
- Screenshots (if any)
- Device & Android version

---

## Changelog

### Version 1.0.0 (November 2025)

**Initial Release**

**Features:**
- BMI calculation (Metric & Imperial)
- Welcome screen with illustration
- Modern Material Design 3 UI
- Input validation
- Healthy weight range
- Animated results
- BMI categories info card

**Tests:**
- 93+ unit tests
- >90% code coverage
- Boundary value testing
- Edge case handling

**UI/UX:**
- Clean, modern interface
- Color-coded categories
- Material icons
- Smooth animations
- Responsive layout

---

## Acknowledgments

- **Android Team** - Jetpack Compose & Material Design 3
- **WHO** - BMI classification standards
- **Material Design** - Design guidelines & icons
- **Kotlin Team** - Amazing programming language
- **Open Source Community** - Inspiration & support

---

## Resources

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

## Star History

If this project helps you, give it a on GitHub!

[![Star History Chart](https://api.star-history.com/svg?repos=username/bmi-calculator&type=Date)](https://star-history.com/#username/bmi-calculator&Date)

---

<div align="center">

**Made with ❤️ using Jetpack Compose**

[⬆ Back to Top](#-bmi-calculator)

</div>
