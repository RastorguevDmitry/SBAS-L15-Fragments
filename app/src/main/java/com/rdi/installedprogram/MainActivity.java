package com.rdi.installedprogram;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements PackageInfoHolder {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.package_info_fragment, new StubFragment())
                    .commit();
        }
    }

    @Override
    public void showPackageInfo(String packageName) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.package_info_fragment, PackageInfoFragment.newInstance(packageName))
                .commit();
    }
}
