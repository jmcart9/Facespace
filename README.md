# Facespace

A Facebook-style social network app created as a 2016 undergraduate capstone and modernized in 2026.

## What this project includes
- CLI social-network application (`src/Facespace.java`)
- Legacy/alternate GUI and helper classes in `src/`
- User profile storage and social graph operations in `src/FacespaceStuff.java`
- Degree-of-separation calculation using BFS
- Java 25 modernization (records, switch expressions, text blocks, `var`, streams, `Optional`)

## Requirements
- JDK 25+
- PowerShell (for `build.ps1`) or any terminal with `javac`/`java`

## Quick start (PowerShell)
```powershell
# from repo root
.\build.ps1
cd src
java Facespace
```

## Manual compile/run
```powershell
cd src
javac UserProfile.java FacespaceStuff.java Facespace.java
java Facespace
```

## CLI commands
- `add`: add a user
- `remove`: remove a user
- `update`: update an existing user
- `find`: show one profile
- `findall`: list all users
- `addf`: create friendship
- `removef`: remove friendship
- `deg`: degree of separation between two users
- `help`: show commands
- `exit`: quit

## Architecture
- `src/UserProfile.java`: immutable `record` for user data plus copy-style update helpers
- `src/FacespaceStuff.java`: business logic (CRUD, friendships, BFS traversal)
- `src/Facespace.java`: command loop, Menu/help text, command dispatch
- `build.ps1`: clean + compile script for core CLI classes

## Java modernization notes
This codebase currently uses stable language/library features in normal compilation mode:
- Records
- Switch expressions
- Text blocks
- `var`
- `Optional`
- Stream API

Historical migration notes and archived docs are in `docs/`.

## Project layout
```text
Facespace/
  src/
  bin/
  build.ps1
  README.md
  docs/
    upgrade-history.md
    archive/2026-upgrade/
```

## Roadmap
- Add automated tests (JUnit 5)
- Add persistence (JSON or database)
- Add REST API layer
- Improve GUI consistency with CLI model

## Screenshots

### GUI Application
![Facespace GUI](docs/images/facespace-gui-screenshot.png)
*Modern Swing-based GUI showing user profile management*

### CLI Application
The CLI provides full CRUD functionality with emoji-enhanced output and BFS-based degree of separation calculations.

## Credits
- Original author: Jorvon Carter (2016 capstone)
- Modernization pass: 2026
