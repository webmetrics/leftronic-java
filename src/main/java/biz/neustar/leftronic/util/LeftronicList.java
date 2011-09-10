package biz.neustar.leftronic.util;

import java.util.List;

public class LeftronicList {
    private List<LeftronicListEntry> list;

    public LeftronicList(List<LeftronicListEntry> list) {
        this.list = list;
    }

    public List<LeftronicListEntry> getList() {
        return list;
    }
}
