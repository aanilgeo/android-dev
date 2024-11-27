package com.example.bitfitpart2;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0016J\b\u0010#\u001a\u00020\u0014H\u0002J\b\u0010$\u001a\u00020\u0014H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006%"}, d2 = {"Lcom/example/bitfitpart2/MainFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/example/bitfitpart2/databinding/FragmentMainBinding;", "binding", "getBinding", "()Lcom/example/bitfitpart2/databinding/FragmentMainBinding;", "feelingScore", "", "hoursSlept", "sleepEntryAdapter", "Lcom/example/bitfitpart2/SleepEntryAdapter;", "sleepEntryDao", "Lcom/example/bitfitpart2/SleepEntryDao;", "getSleepEntryDao", "()Lcom/example/bitfitpart2/SleepEntryDao;", "sleepEntryDao$delegate", "Lkotlin/Lazy;", "addSleepEntry", "", "hours", "feeling", "notes", "", "loadSleepEntries", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "setupRecyclerView", "setupSeekBars", "app_debug"})
public final class MainFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.example.bitfitpart2.databinding.FragmentMainBinding _binding;
    private com.example.bitfitpart2.SleepEntryAdapter sleepEntryAdapter;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy sleepEntryDao$delegate = null;
    private int hoursSlept = 6;
    private int feelingScore = 5;
    
    public MainFragment() {
        super();
    }
    
    private final com.example.bitfitpart2.databinding.FragmentMainBinding getBinding() {
        return null;
    }
    
    private final com.example.bitfitpart2.SleepEntryDao getSleepEntryDao() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void setupSeekBars() {
    }
    
    private final void addSleepEntry(int hours, int feeling, java.lang.String notes) {
    }
    
    private final void loadSleepEntries() {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}