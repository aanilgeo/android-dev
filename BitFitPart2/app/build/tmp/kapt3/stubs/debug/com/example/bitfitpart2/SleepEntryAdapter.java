package com.example.bitfitpart2;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0015\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0014\u0010\u0011\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/bitfitpart2/SleepEntryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/bitfitpart2/SleepEntryAdapter$SleepEntryViewHolder;", "sleepEntries", "", "Lcom/example/bitfitpart2/SleepEntry;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateEntries", "newEntries", "", "SleepEntryViewHolder", "app_debug"})
public final class SleepEntryAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.bitfitpart2.SleepEntryAdapter.SleepEntryViewHolder> {
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.example.bitfitpart2.SleepEntry> sleepEntries;
    
    public SleepEntryAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.bitfitpart2.SleepEntry> sleepEntries) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.bitfitpart2.SleepEntryAdapter.SleepEntryViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.bitfitpart2.SleepEntryAdapter.SleepEntryViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void updateEntries(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.bitfitpart2.SleepEntry> newEntries) {
    }
    
    public SleepEntryAdapter() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/example/bitfitpart2/SleepEntryAdapter$SleepEntryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "dateTextView", "Landroid/widget/TextView;", "getDateTextView", "()Landroid/widget/TextView;", "feelingTextView", "getFeelingTextView", "hoursTextView", "getHoursTextView", "notesTextView", "getNotesTextView", "app_debug"})
    public static final class SleepEntryViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView dateTextView = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView hoursTextView = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView feelingTextView = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView notesTextView = null;
        
        public SleepEntryViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getDateTextView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getHoursTextView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getFeelingTextView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getNotesTextView() {
            return null;
        }
    }
}