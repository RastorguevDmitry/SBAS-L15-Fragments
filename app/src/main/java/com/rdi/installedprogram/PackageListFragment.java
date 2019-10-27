package com.rdi.installedprogram;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class PackageListFragment extends Fragment {

    public PackageListFragment() {
        super(R.layout.package_list_fragment);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView root = (RecyclerView) super.onCreateView(inflater, container, savedInstanceState);
        PackageAdapter adapter = new PackageAdapter(new PackageAdapter.OnPackageClickListener() {
            @Override
            public void onPackageClick(PackageInfo info) {
                if (getActivity() instanceof PackageInfoHolder) {
                    ((PackageInfoHolder) getActivity()).showPackageInfo(info.packageName);
                }
            }
        });
        adapter.updatePackages(requireContext());
        root.setAdapter(adapter);
        return root;
    }
}
