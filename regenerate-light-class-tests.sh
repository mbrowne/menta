#!/bin/bash
# Script to regenerate light class test snapshot files
# This script processes each test .kt file and regenerates the expected .java files

set -e

TEST_DATA_DIR="compiler/testData/asJava/lightClasses/lightClassByFqName"
GRADLE_CMD="./gradlew"

if [ ! -d "$TEST_DATA_DIR" ]; then
    echo "Error: Test data directory not found: $TEST_DATA_DIR"
    exit 1
fi

# Count .kt files
kt_files=("$TEST_DATA_DIR"/*.kt)
total=${#kt_files[@]}

echo "Found $total Kotlin test files in $TEST_DATA_DIR"
echo ""
echo "This script will attempt to regenerate the light class test snapshot files."
echo "Since the test framework doesn't provide direct file output, we'll use a workaround:"
echo ""
echo "Strategy: We'll run the compiler tests and let them automatically update test data"
echo "by using Gradle's test update mechanism with a special flag."
echo ""
echo "Running: $GRADLE_CMD :compiler:test -Pkotlin.test.update.test.data=true --continue -q"
echo ""

# Run the tests with update flag
# The --continue flag ensures all tests run even if some fail
"$GRADLE_CMD" :compiler:test -Pkotlin.test.update.test.data=true --continue -q

echo ""
echo "Test data regeneration attempted."
echo "Checking which files were updated..."
echo ""

# Check what changed
if git status --short "$TEST_DATA_DIR" | grep -q .; then
    echo "Updated files:"
    git status --short "$TEST_DATA_DIR"
    echo ""
    echo "Review the changes and commit them:"
    echo "  git add $TEST_DATA_DIR"
    echo "  git commit -m 'test: regenerate light class test snapshots'"
else
    echo "No files were updated."
    echo "The test update mechanism might not be working for these tests."
    echo ""
    echo "Fallback: Manually inspecting test failures..."
    echo "Run: $GRADLE_CMD :compiler:test --tests '*LightClass*'"
    echo "Then import the project into IntelliJ to see the test failure diffs."
fi
