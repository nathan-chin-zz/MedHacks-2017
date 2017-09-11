package com.example.android.medhacks2017;

/*

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Set;

/**
 * Created by Nathan on 9/10/2017.
 */
/*
public class Bluetooth extends AppCompatActivity {
    private Button enableBT;
    private Button queryPD;
    private Button discovery;
    private static int REQUEST_ENABLE_BT = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        enableBT = (Button)findViewById(R.id.enableBT);
        queryPD = (Button)findViewById(R.id.queryPD);
        discovery = (Button)findViewById(R.id.discovery);

        final BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(bluetoothAdapter == null){
            Toast.makeText(getApplicationContext(),"BT not supported", Toast.LENGTH_SHORT).show();
        }
        // Register for broadcasts when a device is discovered.
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(mReceiver, filter);

        enableBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bluetoothAdapter.isEnabled()) {
                    Toast.makeText(getApplicationContext(),"enabled",Toast.LENGTH_SHORT).show();
                    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
                }
            }
        });

        queryPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();

                if (pairedDevices.size() > 0) {
                    // There are paired devices. Get the name and address of each paired device.
                    for (BluetoothDevice device : pairedDevices) {
                        String deviceName = device.getName();
                        Toast.makeText(getApplicationContext(), deviceName, Toast.LENGTH_SHORT).show();
                        String deviceHardwareAddress = device.getAddress(); // MAC address
                    }
                }

                Intent connect = new Intent(getApplicationContext(), )
            }
        });

        discovery = (Button)findViewById(R.id.discovery);
        discovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent discoverableIntent =
                        new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
                startActivity(discoverableIntent);
            }
        });

    }

    // Create a BroadcastReceiver for ACTION_FOUND.
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Discovery has found a device. Get the BluetoothDevice
                // object and its info from the Intent.
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                String deviceName = device.getName();
                String deviceHardwareAddress = device.getAddress(); // MAC address
            }
        }
    };*/
/*
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Don't forget to unregister the ACTION_FOUND receiver.
        unregisterReceiver(mReceiver);
    }
}
*/
