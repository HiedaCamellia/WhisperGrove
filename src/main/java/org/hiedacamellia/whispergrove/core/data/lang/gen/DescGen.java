package org.hiedacamellia.whispergrove.core.data.lang.gen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DescGen {

    private final String[] viscera = new String[]{"heart","liver","lung","spleen","kidney"};
    private final String[] diseases = new String[]{"hyperactivity","deteriorated"};
    private final int[] levels = new int[]{1,2,3};

    private final String[] viscera_desc_en = new String[]{"Heart","Liver","Lung","Spleen","Kidney"};
    private final String[] diseases_desc_en = new String[]{"Hyperactivity","Deteriorated"};
    private final String[] levels_desc_en = new String[]{"Mild","Moderate","Critical"};
    private final String normal_desc_en = "Normal";

    private final String[] viscera_desc_zh = new String[]{"心","肝","肺","脾","肾"};
    private final String[] diseases_desc_zh = new String[]{"亢","衰"};
    private final String[] levels_desc_zh = new String[]{"轻度","中度","重度"};
    private final String normal_desc_zh = "正常";


    public Map<String,String> gendesc_en() {
        Map<String,String> desc = new HashMap<>();
        List<String> keys = genkeys();
        List<String> values = new ArrayList<>();
        for (String vis : viscera_desc_en) {
            for (String dis : diseases_desc_en) {
                for (String level : levels_desc_en) {
                    values.add(vis + " " + dis + " " + level);
                }
            }
            values.add(vis + " " + normal_desc_en);
        }
        for (int i = 0; i < keys.size(); i++) {
            desc.put(keys.get(i), values.get(i));
        }

        return desc;
    }

    public Map<String,String> gendesc_zh() {
        Map<String,String> desc = new HashMap<>();
        List<String> keys = genkeys();
        List<String> values = new ArrayList<>();
        for (String vis : viscera_desc_zh) {
            for (String dis : diseases_desc_zh) {
                for (String level : levels_desc_zh) {
                    values.add(vis + dis + " " + level);
                }
            }
            values.add(vis + " " + normal_desc_zh);
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
                for (int level : levels) {
                    keys.add("desc.whispergrove." + vis + "." + dis + ".level." + level);
                }
            }
            keys.add("desc.whispergrove." + vis + ".normal");
        }
        return keys;
    }
}
