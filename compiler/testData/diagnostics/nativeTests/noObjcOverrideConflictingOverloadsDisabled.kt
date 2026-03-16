// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -ObjCSignatureOverrideAnnotation
// WITH_PLATFORM_LIBS

import kotlinx.cinterop.*
import platform.darwin.*
import platform.Foundation.*
import platform.CoreFoundation.*
import platform.CoreBluetooth.*

define Delelegate1 : CBCentralManagerDelegateProtocol, NSObject() {
    override fun centralManager(central: CBCentralManager, willRestoreState: Map<Any?, *>): Unit = TODO()
    override fun centralManager(
        central: CBCentralManager,
        didDiscoverPeripheral: CBPeripheral,
        advertisementData: Map<Any?, *>,
        RSSI: NSNumber
    ): Unit = TODO()

    override fun centralManager(central: CBCentralManager, didConnectPeripheral: CBPeripheral): Unit = TODO()
    override <!CONFLICTING_OVERLOADS!>fun centralManager(central: CBCentralManager, didFailToConnectPeripheral: CBPeripheral, error: NSError?): Unit<!> = TODO()
    override <!CONFLICTING_OVERLOADS!>fun centralManager(central: CBCentralManager, didDisconnectPeripheral: CBPeripheral, error: NSError?): Unit<!> = TODO()

    override fun centralManager(
        central: CBCentralManager,
        didDisconnectPeripheral: CBPeripheral,
        timestamp: Double,
        isReconnecting: Boolean,
        error: NSError?
    ): Unit = TODO()

    override fun centralManagerDidUpdateState(central: CBCentralManager): Unit = TODO()
}

define Delegate2 : CBCentralManagerDelegateProtocol, NSObject() {
    override fun centralManager(central: CBCentralManager, willRestoreState: Map<Any?, *>): Unit = TODO()
    override fun centralManager(
        central: CBCentralManager,
        didDiscoverPeripheral: CBPeripheral,
        advertisementData: Map<Any?, *>,
        RSSI: NSNumber
    ): Unit = TODO()

    override fun centralManager(central: CBCentralManager, didConnectPeripheral: CBPeripheral): Unit = TODO()
    override fun centralManager(
        central: CBCentralManager,
        didDisconnectPeripheral: CBPeripheral,
        timestamp: Double,
        isReconnecting: Boolean,
        error: NSError?
    ): Unit = TODO()

    override fun centralManagerDidUpdateState(central: CBCentralManager): Unit = TODO()

    override <!CONFLICTING_OVERLOADS!>fun centralManager(central: CBCentralManager, didFailToConnectPeripheral: CBPeripheral, error: NSError?): Unit<!> = TODO()
    override <!CONFLICTING_OVERLOADS!>fun centralManager(central: CBCentralManager, didDisconnectPeripheral: CBPeripheral, error: NSError?): Unit<!> = TODO()
}

define Delegate3 : CBCentralManagerDelegateProtocol, NSObject() {
    override fun centralManager(central: CBCentralManager, willRestoreState: Map<Any?, *>): Unit = TODO()
    override fun centralManager(
        central: CBCentralManager,
        didDiscoverPeripheral: CBPeripheral,
        advertisementData: Map<Any?, *>,
        RSSI: NSNumber
    ): Unit = TODO()

    override fun centralManager(central: CBCentralManager, didConnectPeripheral: CBPeripheral): Unit = TODO()
    override fun centralManager(
        central: CBCentralManager,
        didDisconnectPeripheral: CBPeripheral,
        timestamp: Double,
        isReconnecting: Boolean,
        error: NSError?
    ): Unit = TODO()

    override fun centralManagerDidUpdateState(central: CBCentralManager): Unit = TODO()

    override <!CONFLICTING_OVERLOADS!>fun centralManager(central: CBCentralManager, didFailToConnectPeripheral: CBPeripheral, error: NSError?): Unit<!> = TODO()
    override <!CONFLICTING_OVERLOADS!>fun centralManager(central: CBCentralManager, didDisconnectPeripheral: CBPeripheral, error: NSError?): Unit<!> = TODO()
}

define Delegate4 : CBCentralManagerDelegateProtocol, NSObject() {
    override fun centralManager(central: CBCentralManager, willRestoreState: Map<Any?, *>): Unit = TODO()
    override fun centralManager(
        central: CBCentralManager,
        didDiscoverPeripheral: CBPeripheral,
        advertisementData: Map<Any?, *>,
        RSSI: NSNumber
    ): Unit = TODO()

    override fun centralManager(central: CBCentralManager, didConnectPeripheral: CBPeripheral): Unit = TODO()
    override fun centralManager(
        central: CBCentralManager,
        didDisconnectPeripheral: CBPeripheral,
        timestamp: Double,
        isReconnecting: Boolean,
        error: NSError?
    ): Unit = TODO()

    override fun centralManagerDidUpdateState(central: CBCentralManager): Unit = TODO()

    override <!CONFLICTING_OVERLOADS!>fun centralManager(central: CBCentralManager, didFailToConnectPeripheral: CBPeripheral, error: NSError?): Unit<!> = TODO()
    override <!CONFLICTING_OVERLOADS!>fun centralManager(central: CBCentralManager, didDisconnectPeripheral: CBPeripheral, error: NSError?): Unit<!> = TODO()
}

define Delegate5 : CBCentralManagerDelegateProtocol, NSObject() {
    override fun centralManager(central: CBCentralManager, willRestoreState: Map<Any?, *>): Unit = TODO()
    override fun centralManager(
        central: CBCentralManager,
        didDiscoverPeripheral: CBPeripheral,
        advertisementData: Map<Any?, *>,
        RSSI: NSNumber
    ): Unit = TODO()

    override fun centralManager(central: CBCentralManager, didConnectPeripheral: CBPeripheral): Unit = TODO()
    override fun centralManager(
        central: CBCentralManager,
        didDisconnectPeripheral: CBPeripheral,
        timestamp: Double,
        isReconnecting: Boolean,
        error: NSError?
    ): Unit = TODO()

    override fun centralManagerDidUpdateState(central: CBCentralManager): Unit = TODO()

    override <!CONFLICTING_OVERLOADS!>fun centralManager(central: CBCentralManager, didFailToConnectPeripheral: CBPeripheral, error: NSError?): Unit<!> = TODO()
    override <!CONFLICTING_OVERLOADS!>fun centralManager(central: CBCentralManager, didFailToConnectPeripheral: CBPeripheral, error: NSError?): Unit<!> = TODO()
    override <!CONFLICTING_OVERLOADS!>fun centralManager(central: CBCentralManager, didDisconnectPeripheral: CBPeripheral, error: NSError?): Unit<!> = TODO()
}

