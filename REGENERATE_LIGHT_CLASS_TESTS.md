# Regenerating Light Class Test Snapshots

The 148 failing light class tests are due to Menta changes affecting how the Analysis API represents symbols. The compiler now generates different Java signatures for light classes, and the snapshot files need to be updated.

## Solution: Use IntelliJ IDEA (Recommended)

### Step 1: Open in IntelliJ
```bash
# Make sure you're on the menta/dynamic branch
git checkout menta/dynamic

# Open the project in IntelliJ
open -a "IntelliJ IDEA" .
```

### Step 2: Run a Failing Test
1. Navigate to: `compiler/tests/org/jetbrains/kotlin/asJava/CompilerLightClassTestGenerated.java`
2. Right-click on one of the failing test methods (e.g., `testAnnotatedParameterInEnumConstructor`)
3. Select "Run 'testAnnotatedParameterInEnumConstructor'"

### Step 3: View the Diff
1. When the test fails, IntelliJ will show a diff popup
2. The popup will show:
   - **LEFT**: Expected (current snapshot file)
   - **RIGHT**: Actual (new compiler output)
3. Review the changes to verify they make sense

### Step 4: Accept All Changes
1. In the diff popup, click "Accept All" or "Accept" to update the snapshot file
2. Alternatively, right-click on the test and select "Run with Coverage" to get more details

### Step 5: Commit the Changes
```bash
# After IntelliJ updates the files
git add compiler/testData/asJava/lightClasses/
git diff --cached head | head -100  # Review the changes
git commit -m "test: update light class snapshots for Menta symbol representation"
```

## Understanding the Changes

The changes are due to Menta's modified Analysis API symbol handling:
- `KtDefine` is now used instead of `KtClass` in certain contexts
- Light classes render from these modified symbols
- Therefore, Java signatures changed accordingly

All changes should be consistent (same type of modification across files).

## Batch Update Alternative (If IDE Not Available)

If you don't have IDE access, you can batch-update by:

1. Creating a simple test runner that captures actual output:
```bash
./gradlew :compiler:test -x distCompilerAll --tests "*testAnnotatedParameterInEnumConstructor*" -q 2>&1
```

2. Then manually verifying a few files to understand the pattern

3. Updating other files programmatically based on that pattern

## What NOT to Do

⚠️ DO NOT manually edit all 148 files by hand
⚠️ DO NOT assume all changes are identical (they depend on the source file)
⚠️ DO NOT commit without reviewing the diffs
