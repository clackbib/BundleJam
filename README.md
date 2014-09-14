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

And use the following way:
- To "Jam" information in Shared Preferences at runtime:

``` Java
    @Jam(key = FragmentC.FRAG_C_KEY)
    public String name;
    
    //Modifiy the value of name in your fragment
    name = "Habib";
```

- And to "UnJam":

```Java
    public static final String FRAG_C_KEY = "FragCKey";

    @UnJam(key = FRAG_C_KEY)
    private String value;
    
    //Retrieve your saved data
    tvName.setText(name);
```
