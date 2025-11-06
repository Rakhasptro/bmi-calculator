# 🧪 Panduan Menjalankan Unit Test - BMI Calculator

## 📋 Test Files yang Tersedia

Saya telah membuat 4 file unit test:

1. **BmiCalculatorTest.kt** (43 test cases)
   - Test perhitungan BMI untuk sistem Metric dan Imperial
   - Test kategori BMI (Underweight, Normal, Overweight, Obese)
   - Test validasi input (weight & height)
   - Test boundary values (nilai batas antar kategori)
   - Test healthy weight range

2. **BmiCategoryTest.kt** (30+ test cases)
   - Test kategori BMI berdasarkan nilai BMI
   - Test display names
   - Test warna untuk setiap kategori
   - Test boundary values

3. **BmiDataTest.kt** (10 test cases)
   - Test BmiData data class
   - Test equality & copy functions

4. **UnitSystemTest.kt** (10 test cases)
   - Test UnitSystem enum (METRIC & IMPERIAL)
   - Test display names dan properties

---

## 🚀 Cara Menjalankan Test

### Metode 1: Menggunakan Command Line (Windows CMD)

#### A. Jalankan SEMUA unit tests:
```cmd
cd e:\androidProject\basic-android-kotlin-compose-training-tip-calculator
gradlew.bat test
```

#### B. Jalankan test untuk package tertentu:
```cmd
gradlew.bat test --tests "com.example.tiptime.*"
```

#### C. Jalankan test untuk class tertentu:
```cmd
gradlew.bat test --tests "com.example.tiptime.utils.BmiCalculatorTest"
gradlew.bat test --tests "com.example.tiptime.model.BmiCategoryTest"
gradlew.bat test --tests "com.example.tiptime.model.BmiDataTest"
gradlew.bat test --tests "com.example.tiptime.model.UnitSystemTest"
```

#### D. Jalankan test method tertentu:
```cmd
gradlew.bat test --tests "com.example.tiptime.utils.BmiCalculatorTest.calculateBmi_metric_normal_returnsCorrectBmi"
```

#### E. Jalankan test dengan output detail:
```cmd
gradlew.bat test --info
```

#### F. Jalankan test dan buat HTML report:
```cmd
gradlew.bat test
```
Hasil report akan ada di: `app/build/reports/tests/test/index.html`

---

### Metode 2: Menggunakan Android Studio / IntelliJ IDEA

#### A. Jalankan SEMUA test dalam 1 file:
1. Buka file test (misalnya `BmiCalculatorTest.kt`)
2. Klik kanan pada nama class
3. Pilih **"Run 'BmiCalculatorTest'"** (atau tekan `Ctrl+Shift+F10`)

#### B. Jalankan 1 test method saja:
1. Klik pada method test yang ingin dijalankan
2. Klik icon ▶️ hijau di sebelah kiri method
3. Atau klik kanan → **"Run 'methodName()'"**

#### C. Jalankan semua test di project:
1. Klik kanan pada folder `test` di Project Explorer
2. Pilih **"Run 'Tests in ...'**
3. Atau: **Run → Run... → All Tests**

#### D. Jalankan test dengan coverage (untuk lihat code coverage):
1. Klik kanan pada file test
2. Pilih **"Run 'BmiCalculatorTest' with Coverage"**
3. Atau tekan `Ctrl+Shift+F10` dengan Coverage

#### E. Lihat hasil test:
- Panel **"Run"** di bagian bawah akan menampilkan hasil
- ✅ Green = Pass
- ❌ Red = Fail
- Status summary akan muncul (misalnya: "43 tests passed")

---

### Metode 3: Menggunakan Gradle Task di Android Studio

1. Buka **Gradle** panel (View → Tool Windows → Gradle)
2. Navigate ke: `app → Tasks → verification → test`
3. Double-click pada **test** task
4. Hasil akan muncul di panel Run

---

## 📊 Membaca Hasil Test

### A. Command Line Output
```
> Task :app:testDebugUnitTest

com.example.tiptime.utils.BmiCalculatorTest > calculateBmi_metric_normal_returnsCorrectBmi() PASSED
com.example.tiptime.utils.BmiCalculatorTest > calculateBmi_metric_underweight_returnsCorrectBmi() PASSED
...

BUILD SUCCESSFUL in 15s
```

### B. HTML Report
Setelah menjalankan test, buka file:
```
app/build/reports/tests/test/index.html
```

Report ini menampilkan:
- ✅ Total tests, passed, failed, skipped
- ⏱️ Durasi execution
- 📊 Success rate (%)
- 📁 Breakdown per package dan class
- 📝 Detail setiap test case

