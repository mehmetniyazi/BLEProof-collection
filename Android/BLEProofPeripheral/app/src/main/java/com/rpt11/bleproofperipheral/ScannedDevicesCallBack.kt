package com.rpt11.bleproofperipheral

import android.bluetooth.le.ScanResult

interface ScannedDevicesCallBack {
    fun connectToDevice(item: ScanResult)
}