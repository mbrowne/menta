#!/usr/bin/env bash
# Bulk regenerate light class test snapshot files
# This script provides the best practicalpproach for updating 148 test files

set -e

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
cd "$SCRIPT_DIR"

TEST_DATA_DIR="compiler/testData/asJava/lightClasses/lightClassByFqName"
FAILED_TESTS_FILE="/tmp/failed_light_class_tests.txt"

echo "╔════════════════════════════════════════════════════════════╗"
echo "║     Light Class Test Snapshot Regeneration Tool            ║"
echo "╚════════════════════════════════════════════════════════════╝"
echo ""

if [ ! -d "$TEST_DATA_DIR" ]; then
    echo "ERROR: Test data directory not found!"
    echo "Expected: $SCRIPT_DIR/$TEST_DATA_DIR"
    exit 1
fi

# Count test files
kt_files=$(find "$TEST_DATA_DIR" -name "*.kt" -type f | wc -l)
echo "Found $kt_files test source files in:"
echo "  $TEST_DATA_DIR"
echo ""

# Extract test names
test_names=$(find "$TEST_DATA_DIR" -name "*.kt" -type f | \
    xargs basename -a | \
    sed 's/\.kt$//' | \
    sort)

echo "Test files:"
count=0
for name in $test_names; do
    echo "  $(printf '%3d' $((++count))). $name"
done
echo ""

echo "╔════════════════════════════════════════════════════════════╗"
echo "║                    Regeneration Strategy                   ║"
echo "╚════════════════════════════════════════════════════════════╝"
echo ""
echo "Since these tests have stale snapshot files, we need to"
echo "regenerate the expected Java signatures from the current"
echo "Menta-enhanced compiler."
echo ""

echo "┌─────────────────────────────────────────────────────────────┐"
echo "│ BEST METHOD: IntelliJ IDEA (Recommended)                   │"
echo "└─────────────────────────────────────────────────────────────┘"
echo ""
echo "Steps:"
echo "  1. Open this project in IntelliJ IDEA"
echo "  2. Navigate to:"
echo "     compiler/tests/org/jetbrains/kotlin/asJava/"
echo "     AbstractCompilerLightClassTest.kt"
echo ""
echo "  3. In the Project tree, expand CompilerLightClassTestGenerated"
echo "     and find any test method (e.g., testAnnotatedParameterInEnumConstructor)"
echo ""
echo "  4. Run the test:"
echo "     - Right-click → Run 'testAnnotatedParameterInEnumConstructor'"
echo "     - Or: Ctrl+Shift+F10 / Cmd+Shift+R"
echo ""
echo "  5. View the test diff failure:"
echo "     - IntelliJ shows a diff popup"
echo "     - LEFT: Expected (old snapshot)"
echo "     - RIGHT: Actual (new compiler output)"
echo "     - Click 'Accept All' to update"
echo ""
echo "  6. Repeat for other tests, or select multiple and run them together"
echo ""

echo "┌─────────────────────────────────────────────────────────────┐"
echo "│ ALTERNATIVE: Gradle Test Update (May not work for these)   │"
echo "└─────────────────────────────────────────────────────────────┘"
echo ""
echo "Command:"
echo "  ./gradlew :compiler:test --tests '*LightClass*' \\"
echo "      -Pkotlin.test.update.test.data=true --continue"
echo ""
echo "Note: This mechanism may not work for all these tests."
echo ""

echo "┌─────────────────────────────────────────────────────────────┐"
echo "│ VERIFICATION: After updating, verify all pass              │"
echo "└─────────────────────────────────────────────────────────────┘"
echo ""
echo "Command:"
echo "  ./gradlew :compiler:test --tests '*LightClass*' -q"
echo ""

echo "┌─────────────────────────────────────────────────────────────┐"
echo "│ COMMIT: When all tests pass                                │"
echo "└─────────────────────────────────────────────────────────────┘"
echo ""
echo "Commands:"
echo "  git add compiler/testData/asJava/lightClasses/"
echo "  git commit -m 'test: update light class snapshots for Menta'"
echo ""

echo "Would you like to run the tests now to see which ones fail?"
echo "This will help identify which test diffs to accept in the IDE."
echo ""
echo "Run this to see a small sample of test failures:"
echo "  ./gradlew :compiler:test --tests '*testAnnotatedParameterInEnumConstructor*' -q"
echo ""
