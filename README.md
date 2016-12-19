# ViewPagerIndicator

ViewPagerIndicator is a library for showing selected bubble along with ViewPager.
You can include it into your application as follows.

# Build.gradle
Add following script into app/build.gradle

repositories {
    maven { 
    url = 'https://jitpack.io' 
    }
}

dependencies {
    compile 'com.github.sampicks:ViewPagerIndicator:1.0'
    }

# Layout xml file
       
        You need to add following namespace.
        
        xmlns:custom="http://schemas.android.com/apk/res-auto"
        
        <com.material.piyush.pagerindicatorlibrary.PagerIndicator
        android:id="@+id/pager"
        android:layout_width="match_parent"
        android:layout_height="30dp"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="100dp"
        android:gravity="center"
        custom:selectedSolidColor="#FF0000"
        custom:selectedStrokeColor="#ffffff"
        custom:numIndicator="5"
        custom:solidColor="#ffffff"
        custom:strokeColor="#FF0000" />
        
# Java file
        
        PagerIndicator pagerIndicator = (PagerIndicator) findViewById(R.id.pager);
        pagerIndicator.setPagerIndicatorCount(10);
        pagerIndicator.setSolidColor(Color.LTGRAY);
        pagerIndicator.setStrokeColor(Color.BLUE);
        pagerIndicator.setSelectedStrokeColor(Color.CYAN);
        pagerIndicator.setSelectedSolidColor(Color.YELLOW);


        pagerIndicator.setPagerIndicatorCount(pager.getCount());
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pagerIndicator.setSelectedIndex(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
