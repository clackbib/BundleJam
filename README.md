BundleJam
=========

Bundle Jam is an annotation processor for android that allows you to save data from a fragment/activity at and pass it to another
fragment/activity at runtime. For now, BundleJam operates using shared preferences.

Add this to your base fragments:

```Java
    @Override
    public void onPause() {
        super.onPause();
        JamProcessor.jamVariables(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        JamProcessor.unjamVariables(this);
    }

```
