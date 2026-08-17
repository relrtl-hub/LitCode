package com.litcode.problems.lfucache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class LFUCache {
    private int capacity;
    private int minFreq;
    private Map<Integer, Node> keyToNode;
    private Map<Integer, LinkedHashMap<Integer, Node>> freqToKeys;

    class Node {
        int key, value, freq;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToNode = new HashMap<>();
        this.freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) return -1;
        Node node = keyToNode.get(key);
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.value = value;
            updateFreq(node);
        } else {
            if (keyToNode.size() >= capacity) {
                LinkedHashMap<Integer, Node> minFreqMap = freqToKeys.get(minFreq);
                int evictKey = minFreqMap.keySet().iterator().next();
                minFreqMap.remove(evictKey);
                keyToNode.remove(evictKey);
            }
            Node node = new Node(key, value);
            keyToNode.put(key, node);
            freqToKeys.computeIfAbsent(1, k -> new LinkedHashMap<>()).put(key, node);
            minFreq = 1;
        }
    }

    private void updateFreq(Node node) {
        int oldFreq = node.freq;
        freqToKeys.get(oldFreq).remove(node.key);
        if (freqToKeys.get(oldFreq).isEmpty()) {
            freqToKeys.remove(oldFreq);
            if (minFreq == oldFreq) minFreq++;
        }
        node.freq++;
        freqToKeys.computeIfAbsent(node.freq, k -> new LinkedHashMap<>()).put(node.key, node);
    }
}