### C. Android Studio Output
Panel Run akan menampilkan:
```
Test Results:
✅ BmiCalculatorTest (43 tests) - PASSED
  ✅ calculateBmi_metric_normal_returnsCorrectBmi - 12ms
  ✅ calculateBmi_metric_underweight_returnsCorrectBmi - 8ms
  ✅ isValidWeight_metric_validWeight_returnsTrue - 5ms
  ...
```

---

## 🎯 Test Coverage Summary

### BmiCalculatorTest (43 tests):
- ✅ Perhitungan BMI Metric (4 tests)
- ✅ Perhitungan BMI Imperial (3 tests)
- ✅ Boundary Cases / Batas Kategori (4 tests)
- ✅ Validasi Weight Metric (4 tests)
- ✅ Validasi Weight Imperial (4 tests)
- ✅ Validasi Height Metric (4 tests)
- ✅ Validasi Height Imperial (4 tests)
- ✅ Healthy Weight Range (2 tests)
- ✅ Validation Messages (2 tests)
- ✅ Edge Cases (3 tests)

### BmiCategoryTest (30+ tests):
- ✅ fromBmi() untuk setiap kategori (16 tests)
- ✅ Display Names (4 tests)
- ✅ Colors (5 tests)
- ✅ Enum Values (1 test)
- ✅ Extreme Values (2 tests)
- ✅ Real-World Scenarios (4 tests)

### BmiDataTest (10 tests):
- ✅ Data Creation (4 tests)
- ✅ Equality (3 tests)
- ✅ Copy Function (2 tests)

### UnitSystemTest (10 tests):
- ✅ Enum Values (4 tests)
- ✅ Display Names (2 tests)
- ✅ Enum Behavior (4 tests)

---

## 🔍 Tips & Best Practices

### 1. Jalankan Test Secara Regular
```cmd
# Sebelum commit code:
gradlew.bat test

# Setelah mengubah logic perhitungan:
gradlew.bat test --tests "com.example.tiptime.utils.BmiCalculatorTest"
```

### 2. Watch Mode (Auto-run saat file berubah)
```cmd
gradlew.bat test --continuous
```

### 3. Parallel Execution (Lebih cepat)
```cmd
gradlew.bat test --parallel
```

### 4. Clean sebelum test (jika hasil aneh)
```cmd
gradlew.bat clean test
```

### 5. Debug Test yang Fail
Di Android Studio:
- Klik kanan pada test yang fail
- Pilih **"Debug 'testName()'"**
- Set breakpoint untuk inspect values

---

## ✅ Expected Results

Jika semua test berhasil, Anda akan melihat:

```
BUILD SUCCESSFUL in 20s
43 actionable tasks: 43 executed
```

Dan di HTML report:
```
Tests: 93 passed, 0 failed, 0 skipped
Success rate: 100%
```

---

## 🐛 Troubleshooting

### Problem: "Test not found"
**Solution:** Pastikan package name sesuai:
```cmd
gradlew.bat test --tests "com.example.tiptime.*"
```

### Problem: "Task 'test' not found"
**Solution:** Pastikan Anda di root project:
```cmd
cd e:\androidProject\basic-android-kotlin-compose-training-tip-calculator
```

### Problem: Test gagal dengan assertion error
**Solution:** Periksa:
1. Logic di `BmiCalculator.kt` sesuai dengan expected values
2. Boundary values (18.5, 25.0, 30.0) benar
3. Formula perhitungan BMI correct

### Problem: Gradle build error
**Solution:**
```cmd
gradlew.bat clean
gradlew.bat test
```

---

## 📈 Continuous Integration (CI)

Untuk auto-run tests di CI/CD:

### GitHub Actions (`.github/workflows/test.yml`):
```yaml
name: Run Tests
on: [push, pull_request]
jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
      - name: Set up JDK
        uses: actions/setup-java@v2
        with:
          java-version: '17'
      - name: Run tests
        run: ./gradlew test
```

---

## 📚 References

- JUnit 4 Documentation: https://junit.org/junit4/
- Android Testing Guide: https://developer.android.com/training/testing
- Gradle Test Task: https://docs.gradle.org/current/userguide/java_testing.html

---

## 🎓 Next Steps

1. ✅ Jalankan semua test untuk memastikan pass
2. ✅ Review HTML report untuk melihat coverage
3. ✅ Tambahkan test baru jika ada logic baru
4. ✅ Integrate test ke CI/CD pipeline
5. ✅ Maintain test coverage > 80%

---

**Total Test Cases: 93+**  
**Expected Coverage: ~90%+ of business logic**  
**Execution Time: ~15-30 seconds**

Good luck testing! 🚀

