#!/usr/bin/env python3
"""
Adds a Menta modification notice to .kt and .java files that have been modified
from their versions in the Kotlin fork point commit.

Usage:
    python scripts/add_menta_notice.py [--dry-run]

Options:
    --dry-run   Report what would change without writing files.
"""

import re
import subprocess
import sys
from pathlib import Path

BASE_COMMIT = "fdb0169dc2e56e2a4fd881694c340adb1e0b28e8"
MODIFICATION_MARKER = "This file has been modified by Menta"
BLOCK_NOTICE_LINE = " * This file has been modified by Menta from the original version."
LINE_NOTICE_LINE = "// This file has been modified by Menta from the original version."

# Patterns identifying the JetBrains copyright line, grouped to allow substitution
BLOCK_PATTERN = re.compile(r"^(/\*\n)( \* Copyright \d{4}-\d{4} JetBrains)", re.MULTILINE)
LINE_PATTERN = re.compile(r"^(// Copyright \d{4}-\d{4} JetBrains)", re.MULTILINE)

# Files to skip: generated files that would be overwritten by ./gradlew generateTests.
# The notice for these is handled via license/COPYRIGHT_HEADER.txt instead.
SKIP_SUBSTRINGS = ["/gen/", "Generated.kt", "Generated.java"]


def is_generated(path: str) -> bool:
    return any(s in path for s in SKIP_SUBSTRINGS)


def get_modified_files(project_root: Path) -> list[Path]:
    result = subprocess.run(
        ["git", "diff", "--name-only", BASE_COMMIT, "HEAD", "--", "*.kt", "*.java"],
        capture_output=True,
        text=True,
        cwd=project_root,
        check=True,
    )
    paths = []
    for line in result.stdout.splitlines():
        if line:
            p = project_root / line
            if p.is_file():
                paths.append(p)
    return paths


def process_file(filepath: Path, dry_run: bool) -> str:
    """
    Returns one of: 'already_noticed', 'added_block', 'added_line',
                    'no_header', 'skipped_generated', 'error'
    """
    if is_generated(str(filepath)):
        return "skipped_generated"

    try:
        content = filepath.read_text(encoding="utf-8", errors="replace")
    except Exception:
        return "error"

    if MODIFICATION_MARKER in content:
        return "already_noticed"

    if BLOCK_PATTERN.search(content):
        new_content = BLOCK_PATTERN.sub(
            r"\1" + BLOCK_NOTICE_LINE + "\n" + r"\2",
            content,
            count=1,
        )
        if not dry_run:
            filepath.write_text(new_content, encoding="utf-8")
        return "added_block"

    if LINE_PATTERN.search(content):
        new_content = LINE_PATTERN.sub(
            LINE_NOTICE_LINE + "\n" + r"\1",
            content,
            count=1,
        )
        if not dry_run:
            filepath.write_text(new_content, encoding="utf-8")
        return "added_line"

    return "no_header"


def main() -> None:
    dry_run = "--dry-run" in sys.argv
    project_root = Path(__file__).resolve().parent.parent

    print(f"Base commit: {BASE_COMMIT}")
    if dry_run:
        print("Dry run — no files will be modified.\n")

    files = get_modified_files(project_root)
    counts: dict[str, int] = {
        "already_noticed": 0,
        "added_block": 0,
        "added_line": 0,
        "no_header": 0,
        "skipped_generated": 0,
        "error": 0,
    }

    for filepath in files:
        result = process_file(filepath, dry_run)
        counts[result] += 1

    added = counts["added_block"] + counts["added_line"]
    with_notice = counts["already_noticed"] + added
    without_notice = counts["no_header"]

    print(f"Modified .kt/.java files (vs fork point):  {len(files)}")
    print(f"  Skipped (generated):                     {counts['skipped_generated']}")
    print(f"  Skipped (no JetBrains header):           {counts['no_header']}")
    print(f"  Already have notice:                     {counts['already_noticed']}")
    action = "Would add" if dry_run else "Added"
    print(f"  {action} notice:                         {added}")
    if counts["error"]:
        print(f"  Errors:                                  {counts['error']}")
    print()
    print(f"Files WITH modification notice:    {with_notice}")
    print(f"Files WITHOUT modification notice: {without_notice}")


if __name__ == "__main__":
    main()
