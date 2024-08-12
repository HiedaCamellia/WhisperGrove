package org.hiedacamellia.whispergrove.core.data.lang.gen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EffectGen {

    private final String[] viscera = new String[]{"heart","liver","lung","spleen","kidney"};
    private final String[] diseases = new String[]{"hyperactivity","deteriorated"};

    private final String[] viscera_desc_en = new String[]{"Heart","Liver","Lung","Spleen","Kidney"};
    private final String[] diseases_desc_en = new String[]{"Hyperactivity","Deteriorated"};

    private final String[] viscera_desc_zh = new String[]{"心","肝","肺","脾","肾"};
    private final String[] diseases_desc_zh = new String[]{"亢","衰"};

    public Map<String,String> geneffect_en() {
        Map<String,String> desc = new HashMap<>();
        List<String> keys = genkeys();
        List<String> values = new ArrayList<>();
        for (String vis : viscera_desc_en) {
            for (String dis : diseases_desc_en) {
                values.add(vis + " " + dis);
            }
        }
        for (int i = 0; i < keys.size(); i++) {
            desc.put(keys.get(i), values.get(i));
        }
        return desc;
    }

    public Map<String,String> geneffect_zh() {
        Map<String,String> desc = new HashMap<>();
        List<String> keys = genkeys();
        List<String> values = new ArrayList<>();
        for (String vis : viscera_desc_zh) {
            for (String dis : diseases_desc_zh) {
                values.add(vis + dis);
            }
        }
        for (int i = 0; i < keys.size(); i++) {
            desc.put(keys.get(i), values.get(i));
        }
        return desc;
    }

    private List<String> genkeys(){
        List<String> keys = new ArrayList<>();
        for (String vis : viscera) {
            for (String dis : diseases) {
                    keys.add("effect.whispergrove." + vis + "_" + dis);

            }
        }
        return keys;
    }
}
