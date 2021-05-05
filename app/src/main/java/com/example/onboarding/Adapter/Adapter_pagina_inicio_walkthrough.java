package com.example.onboarding.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.onboarding.fragment.Fragment_pagina_inicio_walkthroughone;
import com.example.onboarding.fragment.Fragment_pagina_inicio_walkthroughthree;
import com.example.onboarding.fragment.Fragment_pagina_inicio_walkthroughtwo;
import com.example.onboarding.fragment.Fragment_walkthroughone;
import com.example.onboarding.fragment.Fragment_walkthroughthree;
import com.example.onboarding.fragment.Fragment_walkthroughtwo;

public class Adapter_pagina_inicio_walkthrough extends FragmentStatePagerAdapter {

    public Adapter_pagina_inicio_walkthrough(FragmentManager fm)
    {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                Fragment_pagina_inicio_walkthroughone tab1 = new Fragment_pagina_inicio_walkthroughone();
                return tab1;

            case 1:
                Fragment_pagina_inicio_walkthroughtwo tab2 = new Fragment_pagina_inicio_walkthroughtwo();
                return tab2;
            case 2:
                Fragment_pagina_inicio_walkthroughthree tab3 = new Fragment_pagina_inicio_walkthroughthree();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
