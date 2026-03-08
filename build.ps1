# Build Script for Facespace Java 25

Write-Host "================================================" -ForegroundColor Cyan
Write-Host "   Facespace Java 25 Build Script" -ForegroundColor Cyan
Write-Host "================================================" -ForegroundColor Cyan
Write-Host ""

# Check Java version
Write-Host "Checking Java version..." -ForegroundColor Yellow
try {
    $javaVersion = java -version 2>&1 | Select-String "version"
    Write-Host "Found: $javaVersion" -ForegroundColor Green
} catch {
    Write-Host "Java not found! Please install Java 25 or higher." -ForegroundColor Red
    exit 1
}

# Navigate to src directory
Set-Location -Path "src"

# Clean previous builds
Write-Host ""
Write-Host "Cleaning old builds..." -ForegroundColor Yellow
Remove-Item "*.class" -ErrorAction SilentlyContinue
Write-Host "Clean complete" -ForegroundColor Green

# Compile Java files
Write-Host ""
Write-Host "Compiling Java 25 source files..." -ForegroundColor Yellow

javac UserProfile.java FacespaceStuff.java Facespace.java 2>&1

if ($LASTEXITCODE -eq 0) {
    Write-Host "Compilation successful!" -ForegroundColor Green
} else {
    Write-Host "Compilation failed!" -ForegroundColor Red
    Set-Location ..
    exit 1
}

# List compiled files
Write-Host ""
Write-Host "Compiled files:" -ForegroundColor Yellow
Get-ChildItem "*.class" | ForEach-Object { Write-Host "  $($_.Name)" -ForegroundColor Green }

Write-Host ""
Write-Host "================================================" -ForegroundColor Cyan
Write-Host "         BUILD SUCCESSFUL!" -ForegroundColor Cyan
Write-Host "================================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "To run the application:" -ForegroundColor Yellow
Write-Host "   java Facespace" -ForegroundColor White
Write-Host ""

Set-Location ..

