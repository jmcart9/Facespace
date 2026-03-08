# Upgrade History (2016 -> 2026)

This document preserves the migration story from the original capstone code to the modernized Java version.

## Why the upgrade happened
- Keep a 2016 student project runnable on modern JDKs
- Improve readability and maintainability
- Fix known logic bugs while preserving original behavior

## Major changes
- `UserProfile` converted to an immutable `record`
- Command handling rewritten with switch expressions
- Large Menu/help strings converted to text blocks
- Local type inference (`var`) used in core workflows
- Null-prone lookups replaced with `Optional`-based handling
- Collection loops modernized with Stream API where it improved clarity

## Bug fixes called out during migration
- Corrected a field assignment bug where `religion` could be set from `employment`
- Improved null-safety paths for user lookup operations
- Reduced mutable-state risks via immutable profile updates

## Algorithm note
`deg` (degree of separation) uses breadth-first search over friendship edges.

## Scope kept intentionally small
The 2026 pass focused on language modernization and correctness, not a full redesign.

## Suggested next technical steps
- Add JUnit 5 test coverage for CRUD, friendships, and BFS
- Add persistence (JSON or DB)
- Separate CLI I/O from domain logic to simplify testing
- Add CI workflow to compile and run tests on each change

## Archived docs
Detailed snapshot docs from the upgrade session are kept under:
- `docs/archive/2026-upgrade/`

Use `README.md` as the canonical source for running and understanding the current project.

