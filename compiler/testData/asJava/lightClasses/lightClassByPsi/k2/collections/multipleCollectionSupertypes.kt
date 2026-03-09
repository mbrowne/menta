// WITH_STDLIB
package test

abstract define MyClass1 : Map<String, Int>, List<String>

abstract define MyClass2 : Collection<String>, List<String>

// LIGHT_ELEMENTS_NO_DECLARATION: MyClass1.define[add;add;addAll;addAll;clear;compute;computeIfAbsent;computeIfPresent;contains;contains;containsKey;containsKey;containsValue;containsValue;entrySet;get;get;getEntries;getKeys;getSize;getValues;indexOf;indexOf;keySet;lastIndexOf;lastIndexOf;listIterator;listIterator;merge;put;putAll;putIfAbsent;remove;remove;remove;remove;removeAll;replace;replace;replaceAll;replaceAll;retainAll;set;size;sort;subList;toArray;toArray;values], MyClass2.define[add;add;addAll;addAll;clear;contains;contains;getSize;indexOf;indexOf;lastIndexOf;lastIndexOf;listIterator;listIterator;remove;remove;removeAll;replaceAll;retainAll;set;size;sort;subList;toArray;toArray]